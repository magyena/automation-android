#!/bin/bash
# Set variables for SSH parameters

# Receive parameter from outside file
phoneNumber="$1"

jumphostUser="ubuntu"
jumphostHost="108.137.34.236"
jumphostPassword="Welcome.21!--"
privateKey="./p-kp-jumphost-db.pem"

dbUsername="team_qa"
dbName="otp"
dbHost="p-bss-cluster.cluster-crghkxvi5das.ap-southeast-3.rds.amazonaws.com"
dbPort="5432"
dbPassword="4321lupa"
SQLQuery="select otp from otps s where recipient like '%$phoneNumber' and verified=false order by created_at desc limit 1;"

# Suppress warning message and connect to the jumphost with the private key to get the OTP value
otpValue=$(/opt/homebrew/Cellar/sshpass/1.09/bin/sshpass -p "$jumphostPassword" ssh -T -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -i "$privateKey" "$jumphostUser@$jumphostHost" 2>/dev/null << EOF
  PGPASSWORD="$dbPassword" psql -U $dbUsername -d $dbName -h $dbHost -p $dbPort -t -c "$SQLQuery" | grep -oP '\b\d+\b'
EOF
)

# Extract the last line from otpValue
lastLine=$(echo "$otpValue" | tail -n 1)

# Print the OTP value from the last line
echo "$lastLine" | grep -o '[0-9]\+'

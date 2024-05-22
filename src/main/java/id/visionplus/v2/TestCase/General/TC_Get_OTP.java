package id.visionplus.v2.TestCase.General;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TC_Get_OTP{

	public String get_OTP(String phone_number) throws IOException, InterruptedException{	
		String result_otp;
        System.out.println("Arrive to Get OTP Method");

            // Step 1: Specify the path to your shell script
            String scriptPath = "./connect_DB_BSS_OTP.sh";

            // Step 2: Create ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(scriptPath, phone_number);

            // Step 3: Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Step 4: Start the process
            Process process = processBuilder.start();

            // Step 5: Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Step 6: Wait for the process to finish
            int exitCode = process.waitFor();

            // Step 7: Print the output and exit code
            System.out.println("Output of the executed OTP script:");
            System.out.println(output.toString());
            
            result_otp=output.toString();
            
            return result_otp;
	}
	
}

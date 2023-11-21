package org.visionplus_android;

import java.io.*;
import com.jcraft.jsch.*;

public class TestClass 
{
	public static void main(String[] args) {
        String host = "10.10.20.20";
        String user = "mncnow";
        String password = "Welcome.21!--"; // For password-based authentication
        // Alternatively, you can use key-based authentication:
        // String privateKey = "/path/to/private/key.pem";

        try {
            JSch jsch = new JSch();
            
            // If using key-based authentication
            // jsch.addIdentity(privateKey);

            // Create a session
            Session session = jsch.getSession(user, host,22);

            // If using password-based authentication
            session.setPassword(password);

            // Avoid asking for key confirmation
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            // Connect to the remote server
            session.connect();
            
            String A = "fatah"+user+"Alim";
            
            System.out.println(A);

            // Execute command
            String command = "/opt/homebrew/Cellar/sshpass/1.06/bin/sshpass -p \"$jumphostPassword\" ssh -i \"$privateKey\" \"$jumphostUser@"+" <<-EOF\n"
            		+ "  psql -U \"$dbUsername\" -d \"$dbName\" -h \"$dbHost\" -p \"$dbPort\" -t -c \"$SQLQuery\" | grep -oP '\\b\\d+\\b'\n"
            		+ "EOF";
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            // Get the command's output
            InputStream in = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) continue;
                    System.out.println("Exit status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

            // Disconnect from the remote server
            channel.disconnect();
            session.disconnect();

        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }
    }
}
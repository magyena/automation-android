package id.visionplus.v2.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import expectj.ExpectJ;
import expectj.Spawn;


public class DBConnection
{

   public static void main(String[] args) throws Exception 
   { 
		    Process p = Runtime.getRuntime().exec("./src/main/java/org/visionplus_android/utils/connectSMSGatewayDB.sh");
		    p.waitFor();

		    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));


		    String line = "";
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }

		}


   }

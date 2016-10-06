package MyApp.DataLayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Paths;

public class UserData
{

    private HashMap<String,String> hmUserLookup;

    // Constructor: fill hmUserLookup with users and their passwords
    public UserData()
    {
        hmUserLookup = readLoginFile();
    }

    private HashMap<String, String> readLoginFile()
    {
        String[] sLoginCredentials;
        Scanner inputfile = null;
        HashMap<String, String> hmUserLookup = new HashMap<String, String>();
        String sSrcRoot = Paths.get(".").toAbsolutePath().normalize().toString();

        // Read user names and passwords line by line from file and store in hashtable

        try
        {
            try
            {
                inputfile = new Scanner(new File(sSrcRoot + "/src/MyApp/DataLayer/users.txt"));
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

            while (inputfile.hasNextLine())
            {
                sLoginCredentials = inputfile.nextLine().split(",");
                hmUserLookup.put(sLoginCredentials[0], sLoginCredentials[1]);
            }
        }
        finally
        {
            if (inputfile != null)
            {
                inputfile.close();
            }
        }
            return hmUserLookup;

    }

    public boolean checkUserCredentialsInHashmap(String sUsernameParam, String sUserPasswordParam)
    {
        return sUserPasswordParam.equals(hmUserLookup.get(sUsernameParam));
    }

}

package MyApp.AppLayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import MyApp.DataLayer.ReadUserData;
import MyApp.UILayer.InputDialogue;
import MyApp.UILayer.OutputText;

import java.util.HashMap;

public class UserLogin {

    private HashMap<String, String> hmUserLookup;
    public boolean loginGranted;
    public String sUserName;
    public String sUserPassword;

    // Constructor: fill hmUserLookup with users and their passwords

    UserLogin() {
        loginGranted = false;
        ReadUserData dataObject = new ReadUserData();
        hmUserLookup = dataObject.readLoginFile();
    }

    private boolean checkUserCredentials(String sUsernameParam, String sUserPasswordParam)
    {
        if (sUserPasswordParam.equals(hmUserLookup.get(sUsernameParam)))
        {
            sUserName = sUsernameParam;
            sUserPassword = sUserPasswordParam;
            loginGranted = true;
            return loginGranted;
        }
        else
        {
            sUserName = "";
            sUserPassword = sUserPasswordParam;
            loginGranted = false;
            return false;
        }
    }

    public void enterAndCheckUserCredentials()
    {
        // Instantiate UIlayer:
        InputDialogue UIInput = new InputDialogue();
        OutputText UIOutput = new OutputText();

        String sUserName = "";
        String sUserPassword = "";

        UIOutput.showHelperText("Indtast brugernavn (email): ");
        sUserName = UIInput.getInputLineFromKeyboard();

        UIOutput.showHelperText("Indtast password: ");
        sUserPassword = UIInput.getInputLineFromKeyboard();

        if (checkUserCredentials(sUserName, sUserPassword))
        {
            UIOutput.showHelperText("Login granted for: " + sUserName);
        }
        else
        {
            UIOutput.showHelperText("Login denied, please try again");
        }

    }

}

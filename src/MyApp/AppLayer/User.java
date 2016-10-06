package MyApp.AppLayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import MyApp.DataLayer.UserData;
import MyApp.UILayer.InputDialogue;
import MyApp.UILayer.OutputText;

public class User {


    public boolean loginGranted;
    public String sUserName;
    public String sUserPassword;

    private UserData dataObject;
    private InputDialogue UIInput;
    private OutputText UIOutput;

    // Constructor: hmUserLookup contains a pointer to users and their passwords and UI object for input and output

    public User(UserData dataObjectParam, InputDialogue UIInputParam, OutputText UIOutputParam)
    {
        dataObject = dataObjectParam;
        UIInput = UIInputParam;
        UIOutput = UIOutputParam;
        loginGranted = false;
    }

    private boolean checkUserCredentials(String sUsernameParam, String sUserPasswordParam)
    {

        if (dataObject.checkUserCredentialsInHashmap(sUsernameParam, sUserPasswordParam))
        {
            sUserName = sUsernameParam;
            sUserPassword = sUserPasswordParam;
            loginGranted = true;
            return loginGranted;
        }
        else
        {
            sUserName = "";
            sUserPassword = "";
            loginGranted = false;
            return false;
        }
    }

    public void enterAndCheckUserCredentials()
    {
        String sUserName = "";
        String sUserPassword = "";

        UIOutput.showHelperText("Indtast brugernavn (email): ");
        sUserName = UIInput.getInputLineFromKeyboard();

        UIOutput.showHelperText("Indtast password: ");
        sUserPassword = UIInput.getInputLineFromKeyboard();

        if (checkUserCredentials(sUserName, sUserPassword))
        {
            UIOutput.showHelperTextLn("Login granted for: " + sUserName);
        }
        else
        {
            UIOutput.showHelperTextLn("Login denied, please try again");
        }

    }

}

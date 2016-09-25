package MyApp;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import java.util.HashMap;

public class AppLayer {

    private HashMap<String, String> hmUserLookup;
    public boolean loginGranted;
    public String sUserName;
    public String sUserPassword;

    // Constructor: fill hmUserLookup with users and their passwords

    AppLayer() {
        loginGranted = false;
        DataLayer dataObject = new DataLayer();
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
        UILayer UI = new UILayer();

        String sUserName = "";
        String sUserPassword = "";

        UI.showHelperText("Indtast brugernavn (email): ");
        sUserName = UI.getInputLineFromKeyboard();

        UI.showHelperText("Indtast password: ");
        sUserPassword = UI.getInputLineFromKeyboard();

        if (checkUserCredentials(sUserName, sUserPassword))
        {
            UI.showHelperText("Login granted for: " + sUserName);
        }
        else
        {
            UI.showHelperText("Login denied, please try again");
        }

    }

}

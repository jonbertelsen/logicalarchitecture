package MyApp.AppLayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 * Main acts as the controller (facade) and creator of objects
 */

import MyApp.DataLayer.UserData;
import MyApp.UILayer.OutputText;
import MyApp.UILayer.InputDialogue;

public class Main {

    public static void main(String[] args) {

        // Instantiate (create) UI Output object
        OutputText UIOutput = new OutputText();

        // Instantiate (create) UI Input object
        InputDialogue UIInput = new InputDialogue();

        // Instantiate (create) DataObject once and for all
        UserData dataObject = new UserData();

        // Instantiate (create) User1:
        User myUser1 = new User(dataObject, UIInput, UIOutput);

        // Login user1
        myUser1.enterAndCheckUserCredentials();

        // Instantiate User2:
        User myUser2 = new User(dataObject, UIInput, UIOutput);

        // Login user1
        myUser2.enterAndCheckUserCredentials();

        // Output users
        UIOutput.showHelperTextLn("First User: " + myUser1.sUserName);
        UIOutput.showHelperTextLn("Second User: " + myUser2.sUserName);
    }
}

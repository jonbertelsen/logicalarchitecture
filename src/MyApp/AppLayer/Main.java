package MyApp.AppLayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import MyApp.DataLayer.UserData;
import MyApp.UILayer.OutputText;

public class Main {

    public static void main(String[] args) {

        // Instantiate DataObject once and for all
        UserData dataObject = new UserData();

        // Instantiate User1:
        User myUser1 = new User(dataObject);

        // Login user1
        myUser1.enterAndCheckUserCredentials();

        // Instantiate User2:
        User myUser2 = new User(dataObject);

        // Login user1
        myUser2.enterAndCheckUserCredentials();

        // Output users
        OutputText UIOutput = new OutputText();

        UIOutput.showHelperTextLn("First User: " + myUser1.sUserName);
        UIOutput.showHelperTextLn("Second User: " + myUser2.sUserName);
    }
}

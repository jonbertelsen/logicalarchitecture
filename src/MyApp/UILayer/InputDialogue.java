package MyApp.UILayer;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import java.util.Scanner;

public class InputDialogue {

    public String getInputLineFromKeyboard() {
        String sInputText = "";
        Scanner inputFromKeyboard = new Scanner(System.in);

        sInputText = inputFromKeyboard.nextLine();

        return sInputText;
    }


}

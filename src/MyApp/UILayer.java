package MyApp;

/**
 * Created by jonb on 23/09/16 to illustrate the use of UI-layer, App-layer, and Data-Layer architecture
 */

import java.util.*;

public class UILayer {

    public void showHelperText(String sText)
    {
        System.out.print(sText);
    }

    public String getInputLineFromKeyboard() {
        String sInputText = "";
        Scanner inputFromKeyboard = new Scanner(System.in);

        sInputText = inputFromKeyboard.nextLine();

        return sInputText;
    }


}

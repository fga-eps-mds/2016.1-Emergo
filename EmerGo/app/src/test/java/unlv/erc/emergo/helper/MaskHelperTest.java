package unlv.erc.emergo.helper;

import android.app.Application;
import android.content.Context;
import android.text.TextWatcher;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.EditText;

import junit.framework.TestCase;

import helper.MaskHelper;
import unlv.erc.emergo.controller.ConfigController;
import unlv.erc.emergo.controller.EmergencyContactController;

public class MaskHelperTest  extends TestCase{
    MaskHelper maskHelper = new MaskHelper();

    public void testThatStringChanges(){

        String name = "jujuba";
        String name1 = name;
        name1 = maskHelper.unmask(name);
        assertSame(name , name1);

    }

    public void testIfDotDisapear(){
        String string1 = "leo.leo";
        String string2 = "leoleo";
        string1 = maskHelper.unmask(string1);
        assertEquals(string1 , string2);
    }

    public void testIfReturnsVoid(){
        boolean passou = true;
        String isVoid = "";
        String symbols = "././";
        symbols = maskHelper.unmask(symbols);

        if(symbols.compareTo(isVoid) == 0){
            assertTrue(passou);
        }else{
            assertFalse(passou);
        }
    }




}

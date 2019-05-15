/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.view;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *Denna klass är mer eller mindre tagen direkt ur boken. 
 * @author Henri
 */
public class ErrorMessageHandler {
/*
* Denna metod används för att skriva ut felmeddelanden på skärmen till användaren. 
    @param <code>message</code>
*/
    public static void showErrorMsg(String msg){
        StringBuilder errorMsgBuilder = new StringBuilder(); 
        errorMsgBuilder.append(createTime()); 
        errorMsgBuilder.append(", ERROR: "); 
        errorMsgBuilder.append(msg); 
        System.out.println(errorMsgBuilder);
    }
/*
* Denna metod används för att fånga tid och datum.
*/
    private static String createTime(){
        LocalDateTime now = LocalDateTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
         return now.format(formatter); 

    }
    
}

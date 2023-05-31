/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PageController;
import Dashboard.*;
import BookAppointment.*;

/**
 *
 * @author truonghuy
 */
public class PageController {
    public static Home ReturnHome(){
        Home h = new Home();
        h.setVisible(true);
        return h;
    }
    public static BookingSuccessful Submit(){
        BookingSuccessful successful = new BookingSuccessful();
        successful.setVisible(true);
        return successful;
    }
    
}

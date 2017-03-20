/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest;
 
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//The GuestController class is defined as a Spring managed web controller using the @Controller annotation.
@Controller
public class GuestController {
    
    //A GuestDao component is automatically constructed and injected by Spring into the guestDao field 
    //(because it is annotated with the @Autowired annotation).
    @Autowired
    private GuestDao guestDao;
    
    //The guestbook method, which is attached to the "/guest" web request uri (using the @RequestMapping annotation)
    //uses the GuestDao component to process the web request:
    @RequestMapping(value="/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null){
            guestDao.persist(new Guest(name));}
        
        // Prepare the result view (guest.jsp
        // The returned ModelAndView object defines a target JSP ("guest.jsp") and passes the GuestDao component to the JSP 
        // as a request attribute (whose name is "guestDao" and its value is guestDao).
        return new ModelAndView("guest.jsp", "guestDao", guestDao);
    }
    
}

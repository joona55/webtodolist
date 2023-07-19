package com.example.springboot.webtodolist.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", "joona");
        return "welcome";
    }

/*

    @RequestMapping(value="login", method=RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password,
                                  ModelMap model) {

        // Authentication (인증)
        // name - joona
        // password - dummy
        if(authenticationService.authentication(name, password)) {
            model.put("name", name);

            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials. Please try again");

        return "login";
    }
*/

}

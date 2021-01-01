package j2ee.tutos.authentification.controllers;

import j2ee.tutos.authentification.security.UserPrincipal;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home(@AuthenticationPrincipal UserPrincipal principal, Model model){
        model.addAttribute("user",principal.getUser());
        return "userDetail";
    }
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/logout-success", produces = MediaType.TEXT_HTML_VALUE)
    public String logout(){
        return "logout";
    }
}

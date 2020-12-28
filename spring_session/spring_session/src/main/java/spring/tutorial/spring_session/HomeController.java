package spring.tutorial.spring_session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final String ATTRIBUTE_NAME_NOTE="SESSION_NOTE";
    @GetMapping(path = "/home")
    public String home(final Model model, final HttpSession session){
        List<String> notes=(List<String>)session.getAttribute(ATTRIBUTE_NAME_NOTE);
        model.addAttribute("notes",notes);
        return "index";
    }

    @PostMapping(path="/save/note")
    public String saveNoteInSession(@RequestParam("note") String note, final HttpSession session){
        List<String> notes=(List<String>)session.getAttribute(ATTRIBUTE_NAME_NOTE);
        if(notes==null){
            notes=new ArrayList<>();
        }
        notes.add(note);
        session.setAttribute(ATTRIBUTE_NAME_NOTE,notes);
        return "redirect:/home";
    }

    @PostMapping(path = "/destroy/session")
    public String destroySession(final HttpSession session){
        session.invalidate();
        return "redirect:/home";
    }

}

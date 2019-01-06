package pl.coderslab.app.pong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pong")
public class PongController {

    @GetMapping
    public String pong() {
        return "pong";
    }
}

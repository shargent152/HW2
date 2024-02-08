package c322spring2024homework2.Guitar.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String greetings(){
        return "Welcome to the animal service!";
    }
}

package hr.tis.recenzije.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController implements ErrorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/error")
    public String error() {
        return "error";
    }
    
}
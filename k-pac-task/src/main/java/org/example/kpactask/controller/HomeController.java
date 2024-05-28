package org.example.kpactask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("/WEB-INF/static/index.jsp");
    }
}

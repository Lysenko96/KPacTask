package org.example.kpactask.controller;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.jdbc.JdbcKPacDao;
import org.example.kpactask.entity.KPac;
import org.example.kpactask.service.KPacService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kpacs")
@RequiredArgsConstructor
public class KPacController {

    private final KPacService kPacService;

    @GetMapping
    public ModelAndView kpacs(ModelAndView modelAndView) {
        List<KPac> kPacs = kPacService.getAllKPacs();
        modelAndView.addObject("kpacs", kPacs);
        modelAndView.setViewName("/WEB-INF/static/kpacs.jsp");
//        modelAndView.setViewName("/static/kpacs_dhtmlx.html");
        return modelAndView;
    }

    @GetMapping("/newKPac")
    public ModelAndView newKPac(ModelAndView modelAndView) {
        KPac kPac = new KPac();
        new ModelAndView("/WEB-INF/static/addKPac.jsp", "kPac", kPac);
        modelAndView.addObject("kPac", kPac);
        modelAndView.setViewName("/WEB-INF/static/addKPac.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/addKPac", method = RequestMethod.POST)
    public ModelAndView addKPac(@ModelAttribute KPac kPac) {
        kPacService.addKPac(kPac);
        return new ModelAndView("redirect:/kpacs");
    }

    @GetMapping("deleteKPac/{id}")
    public ModelAndView deleteKPac(@PathVariable Long id) {
        kPacService.deleteKPac(id);
        return new ModelAndView("redirect:/kpacs");
    }

}

package org.example.kpactask.controller;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.entity.KPacSet;
import org.example.kpactask.service.KPacSetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class KPacSetController {

    private final KPacSetService kPacSetService;

    @RequestMapping(value = "/sets", method = RequestMethod.GET)
    public ModelAndView sets(ModelAndView modelAndView) {
        modelAndView = kPacSetService.getModelAndViewBySets(modelAndView);
        modelAndView.setViewName("/WEB-INF/static/sets.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "sets/newKPacSet", method = RequestMethod.GET)
    public ModelAndView newKPac(ModelAndView modelAndView) {
        KPacSet kPacSet = new KPacSet();
        modelAndView.addObject("kPacSet", kPacSet);
        modelAndView.setViewName("/WEB-INF/static/addKPacSet.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "sets/addKPacSet", method = RequestMethod.POST)
    public ModelAndView addKPacSet(@ModelAttribute KPacSet kPacSet) {
        kPacSetService.addKPacSet(kPacSet);
        return new ModelAndView("redirect:/sets");
    }


    @RequestMapping(value = "/set/{id}", method = RequestMethod.GET)
    public ModelAndView setById(@PathVariable Long id, ModelAndView modelAndView) {
        modelAndView = kPacSetService.getSetById(id, modelAndView);
        modelAndView.setViewName("/WEB-INF/static/set.jsp");
        return modelAndView;
    }

    @GetMapping("/sets/deleteKPacSet/{id}")
    public ModelAndView deleteKPacSet(@PathVariable Long id) {
        kPacSetService.deleteKPacSet(id);
        return new ModelAndView("redirect:/sets");
    }

}

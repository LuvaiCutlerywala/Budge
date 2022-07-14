package org.luvaicutlerywala.budgetingApp.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class DefaultPageController {

    private static final Logger LOGGER = Logger.getLogger("org.luvaicutlerywala.budgetingApp.core.controllers.DefaultPageController");

    @GetMapping("/")
    public String getHomepage(){
        LOGGER.info("Served homepage");
        return "index";
    }

}

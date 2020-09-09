package com.ruoyi.project.cms.content.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {

    @RequestMapping("/test")
    public int get (){
        return 1;
    }

}

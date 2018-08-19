package com.wejoy.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Router {

    @Autowired
    EventSearchEngine eventSearchEngine;

    public Router(EventSearchEngine eventSearchEngine){
        this.eventSearchEngine = eventSearchEngine;
    }

    @RequestMapping("/search")
    public ArrayList<Event> searchByKeyword(@RequestParam("keyword")String keyword){
        return this.eventSearchEngine.searchByKeyword(keyword);
    }
}

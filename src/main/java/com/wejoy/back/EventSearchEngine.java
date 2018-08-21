package com.wejoy.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EventSearchEngine implements SearchEngine{

    @Autowired
    private RequestSender rs;

    public EventSearchEngine(RequestSender rs){
        this.rs = rs;
    }

    public ArrayList<Event> searchByKeyword(String keyword){
        ArrayList<Event> result = new ArrayList<>();

        result.add(new Event(keyword,keyword,keyword,keyword,keyword));

        try{

            rs.sendPost();
        }catch(Exception e){
            System.out.println(e);
        }

        return result;
    }
}

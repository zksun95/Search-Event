package com.wejoy.back;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EventSearchEngine implements SearchEngine{
    public ArrayList<Event> searchByKeyword(String keyword){
        ArrayList<Event> result = new ArrayList<>();

        result.add(new Event(keyword,keyword,keyword,keyword,keyword));

        return result;
    }
}

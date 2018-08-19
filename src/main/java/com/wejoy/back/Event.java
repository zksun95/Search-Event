package com.wejoy.back;

public class Event {
    private String name;
    private String location;
    private String owner;
    private String time;
    private String img;

    public Event(String name, String location, String owner, String time, String img){
        this.name = name;
        this.location = location;
        this.owner = owner;
        this.time = time;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOwner() {
        return owner;
    }

    public String getTime() {
        return time;
    }
}

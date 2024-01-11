package com.example.lamafirstproject;

public class TeamMember {
    private String name;
    private int imageResource;

    public TeamMember(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}

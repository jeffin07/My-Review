package com.nimkraft.myreview;

/**
 * Created by Jeffin on 19-03-2018.
 */

public class Anime {

    private  String name;
    private String description;
    private String rating;
    private int episode;
    private String catagorie;
    private String img_url;

    public Anime(){}

    public Anime(String name, String description, String rating, int episode, String catagorie, String img_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.episode = episode;
        this.catagorie = catagorie;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public int getEpisode() {
        return episode;
    }

    public String getCatagorie() {
        return catagorie;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public void setCatagorie(String catagorie) {
        this.catagorie = catagorie;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}

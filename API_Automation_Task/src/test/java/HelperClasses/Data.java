package HelperClasses;

import java.util.List;

public class Data {
    private String title;
    private long episode_id;
    private String opening_crawl;
    private String director;
    private String release_date;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;
    private String created;
    private String edited;
    private String url;

    @Override
    public String toString() {
        return "HelperClasses.Data{" +
                "title='" + title + '\'' +
                ", episode_id=" + episode_id +
                ", opening_crawl='" + opening_crawl + '\'' +
                ", director='" + director + '\'' +
                ", release_date='" + release_date + '\'' +
                ", characters=" + characters +
                ", planets=" + planets +
                ", starships=" + starships +
                ", vehicles=" + vehicles +
                ", species=" + species +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }


    public List<String> getCharacters() {
        return characters;
    }
}

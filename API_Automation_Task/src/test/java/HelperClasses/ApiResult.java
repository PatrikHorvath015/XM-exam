package HelperClasses;

import java.util.List;

public class ApiResult {
    private int count;
    private String next;
    private String previous;
    private List<Data> results;

    @Override
    public String toString() {
        return "HelperClasses.ApiResult{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
    public List<String> findCharacters(String title){
        for (Data data: results) {
            if(data.getTitle().equals(title)){
                return data.getCharacters();
            }
        }
        return null;
    }
}

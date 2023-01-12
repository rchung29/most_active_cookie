package org.example;

public class Cookie {
    private String hash;
    private String date;

    public Cookie (String hash, String date) {
        this.hash = hash;
        this.date = date;
    }
    public String getHash(){
        return hash;
    }
    public void setHash(String hash){
        this.hash = hash;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

}

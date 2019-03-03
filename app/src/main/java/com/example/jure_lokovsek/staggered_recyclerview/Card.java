package com.example.jure_lokovsek.staggered_recyclerview;

public class Card {

    private String content1;
    private String content2;
    private String image;

    public Card(String content1, String content2, String image) {
        this.content1 = content1;
        this.content2 = content2;
        this.image = image;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Card{" +
                "content1='" + content1 + '\'' +
                ", content2='" + content2 + '\'' +
                ", image='" + image + '\'' +
                '}';
    }


}

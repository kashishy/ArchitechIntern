package com.example.architechintern;

public class DataPopActivity {

    String name,place,booked,url,star,available,reviews,oldprice,price;

    public DataPopActivity() {
    }

    public DataPopActivity(String name, String place, String booked, String url, String star, String available, String reviews, String oldprice, String price) {
        this.name = name;
        this.place = place;
        this.booked = booked;
        this.url = url;
        this.star = star;
        this.available = available;
        this.reviews = reviews;
        this.oldprice = oldprice;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBooked() {
        return booked;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getOldprice() {
        return oldprice;
    }

    public void setOldprice(String oldprice) {
        this.oldprice = oldprice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

package com.example.movie;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDataItem {

   @SerializedName("title")
   @Expose
   private String title;

   @SerializedName("link")
   @Expose
   private String link;

   @SerializedName("image")
   @Expose
   private String image;

   @SerializedName("pubDate")
   @Expose
   private String pubDate;

   @SerializedName("userRating")
   @Expose
   private String userRating;

   @SerializedName("subtitle")
   @Expose
   private String subtitle;

   @SerializedName("director")
   @Expose
   private String director;

   @SerializedName("actor")
   @Expose
   private String actor;


   public MovieDataItem(String title, String link, String image, String pubDate, String userRating) {
      this.title = title;
      this.link = link;
      this.image = image;
      this.pubDate = pubDate;
      this.userRating = userRating;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getLink() {
      return link;
   }

   public void setLink(String link) {
      this.link = link;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public String getPubDate() {
      return pubDate;
   }

   public void setPubDate(String pubDate) {
      this.pubDate = pubDate;
   }

   public String getUserRating() {
      return userRating;
   }

   public void setUserRating(String userRating) {
      this.userRating = userRating;
   }

   public String getSubtitle() {
      return subtitle;
   }

   public void setSubtitle(String subtitle) {
      this.subtitle = subtitle;
   }

   public String getDirector() {
      return director;
   }

   public void setDirector(String director) {
      this.director = director;
   }

   public String getActor() {
      return actor;
   }

   public void setActor(String actor) {
      this.actor = actor;
   }
}
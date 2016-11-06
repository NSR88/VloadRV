package com.vload.ex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MC11 on 10/28/2016.
 */
public class RoyList implements Serializable{
    @Expose
    @SerializedName("title")
    String Title;
    @Expose
    @SerializedName("description")
    String description;
    @Expose
    @SerializedName("publishedAt")
    String datetime;

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    String thumbnailurl;
}

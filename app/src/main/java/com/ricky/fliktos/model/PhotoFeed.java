package com.ricky.fliktos.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Generated from http://www.jsonschema2pojo.org/
 */
public class PhotoFeed implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("generator")
    @Expose
    private String generator;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    public final static Parcelable.Creator<PhotoFeed> CREATOR = new Creator<PhotoFeed>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PhotoFeed createFromParcel(Parcel in) {
            return new PhotoFeed(in);
        }

        public PhotoFeed[] newArray(int size) {
            return (new PhotoFeed[size]);
        }

    };

    protected PhotoFeed(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.modified = ((String) in.readValue((String.class.getClassLoader())));
        this.generator = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.items, (com.ricky.fliktos.model.Item.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public PhotoFeed() {
    }

    /**
     * @param title
     * @param items
     * @param description
     * @param link
     * @param generator
     * @param modified
     */
    public PhotoFeed(String title, String link, String description, String modified, String generator, List<Item> items) {
        super();
        this.title = title;
        this.link = link;
        this.description = description;
        this.modified = modified;
        this.generator = generator;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PhotoFeed withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PhotoFeed withLink(String link) {
        this.link = link;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PhotoFeed withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public PhotoFeed withModified(String modified) {
        this.modified = modified;
        return this;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public PhotoFeed withGenerator(String generator) {
        this.generator = generator;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public PhotoFeed withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(link);
        dest.writeValue(description);
        dest.writeValue(modified);
        dest.writeValue(generator);
        dest.writeList(items);
    }

    public int describeContents() {
        return 0;
    }

}
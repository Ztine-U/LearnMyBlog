package com.blacktea.ztine.learnmyblog.model;

/**
 * Created by ztine on 16/6/4.
 */
public class Blog {


    private String bID;
    private String bTitle;
    private String bSummary;
    private String bPublished;
    private Author author;
    private String bLink;
    private String bComments;
    private String bViews;
    private String bDiggs;

    public Blog() {
    }

    public Blog(Author author, String bComments, String bDiggs, String bID, String bLink, String bPublished, String bSummary, String bTitle, String bViews) {
        this.author = author;
        this.bComments = bComments;
        this.bDiggs = bDiggs;
        this.bID = bID;
        this.bLink = bLink;
        this.bPublished = bPublished;
        this.bSummary = bSummary;
        this.bTitle = bTitle;
        this.bViews = bViews;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getbComments() {
        return bComments;
    }

    public void setbComments(String bComments) {
        this.bComments = bComments;
    }

    public String getbDiggs() {
        return bDiggs;
    }

    public void setbDiggs(String bDiggs) {
        this.bDiggs = bDiggs;
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getbLink() {
        return bLink;
    }

    public void setbLink(String bLink) {
        this.bLink = bLink;
    }

    public String getbPublished() {
        return bPublished;
    }

    public void setbPublished(String bPublished) {
        this.bPublished = bPublished;
    }

    public String getbSummary() {
        return bSummary;
    }

    public void setbSummary(String bSummary) {
        this.bSummary = bSummary;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbViews() {
        return bViews;
    }

    public void setbViews(String bViews) {
        this.bViews = bViews;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "author=" + author +
                ", bID='" + bID + '\'' +
                ", bTitle='" + bTitle + '\'' +
                ", bSummary='" + bSummary + '\'' +
                ", bPublished='" + bPublished + '\'' +
                ", bLink='" + bLink + '\'' +
                ", bComments='" + bComments + '\'' +
                ", bViews='" + bViews + '\'' +
                ", bDiggs='" + bDiggs + '\'' +
                '}';
    }
}

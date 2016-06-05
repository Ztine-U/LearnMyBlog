package com.blacktea.ztine.learnmyblog.model;

/**
 * Created by ztine on 16/6/4.
 */
public class Author {
    private String aName;
    private String aAvatar;
    private String aUri;

    public Author() {
    }

    public Author(String aAvatar, String aName, String aUri) {
        this.aAvatar = aAvatar;
        this.aName = aName;
        this.aUri = aUri;
    }

    public String getaAvatar() {
        return aAvatar;
    }

    public void setaAvatar(String aAvatar) {
        this.aAvatar = aAvatar;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaUri() {
        return aUri;
    }

    public void setaUri(String aUri) {
        this.aUri = aUri;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aAvatar='" + aAvatar + '\'' +
                ", aName='" + aName + '\'' +
                ", aUri='" + aUri + '\'' +
                '}';
    }
}

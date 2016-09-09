package com.example.tutorial1.backend;

public class UserJava {

    private String author;
    private String comments;
    private Integer vote;
    private String thumbnail;
    private String moreAction;

    public UserJava(String author, String comments, Integer vote, String thumbnail, String moreAction) {
        this.author = author;
        this.comments = comments;
        this.vote = vote;
        this.thumbnail = thumbnail;
        this.moreAction = moreAction;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMoreAction() {
        return moreAction;
    }

    public void setMoreAction(String moreAction) {
        this.moreAction = moreAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserJava userJava = (UserJava) o;

        if (author != null ? !author.equals(userJava.author) : userJava.author != null)
            return false;
        if (comments != null ? !comments.equals(userJava.comments) : userJava.comments != null)
            return false;
        if (vote != null ? !vote.equals(userJava.vote) : userJava.vote != null) return false;
        if (thumbnail != null ? !thumbnail.equals(userJava.thumbnail) : userJava.thumbnail != null)
            return false;
        return moreAction != null ? moreAction.equals(userJava.moreAction) : userJava.moreAction == null;

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (vote != null ? vote.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (moreAction != null ? moreAction.hashCode() : 0);
        return result;
    }
}

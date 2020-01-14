package models;

import java.io.Serializable;

public class Ad implements Serializable {
    private Long id;
    private Long userId;
    private String title;
    private String description;


    public Ad() {
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

//    public Ad(Long id, String title, String description) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//    }

    public Ad(Long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(Long id, Long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
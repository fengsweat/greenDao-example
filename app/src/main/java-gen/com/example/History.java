package com.example;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table HISTORY.
 */
public class History {

    private Long id;
    /** Not-null value. */
    private String message_id;
    private String message;

    public History() {
    }

    public History(Long id) {
        this.id = id;
    }

    public History(Long id, String message_id, String message) {
        this.id = id;
        this.message_id = message_id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getMessage_id() {
        return message_id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

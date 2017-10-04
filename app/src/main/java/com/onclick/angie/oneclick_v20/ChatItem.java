package com.onclick.angie.oneclick_v20;

import java.util.Date;

/**
 * Created by Angie on 10/4/2017.
 */

public class ChatItem {
    private String chat_id;
    private String chat_email;
    private String chat_message;
    private long chat_time;

    public ChatItem() {
    }

    public ChatItem(String chat_email, String chat_message) {
        this.chat_email = chat_email;
        this.chat_message = chat_message;
        chat_time = new Date().getTime();
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getChat_email() {
        return chat_email;
    }

    public void setChat_email(String chat_email) {
        this.chat_email = chat_email;
    }

    public String getChat_message() {
        return chat_message;
    }

    public void setChat_message(String chat_message) {
        this.chat_message = chat_message;
    }

    public long getChat_time() {
        return chat_time;
    }

}


package com.blog.domain;/**
 * Created by apple on 15/10/22.
 */

import com.blog.core.base.BaseEntity;

import java.util.List;

/**
 * com.blog.domain
 *
 * @author : 余峻豪
 * @date : 15/10/22
 */
public class User extends BaseEntity{
    private String username;
    private String password;
    private List<History> historyList;

    @Override
    public String toString () {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", historyList=" + historyList +
                '}';
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public List<History> getHistoryList () {
        return historyList;
    }

    public void setHistoryList (List<History> historyList) {
        this.historyList = historyList;
    }
}

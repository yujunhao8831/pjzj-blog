package com.blog.domain;/**
 * Created by apple on 15/10/22.
 */

import com.blog.core.base.BaseEntity;

import java.util.Date;

/**
 * com.blog.domain
 *
 * @author : 余峻豪
 * @date : 15/10/22
 */
public class History extends BaseEntity {

    private Long parentId;

    private Date historyDate = new Date();
    /** 从 HistoryEnum 中取值 **/
    private Integer historyType;

    private String historyMessage;



    @Override
    public String toString () {
        return "History{" +
                "parentId=" + parentId +
                ", historyDate=" + historyDate +
                ", historyType=" + historyType +
                ", historyMessage='" + historyMessage + '\'' +
                '}';
    }

    public Long getParentId () {
        return parentId;
    }

    public void setParentId (Long parentId) {
        this.parentId = parentId;
    }

    public Date getHistoryDate () {
        return historyDate;
    }

    public void setHistoryDate (Date historyDate) {
        this.historyDate = historyDate;
    }

    public Integer getHistoryType () {
        return historyType;
    }

    public void setHistoryType (Integer historyType) {
        this.historyType = historyType;
    }

    public String getHistoryMessage () {
        return historyMessage;
    }

    public void setHistoryMessage (String historyMessage) {
        this.historyMessage = historyMessage;
    }
}

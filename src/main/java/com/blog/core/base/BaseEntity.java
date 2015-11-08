package com.blog.core.base;/**
 * Created by apple on 15/10/22.
 */

import java.io.Serializable;

/**
 * com.blog.core.base
 *
 * @author : 余峻豪
 * @date : 15/10/22
 */
public class BaseEntity implements Serializable {

    private Long id;

    @Override
    public String toString () {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }
}

package com.blog.core.base;/**
 * Created by apple on 15/11/8.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * com.blog.core.base
 *
 * @author : 余峻豪
 * @date : 15/11/8
 */
public abstract class BaseController {

    protected final Logger logger = LogManager.getLogger(this.getClass());
}

package com.blog.service.impl;/**
 * Created by apple on 15/10/23.
 */

import com.blog.core.base.BaseServiceImpl;
import com.blog.dao.HistoryDao;
import com.blog.domain.History;
import com.blog.service.HistoryService;
import org.springframework.stereotype.Service;

/**
 * com.blog.service.impl
 *
 * @author : 余峻豪
 * @date : 15/10/23
 */
@Service
public class HistoryServiceImpl extends BaseServiceImpl<History,HistoryDao> implements HistoryService {
}

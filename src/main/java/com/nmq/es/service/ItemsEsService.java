package com.nmq.es.service;

import com.nmq.es.common.PagedGridResult;

/**
 * @author niemengquan
 * @create 2020/9/23
 * @modifyUser
 * @modifyDate
 */
public interface ItemsEsService {
    /**
     * 根据关键搜索
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);
}

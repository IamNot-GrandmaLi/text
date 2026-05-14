/**
 * Project Name : cncc
 * File Name    : PageUtils
 * Package Name : com.ustc.cncc.backend.util
 * Date         : 2021-04-06 10:04
 * Author       : jbz
 * Copyright (c) 2019, jiang.baozi@ustcinfo.com All Rights Reserved.
 */
package com.test.utils;

import lombok.Data;

/**
 * @author : jbz
 * @ClassName : PageUtils
 * @Date : 2021-04-06 10:04
 * @Description :
 */
@Data
public class PageUtil {


    /**
     * 总数
     */
    private Integer totalSum;

    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页显示行数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;


    /**
     * @param totalSum    总数量
     * @param pageSize    每页数量
     * @param currentPage 当前页
     */
    public PageUtil(Integer totalSum, Integer pageSize, Integer currentPage) {
        this.totalSum = totalSum;
        //总页数
        if (totalSum != 0 && pageSize != 0) {
            this.totalPage = totalSum % pageSize == 0 ? totalSum / pageSize : (totalSum / pageSize + 1);
        }
        //转到第一页，当前页
        if (null == currentPage || currentPage <= 0) {
            this.currentPage = 1;
            //转到最后一页
        } else if (currentPage > this.totalPage && this.totalPage > 0) {
            this.currentPage = this.totalPage;
        } else {
            this.currentPage = currentPage;
        }
        this.pageSize = pageSize;
    }
}
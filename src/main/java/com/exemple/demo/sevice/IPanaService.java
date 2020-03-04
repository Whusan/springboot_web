package com.exemple.demo.sevice;

import com.exemple.demo.entity.DateList;

import java.util.List;

public interface IPanaService {
    /*
     *@Description 查询所有电影时间
     *@Author  好人1生平胸
     *@Date  2020/3/4 14:43
     *@since 1.0.0
     */
    List<DateList> allMovieDate();
}

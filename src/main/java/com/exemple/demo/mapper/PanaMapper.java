package com.exemple.demo.mapper;

import com.exemple.demo.entity.DateList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PanaMapper {
    @Select("SELECT a.date,COUNT(*) cnt FROM (SELECT DATE_FORMAT(date,'%Y') date FROM movie) a GROUP BY a.date")
    List<DateList> allDateList();
}

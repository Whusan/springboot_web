package com.exemple.demo.controller;

import com.exemple.demo.domain.Result;
import com.exemple.demo.entity.DateList;
import com.exemple.demo.enums.ResultEnum;
import com.exemple.demo.sevice.INavigationService;
import com.exemple.demo.sevice.IPanaService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName panaController
 * @Description TODO
 * @Author 好人1生平胸
 * @Date 2020/3/4 13:45
 * @Version 1.0
 **/
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/pana")
public class PanaController {
    private static Logger logger = LoggerFactory.getLogger(PanaController.class);

    @Autowired
    private IPanaService panaService;

    @GetMapping("/datelist")
    public Result allMovie(){
        Map<String, List<String>> resultMap = Maps.newHashMap();
        List<DateList> list = panaService.allMovieDate();
//        Map<String, String> resultMap = list.stream().collect(Collectors.toMap(DateList::getDate,DateList::getCnt));
        List<String> date = new ArrayList<>();
        List<String> cnt = new ArrayList<>();
        list.forEach(dateList -> {
            date.add(dateList.getDate());
            cnt.add(dateList.getCnt());
        });
        resultMap.put("date",date);
        resultMap.put("cnt",cnt);
        return new Result<>(ResultEnum.SUCCESS, resultMap);
    }
}

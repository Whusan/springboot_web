package com.exemple.demo.controller;

import com.exemple.demo.domain.Result;
import com.exemple.demo.entity.Movie;
import com.exemple.demo.entity.Mtype;
import com.exemple.demo.enums.ResultEnum;
import com.exemple.demo.mapper.SpiderMapper;
import com.exemple.demo.sevice.ISpiderService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/analyze")
public class TypeController {
    private static Logger logger = LoggerFactory.getLogger(TypeController.class);
    @Autowired
    private ISpiderService iSpiderService;

    @RequestMapping("/list01")
    @ResponseBody
    public List<Mtype> echartsShow(Model model) {
        List<Mtype> mtypes = iSpiderService.moviesTypeList();
        return iSpiderService.moviesTypeList();
    }
}

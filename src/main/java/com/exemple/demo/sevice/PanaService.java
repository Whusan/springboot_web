package com.exemple.demo.sevice;

import com.exemple.demo.entity.DateList;
import com.exemple.demo.mapper.PanaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PanaService
 * @Description TODO
 * @Author 好人1生平胸
 * @Date 2020/3/4 14:43
 * @Version 1.0
 **/
@Service
public class PanaService implements IPanaService {
    @Autowired
    PanaMapper panaMapper;

    @Override
    public List<DateList> allMovieDate() {
        return panaMapper.allDateList();
    }
}

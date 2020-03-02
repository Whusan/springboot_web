package com.exemple.demo.controller;

import com.exemple.demo.Const.SqlParam;
import com.exemple.demo.domain.Result;
import com.exemple.demo.enums.ResultEnum;
import com.exemple.demo.sevice.INavigationService;
import com.exemple.demo.sevice.ISpiderService;
import com.exemple.demo.utils.SessionUtil;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Caby on 2017-06-01 3:38 PM.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/spider")
public class SpiderController {
    private static Logger logger = LoggerFactory.getLogger(SpiderController.class);

    private static String t1 ;
    private static String t2 ;

    @Autowired
    private ISpiderService navigationService;

    /**
     * 分页获取导航栏列表
     *
     * @param pageNo Integer, 分页
     * @return Result
     */
    @GetMapping("/list")
    public Result allNavigations(@RequestParam(value = "pageNo", required = false, defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "time1", required = false) String time1,
                                 @RequestParam(value = "time2", required = false) String time2) {
        if (pageNo==0){
            if ( time1 == null || time1.equals(""))  {
                t1 = SqlParam.time1;
                t2 = SqlParam.time2;

            } else {
                t1 = time1.replace('/', '-');
                t2 = time2.replace('/', '-');
            }
        }

        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("navigationCount", navigationService.navigationCount(t1, t2));
        resultMap.put("pageNo", pageNo);
        resultMap.put("pageSize", SqlParam.PageSize);
        resultMap.put("navigationList", navigationService.navigationList(pageNo, t1, t2));
        return new Result<>(ResultEnum.SUCCESS, resultMap);
    }


    /**
     * 删除导航栏
     *
     * @param body String, 请求体, RequestParam不起作用
     * @return Result
     */
    @DeleteMapping("/del")
    public Result deleteNavigation(@RequestBody String body) { // RequestParam does not work!
        List<String> list = Splitter.on("=").splitToList(body);
        Integer nid = Integer.parseInt(list.get(1));
        return new Result(navigationService.deleteNavigation(nid) ? ResultEnum.SUCCESS : ResultEnum.ERR_UNKNOWN);
    }
}

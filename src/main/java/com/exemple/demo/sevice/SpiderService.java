package com.exemple.demo.sevice;

import com.exemple.demo.Const.SqlParam;
import com.exemple.demo.domain.Interface;
import com.exemple.demo.domain.Navigation;
import com.exemple.demo.entity.Movie;
import com.exemple.demo.mapper.NavigationMapper;
import com.exemple.demo.mapper.SpiderMapper;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Caby on 2017-06-01 3:26 PM.
 */
@Service
public class SpiderService implements ISpiderService {
    @Autowired
    private SpiderMapper navigationMapper;
    @Autowired
    private ISpiderService interfaceService;


    private List<Movie> transform(List<com.exemple.demo.entity.Movie> navigationList) {
        List<Movie> resultList = Lists.newArrayList();
        if (navigationList == null || navigationList.isEmpty()) {
            return resultList;
        }
        for (com.exemple.demo.entity.Movie navigation : navigationList) {
            Movie one = new Movie();
            one.setName(navigation.getName());
            one.setDirector(navigation.getDirector());
            one.setWrite(navigation.getWrite());
            one.setActors(navigation.getActors());
            one.setType(navigation.getType());
            one.setWrite(navigation.getWrite());
            one.setDate(navigation.getDate());
            one.setTimelong(navigation.getTimelong());
            one.setIMDburl(navigation.getIMDburl());
            one.setIntrodduction(navigation.getIntrodduction());
            one.setTrailerurl(navigation.getTrailerurl());
            one.setMovieurl(navigation.getMovieurl());
//            if (!Strings.isNullOrEmpty(navigation.getInterfaceIds())) {
//                List<String> interfaceIds = Splitter.on(',')
//                        .trimResults()
//                        .omitEmptyStrings()
//                        .splitToList(navigation.getInterfaceIds());
//                for (String idString : interfaceIds) {
//                    Integer iid = Integer.parseInt(idString);
//                }
//            }

            resultList.add(one);
        }
        return resultList;
    }


    /**
     * 获取所有导航栏
     * @param pageNo Integer, 分页数
     * @return List<Navigation>
     */
    @Override
    public List<Movie> navigationList(Integer pageNo,String time1,String time2) {
        if (pageNo == null) {
            pageNo = 0;
        }
        return this.transform(navigationMapper.navigationList(pageNo * SqlParam.PageSize, SqlParam.PageSize,time1, time2));
    }

    /**
     * 获取导航栏总数量
     * @return Integer
     */
    @Override
    public Integer navigationCount(String time1,String time2) {
        return navigationMapper.navigationCount(time1,time2);
    }



    /**
     * 删除导航栏
     * @param nid Integer, 要删除的导航栏id
     * @return boolean
     */
    @Override
    public boolean deleteNavigation(Integer nid) {
        navigationMapper.deleteNavigation(nid);
        return true;
    }
}

package com.exemple.demo.sevice;

import com.exemple.demo.domain.Navigation;
import com.exemple.demo.entity.Movie;
import com.exemple.demo.entity.Mtype;

import java.util.List;

/**
 * Created by Caby on 2017-06-01 3:22 PM.
 */
public interface ISpiderService {

    /**
     * 获取所有导航栏
     *
     * @param pageNo Integer, 分页数
     * @return List<Navigation>
     */
    List<Movie> navigationList(Integer pageNo, String time1, String time2);

    /**
     * 获取导航栏总数量
     *
     * @return Integer
     */
    Integer navigationCount(String time1, String time2);

    /**
     * 获取所有的影片类型
     *
     * @return Integer
     */
    List<Mtype> moviesTypeList();

    /**
     * 删除导航栏
     *
     * @param nid Integer, 要删除的name
     * @return boolean
     */
    boolean deleteNavigation(Integer nid);
}

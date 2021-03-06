package com.exemple.demo.mapper;

import com.exemple.demo.entity.Movie;
import com.exemple.demo.entity.Mtype;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Caby on 2017-06-01 3:13 PM.
 */
public interface SpiderMapper {
    @Select("SELECT * from movie")
    List<Movie> allNavigations();

    @Select("SELECT a.type as tam,count(a.type) as nums from (select substring_index(substring_index(a.type,' ',b.help_topic_id+1),' ',-1) type " +
            "from movie a  join  mysql.help_topic b  on b.help_topic_id < (length(a.type) - length(replace(a.type,' ',''))+1)) as a GROUP BY a.type")
    List<Mtype> moviesTypeList();

    @Select("SELECT * from movie where date>#{time1} and date <#{time2} order by date LIMIT #{offset}, #{pageSize}")
    List<Movie> navigationList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("time1") String time1, @Param("time2") String time2);

    @Select("SELECT COUNT(name) FROM movie where date>#{time1} and date <#{time2}")
    Integer navigationCount(@Param("time1") String time1, @Param("time2") String time2);

    @Select("SELECT n.id, n.`name`, n.`status`, n.ctime createTime, n.order_num orderNumber, GROUP_CONCAT(i.id) interfaceIds " +
            "FROM navigation n " +
            "LEFT JOIN interface i ON n.id = i.nid " +
            "WHERE n.status = 0 " +
            "GROUP BY n.id " +
            "ORDER BY n.order_num DESC, n.id, i.order_num DESC, i.id")
    List<Movie> navigationsEnabled();

    @Select("SELECT n.id, n.`name`, n.`status`, n.ctime createTime, n.order_num orderNumber, GROUP_CONCAT(i.id) interfaceIds " +
            "FROM navigation n " +
            "INNER JOIN interface i ON n.id = i.nid AND i.status = 0 " +
            "INNER JOIN role_interface ri ON i.id = ri.iid AND ri.status = 0 " +
            "INNER JOIN user_role ur ON ri.rid = ur.rid AND ur.status = 0 AND ur.uid = #{uid} " +
            "WHERE n.status = 0 " +
            "GROUP BY n.id " +
            "ORDER BY n.order_num DESC, n.id, i.order_num DESC, i.id")
    List<Movie> navigationsShowInView(@Param("uid") Integer uid);


    @Delete("DELETE FROM movie WHERE id = #{nid}")
    void deleteNavigation(@Param("name") Integer nid);
}

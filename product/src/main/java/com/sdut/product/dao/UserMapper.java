package com.sdut.product.dao;

import com.sdut.product.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Component
@Mapper
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product..user
     *
     * @mbggenerated Tue Mar 12 11:38:17 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product..user
     *
     * @mbggenerated Tue Mar 12 11:38:17 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product..user
     *
     * @mbggenerated Tue Mar 12 11:38:17 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    List<User> selectAll(@Param(value="str")String str);

    int selectCount(@Param(value="str")String str);

    int selectByUsername(String username);

    int deleteByIds(@Param(value = "ids") String ids);
}
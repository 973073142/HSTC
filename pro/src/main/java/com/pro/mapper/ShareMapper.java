package com.pro.mapper;

import com.pro.entity.Share;
import com.pro.entity.ShareExample;
import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ShareMapper {
    int countByExample(ShareExample example);

    int deleteByExample(ShareExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Object object, @Param("example") ShareExample example);

    int updateByExample(@Param("record") Share record, @Param("example") ShareExample example);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
    
    @Select("select * from share where sid in (select collect.sid from collect where uid=#{uid})")
    List<Share> selectShareByUidInCollect(int uid);
    
    
    
    
    
    /**
     * 		多表查询
     */
    @Select("select * from share where sid=#{sid}")
    @Results({
    	@Result(property = "user" ,column="uid",one = @One(select = "com.pro.mapper.UserMapper.selectUserByUid"))
    })
    public Share selectShareWithUserBySid(int sid) ;
    
    
    @Select("select * from share")
    @Results({
    	@Result(property = "user" ,column="uid",one = @One(select = "com.pro.mapper.UserMapper.selectUserByUid"))
    })
    public List<Share> selectShareWithUserAll();
}
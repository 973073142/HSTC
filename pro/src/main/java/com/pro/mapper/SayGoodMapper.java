package com.pro.mapper;

import com.pro.entity.SayGood;
import com.pro.entity.SayGoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SayGoodMapper {
    int countByExample(SayGoodExample example);

    int deleteByExample(SayGoodExample example);

    int deleteByPrimaryKey(Integer sgid);

    int insert(SayGood record);

    int insertSelective(SayGood record);

    List<SayGood> selectByExample(SayGoodExample example);

    SayGood selectByPrimaryKey(Integer sgid);

    int updateByExampleSelective(@Param("record") SayGood record, @Param("example") SayGoodExample example);

    int updateByExample(@Param("record") SayGood record, @Param("example") SayGoodExample example);

    int updateByPrimaryKeySelective(SayGood record);

    int updateByPrimaryKey(SayGood record);
}
package com.pro.mapper;

import com.pro.entity.Comment;
import com.pro.entity.CommentExample;
import com.pro.entity.CommentWithUserUname;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    @Select("select t.cid ,t.sid,t.uid uid,u.uname,t.uid2 uid2,t.uname2,t.ccontent "
    		+ "from user u,(select c.cid ,c.sid,c.uid uid,c.uid2 uid2,u.uname uname2,c.ccontent from comment c,user u where c.uid2=u.uid) t where t.uid=u.uid and t.sid=#{sid}")
    List<CommentWithUserUname> getCommentBySid(int sid);
    
    
    @Select("select t.cid ,t.sid,t.uid uid,u.uname,t.uid2 uid2,t.uname2,t.ccontent"
    		+ " from user u,(select c.cid ,c.sid,c.uid uid,c.uid2 uid2,u.uname uname2,c.ccontent from comment c,user u where c.uid2=u.uid) t where t.uid=u.uid and t.cid=#{cid}")
    CommentWithUserUname getConmentCommentByCid(int cid);
    
    
}
package com.cl.dao;

import com.cl.entity.DiscusschayexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusschayexinxiView;


/**
 * 茶叶信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface DiscusschayexinxiDao extends BaseMapper<DiscusschayexinxiEntity> {
	
	List<DiscusschayexinxiView> selectListView(@Param("ew") Wrapper<DiscusschayexinxiEntity> wrapper);

	List<DiscusschayexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschayexinxiEntity> wrapper);
	
	DiscusschayexinxiView selectView(@Param("ew") Wrapper<DiscusschayexinxiEntity> wrapper);
	

}

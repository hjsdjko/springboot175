package com.cl.dao;

import com.cl.entity.HuodongleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongleixingView;


/**
 * 活动类型
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface HuodongleixingDao extends BaseMapper<HuodongleixingEntity> {
	
	List<HuodongleixingView> selectListView(@Param("ew") Wrapper<HuodongleixingEntity> wrapper);

	List<HuodongleixingView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongleixingEntity> wrapper);
	
	HuodongleixingView selectView(@Param("ew") Wrapper<HuodongleixingEntity> wrapper);
	

}

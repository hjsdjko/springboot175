package com.cl.dao;

import com.cl.entity.HuodongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongxinxiView;


/**
 * 活动信息
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface HuodongxinxiDao extends BaseMapper<HuodongxinxiEntity> {
	
	List<HuodongxinxiView> selectListView(@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);

	List<HuodongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);
	
	HuodongxinxiView selectView(@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongxinxiEntity> wrapper);



}

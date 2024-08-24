package com.cl.dao;

import com.cl.entity.ChayexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChayexinxiView;


/**
 * 茶叶信息
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface ChayexinxiDao extends BaseMapper<ChayexinxiEntity> {
	
	List<ChayexinxiView> selectListView(@Param("ew") Wrapper<ChayexinxiEntity> wrapper);

	List<ChayexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChayexinxiEntity> wrapper);
	
	ChayexinxiView selectView(@Param("ew") Wrapper<ChayexinxiEntity> wrapper);
	

}

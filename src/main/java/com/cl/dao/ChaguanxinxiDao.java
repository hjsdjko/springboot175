package com.cl.dao;

import com.cl.entity.ChaguanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChaguanxinxiView;


/**
 * 茶馆信息
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface ChaguanxinxiDao extends BaseMapper<ChaguanxinxiEntity> {
	
	List<ChaguanxinxiView> selectListView(@Param("ew") Wrapper<ChaguanxinxiEntity> wrapper);

	List<ChaguanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChaguanxinxiEntity> wrapper);
	
	ChaguanxinxiView selectView(@Param("ew") Wrapper<ChaguanxinxiEntity> wrapper);
	

}

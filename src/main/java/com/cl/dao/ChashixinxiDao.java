package com.cl.dao;

import com.cl.entity.ChashixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChashixinxiView;


/**
 * 茶史信息
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface ChashixinxiDao extends BaseMapper<ChashixinxiEntity> {
	
	List<ChashixinxiView> selectListView(@Param("ew") Wrapper<ChashixinxiEntity> wrapper);

	List<ChashixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChashixinxiEntity> wrapper);
	
	ChashixinxiView selectView(@Param("ew") Wrapper<ChashixinxiEntity> wrapper);
	

}

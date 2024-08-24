package com.cl.dao;

import com.cl.entity.ChaweiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChaweiyuyueView;


/**
 * 茶位预约
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface ChaweiyuyueDao extends BaseMapper<ChaweiyuyueEntity> {
	
	List<ChaweiyuyueView> selectListView(@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);

	List<ChaweiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);
	
	ChaweiyuyueView selectView(@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);



}

package com.cl.dao;

import com.cl.entity.CanjiahuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CanjiahuodongView;


/**
 * 参加活动
 * 
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface CanjiahuodongDao extends BaseMapper<CanjiahuodongEntity> {
	
	List<CanjiahuodongView> selectListView(@Param("ew") Wrapper<CanjiahuodongEntity> wrapper);

	List<CanjiahuodongView> selectListView(Pagination page,@Param("ew") Wrapper<CanjiahuodongEntity> wrapper);
	
	CanjiahuodongView selectView(@Param("ew") Wrapper<CanjiahuodongEntity> wrapper);
	

}

package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CanjiahuodongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CanjiahuodongView;


/**
 * 参加活动
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface CanjiahuodongService extends IService<CanjiahuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanjiahuodongView> selectListView(Wrapper<CanjiahuodongEntity> wrapper);
   	
   	CanjiahuodongView selectView(@Param("ew") Wrapper<CanjiahuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanjiahuodongEntity> wrapper);
   	

}


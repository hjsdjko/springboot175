package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuodongleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuodongleixingView;


/**
 * 活动类型
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface HuodongleixingService extends IService<HuodongleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongleixingView> selectListView(Wrapper<HuodongleixingEntity> wrapper);
   	
   	HuodongleixingView selectView(@Param("ew") Wrapper<HuodongleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongleixingEntity> wrapper);
   	

}


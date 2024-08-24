package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChaweiyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChaweiyuyueView;


/**
 * 茶位预约
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface ChaweiyuyueService extends IService<ChaweiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChaweiyuyueView> selectListView(Wrapper<ChaweiyuyueEntity> wrapper);
   	
   	ChaweiyuyueView selectView(@Param("ew") Wrapper<ChaweiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChaweiyuyueEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChaweiyuyueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChaweiyuyueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChaweiyuyueEntity> wrapper);



}


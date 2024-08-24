package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChayexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChayexinxiView;


/**
 * 茶叶信息
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface ChayexinxiService extends IService<ChayexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChayexinxiView> selectListView(Wrapper<ChayexinxiEntity> wrapper);
   	
   	ChayexinxiView selectView(@Param("ew") Wrapper<ChayexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChayexinxiEntity> wrapper);
   	

}


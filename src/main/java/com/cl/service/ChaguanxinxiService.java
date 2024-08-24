package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChaguanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChaguanxinxiView;


/**
 * 茶馆信息
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface ChaguanxinxiService extends IService<ChaguanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChaguanxinxiView> selectListView(Wrapper<ChaguanxinxiEntity> wrapper);
   	
   	ChaguanxinxiView selectView(@Param("ew") Wrapper<ChaguanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChaguanxinxiEntity> wrapper);
   	

}


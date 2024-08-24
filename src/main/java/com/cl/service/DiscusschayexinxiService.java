package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusschayexinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusschayexinxiView;


/**
 * 茶叶信息评论表
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
public interface DiscusschayexinxiService extends IService<DiscusschayexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschayexinxiView> selectListView(Wrapper<DiscusschayexinxiEntity> wrapper);
   	
   	DiscusschayexinxiView selectView(@Param("ew") Wrapper<DiscusschayexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschayexinxiEntity> wrapper);
   	

}


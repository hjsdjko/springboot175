package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChashixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChashixinxiView;


/**
 * 茶史信息
 *
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
public interface ChashixinxiService extends IService<ChashixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChashixinxiView> selectListView(Wrapper<ChashixinxiEntity> wrapper);
   	
   	ChashixinxiView selectView(@Param("ew") Wrapper<ChashixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChashixinxiEntity> wrapper);
   	

}


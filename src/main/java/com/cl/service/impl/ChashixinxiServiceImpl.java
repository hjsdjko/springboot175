package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChashixinxiDao;
import com.cl.entity.ChashixinxiEntity;
import com.cl.service.ChashixinxiService;
import com.cl.entity.view.ChashixinxiView;

@Service("chashixinxiService")
public class ChashixinxiServiceImpl extends ServiceImpl<ChashixinxiDao, ChashixinxiEntity> implements ChashixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChashixinxiEntity> page = this.selectPage(
                new Query<ChashixinxiEntity>(params).getPage(),
                new EntityWrapper<ChashixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChashixinxiEntity> wrapper) {
		  Page<ChashixinxiView> page =new Query<ChashixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChashixinxiView> selectListView(Wrapper<ChashixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChashixinxiView selectView(Wrapper<ChashixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

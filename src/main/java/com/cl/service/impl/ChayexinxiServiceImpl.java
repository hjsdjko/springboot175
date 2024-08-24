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


import com.cl.dao.ChayexinxiDao;
import com.cl.entity.ChayexinxiEntity;
import com.cl.service.ChayexinxiService;
import com.cl.entity.view.ChayexinxiView;

@Service("chayexinxiService")
public class ChayexinxiServiceImpl extends ServiceImpl<ChayexinxiDao, ChayexinxiEntity> implements ChayexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChayexinxiEntity> page = this.selectPage(
                new Query<ChayexinxiEntity>(params).getPage(),
                new EntityWrapper<ChayexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChayexinxiEntity> wrapper) {
		  Page<ChayexinxiView> page =new Query<ChayexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChayexinxiView> selectListView(Wrapper<ChayexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChayexinxiView selectView(Wrapper<ChayexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.cl.dao.DiscusschayexinxiDao;
import com.cl.entity.DiscusschayexinxiEntity;
import com.cl.service.DiscusschayexinxiService;
import com.cl.entity.view.DiscusschayexinxiView;

@Service("discusschayexinxiService")
public class DiscusschayexinxiServiceImpl extends ServiceImpl<DiscusschayexinxiDao, DiscusschayexinxiEntity> implements DiscusschayexinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschayexinxiEntity> page = this.selectPage(
                new Query<DiscusschayexinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusschayexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschayexinxiEntity> wrapper) {
		  Page<DiscusschayexinxiView> page =new Query<DiscusschayexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusschayexinxiView> selectListView(Wrapper<DiscusschayexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschayexinxiView selectView(Wrapper<DiscusschayexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.cl.dao.ChaguanxinxiDao;
import com.cl.entity.ChaguanxinxiEntity;
import com.cl.service.ChaguanxinxiService;
import com.cl.entity.view.ChaguanxinxiView;

@Service("chaguanxinxiService")
public class ChaguanxinxiServiceImpl extends ServiceImpl<ChaguanxinxiDao, ChaguanxinxiEntity> implements ChaguanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChaguanxinxiEntity> page = this.selectPage(
                new Query<ChaguanxinxiEntity>(params).getPage(),
                new EntityWrapper<ChaguanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChaguanxinxiEntity> wrapper) {
		  Page<ChaguanxinxiView> page =new Query<ChaguanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChaguanxinxiView> selectListView(Wrapper<ChaguanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChaguanxinxiView selectView(Wrapper<ChaguanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

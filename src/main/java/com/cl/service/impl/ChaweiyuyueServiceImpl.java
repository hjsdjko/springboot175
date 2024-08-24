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


import com.cl.dao.ChaweiyuyueDao;
import com.cl.entity.ChaweiyuyueEntity;
import com.cl.service.ChaweiyuyueService;
import com.cl.entity.view.ChaweiyuyueView;

@Service("chaweiyuyueService")
public class ChaweiyuyueServiceImpl extends ServiceImpl<ChaweiyuyueDao, ChaweiyuyueEntity> implements ChaweiyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChaweiyuyueEntity> page = this.selectPage(
                new Query<ChaweiyuyueEntity>(params).getPage(),
                new EntityWrapper<ChaweiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChaweiyuyueEntity> wrapper) {
		  Page<ChaweiyuyueView> page =new Query<ChaweiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChaweiyuyueView> selectListView(Wrapper<ChaweiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChaweiyuyueView selectView(Wrapper<ChaweiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChaweiyuyueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChaweiyuyueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChaweiyuyueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}

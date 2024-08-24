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


import com.cl.dao.CanjiahuodongDao;
import com.cl.entity.CanjiahuodongEntity;
import com.cl.service.CanjiahuodongService;
import com.cl.entity.view.CanjiahuodongView;

@Service("canjiahuodongService")
public class CanjiahuodongServiceImpl extends ServiceImpl<CanjiahuodongDao, CanjiahuodongEntity> implements CanjiahuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanjiahuodongEntity> page = this.selectPage(
                new Query<CanjiahuodongEntity>(params).getPage(),
                new EntityWrapper<CanjiahuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanjiahuodongEntity> wrapper) {
		  Page<CanjiahuodongView> page =new Query<CanjiahuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CanjiahuodongView> selectListView(Wrapper<CanjiahuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanjiahuodongView selectView(Wrapper<CanjiahuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscusschayexinxiEntity;
import com.cl.entity.view.DiscusschayexinxiView;

import com.cl.service.DiscusschayexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 茶叶信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
@RestController
@RequestMapping("/discusschayexinxi")
public class DiscusschayexinxiController {
    @Autowired
    private DiscusschayexinxiService discusschayexinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusschayexinxiEntity discusschayexinxi,
		HttpServletRequest request){
        EntityWrapper<DiscusschayexinxiEntity> ew = new EntityWrapper<DiscusschayexinxiEntity>();

		PageUtils page = discusschayexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschayexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusschayexinxiEntity discusschayexinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscusschayexinxiEntity> ew = new EntityWrapper<DiscusschayexinxiEntity>();

		PageUtils page = discusschayexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschayexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusschayexinxiEntity discusschayexinxi){
       	EntityWrapper<DiscusschayexinxiEntity> ew = new EntityWrapper<DiscusschayexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusschayexinxi, "discusschayexinxi")); 
        return R.ok().put("data", discusschayexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusschayexinxiEntity discusschayexinxi){
        EntityWrapper< DiscusschayexinxiEntity> ew = new EntityWrapper< DiscusschayexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusschayexinxi, "discusschayexinxi")); 
		DiscusschayexinxiView discusschayexinxiView =  discusschayexinxiService.selectView(ew);
		return R.ok("查询茶叶信息评论表成功").put("data", discusschayexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusschayexinxiEntity discusschayexinxi = discusschayexinxiService.selectById(id);
		discusschayexinxi = discusschayexinxiService.selectView(new EntityWrapper<DiscusschayexinxiEntity>().eq("id", id));
        return R.ok().put("data", discusschayexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusschayexinxiEntity discusschayexinxi = discusschayexinxiService.selectById(id);
		discusschayexinxi = discusschayexinxiService.selectView(new EntityWrapper<DiscusschayexinxiEntity>().eq("id", id));
        return R.ok().put("data", discusschayexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusschayexinxiEntity discusschayexinxi, HttpServletRequest request){
    	discusschayexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusschayexinxi);
        discusschayexinxiService.insert(discusschayexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusschayexinxiEntity discusschayexinxi, HttpServletRequest request){
    	discusschayexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusschayexinxi);
        discusschayexinxiService.insert(discusschayexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusschayexinxiEntity discusschayexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusschayexinxi);
        discusschayexinxiService.updateById(discusschayexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusschayexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusschayexinxiEntity discusschayexinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscusschayexinxiEntity> ew = new EntityWrapper<DiscusschayexinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discusschayexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschayexinxi), params), params));
        return R.ok().put("data", page);
    }








}

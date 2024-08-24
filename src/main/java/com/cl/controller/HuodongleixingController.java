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

import com.cl.entity.HuodongleixingEntity;
import com.cl.entity.view.HuodongleixingView;

import com.cl.service.HuodongleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 活动类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
@RestController
@RequestMapping("/huodongleixing")
public class HuodongleixingController {
    @Autowired
    private HuodongleixingService huodongleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongleixingEntity huodongleixing,
		HttpServletRequest request){
        EntityWrapper<HuodongleixingEntity> ew = new EntityWrapper<HuodongleixingEntity>();

		PageUtils page = huodongleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongleixingEntity huodongleixing, 
		HttpServletRequest request){
        EntityWrapper<HuodongleixingEntity> ew = new EntityWrapper<HuodongleixingEntity>();

		PageUtils page = huodongleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongleixingEntity huodongleixing){
       	EntityWrapper<HuodongleixingEntity> ew = new EntityWrapper<HuodongleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongleixing, "huodongleixing")); 
        return R.ok().put("data", huodongleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongleixingEntity huodongleixing){
        EntityWrapper< HuodongleixingEntity> ew = new EntityWrapper< HuodongleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongleixing, "huodongleixing")); 
		HuodongleixingView huodongleixingView =  huodongleixingService.selectView(ew);
		return R.ok("查询活动类型成功").put("data", huodongleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongleixingEntity huodongleixing = huodongleixingService.selectById(id);
		huodongleixing = huodongleixingService.selectView(new EntityWrapper<HuodongleixingEntity>().eq("id", id));
        return R.ok().put("data", huodongleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongleixingEntity huodongleixing = huodongleixingService.selectById(id);
		huodongleixing = huodongleixingService.selectView(new EntityWrapper<HuodongleixingEntity>().eq("id", id));
        return R.ok().put("data", huodongleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongleixingEntity huodongleixing, HttpServletRequest request){
    	huodongleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongleixing);
        huodongleixingService.insert(huodongleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongleixingEntity huodongleixing, HttpServletRequest request){
    	huodongleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongleixing);
        huodongleixingService.insert(huodongleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongleixingEntity huodongleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongleixing);
        huodongleixingService.updateById(huodongleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

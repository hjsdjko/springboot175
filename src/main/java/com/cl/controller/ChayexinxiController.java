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

import com.cl.entity.ChayexinxiEntity;
import com.cl.entity.view.ChayexinxiView;

import com.cl.service.ChayexinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 茶叶信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
@RestController
@RequestMapping("/chayexinxi")
public class ChayexinxiController {
    @Autowired
    private ChayexinxiService chayexinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChayexinxiEntity chayexinxi,
		HttpServletRequest request){
        EntityWrapper<ChayexinxiEntity> ew = new EntityWrapper<ChayexinxiEntity>();

		PageUtils page = chayexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chayexinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChayexinxiEntity chayexinxi, 
		HttpServletRequest request){
        EntityWrapper<ChayexinxiEntity> ew = new EntityWrapper<ChayexinxiEntity>();

		PageUtils page = chayexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chayexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChayexinxiEntity chayexinxi){
       	EntityWrapper<ChayexinxiEntity> ew = new EntityWrapper<ChayexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chayexinxi, "chayexinxi")); 
        return R.ok().put("data", chayexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChayexinxiEntity chayexinxi){
        EntityWrapper< ChayexinxiEntity> ew = new EntityWrapper< ChayexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chayexinxi, "chayexinxi")); 
		ChayexinxiView chayexinxiView =  chayexinxiService.selectView(ew);
		return R.ok("查询茶叶信息成功").put("data", chayexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChayexinxiEntity chayexinxi = chayexinxiService.selectById(id);
		chayexinxi.setClicknum(chayexinxi.getClicknum()+1);
		chayexinxiService.updateById(chayexinxi);
		chayexinxi = chayexinxiService.selectView(new EntityWrapper<ChayexinxiEntity>().eq("id", id));
        return R.ok().put("data", chayexinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChayexinxiEntity chayexinxi = chayexinxiService.selectById(id);
		chayexinxi.setClicknum(chayexinxi.getClicknum()+1);
		chayexinxiService.updateById(chayexinxi);
		chayexinxi = chayexinxiService.selectView(new EntityWrapper<ChayexinxiEntity>().eq("id", id));
        return R.ok().put("data", chayexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChayexinxiEntity chayexinxi, HttpServletRequest request){
    	chayexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chayexinxi);
        chayexinxiService.insert(chayexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChayexinxiEntity chayexinxi, HttpServletRequest request){
    	chayexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chayexinxi);
        chayexinxiService.insert(chayexinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChayexinxiEntity chayexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chayexinxi);
        chayexinxiService.updateById(chayexinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chayexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

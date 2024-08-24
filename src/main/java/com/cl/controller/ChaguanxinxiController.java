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

import com.cl.entity.ChaguanxinxiEntity;
import com.cl.entity.view.ChaguanxinxiView;

import com.cl.service.ChaguanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 茶馆信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
@RestController
@RequestMapping("/chaguanxinxi")
public class ChaguanxinxiController {
    @Autowired
    private ChaguanxinxiService chaguanxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChaguanxinxiEntity chaguanxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			chaguanxinxi.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChaguanxinxiEntity> ew = new EntityWrapper<ChaguanxinxiEntity>();

		PageUtils page = chaguanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chaguanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChaguanxinxiEntity chaguanxinxi, 
		HttpServletRequest request){
        EntityWrapper<ChaguanxinxiEntity> ew = new EntityWrapper<ChaguanxinxiEntity>();

		PageUtils page = chaguanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chaguanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChaguanxinxiEntity chaguanxinxi){
       	EntityWrapper<ChaguanxinxiEntity> ew = new EntityWrapper<ChaguanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chaguanxinxi, "chaguanxinxi")); 
        return R.ok().put("data", chaguanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChaguanxinxiEntity chaguanxinxi){
        EntityWrapper< ChaguanxinxiEntity> ew = new EntityWrapper< ChaguanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chaguanxinxi, "chaguanxinxi")); 
		ChaguanxinxiView chaguanxinxiView =  chaguanxinxiService.selectView(ew);
		return R.ok("查询茶馆信息成功").put("data", chaguanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChaguanxinxiEntity chaguanxinxi = chaguanxinxiService.selectById(id);
		chaguanxinxi = chaguanxinxiService.selectView(new EntityWrapper<ChaguanxinxiEntity>().eq("id", id));
        return R.ok().put("data", chaguanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChaguanxinxiEntity chaguanxinxi = chaguanxinxiService.selectById(id);
		chaguanxinxi = chaguanxinxiService.selectView(new EntityWrapper<ChaguanxinxiEntity>().eq("id", id));
        return R.ok().put("data", chaguanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChaguanxinxiEntity chaguanxinxi, HttpServletRequest request){
    	chaguanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chaguanxinxi);
        chaguanxinxiService.insert(chaguanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChaguanxinxiEntity chaguanxinxi, HttpServletRequest request){
    	chaguanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chaguanxinxi);
        chaguanxinxiService.insert(chaguanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChaguanxinxiEntity chaguanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chaguanxinxi);
        chaguanxinxiService.updateById(chaguanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chaguanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

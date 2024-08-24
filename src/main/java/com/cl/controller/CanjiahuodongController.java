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

import com.cl.entity.CanjiahuodongEntity;
import com.cl.entity.view.CanjiahuodongView;

import com.cl.service.CanjiahuodongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 参加活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-11 22:37:23
 */
@RestController
@RequestMapping("/canjiahuodong")
public class CanjiahuodongController {
    @Autowired
    private CanjiahuodongService canjiahuodongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CanjiahuodongEntity canjiahuodong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			canjiahuodong.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CanjiahuodongEntity> ew = new EntityWrapper<CanjiahuodongEntity>();

		PageUtils page = canjiahuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjiahuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CanjiahuodongEntity canjiahuodong, 
		HttpServletRequest request){
        EntityWrapper<CanjiahuodongEntity> ew = new EntityWrapper<CanjiahuodongEntity>();

		PageUtils page = canjiahuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjiahuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CanjiahuodongEntity canjiahuodong){
       	EntityWrapper<CanjiahuodongEntity> ew = new EntityWrapper<CanjiahuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( canjiahuodong, "canjiahuodong")); 
        return R.ok().put("data", canjiahuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CanjiahuodongEntity canjiahuodong){
        EntityWrapper< CanjiahuodongEntity> ew = new EntityWrapper< CanjiahuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( canjiahuodong, "canjiahuodong")); 
		CanjiahuodongView canjiahuodongView =  canjiahuodongService.selectView(ew);
		return R.ok("查询参加活动成功").put("data", canjiahuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CanjiahuodongEntity canjiahuodong = canjiahuodongService.selectById(id);
		canjiahuodong = canjiahuodongService.selectView(new EntityWrapper<CanjiahuodongEntity>().eq("id", id));
        return R.ok().put("data", canjiahuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CanjiahuodongEntity canjiahuodong = canjiahuodongService.selectById(id);
		canjiahuodong = canjiahuodongService.selectView(new EntityWrapper<CanjiahuodongEntity>().eq("id", id));
        return R.ok().put("data", canjiahuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CanjiahuodongEntity canjiahuodong, HttpServletRequest request){
    	canjiahuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjiahuodong);
        canjiahuodongService.insert(canjiahuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CanjiahuodongEntity canjiahuodong, HttpServletRequest request){
    	canjiahuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjiahuodong);
        canjiahuodongService.insert(canjiahuodong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CanjiahuodongEntity canjiahuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canjiahuodong);
        canjiahuodongService.updateById(canjiahuodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        canjiahuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}

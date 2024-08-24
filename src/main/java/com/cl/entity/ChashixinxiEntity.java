package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 茶史信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
@TableName("chashixinxi")
public class ChashixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChashixinxiEntity() {
		
	}
	
	public ChashixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 茶叶名称
	 */
					
	private String chayemingcheng;
	
	/**
	 * 茶叶类型
	 */
					
	private String chayeleixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 制作过程
	 */
					
	private String zhizuoguocheng;
	
	/**
	 * 文化蕴含
	 */
					
	private String wenhuayunhan;
	
	/**
	 * 历史背景
	 */
					
	private String lishibeijing;
	
	/**
	 * 演变过程
	 */
					
	private String yanbianguocheng;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：茶叶名称
	 */
	public void setChayemingcheng(String chayemingcheng) {
		this.chayemingcheng = chayemingcheng;
	}
	/**
	 * 获取：茶叶名称
	 */
	public String getChayemingcheng() {
		return chayemingcheng;
	}
	/**
	 * 设置：茶叶类型
	 */
	public void setChayeleixing(String chayeleixing) {
		this.chayeleixing = chayeleixing;
	}
	/**
	 * 获取：茶叶类型
	 */
	public String getChayeleixing() {
		return chayeleixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：制作过程
	 */
	public void setZhizuoguocheng(String zhizuoguocheng) {
		this.zhizuoguocheng = zhizuoguocheng;
	}
	/**
	 * 获取：制作过程
	 */
	public String getZhizuoguocheng() {
		return zhizuoguocheng;
	}
	/**
	 * 设置：文化蕴含
	 */
	public void setWenhuayunhan(String wenhuayunhan) {
		this.wenhuayunhan = wenhuayunhan;
	}
	/**
	 * 获取：文化蕴含
	 */
	public String getWenhuayunhan() {
		return wenhuayunhan;
	}
	/**
	 * 设置：历史背景
	 */
	public void setLishibeijing(String lishibeijing) {
		this.lishibeijing = lishibeijing;
	}
	/**
	 * 获取：历史背景
	 */
	public String getLishibeijing() {
		return lishibeijing;
	}
	/**
	 * 设置：演变过程
	 */
	public void setYanbianguocheng(String yanbianguocheng) {
		this.yanbianguocheng = yanbianguocheng;
	}
	/**
	 * 获取：演变过程
	 */
	public String getYanbianguocheng() {
		return yanbianguocheng;
	}

}

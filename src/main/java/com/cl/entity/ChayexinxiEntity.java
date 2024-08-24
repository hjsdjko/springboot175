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
 * 茶叶信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
@TableName("chayexinxi")
public class ChayexinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChayexinxiEntity() {
		
	}
	
	public ChayexinxiEntity(T t) {
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
	 * 茶叶等级
	 */
					
	private String chayedengji;
	
	/**
	 * 品牌
	 */
					
	private String pinpai;
	
	/**
	 * 产地
	 */
					
	private String chandi;
	
	/**
	 * 年份
	 */
					
	private String nianfen;
	
	/**
	 * 生产日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shengchanriqi;
	
	/**
	 * 茶叶详情
	 */
					
	private String chayexiangqing;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
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
	 * 设置：茶叶等级
	 */
	public void setChayedengji(String chayedengji) {
		this.chayedengji = chayedengji;
	}
	/**
	 * 获取：茶叶等级
	 */
	public String getChayedengji() {
		return chayedengji;
	}
	/**
	 * 设置：品牌
	 */
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	/**
	 * 获取：品牌
	 */
	public String getPinpai() {
		return pinpai;
	}
	/**
	 * 设置：产地
	 */
	public void setChandi(String chandi) {
		this.chandi = chandi;
	}
	/**
	 * 获取：产地
	 */
	public String getChandi() {
		return chandi;
	}
	/**
	 * 设置：年份
	 */
	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}
	/**
	 * 获取：年份
	 */
	public String getNianfen() {
		return nianfen;
	}
	/**
	 * 设置：生产日期
	 */
	public void setShengchanriqi(Date shengchanriqi) {
		this.shengchanriqi = shengchanriqi;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getShengchanriqi() {
		return shengchanriqi;
	}
	/**
	 * 设置：茶叶详情
	 */
	public void setChayexiangqing(String chayexiangqing) {
		this.chayexiangqing = chayexiangqing;
	}
	/**
	 * 获取：茶叶详情
	 */
	public String getChayexiangqing() {
		return chayexiangqing;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}

package com.cl.entity.view;

import com.cl.entity.ChayexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 茶叶信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-11 22:37:22
 */
@TableName("chayexinxi")
public class ChayexinxiView  extends ChayexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChayexinxiView(){
	}
 
 	public ChayexinxiView(ChayexinxiEntity chayexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, chayexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

package com.entity.view;

import com.entity.YingpinyaoqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 应聘邀请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date
 */
@TableName("yingpinyaoqing")
public class YingpinyaoqingView  extends YingpinyaoqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingpinyaoqingView(){
	}
 
 	public YingpinyaoqingView(YingpinyaoqingEntity yingpinyaoqingEntity){
 	try {
			BeanUtils.copyProperties(this, yingpinyaoqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

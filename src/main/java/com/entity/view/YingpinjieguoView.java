package com.entity.view;

import com.entity.YingpinjieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 应聘结果
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date
 */
@TableName("yingpinjieguo")
public class YingpinjieguoView  extends YingpinjieguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingpinjieguoView(){
	}
 
 	public YingpinjieguoView(YingpinjieguoEntity yingpinjieguoEntity){
 	try {
			BeanUtils.copyProperties(this, yingpinjieguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

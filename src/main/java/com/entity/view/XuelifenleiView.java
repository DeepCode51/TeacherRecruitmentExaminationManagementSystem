package com.entity.view;

import com.entity.XuelifenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学历分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date
 */
@TableName("xuelifenlei")
public class XuelifenleiView  extends XuelifenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuelifenleiView(){
	}
 
 	public XuelifenleiView(XuelifenleiEntity xuelifenleiEntity){
 	try {
			BeanUtils.copyProperties(this, xuelifenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

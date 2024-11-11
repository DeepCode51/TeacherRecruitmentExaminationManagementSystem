package com.entity.model;

import com.entity.ZhaopinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 招聘信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date
 */
public class ZhaopinxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 岗位类别
	 */
	
	private String gangweileibie;
		
	/**
	 * 封面图
	 */
	
	private String fengmiantu;
		
	/**
	 * 岗位简介
	 */
	
	private String gangweijianjie;
		
	/**
	 * 招聘人数
	 */
	
	private Integer zhaopinrenshu;
		
	/**
	 * 学历要求
	 */
	
	private String xueliyaoqiu;
		
	/**
	 * 专业要求
	 */
	
	private String zhuanyeyaoqiu;
		
	/**
	 * 其他条件
	 */
	
	private String qitatiaojian;
		
	/**
	 * 招聘方式
	 */
	
	private String zhaopinfangshi;
		
	/**
	 * 薪资待遇
	 */
	
	private String xinzidaiyu;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
				
	
	/**
	 * 设置：岗位类别
	 */
	 
	public void setGangweileibie(String gangweileibie) {
		this.gangweileibie = gangweileibie;
	}
	
	/**
	 * 获取：岗位类别
	 */
	public String getGangweileibie() {
		return gangweileibie;
	}
				
	
	/**
	 * 设置：封面图
	 */
	 
	public void setFengmiantu(String fengmiantu) {
		this.fengmiantu = fengmiantu;
	}
	
	/**
	 * 获取：封面图
	 */
	public String getFengmiantu() {
		return fengmiantu;
	}
				
	
	/**
	 * 设置：岗位简介
	 */
	 
	public void setGangweijianjie(String gangweijianjie) {
		this.gangweijianjie = gangweijianjie;
	}
	
	/**
	 * 获取：岗位简介
	 */
	public String getGangweijianjie() {
		return gangweijianjie;
	}
				
	
	/**
	 * 设置：招聘人数
	 */
	 
	public void setZhaopinrenshu(Integer zhaopinrenshu) {
		this.zhaopinrenshu = zhaopinrenshu;
	}
	
	/**
	 * 获取：招聘人数
	 */
	public Integer getZhaopinrenshu() {
		return zhaopinrenshu;
	}
				
	
	/**
	 * 设置：学历要求
	 */
	 
	public void setXueliyaoqiu(String xueliyaoqiu) {
		this.xueliyaoqiu = xueliyaoqiu;
	}
	
	/**
	 * 获取：学历要求
	 */
	public String getXueliyaoqiu() {
		return xueliyaoqiu;
	}
				
	
	/**
	 * 设置：专业要求
	 */
	 
	public void setZhuanyeyaoqiu(String zhuanyeyaoqiu) {
		this.zhuanyeyaoqiu = zhuanyeyaoqiu;
	}
	
	/**
	 * 获取：专业要求
	 */
	public String getZhuanyeyaoqiu() {
		return zhuanyeyaoqiu;
	}
				
	
	/**
	 * 设置：其他条件
	 */
	 
	public void setQitatiaojian(String qitatiaojian) {
		this.qitatiaojian = qitatiaojian;
	}
	
	/**
	 * 获取：其他条件
	 */
	public String getQitatiaojian() {
		return qitatiaojian;
	}
				
	
	/**
	 * 设置：招聘方式
	 */
	 
	public void setZhaopinfangshi(String zhaopinfangshi) {
		this.zhaopinfangshi = zhaopinfangshi;
	}
	
	/**
	 * 获取：招聘方式
	 */
	public String getZhaopinfangshi() {
		return zhaopinfangshi;
	}
				
	
	/**
	 * 设置：薪资待遇
	 */
	 
	public void setXinzidaiyu(String xinzidaiyu) {
		this.xinzidaiyu = xinzidaiyu;
	}
	
	/**
	 * 获取：薪资待遇
	 */
	public String getXinzidaiyu() {
		return xinzidaiyu;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
			
}

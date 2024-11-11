package com.entity;

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
 * 应聘结果
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date
 */
@TableName("yingpinjieguo")
public class YingpinjieguoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingpinjieguoEntity() {
		
	}
	public YingpinjieguoEntity(T t) {
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
	 * 岗位名称
	 */					
	private String gangweimingcheng;	
	/**
	 * 岗位类别
	 */
	private String gangweileibie;
	/**
	 * 薪资待遇
	 */
	private String xinzidaiyu;
	/**
	 * 笔试分数
	 */
	private Float bishifenshu;
	/**
	 * 面试分数
	 */
	private Float mianshifenshu;
	/**
	 * 总分
	 */
	private String zongfen;
	/**
	 * 面试结果
	 */
	private String mianshijieguo;	
	/**
	 * 登记时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;	
	/**
	 * 用户名
	 */					
	private String yonghuming;	
	/**
	 * 姓名
	 */					
	private String xingming;	
	/**
	 * 手机
	 */					
	private String shouji;	
	/**
	 * 跨表用户id
	 */					
	private Long crossuserid;	
	/**
	 * 跨表主键id
	 */					
	private Long crossrefid;
	
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
	 * 设置：岗位名称
	 */
	public void setGangweimingcheng(String gangweimingcheng) {
		this.gangweimingcheng = gangweimingcheng;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getGangweimingcheng() {
		return gangweimingcheng;
	}
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
	 * 设置：笔试分数
	 */
	public void setBishifenshu(Float bishifenshu) {
		this.bishifenshu = bishifenshu;
	}
	/**
	 * 获取：笔试分数
	 */
	public Float getBishifenshu() {
		return bishifenshu;
	}
	/**
	 * 设置：面试分数
	 */
	public void setMianshifenshu(Float mianshifenshu) {
		this.mianshifenshu = mianshifenshu;
	}
	/**
	 * 获取：面试分数
	 */
	public Float getMianshifenshu() {
		return mianshifenshu;
	}
	/**
	 * 设置：总分
	 */
	public void setZongfen(String zongfen) {
		this.zongfen = zongfen;
	}
	/**
	 * 获取：总分
	 */
	public String getZongfen() {
		return zongfen;
	}
	/**
	 * 设置：面试结果
	 */
	public void setMianshijieguo(String mianshijieguo) {
		this.mianshijieguo = mianshijieguo;
	}
	/**
	 * 获取：面试结果
	 */
	public String getMianshijieguo() {
		return mianshijieguo;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
}

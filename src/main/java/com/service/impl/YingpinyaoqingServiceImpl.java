package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YingpinyaoqingDao;
import com.entity.YingpinyaoqingEntity;
import com.service.YingpinyaoqingService;
import com.entity.vo.YingpinyaoqingVO;
import com.entity.view.YingpinyaoqingView;

@Service("yingpinyaoqingService")
public class YingpinyaoqingServiceImpl extends ServiceImpl<YingpinyaoqingDao, YingpinyaoqingEntity> implements YingpinyaoqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingpinyaoqingEntity> page = this.selectPage(
                new Query<YingpinyaoqingEntity>(params).getPage(),
                new EntityWrapper<YingpinyaoqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingpinyaoqingEntity> wrapper) {
		  Page<YingpinyaoqingView> page =new Query<YingpinyaoqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YingpinyaoqingVO> selectListVO(Wrapper<YingpinyaoqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YingpinyaoqingVO selectVO(Wrapper<YingpinyaoqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YingpinyaoqingView> selectListView(Wrapper<YingpinyaoqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingpinyaoqingView selectView(Wrapper<YingpinyaoqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

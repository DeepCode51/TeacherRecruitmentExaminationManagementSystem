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


import com.dao.XuelifenleiDao;
import com.entity.XuelifenleiEntity;
import com.service.XuelifenleiService;
import com.entity.vo.XuelifenleiVO;
import com.entity.view.XuelifenleiView;

@Service("xuelifenleiService")
public class XuelifenleiServiceImpl extends ServiceImpl<XuelifenleiDao, XuelifenleiEntity> implements XuelifenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuelifenleiEntity> page = this.selectPage(
                new Query<XuelifenleiEntity>(params).getPage(),
                new EntityWrapper<XuelifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuelifenleiEntity> wrapper) {
		  Page<XuelifenleiView> page =new Query<XuelifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuelifenleiVO> selectListVO(Wrapper<XuelifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuelifenleiVO selectVO(Wrapper<XuelifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuelifenleiView> selectListView(Wrapper<XuelifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuelifenleiView selectView(Wrapper<XuelifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

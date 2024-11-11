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


import com.dao.GerenjianliDao;
import com.entity.GerenjianliEntity;
import com.service.GerenjianliService;
import com.entity.vo.GerenjianliVO;
import com.entity.view.GerenjianliView;

@Service("gerenjianliService")
public class GerenjianliServiceImpl extends ServiceImpl<GerenjianliDao, GerenjianliEntity> implements GerenjianliService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GerenjianliEntity> page = this.selectPage(
                new Query<GerenjianliEntity>(params).getPage(),
                new EntityWrapper<GerenjianliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GerenjianliEntity> wrapper) {
		  Page<GerenjianliView> page =new Query<GerenjianliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GerenjianliVO> selectListVO(Wrapper<GerenjianliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GerenjianliVO selectVO(Wrapper<GerenjianliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GerenjianliView> selectListView(Wrapper<GerenjianliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GerenjianliView selectView(Wrapper<GerenjianliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

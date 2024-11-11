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


import com.dao.YingpinjieguoDao;
import com.entity.YingpinjieguoEntity;
import com.service.YingpinjieguoService;
import com.entity.vo.YingpinjieguoVO;
import com.entity.view.YingpinjieguoView;

@Service("yingpinjieguoService")
public class YingpinjieguoServiceImpl extends ServiceImpl<YingpinjieguoDao, YingpinjieguoEntity> implements YingpinjieguoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingpinjieguoEntity> page = this.selectPage(
                new Query<YingpinjieguoEntity>(params).getPage(),
                new EntityWrapper<YingpinjieguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingpinjieguoEntity> wrapper) {
		  Page<YingpinjieguoView> page =new Query<YingpinjieguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YingpinjieguoVO> selectListVO(Wrapper<YingpinjieguoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YingpinjieguoVO selectVO(Wrapper<YingpinjieguoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YingpinjieguoView> selectListView(Wrapper<YingpinjieguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingpinjieguoView selectView(Wrapper<YingpinjieguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

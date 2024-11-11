package com.dao;

import com.entity.XuelifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuelifenleiVO;
import com.entity.view.XuelifenleiView;


/**
 * 学历分类
 * 
 * @author 
 * @email 
 * @date
 */
public interface XuelifenleiDao extends BaseMapper<XuelifenleiEntity> {
	
	List<XuelifenleiVO> selectListVO(@Param("ew") Wrapper<XuelifenleiEntity> wrapper);
	
	XuelifenleiVO selectVO(@Param("ew") Wrapper<XuelifenleiEntity> wrapper);
	
	List<XuelifenleiView> selectListView(@Param("ew") Wrapper<XuelifenleiEntity> wrapper);

	List<XuelifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<XuelifenleiEntity> wrapper);
	
	XuelifenleiView selectView(@Param("ew") Wrapper<XuelifenleiEntity> wrapper);
	
}

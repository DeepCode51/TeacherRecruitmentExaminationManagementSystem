package com.dao;

import com.entity.YingpinjieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YingpinjieguoVO;
import com.entity.view.YingpinjieguoView;


/**
 * 应聘结果
 * 
 * @author 
 * @email 
 * @date
 */
public interface YingpinjieguoDao extends BaseMapper<YingpinjieguoEntity> {
	
	List<YingpinjieguoVO> selectListVO(@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);
	
	YingpinjieguoVO selectVO(@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);
	
	List<YingpinjieguoView> selectListView(@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);

	List<YingpinjieguoView> selectListView(Pagination page,@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);
	
	YingpinjieguoView selectView(@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);
	
}

package com.dao;

import com.entity.MenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MenuVO;
import com.entity.view.MenuView;


/**
 * 菜单
 * 
 * @author 
 * @email 
 * @date
 */
public interface MenuDao extends BaseMapper<MenuEntity> {
	
	List<MenuVO> selectListVO(@Param("ew") Wrapper<MenuEntity> wrapper);
	
	MenuVO selectVO(@Param("ew") Wrapper<MenuEntity> wrapper);
	
	List<MenuView> selectListView(@Param("ew") Wrapper<MenuEntity> wrapper);

	List<MenuView> selectListView(Pagination page,@Param("ew") Wrapper<MenuEntity> wrapper);
	
	MenuView selectView(@Param("ew") Wrapper<MenuEntity> wrapper);
	
}

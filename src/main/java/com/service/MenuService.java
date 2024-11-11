package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MenuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MenuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MenuView;


/**
 * 菜单
 *
 * @author 
 * @email 
 * @date
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MenuVO> selectListVO(Wrapper<MenuEntity> wrapper);
   	
   	MenuVO selectVO(@Param("ew") Wrapper<MenuEntity> wrapper);
   	
   	List<MenuView> selectListView(Wrapper<MenuEntity> wrapper);
   	
   	MenuView selectView(@Param("ew") Wrapper<MenuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MenuEntity> wrapper);
   	
}


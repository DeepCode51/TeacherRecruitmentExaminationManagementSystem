package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuelifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuelifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuelifenleiView;


/**
 * 学历分类
 *
 * @author 
 * @email 
 * @date
 */
public interface XuelifenleiService extends IService<XuelifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuelifenleiVO> selectListVO(Wrapper<XuelifenleiEntity> wrapper);
   	
   	XuelifenleiVO selectVO(@Param("ew") Wrapper<XuelifenleiEntity> wrapper);
   	
   	List<XuelifenleiView> selectListView(Wrapper<XuelifenleiEntity> wrapper);
   	
   	XuelifenleiView selectView(@Param("ew") Wrapper<XuelifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuelifenleiEntity> wrapper);
   	
}


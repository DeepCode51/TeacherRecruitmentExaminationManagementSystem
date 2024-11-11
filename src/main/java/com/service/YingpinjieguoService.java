package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YingpinjieguoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YingpinjieguoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YingpinjieguoView;


/**
 * 应聘结果
 *
 * @author 
 * @email 
 * @date
 */
public interface YingpinjieguoService extends IService<YingpinjieguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingpinjieguoVO> selectListVO(Wrapper<YingpinjieguoEntity> wrapper);
   	
   	YingpinjieguoVO selectVO(@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);
   	
   	List<YingpinjieguoView> selectListView(Wrapper<YingpinjieguoEntity> wrapper);
   	
   	YingpinjieguoView selectView(@Param("ew") Wrapper<YingpinjieguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingpinjieguoEntity> wrapper);
   	
}


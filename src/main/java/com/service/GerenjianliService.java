package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GerenjianliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GerenjianliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GerenjianliView;


/**
 * 个人简历
 *
 * @author 
 * @email 
 * @date
 */
public interface GerenjianliService extends IService<GerenjianliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GerenjianliVO> selectListVO(Wrapper<GerenjianliEntity> wrapper);
   	
   	GerenjianliVO selectVO(@Param("ew") Wrapper<GerenjianliEntity> wrapper);
   	
   	List<GerenjianliView> selectListView(Wrapper<GerenjianliEntity> wrapper);
   	
   	GerenjianliView selectView(@Param("ew") Wrapper<GerenjianliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GerenjianliEntity> wrapper);
   	
}


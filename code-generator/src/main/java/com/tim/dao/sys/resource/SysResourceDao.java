package com.tim.dao.sys.resource;

import com.tim.entity.sys.resource.SysResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lizhiming
 * @since 2018-06-06
 */
public interface SysResourceDao extends BaseMapper<SysResource> {
    List<SysResource> userResource(@Param("username") String username);
}
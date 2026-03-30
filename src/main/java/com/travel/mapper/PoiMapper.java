package com.travel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.travel.model.entity.Poi;
import org.apache.ibatis.annotations.Mapper;

/**
 * POI 表 Mapper。
 */
@Mapper
public interface PoiMapper extends BaseMapper<Poi>
{
}


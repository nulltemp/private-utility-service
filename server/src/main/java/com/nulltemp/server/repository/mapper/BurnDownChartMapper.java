package com.nulltemp.server.repository.mapper;

import com.nulltemp.server.repository.entity.BurnDownChartEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BurnDownChartMapper {
	@Select("SELECT * FROM burn_down_charts")
	List<BurnDownChartEntity> findAll();
}

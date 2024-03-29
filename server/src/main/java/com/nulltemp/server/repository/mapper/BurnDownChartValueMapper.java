package com.nulltemp.server.repository.mapper;

import com.nulltemp.server.repository.entity.BurnDownChartValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BurnDownChartValueMapper {
	@Select("SELECT * " +
			"FROM burn_down_chart_values " +
			"WHERE burn_down_chart_id = #{burnDownChartId} " +
			"AND date >= #{from} " +
			"AND date <= #{to}")
	List<BurnDownChartValueEntity> findBy(long burnDownChartId, LocalDate from, LocalDate to);
}

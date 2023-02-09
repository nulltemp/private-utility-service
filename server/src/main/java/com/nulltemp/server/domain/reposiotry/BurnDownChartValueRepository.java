package com.nulltemp.server.domain.reposiotry;

import com.nulltemp.server.domain.model.BurnDownChartValue;

import java.util.List;

public interface BurnDownChartValueRepository {
	List<BurnDownChartValue> findBy(long burnDownChartId);
}

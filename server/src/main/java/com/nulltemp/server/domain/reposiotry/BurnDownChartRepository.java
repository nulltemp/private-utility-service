package com.nulltemp.server.domain.reposiotry;

import com.nulltemp.server.domain.model.BurnDownChart;

import java.util.List;

public interface BurnDownChartRepository {
	List<BurnDownChart> findAll();
}

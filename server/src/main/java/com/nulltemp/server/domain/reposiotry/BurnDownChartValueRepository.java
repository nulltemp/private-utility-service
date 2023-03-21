package com.nulltemp.server.domain.reposiotry;

import com.nulltemp.server.domain.model.BurnDownChartValue;

import java.time.LocalDate;
import java.util.List;

public interface BurnDownChartValueRepository {
	List<BurnDownChartValue> findBy(long burnDownChartId, LocalDate from, LocalDate to);
}

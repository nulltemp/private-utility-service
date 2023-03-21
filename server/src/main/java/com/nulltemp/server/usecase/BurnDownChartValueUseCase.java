package com.nulltemp.server.usecase;

import com.nulltemp.server.domain.model.BurnDownChartValue;
import com.nulltemp.server.domain.service.BurnDownChartValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BurnDownChartValueUseCase {
	private final BurnDownChartValueService burnDownChartValueService;

	public List<BurnDownChartValue> findBy(long burnDownChartId, LocalDate from, LocalDate to) {
		return burnDownChartValueService.findBy(burnDownChartId, from, to);
	}
}

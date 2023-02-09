package com.nulltemp.server.usecase;

import com.nulltemp.server.domain.model.BurnDownChart;
import com.nulltemp.server.domain.service.BurnDownChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BurnDownChartUseCase {
	private final BurnDownChartService burnDownChartService;

	public List<BurnDownChart> findAll() {
		return burnDownChartService.findAll();
	}
}

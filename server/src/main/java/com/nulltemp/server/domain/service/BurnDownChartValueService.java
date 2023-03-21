package com.nulltemp.server.domain.service;

import com.nulltemp.server.domain.model.BurnDownChartValue;
import com.nulltemp.server.domain.reposiotry.BurnDownChartValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BurnDownChartValueService {
	private final BurnDownChartValueRepository burnDownChartValueRepository;

	public List<BurnDownChartValue> findBy(long burnDownChartId, LocalDate from, LocalDate to) {
		return burnDownChartValueRepository.findBy(burnDownChartId, from, to);
	}
}

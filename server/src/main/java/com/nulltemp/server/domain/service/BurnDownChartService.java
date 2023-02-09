package com.nulltemp.server.domain.service;

import com.nulltemp.server.domain.model.BurnDownChart;
import com.nulltemp.server.domain.reposiotry.BurnDownChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BurnDownChartService {
	private final BurnDownChartRepository burnDownChartRepository;

	public List<BurnDownChart> findAll() {
		return burnDownChartRepository.findAll();
	};
}

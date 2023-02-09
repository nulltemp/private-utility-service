package com.nulltemp.server.presentation.controller;

import com.nulltemp.server.presentation.response.BurnDownChartResponse;
import com.nulltemp.server.usecase.BurnDownChartUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("charts/burn-down")
public class BurnDownChartController {
	private final BurnDownChartUseCase burnDownChartUseCase;
	@Qualifier("modelMapper")
	private final ModelMapper modelMapper;

	@GetMapping
	public BurnDownChartResponse findAll() {
		return BurnDownChartResponse.builder()
				.contents(burnDownChartUseCase.findAll().stream()
						.map(burnDownChart ->
								modelMapper.map(burnDownChart, BurnDownChartResponse.BurnDownChart.class))
						.collect(Collectors.toList()))
				.build();
	}
}

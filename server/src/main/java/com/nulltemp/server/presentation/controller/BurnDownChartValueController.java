package com.nulltemp.server.presentation.controller;

import com.nulltemp.server.presentation.response.BurnDownChartValueResponse;
import com.nulltemp.server.usecase.BurnDownChartValueUseCase;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("charts/burn-down/{burnDownChartId}/values")
public class BurnDownChartValueController {
	private final BurnDownChartValueUseCase burnDownChartValueUseCase;
	@Qualifier("modelMapper")
	private final ModelMapper modelMapper;

	@GetMapping
	public BurnDownChartValueResponse findBy(
			@PathVariable("burnDownChartId") long burnDownChartId,
			@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
			@RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
		return BurnDownChartValueResponse.builder()
				.contents(burnDownChartValueUseCase.findBy(burnDownChartId, from, to).stream()
						.map(burnDownChartValue ->
								modelMapper.map(burnDownChartValue,
										BurnDownChartValueResponse.BurnDownChartValue.class))
						.collect(Collectors.toList()))
				.build();
	}
}

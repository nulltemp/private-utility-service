package com.nulltemp.server.presentation.controller;

import com.nulltemp.server.presentation.response.BurnDownChartValueResponse;
import com.nulltemp.server.usecase.BurnDownChartValueUseCase;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("charts/burn-down/{burnDownChartId}/values")
public class BurnDownChartValueController {
	private final BurnDownChartValueUseCase burnDownChartValueUseCase;
	@Qualifier("modelMapper")
	private final ModelMapper modelMapper;

	@GetMapping
	public BurnDownChartValueResponse findBy(@PathParam("burnDownChartId") long burnDownChartId) {
		return BurnDownChartValueResponse.builder()
				.contents(burnDownChartValueUseCase.findBy(burnDownChartId).stream()
						.map(burnDownChartValue ->
								modelMapper.map(burnDownChartValue,
										BurnDownChartValueResponse.BurnDownChartValue.class))
						.collect(Collectors.toList()))
				.build();
	}
}

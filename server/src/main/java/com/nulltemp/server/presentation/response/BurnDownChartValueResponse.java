package com.nulltemp.server.presentation.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class BurnDownChartValueResponse {
	private List<BurnDownChartValue> contents;

	@Data
	public static class BurnDownChartValue {
		private long id;
		private long burnDownChartId;
		private LocalDate date;
		private int value;
	}
}

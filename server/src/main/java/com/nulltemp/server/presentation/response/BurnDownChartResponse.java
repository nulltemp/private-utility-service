package com.nulltemp.server.presentation.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BurnDownChartResponse {
	private List<BurnDownChart> contents;

	@Data
	public static class BurnDownChart {
		private long id;
		private String name;
	}
}

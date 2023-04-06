package com.nulltemp.server.domain.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class BurnDownChartValue {
	long burnDownChartId;
	LocalDate date;
	int value;
}

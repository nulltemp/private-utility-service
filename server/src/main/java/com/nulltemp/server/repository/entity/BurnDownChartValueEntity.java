package com.nulltemp.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class BurnDownChartValueEntity extends CommonEntity {
	private long burnDownChartId;
	private LocalDate date;
	private int value;
}

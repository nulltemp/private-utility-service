package com.nulltemp.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BurnDownChartEntity extends CommonEntity {
	private long id;
	private String name;
}

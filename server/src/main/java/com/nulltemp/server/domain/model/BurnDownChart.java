package com.nulltemp.server.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BurnDownChart {
	long id;
	String name;
}

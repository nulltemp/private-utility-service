package com.nulltemp.server.repository.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public abstract class CommonEntity {
	private Timestamp insertDate;
	private Timestamp updateDate;
}

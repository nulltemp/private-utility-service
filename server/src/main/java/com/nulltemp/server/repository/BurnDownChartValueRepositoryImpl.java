package com.nulltemp.server.repository;

import com.nulltemp.server.domain.model.BurnDownChartValue;
import com.nulltemp.server.domain.reposiotry.BurnDownChartValueRepository;
import com.nulltemp.server.repository.mapper.BurnDownChartValueMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BurnDownChartValueRepositoryImpl implements BurnDownChartValueRepository {
	private final BurnDownChartValueMapper burnDownChartValueMapper;
	@Qualifier("builderModelMapper")
	private final ModelMapper buildModelMapper;

	@Override
	public List<BurnDownChartValue> findBy(long burnDownChartId, LocalDate from, LocalDate to) {
		return burnDownChartValueMapper.findBy(burnDownChartId, from, to).stream()
				.map(burnDownChartValueEntity ->
						buildModelMapper.map(burnDownChartValueEntity,
								BurnDownChartValue.BurnDownChartValueBuilder.class).build())
				.collect(Collectors.toList());
	}
}

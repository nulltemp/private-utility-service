package com.nulltemp.server.repository;

import com.nulltemp.server.domain.model.BurnDownChart;
import com.nulltemp.server.domain.reposiotry.BurnDownChartRepository;
import com.nulltemp.server.repository.mapper.BurnDownChartMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BurnDownChartRepositoryImpl implements BurnDownChartRepository {
	private final BurnDownChartMapper burnDownChartMapper;
	@Qualifier("builderModelMapper")
	private final ModelMapper buildModelMapper;

	@Override
	public List<BurnDownChart> findAll() {
		return burnDownChartMapper.findAll().stream()
				.map(burnDownChartEntity ->
						buildModelMapper.map(burnDownChartEntity, BurnDownChart.BurnDownChartBuilder.class).build())
				.collect(Collectors.toList());
	}
}

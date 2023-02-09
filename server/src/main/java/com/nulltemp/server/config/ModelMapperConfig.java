package com.nulltemp.server.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.util.Strings;
import org.modelmapper.spi.PropertyType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {
	@Bean("modelMapper")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean("builderModelMapper")
	public ModelMapper builderModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setDestinationNamingConvention((propertyName, propertyType) ->
						PropertyType.METHOD.equals(propertyType))
				.setDestinationNameTransformer((name, nameableType) -> Strings.decapitalize(name));
		return modelMapper;
	}
}


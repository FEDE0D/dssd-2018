package com.dssd.grupo8.configuration;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

  /*
    Sometimes, the automatic conversion from/to a DTO is not possible. In these cases, a provider
    must be defined for the ModelMapper's TypeMap, establishing how the conversion should work.
  */
  @Bean
  public ModelMapper modelMapper() {

    ModelMapper mm = new ModelMapper();

    mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    mm.getConfiguration().setPropertyCondition(ctx -> Hibernate.isInitialized(ctx.getSource()));

    return mm;
  }
}

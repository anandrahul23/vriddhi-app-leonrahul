package com.anand.marketdataserice.marketDataVendors.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityDtoMapper {

    private static final Logger log = LoggerFactory.getLogger(EntityDtoMapper.class);

      private static final ModelMapper modelMapper = new ModelMapper();
    public static <T> T mapEntityToDto(Object entity, Class<T> dtoClass) {
        log.info("Mapping entity to dto {}", entity);
        return modelMapper.map(entity, dtoClass);
    }

    public static <T> T mapDtoToEntity(Object dto, Class<T> entityClass) {
        var et = modelMapper.map(dto, entityClass);
        log.info("Mapping dto to entity {}", et);

        return et;
    }
}

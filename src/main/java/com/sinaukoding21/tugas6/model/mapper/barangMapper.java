package com.sinaukoding21.tugas6.model.mapper;

import com.sinaukoding21.tugas6.model.barang;
import com.sinaukoding21.tugas6.model.dto.barangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface barangMapper {
    barangMapper INSTANCE = Mappers.getMapper(barangMapper.class);

    barang toEntity(barangDTO dto);

    barangDTO toDto(barang data);

    List<barangDTO> toListDTO(List<barang> list);

    List<barang> toListEntity(List<barangDTO> data);
}

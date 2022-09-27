package tokosinaukoding.entity.mapping;

import tokosinaukoding.tokosinaukoding.entity.Produk;
import tokosinaukoding.tokosinaukoding.entity.dto.ProdukDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdukMapping {
    ProdukMapping instance = Mappers.getMapper(ProdukMapping.class);

    Produk toEntity(ProdukDTO dto);

    ProdukDTO toDto(Produk param);

    List<ProdukDTO> toListDto(List<Produk> produkList);
}
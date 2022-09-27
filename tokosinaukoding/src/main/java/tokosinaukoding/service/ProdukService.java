package tokosinaukoding.service;

import tokosinaukoding.tokosinaukoding.entity.dto.ProdukDTO;

import java.util.List;

public interface ProdukService {
    ProdukDTO save(ProdukDTO param);

    List<ProdukDTO> findAllData();

    ProdukDTO update(ProdukDTO param, Long id);

    Boolean delete(Long id);

    ProdukDTO findById(Long id);
}
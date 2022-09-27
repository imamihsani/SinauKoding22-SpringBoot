package tokosinaukoding.service.impl;

import tokosinaukoding.tokosinaukoding.entity.Produk;
import tokosinaukoding.tokosinaukoding.entity.dto.ProdukDTO;
import tokosinaukoding.tokosinaukoding.entity.mapping.ProdukMapping;
import tokosinaukoding.tokosinaukoding.repository.ProdukRepository;
import tokosinaukoding.tokosinaukoding.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukServiceImpl implements ProdukService {
    @Autowired
    private ProdukRepository repository;

    @Override
    public ProdukDTO save(ProdukDTO param) {
        Produk data = repository.save(ProdukMapping.instance.toEntity(param));
        return ProdukMapping.instance.toDto(data);
    }

    @Override
    public List<ProdukDTO> findAllData() {
        return ProdukMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public ProdukDTO update(ProdukDTO param, Long id) {
        Produk data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setName(param.getName() == null ? data.getName() : param.getName());
            data.setPrice(param.getPrice() != null ? param.getPrice() : data.getPrice());
            data.setStock(param.getStock() != null ? param.getStock() : data.getStock());

            return ProdukMapping.instance.toDto(repository.save(data));
        }

        return ProdukMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Produk data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public ProdukDTO findById(Long id) {
        return ProdukMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
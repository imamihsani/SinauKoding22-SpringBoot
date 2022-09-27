package tokosinaukoding.repository;

import tokosinaukoding.tokosinaukoding.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
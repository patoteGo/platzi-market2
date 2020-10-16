package com.platzi.platzimarket2.persistence;

import com.platzi.platzimarket2.domain.Purchase;
import com.platzi.platzimarket2.domain.repository.PurchaseRepository;
import com.platzi.platzimarket2.persistence.crud.CompraCrudRepository;
import com.platzi.platzimarket2.persistence.entity.Compra;
import com.platzi.platzimarket2.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

  @Autowired private CompraCrudRepository compraCrudRepository;

  @Autowired private PurchaseMapper mapper;

  @Override
  public List<Purchase> getAll() {
    return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return compraCrudRepository
        .findByIdCliente(clientId)
        .map(compras -> mapper.toPurchases(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Compra compra = mapper.toCompra(purchase);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));

    return mapper.toPurchase(compraCrudRepository.save(compra));
  }
}

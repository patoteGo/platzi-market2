package com.platzi.platzimarket2.persistence;

import com.platzi.platzimarket2.domain.Product;
import com.platzi.platzimarket2.domain.repository.ProductRepository;
import com.platzi.platzimarket2.persistence.crud.ProductoCrudRepository;
import com.platzi.platzimarket2.persistence.entity.Producto;
import com.platzi.platzimarket2.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProductList(productos);

    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos =  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProductList(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProductList(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProductList(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
    return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }



    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}

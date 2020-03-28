package ru.domclick.quarkustest.service;

import ru.domclick.quarkustest.controller.dto.ProductDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class ProductService {
    private final AtomicLong productSequence = new AtomicLong();
    private final Map<Long, ProductDto> productStorage = new HashMap<>();

    public ProductDto createProduct(ProductDto productDto) {
        final long productId = productSequence.getAndIncrement();
        productDto.setId(productId);
        productStorage.put(productId, productDto);
        return productDto;
    }

    public List<ProductDto> list() {
        return new ArrayList<>(productStorage.values());
    }

    public ProductDto get(long productId) {
        return productStorage.get(productId);
    }
}

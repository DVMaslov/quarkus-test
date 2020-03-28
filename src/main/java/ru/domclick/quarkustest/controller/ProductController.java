package ru.domclick.quarkustest.controller;

import ru.domclick.quarkustest.controller.dto.ProductDto;
import ru.domclick.quarkustest.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @POST
    public ProductDto create(ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GET
    public List<ProductDto> list() {
        return productService.list();
    }

    @GET
    @Path("{productId}")
    public ProductDto get(@PathParam("productId") long productId) {
        return productService.get(productId);
    }
}

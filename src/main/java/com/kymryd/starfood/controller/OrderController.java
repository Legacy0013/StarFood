package com.kymryd.starfood.controller;

import com.kymryd.starfood.dto.OrderProductDto;
import com.kymryd.starfood.model.entities.OrderEntity;
import com.kymryd.starfood.model.entities.OrderLineEntity;
import com.kymryd.starfood.service.OrderLineService;
import com.kymryd.starfood.service.OrderService;
import com.kymryd.starfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderLineService orderProductService;


    @PostMapping
    public OrderEntity create(@RequestBody OrderEntity order){
        return orderService.create(order);
    }
/*    public ResponseEntity<OrderEntity> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        OrderEntity order = new OrderEntity();
        order.setUserIdCustomer(1);
        order.setOrderWeigth(1);
        order.setOriginId(1);
        order.setUserIdOrigin(1);
        order.setPaymentMethodId(1);
        order.setOrderStatusId(1);
        order = this.orderService.create(order);

        List<OrderLineEntity> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderLineEntity(order, productService.getProduct(dto
                    .getProduct()
                    .getProductId()), dto.getQuantity())));
        }

        order.setOrderLinesByOrderId(orderProducts);

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getOrderId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }*/

    @GetMapping(path = {"/{id}"})
    public OrderEntity findOne(@PathVariable("id") int id){
        return orderService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public OrderEntity update(@PathVariable("id") int id, @RequestBody OrderEntity order){
        order.setOrderId(id);
        return orderService.update(order);
    }

    @DeleteMapping(path ={"/{id}"})
    public OrderEntity delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping
    public List<OrderEntity> findAll(){
        return orderService.findAll();
    }


   /* private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                        .getProduct()
                        .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }

    public static class OrderForm {

        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }*/
}


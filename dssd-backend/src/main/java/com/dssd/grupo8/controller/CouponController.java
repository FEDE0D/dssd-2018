package com.dssd.grupo8.controller;

import com.dssd.grupo8.dto.CouponDTO;
import com.dssd.grupo8.model.Coupon;
import com.dssd.grupo8.service.CouponService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/coupon")
public class CouponController extends GenericController<Coupon, CouponService> {

    public CouponController(CouponService service, ModelMapper modelMapper) {
        super(service, modelMapper);
    }

    @GetMapping
    public ResponseEntity<List<CouponDTO>> findAll() {
        return ResponseEntity.ok(this.service.findAll().stream().map(c -> this.modelMapper.map(c, CouponDTO.class)).collect(Collectors.toList()));
    }



}

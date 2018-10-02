package com.dssd.grupo8.controller;

import com.dssd.grupo8.dto.CouponCreateDTO;
import com.dssd.grupo8.dto.CouponDTO;
import com.dssd.grupo8.dto.CouponUpdateDTO;
import com.dssd.grupo8.model.Coupon;
import com.dssd.grupo8.service.CouponService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coupon")
public class CouponController extends GenericController<Coupon, CouponService, CouponDTO, CouponCreateDTO, CouponUpdateDTO> {

    @Override
    Class<CouponDTO> dtoClass() {
        return CouponDTO.class;
    }

    public CouponController(CouponService service, ModelMapper modelMapper) {
        super(service, modelMapper);
    }

}

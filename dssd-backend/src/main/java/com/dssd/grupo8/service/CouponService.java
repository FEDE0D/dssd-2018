package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.CouponDTO;
import com.dssd.grupo8.model.Coupon;
import com.dssd.grupo8.repository.CouponRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CouponService extends GenericService<Coupon, CouponRepository> {

    @Autowired
    public CouponService(CouponRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    public CouponDTO createCoupon(long number, boolean used) {
        Coupon coupon = new Coupon();
        coupon.setNumber(number);
        coupon.setUsed(used);

        coupon = this.repository.save(coupon);
        return this.modelMapper.map(coupon, CouponDTO.class);
    }
}

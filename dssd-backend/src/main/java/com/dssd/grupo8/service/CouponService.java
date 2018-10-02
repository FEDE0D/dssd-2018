package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.CouponCreateDTO;
import com.dssd.grupo8.dto.CouponDTO;
import com.dssd.grupo8.dto.CouponUpdateDTO;
import com.dssd.grupo8.model.Coupon;
import com.dssd.grupo8.repository.CouponRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService extends GenericService<Coupon, CouponRepository, CouponDTO, CouponCreateDTO, CouponUpdateDTO> {

    @Autowired
    public CouponService(CouponRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public CouponDTO createFromDTO(CouponCreateDTO createDTO) {
        Coupon coupon = new Coupon();
        coupon.setNumber(createDTO.getNumber());
        coupon.setUsed(createDTO.isUsed());
        this.repository.save(coupon);

        return this.modelMapper.map(coupon, CouponDTO.class);
    }

    @Override
    public CouponDTO updateFromDTO(Long id, CouponUpdateDTO updateDTO) {
        Coupon coupon = this.findById(id);
        coupon.setNumber(updateDTO.getNumber());
        coupon.setUsed(updateDTO.isUsed());
        this.repository.save(coupon);

        return this.modelMapper.map(coupon, CouponDTO.class);
    }

}

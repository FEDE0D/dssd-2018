package com.dssd.grupo8.service;

import com.dssd.grupo8.dto.CouponDTO;
import com.dssd.grupo8.model.Coupon;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class CouponServiceTestCase {

    @Autowired
    @Getter
    private CouponService service;

    @Test
    public void basicTest() {
        CouponDTO coupon = service.createCoupon(123L, true);
        Assert.assertNotNull(coupon.getId());
        Assert.assertEquals((long) coupon.getNumber(), 123L);
        Assert.assertTrue(coupon.isUsed());

        List<Coupon> coupons = service.findAll();
        Assert.assertEquals(1, coupons.size());
    }

}

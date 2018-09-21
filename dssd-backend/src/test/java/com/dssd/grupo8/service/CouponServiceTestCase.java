package com.dssd.grupo8.service;

import com.dssd.grupo8.dssdbackend.DssdBackendApplication;
import com.dssd.grupo8.dto.CouponDTO;
import com.dssd.grupo8.model.Coupon;
import com.dssd.grupo8.service.CouponService;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DssdBackendApplication.class)
@ComponentScan(basePackages = {"com.dssd", "com.dssd.grupo8.repository"})
@EntityScan(basePackages = "com.dssd")
@Transactional
@Rollback
public class CouponServiceTestCase {

    @Autowired
    @Getter
    private CouponService service;

    @Test
    public void basicTest() {
        CouponDTO coupon = service.createCoupon(123L, true);
        Assert.assertEquals((long) coupon.getNumber(), 123L);
        Assert.assertTrue(coupon.isUsed());
    }

}

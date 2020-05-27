package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 李广帅
 * @date 2020/5/27 8:10 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAddressService {

    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService addressService;


    @Test
    public void testFindAddressById() {
        Address address = addressService.findAddressByAddressId("7l6pW8STkTkX64700uvYR7uEW044m9Gh");
        System.out.println(address);
    }
}

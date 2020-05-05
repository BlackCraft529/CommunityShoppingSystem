package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.OrderMapper;
import cn.jsnu.css.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:55
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public void setOrderMapper(OrderMapper orderMapper){this.orderMapper=orderMapper;}

}

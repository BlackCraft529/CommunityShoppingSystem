package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.GoodMapper;
import cn.jsnu.css.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:52
 */
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    public void setGoodMapper(GoodMapper goodMapper){this.goodMapper=goodMapper;}
}

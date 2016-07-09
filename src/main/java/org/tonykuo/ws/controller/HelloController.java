package org.tonykuo.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tonykuo.persistence.entity.HanksMasterUserId;
import org.tonykuo.service.UserService;
import org.tonykuo.service.util.LogUtil;

@Controller
public class HelloController {
    
    @Autowired
    UserService userSerice;
    
    @RequestMapping("/index")
    public String hello() {
        
        LogUtil.info("test = " + userSerice.findAll().size());
        
        // 2016061500001   0910360200
        HanksMasterUserId hanksMasterUserId = 
                new HanksMasterUserId("2016061500001", "0910360200");
        
        LogUtil.info("test 2 = " + userSerice.findOne(hanksMasterUserId).getId().getMasterUserId());
        
        return "index";
    }

}

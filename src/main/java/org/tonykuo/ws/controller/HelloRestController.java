package org.tonykuo.ws.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tonykuo.service.dto.DemoDTO;
import org.tonykuo.service.util.LogUtil;

@RestController
@RequestMapping("/rest")
public class HelloRestController {

    @RequestMapping(value = "/getjson", produces = { "application/json;charset=UTF-8" })
    public DemoDTO getjson(DemoDTO obj) {
        return new DemoDTO(obj.getId() + 1, obj.getName() + "yy");
    }

    @RequestMapping(value = "/getxml", produces = { "application/xml;charset=UTF-8" })
    public DemoDTO getxml(DemoDTO obj) {
        return new DemoDTO(obj.getId() + 1, obj.getName() + "yy");
    }
    
    @RequestMapping(value = "/parseJson", method = {RequestMethod.POST })
    public void saveDemo(@RequestBody DemoDTO demo) { 
        LogUtil.info("demo = " + demo.toString());
    }
    
    @RequestMapping(value = "/parseJsonList", method = {RequestMethod.POST})
    public void saveDemoList(@RequestBody List<DemoDTO> demoList) { 
        LogUtil.info("demoList = " + demoList);
    } 

}

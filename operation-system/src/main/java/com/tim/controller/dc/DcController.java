package com.tim.controller.dc;

import com.tim.service.dc.DcClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class DcController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    DcClient dcClient;

//    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    @GetMapping("/consumer")
    public String  dc() {
        return dcClient.consumer();
    }

}

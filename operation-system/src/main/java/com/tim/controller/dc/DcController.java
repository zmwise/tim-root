package com.tim.controller.dc;

import com.tim.service.dc.DcClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@Slf4j
public class DcController {

    @Autowired
    DcClient dcClient;

//    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    @GetMapping("/consumer")
    public String  consumer() {
        return dcClient.consumer();
    }

}

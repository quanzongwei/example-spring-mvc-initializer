package eu.kielczewski.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
class IndexController {
    @Autowired
    Do aDo;


    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return "Hello world2";
    }

    @RequestMapping(value = "/baby",method = RequestMethod.GET)
    //@SuppressWarnings("SameReturnValue")
    @ResponseBody
    public String get() {
        aDo.play();
        return "you are try to get some thing :"+ aDo.play();
    }

    @RequestMapping(value = "/map",method = RequestMethod.GET)
    //@SuppressWarnings("SameReturnValue")
    @ResponseBody
    public Map getMap() {
        Map map = new HashMap();
        map.put("name", "zhangsan");
        return map;

    }
}

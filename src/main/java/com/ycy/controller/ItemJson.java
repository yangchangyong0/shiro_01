package com.ycy.controller;

import com.ycy.model.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2015/9/30 0030.
 */
@Controller
@RequestMapping("/json")
public class ItemJson {

    @RequestMapping("/requestPage")
    public String requestPage() throws Exception {
        return "jsontest";

    }

    // 商品修改提交json信息，响应json信息
    @RequestMapping("/requestJson")
    @ResponseBody
    public Items editItemSubmit_RequestJson(@RequestBody Items items) throws Exception {
        System.out.println(items);
        //itemService.saveItem(items);
        return items;

    }


    // 商品修改提交json信息，响应json信息
    @RequestMapping("/responseJson")
    @ResponseBody
    public Items responseJson( Items items) throws Exception {
        System.out.println(items);
        //itemService.saveItem(items);
        return items;

    }

}

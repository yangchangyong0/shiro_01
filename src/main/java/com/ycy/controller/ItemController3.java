package com.ycy.controller;


import com.ycy.model.Items;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/9/17 0017.
 */
//@Controller
public class ItemController3 {
    //@RequestMapping("/queryItems")//建议与方法名称一致
    public ModelAndView queryItems(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        //商品列表
        List<Items> itemsList = new ArrayList<Items>();

        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        items_1.setCreatetime(new Date());

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");
        items_2.setCreatetime(new Date());
        itemsList.add(items_1);
        itemsList.add(items_2);

        //创建modelAndView准备填充数据、设置视图
        ModelAndView modelAndView = new ModelAndView();
        httpServletRequest.setCharacterEncoding("utf-8");
        //填充数据
        modelAndView.addObject("itemsList", itemsList);
        //视图
        modelAndView.setViewName("order/itemsList");

        return modelAndView;
    }
}

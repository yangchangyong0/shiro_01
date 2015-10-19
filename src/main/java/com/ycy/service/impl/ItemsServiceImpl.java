package com.ycy.service.impl;

import com.ycy.Exception.CustomException;
import com.ycy.dto.ItemsCustom;
import com.ycy.mapper.ItemsMapper;
import com.ycy.model.Items;
import com.ycy.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22 0022.
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    public ItemsCustom getItemsById(Integer id) throws  Exception{
        Items items = itemsMapper.getItemsById(id);
        //在这里随着需求的变量，需要查询商品的其它的相关信息，返回到controller
        if(items==null){
            throw new CustomException("修改商品信息不存在");
        }
        ItemsCustom itemsCustom = new ItemsCustom();
        //将items的属性拷贝到itemsCustom
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;

    }

    public List<ItemsCustom> findtemsList(ItemsCustom itemsCustom) throws Exception {
        return itemsMapper.findtemsList(itemsCustom);
    }

    public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception {
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}

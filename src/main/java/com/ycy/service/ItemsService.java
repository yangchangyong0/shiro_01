package com.ycy.service;

import com.ycy.dto.ItemsCustom;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22 0022.
 */
public interface ItemsService {
    public ItemsCustom getItemsById(Integer id) throws Exception;

    public List<ItemsCustom> findtemsList(ItemsCustom itemsCustom) throws Exception;

    public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception;
}

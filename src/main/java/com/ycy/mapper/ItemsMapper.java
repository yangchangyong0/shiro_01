package com.ycy.mapper;

import com.ycy.dto.ItemsCustom;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22 0022.
 */
public interface ItemsMapper {
    public ItemsCustom getItemsById(Integer itemsCustom);

    public List<ItemsCustom> findtemsList(ItemsCustom itemsCustom);

    public  void  updateByPrimaryKeyWithBLOBs(ItemsCustom itemsCustom);

}

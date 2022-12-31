package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.PageInfo;
import com.example.server.pojo.School;
import com.example.server.pojo.Shopping;
import com.example.server.pojo.SurroundingShopping;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
public interface ISurroundingShoppingService extends IService<SurroundingShopping> {
    List<SurroundingShopping> getShoppings(String name, String community, int page, String district);

    PageInfo getPageInfo(String name, String community, int page, String district);

    void addShopping(Shopping shopping);

    void update(Shopping shopping);

    void delete(Shopping shopping);
}

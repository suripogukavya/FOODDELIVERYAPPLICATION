package com.tap.dao;

import java.util.List;
import com.tap.model.MenuItem;

public interface MenuItemDAO {

    int addMenuItem(MenuItem item);

    MenuItem getMenuItem(int itemId);

    List<MenuItem> getItemsByRestaurant(int restaurantId);

    void updateMenuItem(MenuItem item);

    void deleteMenuItem(int itemId);

    List<MenuItem> getAllMenuItems();
}

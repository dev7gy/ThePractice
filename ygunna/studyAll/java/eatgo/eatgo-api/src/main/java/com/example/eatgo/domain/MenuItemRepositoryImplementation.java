package com.example.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImplementation implements MenuItemRepository{
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    MenuItemRepositoryImplementation() {
        menuItems.add(new MenuItem("Kimchi"));
    }
    @Override
    public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
        return menuItems;
    }
}

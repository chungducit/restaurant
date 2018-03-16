package com.project.restaurant.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.Category;
import com.project.restaurant.models.Items;
import com.project.restaurant.models.business.CategoryInfo;
import com.project.restaurant.models.business.ItemInfo;
import com.project.restaurant.repositories.CategoryRepository;
import com.project.restaurant.repositories.ItemsRepository;

@Service
public class ItemService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
    @Autowired
    public ItemService (CategoryRepository categoryRepository, ItemsRepository itemsRepository) {
        this.categoryRepository = categoryRepository;
        this.itemsRepository = itemsRepository;
    }
    
    public List<CategoryInfo> getAllItemInfo () {
		Iterable<Category> cates = this.categoryRepository.findByParentId(null);
		Map<Long, CategoryInfo> cateInfoMap = new HashMap<>();
		
		cates.forEach(cate -> {
			CategoryInfo cateInfo = new CategoryInfo();
			cateInfo.setId(cate.getId());
			cateInfo.setName(cate.getName());
			cateInfo.setCode(cate.getCode());
			cateInfo.setParentId(cate.getParentId());
			Iterable<Category> cates_child = this.categoryRepository.findByParentId(cate.getId());
			if (null != cates_child) {
				List<CategoryInfo> cateList = new ArrayList<>();
				cates_child.forEach(c -> {
					CategoryInfo sub_cateInfo = new CategoryInfo();
					sub_cateInfo.setId(c.getId());
					sub_cateInfo.setName(c.getName());
					sub_cateInfo.setCode(c.getCode());
					sub_cateInfo.setParentId(c.getParentId());
					
					//Get item list of this category
					Iterable<Items> items = itemsRepository.findByCategoryId(c.getId());
					if (null != items) {
						List<ItemInfo> itemList = new ArrayList<>();
						items.forEach(i -> {
							if (i.getIsDelete() == false) {
								ItemInfo iteminfo = new ItemInfo();
								iteminfo.setId(i.getId());
								iteminfo.setName(i.getName());
								iteminfo.setCode(i.getCode());
								iteminfo.setPrice(i.getPrice());
								itemList.add(iteminfo);
							}
						});
						
						sub_cateInfo.setItemList(itemList);
					}
					
					//Add list category child to root
					cateList.add(sub_cateInfo);
				});
				cateInfo.setCateList(cateList);
			}

			cateInfoMap.put(cate.getId(), cateInfo);
        });
    	
        List<CategoryInfo> categoriesInfo = new ArrayList<>();
        for (Long cateId : cateInfoMap.keySet()) {
        	categoriesInfo.add(cateInfoMap.get(cateId));
        }
        return categoriesInfo;
    }
	
}

package com.likelion.springprac.item.api;

import com.likelion.springprac.item.api.dto.ItemDto;
import com.likelion.springprac.item.application.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("items")
    public void save(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemDto);
    }

    @GetMapping("items/{id}")
    public ItemDto findById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @GetMapping("items")
    public List<ItemDto> findAllItems() {
        return itemService.findAllItems();
    }

    @PatchMapping("items/{id}")
    public void updateById(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        itemService.updateItemById(id, itemDto);
    }

    @DeleteMapping("items/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
}

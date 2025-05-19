package com.likelion.springprac.item.application;

import com.likelion.springprac.item.domain.Item;
import com.likelion.springprac.item.domain.ItemRepository;
import com.likelion.springprac.item.api.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private static Long sequence = 0L;

    public void saveItem(ItemDto requestDto) {
        Item item = Item.builder()
                .id(++sequence)
                .name(requestDto.name())
                .year(requestDto.year())
                .build();

        itemRepository.save(item);
    }

    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id);
        if (item == null) {
            throw new IllegalArgumentException("해당하는 물건이 없습니다. id = " + id);
        }
        return toDto(item);
    }

    public List<ItemDto> findAllItems() {
        return itemRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Item updateItemById(Long id, ItemDto requestDto) {
        Item item = itemRepository.findById(id);
        if (item == null) {
            throw new IllegalArgumentException("해당하는 물건이 없습니다. id = " + id);
        }

        item.update(requestDto.name(), requestDto.year());
        itemRepository.updateById(id, item);
        return item;
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    private ItemDto toDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .year(item.getYear())
                .build();
    }
}
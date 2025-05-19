package com.likelion.springprac.item.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryitemRepository implements ItemRepository {
    private static Map<Long, Item> database = new HashMap<>();

    @Override
    public void save(Item item) {
        database.put(item.getId(), item);
    }

    @Override
    public Item findById(Long id) {
        return database.get(id);
    }

    @Override
    public List<Item> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Item item) {
        database.put(id, item);

    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }
}

package com.likelion.springprac.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Item {

    private Long id; // 책의 고유 id
    private String name; // 책 이름
    private Long year; // 책 연도

    @Builder
    public Item(Long id, String name, Long year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }


    public void update(String name, Long count) {
        this.name = name;
        this.year = year;
    }
}
package com.general.stores.naver.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class NaverProduct extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;
    
 // 관심 상품 생성 시 이용함
    public NaverProduct(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.image = requestDto.getImage();
        this.myprice = 0;
    }
    
 // 관심 가격 변경 시 이용함
    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }

    public void updateByItemDto(ItemDto itemDto) {
        this.lprice = itemDto.getLprice();
    }
}
package com.jinju.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long num;
    private String name;
    private int price;
    private int stock;

    // public String toString(){
    //     return "num : "+num +"\nname"+name+"\nprice :"+price+"\nstock : "+stock;
    // }
}

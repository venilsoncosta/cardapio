package com.venilson.cardapio.food;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "foods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(FoodRequestDTO foodRequestDTO) {
        this.image = foodRequestDTO.image();
        this.title = foodRequestDTO.title();
        this.price = foodRequestDTO.price();
    }
}

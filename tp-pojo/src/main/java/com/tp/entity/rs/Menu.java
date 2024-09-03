package com.tp.entity.rs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends Good {
   private Food food;
   private Drink drink;
   private Snack snack;


}

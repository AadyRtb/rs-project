package com.rs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends Good{
   private Food food;
   private  Drink drink;
   private  Snack snack;


}

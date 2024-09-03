package com.tp.dto;

import lombok.Data;

@Data
public class CreditUpdateDTO  {
    private String sid;
    private Float totalCredit;

    private Float needCredit;
}

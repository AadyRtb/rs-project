package com.tp.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LBCreditVO implements Serializable {
    private Float lg;
    private Float my;
    private Float yx;
    private Float jg;
    private Float sx;
    private Float sk;
}

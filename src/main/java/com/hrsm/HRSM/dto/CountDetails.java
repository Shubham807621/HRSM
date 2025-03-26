package com.hrsm.HRSM.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountDetails {

    private Long totalClientCount;
    private Long totalProjectCount;
}

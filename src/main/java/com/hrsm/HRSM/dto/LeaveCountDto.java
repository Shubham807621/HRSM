package com.hrsm.HRSM.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaveCountDto {

    private Long causalLeave;
    private Long sickLeave;
    private Long earnedLeave;
    private Long plannedLeave;
    private Long flexiLeave;

    // ✅ Constructor for JPA Projection
//    public LeaveCountDto(Long causalLeave, Long sickLeave, Long earnedLeave, Long plannedLeave, Long flexiLeave) {
//        this.causalLeave = causalLeave != null ? causalLeave.intValue() : 0;
//        this.sickLeave = sickLeave != null ? sickLeave.intValue() : 0;
//        this.earnedLeave = earnedLeave != null ? earnedLeave.intValue() : 0;
//        this.plannedLeave = plannedLeave != null ? plannedLeave.intValue() : 0;
//        this.flexiLeave = flexiLeave != null ? flexiLeave.intValue() : 0;
//    }
}

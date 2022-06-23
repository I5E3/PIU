package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyDTO {
    private String userNum;
    private String userName;
    private String projectNum;
    private String phoneNumber;
    private String registDate;
    private String approach;

    public ApplyDTO(String userNum, String userName, String projectNum, String phoneNumber, String registDate, String approach) {
        this.userNum = userNum;
        this.userName = userName;
        this.projectNum = projectNum;
        this.phoneNumber = phoneNumber;
        this.registDate = registDate;
        this.approach = approach;
    }
}

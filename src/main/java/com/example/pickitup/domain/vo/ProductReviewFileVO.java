package com.example.pickitup.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class ProductReviewFileVO {
    private String uuid;
    private String uploadPath;
    private String fileName;
    private Long fileSize;
    private Long productReviewNum;

}
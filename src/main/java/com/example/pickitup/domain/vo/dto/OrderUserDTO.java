<<<<<<< HEAD
package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.OrderCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class OrderUserDTO {
    private OrderCriteria orderCriteria;
    private Long orderNum;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String addressDetail;
    private Long productNum;
    private String productName;
    private String manufacturer;
    private String supplier;
    private String registDate;
    private String status;
    private Long userNum;
    private Long counting;
    private String addressComment;
    private Long num;
    private Long total;
    private String nickName;
    private Long point;
=======
package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.OrderCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class OrderUserDTO {
    private OrderCriteria orderCriteria;
    private Long orderNum;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String addressDetail;
    private Long productNum;
    private String productName;
    private String manufacturer;
    private String supplier;
    private String registDate;
    private String status;
    private Long userNum;
    private Long counting;
    private String addressComment;
    private Long num;
    private Long total;
    private String nickName;
    private Long point;
>>>>>>> 383d576e94bb33cf289090cbcbef6df83f1d4878
}
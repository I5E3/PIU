package com.example.pickitup.domain.vo.dto;

import com.example.pickitup.domain.vo.product.productQna.ProductQnaVO;
import com.example.pickitup.domain.vo.user.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQnaUserDTO {
    private List<ProductQnaVO> productQnaVOList;
    private UserVO userVOList;
}

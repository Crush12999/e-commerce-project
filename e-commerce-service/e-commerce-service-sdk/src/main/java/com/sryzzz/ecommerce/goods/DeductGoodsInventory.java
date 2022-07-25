package com.sryzzz.ecommerce.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author sryzzz
 * @create 2022/7/25 22:30
 * @description 扣减商品库存
 */
@ApiModel(description = "扣减商品库存对象")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeductGoodsInventory {

    @ApiModelProperty(value = "商品主键 id")
    private Long goodsId;

    @ApiModelProperty(value = "扣减个数")
    private Integer count;
}

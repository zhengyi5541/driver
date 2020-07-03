/*
*  Copyright 2019-2020 Zheng Jie
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package me.zhengjie.modules.zhengyi.driverDetails.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-07-03
**/
@Entity
@Data
@Table(name="zy_driver_details")
public class ZyDriverDetails implements Serializable {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private String id;

    @Column(name = "driver_order_id")
    @ApiModelProperty(value = "司机订单id")
    private String driverOrderId;

    @Column(name = "owner_id")
    @ApiModelProperty(value = "雇主id")
    private String ownerId;

    @Column(name = "name")
    @ApiModelProperty(value = "司机姓名")
    private String name;

    @Column(name = "type")
    @ApiModelProperty(value = "运输类型")
    private Integer type;

    @Column(name = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    @Column(name = "driving_type")
    @ApiModelProperty(value = "驾照类型")
    private Integer drivingType;

    @Column(name = "content")
    @ApiModelProperty(value = "订单备注")
    private String content;

    @Column(name = "owner_name")
    @ApiModelProperty(value = "雇主名称")
    private String ownerName;

    @Column(name = "owner_phone")
    @ApiModelProperty(value = "雇主电话")
    private String ownerPhone;

    public void copy(ZyDriverDetails source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
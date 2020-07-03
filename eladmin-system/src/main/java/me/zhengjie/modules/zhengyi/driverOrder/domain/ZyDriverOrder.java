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
package me.zhengjie.modules.zhengyi.driverOrder.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-06-05
**/
@Entity
@Data
@Table(name="zy_driver_order")
public class ZyDriverOrder implements Serializable {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private String id;

    @Column(name = "user_id")
    @ApiModelProperty(value = "user_id")
    private String userId;

    @Column(name = "name")
    @ApiModelProperty(value = "姓名")
    private String name;

    @Column(name = "age")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Column(name = "driving_year")
    @ApiModelProperty(value = "驾龄")
    private Integer drivingYear;

    @Column(name = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    @Column(name = "type")
    @ApiModelProperty(value = "可接受运输类型")
    private String type;

    @Column(name = "driving_type")
    @ApiModelProperty(value = "驾驶证类型")
    private Integer drivingType;

    @Column(name = "work")
    @ApiModelProperty(value = "在职状态")
    private Integer work;

    @Column(name = "content")
    @ApiModelProperty(value = "备注")
    private String content;

    @Column(name = "hire")
    @ApiModelProperty(value = "订单状态")
    private Integer hire;

    @Column(name = "del")
    @ApiModelProperty(value = "删除状态")
    private Integer del;

    @Column(name = "create_by")
    @ApiModelProperty(value = "创建人")
    private String createBy;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    public void copy(ZyDriverOrder source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}

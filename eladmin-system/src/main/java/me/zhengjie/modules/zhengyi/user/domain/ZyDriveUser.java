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
package me.zhengjie.modules.zhengyi.user.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-06-25
**/
@Entity
@Data
@Table(name="zy_drive_user")
public class ZyDriveUser implements Serializable {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private String id;

    @Column(name = "name")
    @ApiModelProperty(value = "姓名")
    private String name;

    @Column(name = "img")
    @ApiModelProperty(value = "照片")
    private String img;

    @Column(name = "age")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Column(name = "driving_years")
    @ApiModelProperty(value = "驾龄")
    private Integer drivingYears;

    @Column(name = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    @Column(name = "driving_type")
    @ApiModelProperty(value = "驾驶证类型")
    private Integer drivingType;

    @Column(name = "working_state")
    @ApiModelProperty(value = "在职状态")
    private Integer workingState;

    @Column(name = "status")
    @ApiModelProperty(value = "禁用状态")
    private Long status;

    @Column(name = "del")
    @ApiModelProperty(value = "删除状态")
    private Integer del;

    @Column(name = "audit")
    @ApiModelProperty(value = "审核状态")
    private Integer audit;

    @Column(name = "driver_positive")
    @ApiModelProperty(value = "驾驶证正面")
    private String driverPositive;

    @Column(name = "driver_reverse")
    @ApiModelProperty(value = "驾驶证反面")
    private String driverReverse;

    @Column(name = "create_time")
    @CreationTimestamp
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    public void copy(ZyDriveUser source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
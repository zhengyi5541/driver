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
package me.zhengjie.modules.zhengyi.ownerOrder.domain;

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
@Table(name="zy_owner_order")
public class ZyOwnerOrder implements Serializable {

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private String id;

    @Column(name = "user_id")
    @ApiModelProperty(value = "user_id")
    private String userId;

    @Column(name = "name")
    @ApiModelProperty(value = "名称")
    private String name;

    @Column(name = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    @Column(name = "driving_type")
    @ApiModelProperty(value = "需要驾驶证类型")
    private Integer drivingType;

    @Column(name = "money")
    @ApiModelProperty(value = "金额")
    private Integer money;

    @Column(name = "type")
    @ApiModelProperty(value = "运输类型")
    private Integer type;

    @Column(name = "num")
    @ApiModelProperty(value = "所需人数")
    private Integer num;

    @Column(name = "content")
    @ApiModelProperty(value = "备注")
    private String content;

    @Column(name = "del")
    @ApiModelProperty(value = "删除状态")
    private Integer del;

    @Column(name = "status")
    @ApiModelProperty(value = "完结状态")
    private Integer status;

    @Column(name = "create_by")
    @ApiModelProperty(value = "创建人")
    private String createBy;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    public void copy(ZyOwnerOrder source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}

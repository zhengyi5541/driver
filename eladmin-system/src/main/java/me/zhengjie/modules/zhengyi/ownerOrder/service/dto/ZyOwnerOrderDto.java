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
package me.zhengjie.modules.zhengyi.ownerOrder.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-06-05
**/
@Data
public class ZyOwnerOrderDto implements Serializable {

    /** id */
    private String id;

    /** user_id */
    private String userId;

    /** 名称 */
    private String name;

    /** 电话 */
    private String phone;

    /** 需要驾驶证类型 */
    private Integer drivingType;

    /** 金额 */
    private Integer money;

    /** 运输类型 */
    private Integer type;

    /** 所需人数 */
    private Integer num;

    /** 备注 */
    private String content;

    /** 删除状态 */
    private Integer del;

    /** 完结状态 */
    private Integer status;

    /** 创建人 */
    private String createBy;

    /** 创建时间 */
    private Timestamp createTime;
}

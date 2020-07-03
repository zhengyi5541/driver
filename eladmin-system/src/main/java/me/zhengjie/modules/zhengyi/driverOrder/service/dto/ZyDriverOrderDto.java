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
package me.zhengjie.modules.zhengyi.driverOrder.service.dto;

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
public class ZyDriverOrderDto implements Serializable {

    /** id */
    private String id;

    /** user_id */
    private String userId;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 驾龄 */
    private Integer drivingYear;

    /** 电话 */
    private String phone;

    /** 可接受运输类型 */
    private String type;

    /** 驾驶证类型 */
    private Integer drivingType;

    /** 在职状态 */
    private Integer work;

    /** 备注 */
    private String content;

    /** 订单状态 */
    private Integer hire;

    /** 删除状态 */
    private Integer del;

    /** 创建人 */
    private String createBy;

    /** 创建时间 */
    private Timestamp createTime;
}

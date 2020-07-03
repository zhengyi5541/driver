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
package me.zhengjie.modules.zhengyi.user.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-06-25
**/
@Data
public class ZyDriveUserDto implements Serializable {

    /** id */
    private String id;

    /** 姓名 */
    private String name;

    /** 照片 */
    private String img;

    /** 年龄 */
    private Integer age;

    /** 驾龄 */
    private Integer drivingYears;

    /** 电话 */
    private String phone;

    /** 驾驶证类型 */
    private Integer drivingType;

    /** 在职状态 */
    private Integer workingState;

    /** 禁用状态 */
    private Long status;

    /** 删除状态 */
    private Integer del;

    /** 审核状态 */
    private Integer audit;

    /** 驾驶证正面 */
    private String driverPositive;

    /** 驾驶证反面 */
    private String driverReverse;

    /** 创建时间 */
    private Timestamp createTime;
}
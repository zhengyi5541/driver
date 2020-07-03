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
package me.zhengjie.modules.zhengyi.driverDetails.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-07-03
**/
@Data
public class ZyDriverDetailsDto implements Serializable {

    /** id */
    private String id;

    /** 司机订单id */
    private String driverOrderId;

    /** 雇主id */
    private String ownerId;

    /** 司机姓名 */
    private String name;

    /** 运输类型 */
    private Integer type;

    /** 电话 */
    private String phone;

    /** 驾照类型 */
    private Integer drivingType;

    /** 订单备注 */
    private String content;

    /** 雇主名称 */
    private String ownerName;

    /** 雇主电话 */
    private String ownerPhone;
}
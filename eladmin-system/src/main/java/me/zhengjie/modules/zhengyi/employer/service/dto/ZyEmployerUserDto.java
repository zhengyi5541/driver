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
package me.zhengjie.modules.zhengyi.employer.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 政一
* @date 2020-06-26
**/
@Data
public class ZyEmployerUserDto implements Serializable {

    /** id */
    private String id;

    /** 姓名 */
    private String name;

    /** 电话 */
    private String phone;

    /** 审核状态 */
    private Integer audit;

    /** 禁用状态 */
    private Long status;

    /** 删除状态 */
    private Integer del;

    /** 营业执照 */
    private String licenseImg;

    /** 创建时间 */
    private Timestamp createTime;
}
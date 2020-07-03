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
import java.util.List;
import me.zhengjie.annotation.Query;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-06-05
**/
@Data
public class ZyDriverOrderQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /** 小于等于 */
    @Query(type = Query.Type.LESS_THAN)
    private Integer age;

    /** 小于等于 */
    @Query(type = Query.Type.LESS_THAN)
    private Integer drivingYear;

    /** 精确 */
    @Query
    private String type;
    /** 精确 */
    @Query
    private Integer del;

    /** 精确 */
    @Query
    private Integer hire;

    /** 精确 */
    @Query
    private Integer drivingType;
}

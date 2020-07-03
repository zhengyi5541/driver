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
package me.zhengjie.modules.zhengyi.driverDetails.service;

import me.zhengjie.modules.zhengyi.driverDetails.domain.ZyDriverDetails;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsDto;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @description 服务接口
* @author 政一
* @date 2020-07-03
**/
public interface ZyDriverDetailsService {

    /**
    * 创建
    * @param resources /
    * @return ZyDriverDetailsDto
    */
    ZyDriverDetailsDto create(ZyDriverDetails resources);

    /**
     * 获取完成订单详情
     * @param id
     * @return
     */
    ZyDriverDetailsDto getDriverDetails(String id);


}

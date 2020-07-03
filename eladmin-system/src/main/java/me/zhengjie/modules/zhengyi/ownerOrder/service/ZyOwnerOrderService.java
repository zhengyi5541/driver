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
package me.zhengjie.modules.zhengyi.ownerOrder.service;

import me.zhengjie.modules.zhengyi.ownerOrder.domain.ZyOwnerOrder;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderDto;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @description 服务接口
* @author 政一
* @date 2020-06-05
**/
public interface ZyOwnerOrderService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ZyOwnerOrderQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ZyOwnerOrderDto>
    */
    List<ZyOwnerOrderDto> queryAll(ZyOwnerOrderQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ZyOwnerOrderDto
     */
    ZyOwnerOrderDto findById(String id);

    /**
    * 创建
    * @param resources /
    * @return ZyOwnerOrderDto
    */
    ZyOwnerOrderDto create(ZyOwnerOrder resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ZyOwnerOrder resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(String[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<ZyOwnerOrderDto> all, HttpServletResponse response) throws IOException;

    /**
     * 通过用户id查询所有订单
     * @param userId
     * @return
     */
    List<ZyOwnerOrderDto> findAllOrder(String userId);

    /**
     * 查询所有未匹配的订单
     * @return
     */
    List<ZyOwnerOrderDto> findAllOrderByStatus(ZyOwnerOrderQueryCriteria criteria);
}

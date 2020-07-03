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
package me.zhengjie.modules.zhengyi.ownerOrder.repository;

import me.zhengjie.modules.zhengyi.ownerOrder.domain.ZyOwnerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-06-05
**/
public interface ZyOwnerOrderRepository extends JpaRepository<ZyOwnerOrder, String>, JpaSpecificationExecutor<ZyOwnerOrder> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update zy_owner_order set del = 0 where id = ?1")
    void updateById(String id);

    @Transactional
    @Query(nativeQuery = true,value = "select * from zy_owner_order where user_id = ?1 order by status desc,create_time desc")
    List<ZyOwnerOrder> findAllOrder(String userId);

}

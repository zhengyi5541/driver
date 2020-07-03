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
package me.zhengjie.modules.zhengyi.driverDetails.repository;

import me.zhengjie.modules.zhengyi.driverDetails.domain.ZyDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-07-03
**/
public interface ZyDriverDetailsRepository extends JpaRepository<ZyDriverDetails, String>, JpaSpecificationExecutor<ZyDriverDetails> {

    @Query(nativeQuery = true,value = "select * from zy_driver_details where driver_order_id = ?1")
    ZyDriverDetails getDriverDetails(String id);
}

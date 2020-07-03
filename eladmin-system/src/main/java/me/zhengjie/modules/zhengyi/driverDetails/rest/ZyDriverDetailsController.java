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
package me.zhengjie.modules.zhengyi.driverDetails.rest;

import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Log;
import me.zhengjie.modules.zhengyi.driverDetails.domain.ZyDriverDetails;
import me.zhengjie.modules.zhengyi.driverDetails.service.ZyDriverDetailsService;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsDto;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsQueryCriteria;
import me.zhengjie.modules.zhengyi.driverOrder.service.ZyDriverOrderService;
import me.zhengjie.modules.zhengyi.driverOrder.service.dto.ZyDriverOrderDto;
import me.zhengjie.modules.zhengyi.employer.service.ZyEmployerUserService;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserDto;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-07-03
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "司机订单详情")
@RequestMapping("/api/zyDriverDetails")
public class ZyDriverDetailsController {

    private final ZyDriverDetailsService zyDriverDetailsService;

    private final ZyDriverOrderService zyDriverOrderService;

    private final ZyEmployerUserService zyEmployerUserService;

    @AnonymousAccess
    @PostMapping(value = "/add")
    @Log("新增完结订单详情")
    @ApiOperation("新增完结订单详情")
    public ResponseEntity<Object> create(@Validated @RequestBody ZyDriverDetails resources){
        //修改车主订单
        zyDriverOrderService.updateHire(resources.getDriverOrderId(),1);
        ZyDriverOrderDto orderDto = zyDriverOrderService.findById(resources.getDriverOrderId());
        ZyEmployerUserDto userDto = zyEmployerUserService.findById(resources.getOwnerId());
        resources.setName(orderDto.getName());
        resources.setPhone(orderDto.getPhone());
        resources.setType(Integer.parseInt(orderDto.getType()));
        resources.setDrivingType(orderDto.getDrivingType());
        resources.setContent(orderDto.getContent());
        resources.setOwnerName(userDto.getName());
        resources.setOwnerPhone(userDto.getPhone());
        return new ResponseEntity<>(zyDriverDetailsService.create(resources),HttpStatus.CREATED);
    }

    @AnonymousAccess
    @GetMapping(value = "/getDriverDetails")
    @Log("获取完成订单详情")
    @ApiOperation("获取完成订单详情")
    public ZyDriverDetailsDto getDriverDetails(@RequestParam String id){
        return zyDriverDetailsService.getDriverDetails(id);
    }
}

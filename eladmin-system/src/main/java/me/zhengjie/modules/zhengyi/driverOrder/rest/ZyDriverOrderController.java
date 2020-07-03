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
package me.zhengjie.modules.zhengyi.driverOrder.rest;

import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Log;
import me.zhengjie.modules.zhengyi.driverOrder.domain.ZyDriverOrder;
import me.zhengjie.modules.zhengyi.driverOrder.service.ZyDriverOrderService;
import me.zhengjie.modules.zhengyi.driverOrder.service.dto.ZyDriverOrderDto;
import me.zhengjie.modules.zhengyi.driverOrder.service.dto.ZyDriverOrderQueryCriteria;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderDto;
import me.zhengjie.utils.SecurityUtils;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-06-05
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "司机订单管理")
@RequestMapping("/api/zyDriverOrder")
public class ZyDriverOrderController {

    private final ZyDriverOrderService zyDriverOrderService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('zyDriverOrder:list')")
    public void download(HttpServletResponse response, ZyDriverOrderQueryCriteria criteria) throws IOException {
        zyDriverOrderService.download(zyDriverOrderService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询司机订单")
    @ApiOperation("查询司机订单")
    @PreAuthorize("@el.check('zyDriverOrder:list')")
    public ResponseEntity<Object> query(ZyDriverOrderQueryCriteria criteria, Pageable pageable){
        criteria.setDel(1);
        Map<String, Object> map = zyDriverOrderService.queryAll(criteria, pageable);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @PostMapping
    @Log("新增司机订单")
    @ApiOperation("新增司机订单")
    @PreAuthorize("@el.check('zyDriverOrder:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody ZyDriverOrder resources){
        //resources.setCreateBy(SecurityUtils.getCurrentUser().getUsername());
        resources.setCreateTime(new Timestamp(System.currentTimeMillis()));
        resources.setHire(2);
        resources.setDel(1);
        return new ResponseEntity<>(zyDriverOrderService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改司机订单")
    @ApiOperation("修改司机订单")
    @PreAuthorize("@el.check('zyDriverOrder:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody ZyDriverOrder resources){
        zyDriverOrderService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除司机订单")
    @ApiOperation("删除司机订单")
    @PreAuthorize("@el.check('zyDriverOrder:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody String[] ids) {
        zyDriverOrderService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @AnonymousAccess
    @ApiOperation("获司机所有订单")
    @GetMapping(value = "/findAllOrder")
    public List<ZyDriverOrderDto> findAllOrder(@RequestParam String userId){
        return zyDriverOrderService.findAllOrder(userId);
    }

    @AnonymousAccess
    @ApiOperation("获司机所有未匹配订单")
    @GetMapping(value = "/findAllOrderByHire")
    public List<ZyDriverOrderDto> findAllOrderByHire(ZyDriverOrderQueryCriteria criteria){
        return zyDriverOrderService.findAllOrderByHire(criteria);
    }

}

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
package me.zhengjie.modules.zhengyi.ownerOrder.rest;

import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Log;
import me.zhengjie.modules.zhengyi.ownerOrder.domain.ZyOwnerOrder;
import me.zhengjie.modules.zhengyi.ownerOrder.service.ZyOwnerOrderService;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderDto;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderQueryCriteria;
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
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-06-05
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "车主订单管理")
@RequestMapping("/api/zyOwnerOrder")
public class ZyOwnerOrderController {

    private final ZyOwnerOrderService zyOwnerOrderService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('zyOwnerOrder:list')")
    public void download(HttpServletResponse response, ZyOwnerOrderQueryCriteria criteria) throws IOException {
        zyOwnerOrderService.download(zyOwnerOrderService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询车主订单")
    @ApiOperation("查询车主订单")
    @PreAuthorize("@el.check('zyOwnerOrder:list')")
    public ResponseEntity<Object> query(ZyOwnerOrderQueryCriteria criteria, Pageable pageable){
        criteria.setDel(1);
        return new ResponseEntity<>(zyOwnerOrderService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增车主订单")
    @ApiOperation("新增车主订单")
    @PreAuthorize("@el.check('zyOwnerOrder:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody ZyOwnerOrder resources){
        resources.setCreateBy(SecurityUtils.getCurrentUser().getUsername());
        resources.setCreateTime(new Timestamp(System.currentTimeMillis()));
        resources.setStatus(2);
        resources.setDel(1);
        return new ResponseEntity<>(zyOwnerOrderService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改车主订单")
    @ApiOperation("修改车主订单")
    @PreAuthorize("@el.check('zyOwnerOrder:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody ZyOwnerOrder resources){
        zyOwnerOrderService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除车主订单")
    @ApiOperation("删除车主订单")
    @PreAuthorize("@el.check('zyOwnerOrder:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody String[] ids) {
        zyOwnerOrderService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @AnonymousAccess
    @ApiOperation("获取本车主所有订单")
    @GetMapping(value = "/findAllOrder")
    public List<ZyOwnerOrderDto> findAllOrder(@RequestParam String userId){
        return zyOwnerOrderService.findAllOrder(userId);
    }

    @AnonymousAccess
    @ApiOperation("获取本车主所有订单")
    @GetMapping(value = "/findAllOrderByStatus")
    public List<ZyOwnerOrderDto> findAllOrderByStatus(ZyOwnerOrderQueryCriteria criteria){
        return zyOwnerOrderService.findAllOrderByStatus(criteria);
    }
}

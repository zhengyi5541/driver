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
package me.zhengjie.modules.zhengyi.employer.rest;

import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Log;
import me.zhengjie.modules.zhengyi.employer.domain.ZyEmployerUser;
import me.zhengjie.modules.zhengyi.employer.service.ZyEmployerUserService;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserQueryCriteria;
import me.zhengjie.modules.zhengyi.user.domain.ZyDriveUser;
import me.zhengjie.modules.zhengyi.user.service.ZyDriveUserService;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author 政一
* @date 2020-06-26
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "雇主列表管理")
@RequestMapping("/api/zyEmployerUser")
public class ZyEmployerUserController {

    private final ZyEmployerUserService zyEmployerUserService;
    private final ZyDriveUserService zyDriveUserService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('zyEmployerUser:list')")
    public void download(HttpServletResponse response, ZyEmployerUserQueryCriteria criteria) throws IOException {
        zyEmployerUserService.download(zyEmployerUserService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询雇主列表")
    @ApiOperation("查询雇主列表")
    @PreAuthorize("@el.check('zyEmployerUser:list')")
    public ResponseEntity<Object> query(ZyEmployerUserQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(zyEmployerUserService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增雇主列表")
    @ApiOperation("新增雇主列表")
    @PreAuthorize("@el.check('zyEmployerUser:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody ZyEmployerUser resources){
        return new ResponseEntity<>(zyEmployerUserService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改雇主列表")
    @ApiOperation("修改雇主列表")
    @PreAuthorize("@el.check('zyEmployerUser:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody ZyEmployerUser resources){
        zyEmployerUserService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除雇主列表")
    @ApiOperation("删除雇主列表")
    @PreAuthorize("@el.check('zyEmployerUser:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody String[] ids) {
        zyEmployerUserService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("上传驾驶证照片")
    @PostMapping(value = "/updateDriver")
    @AnonymousAccess
    public String DriverPositive(@RequestParam MultipartFile avatar){
        return zyDriveUserService.updateDriver(avatar);
    }


    @ApiOperation("修改用户审核状态")
    @PostMapping(value = "/updateAudit")
    public ResponseEntity<Object> updateAudit(@RequestBody ZyEmployerUser zyEmployerUser){
        zyEmployerUserService.updateAudit(zyEmployerUser.getAudit(),zyEmployerUser.getId());
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

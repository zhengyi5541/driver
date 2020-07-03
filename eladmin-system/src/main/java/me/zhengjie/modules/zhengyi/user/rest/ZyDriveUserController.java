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
package me.zhengjie.modules.zhengyi.user.rest;

import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.annotation.Log;
import me.zhengjie.modules.zhengyi.user.domain.ZyDriveUser;
import me.zhengjie.modules.zhengyi.user.service.ZyDriveUserService;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserDto;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserQueryCriteria;
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
* @date 2020-06-25
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "车主用户管理")
@RequestMapping("/api/zyDriveUser")
public class ZyDriveUserController {

    private final ZyDriveUserService zyDriveUserService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('zyDriveUser:list')")
    public void download(HttpServletResponse response, ZyDriveUserQueryCriteria criteria) throws IOException {
        zyDriveUserService.download(zyDriveUserService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询车主用户")
    @ApiOperation("查询车主用户")
    @PreAuthorize("@el.check('zyDriveUser:list')")
    @AnonymousAccess
    public ResponseEntity<Object> query(ZyDriveUserQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(zyDriveUserService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增车主用户")
    @ApiOperation("新增车主用户")
    @PreAuthorize("@el.check('zyDriveUser:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody ZyDriveUser resources){
        return new ResponseEntity<>(zyDriveUserService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改车主用户")
    @ApiOperation("修改车主用户")
    @PreAuthorize("@el.check('zyDriveUser:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody ZyDriveUser resources){
        ZyDriveUserDto userDto = zyDriveUserService.findById(resources.getId());
        if(userDto.getDriverPositive() != resources.getDriverPositive()){
            zyDriveUserService.deleteOldPath(userDto.getDriverPositive());
        }
        if(userDto.getDriverReverse() != resources.getDriverReverse()){
            zyDriveUserService.deleteOldPath(userDto.getDriverReverse());
        }
        zyDriveUserService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除车主用户")
    @ApiOperation("删除车主用户")
    @PreAuthorize("@el.check('zyDriveUser:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody String[] ids) {
        zyDriveUserService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("上传驾驶证照片")
    @PostMapping(value = "/updateDriver")
    @AnonymousAccess
    public String DriverPositive(@RequestParam MultipartFile avatar){
        return zyDriveUserService.updateDriver(avatar);
    }


    @ApiOperation("修改用户状态")
    @PostMapping(value = "/updateAudit")
    public ResponseEntity<Object> updateAudit(@RequestBody ZyDriveUser zyDriveUser){
        zyDriveUserService.updateAudit(zyDriveUser.getAudit(),zyDriveUser.getId());
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

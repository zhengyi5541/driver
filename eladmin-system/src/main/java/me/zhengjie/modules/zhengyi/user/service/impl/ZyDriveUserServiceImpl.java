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
package me.zhengjie.modules.zhengyi.user.service.impl;

import me.zhengjie.config.FileProperties;
import me.zhengjie.modules.system.domain.User;
import me.zhengjie.modules.zhengyi.user.domain.ZyDriveUser;
import me.zhengjie.utils.*;
import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.zhengyi.user.repository.ZyDriveUserRepository;
import me.zhengjie.modules.zhengyi.user.service.ZyDriveUserService;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserDto;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserQueryCriteria;
import me.zhengjie.modules.zhengyi.user.service.mapstruct.ZyDriveUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author 政一
* @date 2020-06-25
**/
@Service
@RequiredArgsConstructor
public class ZyDriveUserServiceImpl implements ZyDriveUserService {

    private final ZyDriveUserRepository zyDriveUserRepository;
    private final ZyDriveUserMapper zyDriveUserMapper;
    private final FileProperties properties;

    @Override
    public Map<String,Object> queryAll(ZyDriveUserQueryCriteria criteria, Pageable pageable){
        Page<ZyDriveUser> page = zyDriveUserRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(zyDriveUserMapper::toDto));
    }

    @Override
    public List<ZyDriveUserDto> queryAll(ZyDriveUserQueryCriteria criteria){
        return zyDriveUserMapper.toDto(zyDriveUserRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ZyDriveUserDto findById(String id) {
        ZyDriveUser zyDriveUser = zyDriveUserRepository.findById(id).orElseGet(ZyDriveUser::new);
        ValidationUtil.isNull(zyDriveUser.getId(),"ZyDriveUser","id",id);
        return zyDriveUserMapper.toDto(zyDriveUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZyDriveUserDto create(ZyDriveUser resources) {
        resources.setId(IdUtil.simpleUUID()); 
        return zyDriveUserMapper.toDto(zyDriveUserRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ZyDriveUser resources) {
        ZyDriveUser zyDriveUser = zyDriveUserRepository.findById(resources.getId()).orElseGet(ZyDriveUser::new);
        ValidationUtil.isNull( zyDriveUser.getId(),"ZyDriveUser","id",resources.getId());
        zyDriveUser.copy(resources);
        zyDriveUserRepository.save(zyDriveUser);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            zyDriveUserRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ZyDriveUserDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ZyDriveUserDto zyDriveUser : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("姓名", zyDriveUser.getName());
            map.put("照片", zyDriveUser.getImg());
            map.put("年龄", zyDriveUser.getAge());
            map.put("驾龄", zyDriveUser.getDrivingYears());
            map.put("电话", zyDriveUser.getPhone());
            map.put("驾驶证类型", zyDriveUser.getDrivingType());
            map.put("在职状态", zyDriveUser.getWorkingState());
            map.put("禁用状态", zyDriveUser.getStatus());
            map.put("删除状态", zyDriveUser.getDel());
            map.put("审核状态", zyDriveUser.getAudit());
            map.put("驾驶证正面", zyDriveUser.getDriverPositive());
            map.put("驾驶证反面", zyDriveUser.getDriverReverse());
            map.put("创建时间", zyDriveUser.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public String updateDriver(MultipartFile multipartFile) {
        File file = FileUtil.upload(multipartFile, properties.getPath().getAvatar());
        String path = Objects.requireNonNull(file).getPath();
        return path;
    }


    @Override
    public void updateAudit(Integer audit,String id) {
        zyDriveUserRepository.updateAudit(audit,id);
    }

    @Override
    public void deleteOldPath(String path) {
        FileUtil.del(path);
    }
}
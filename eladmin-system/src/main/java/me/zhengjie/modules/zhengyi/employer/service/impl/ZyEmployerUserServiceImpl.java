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
package me.zhengjie.modules.zhengyi.employer.service.impl;

import me.zhengjie.modules.zhengyi.employer.domain.ZyEmployerUser;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.zhengyi.employer.repository.ZyEmployerUserRepository;
import me.zhengjie.modules.zhengyi.employer.service.ZyEmployerUserService;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserDto;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserQueryCriteria;
import me.zhengjie.modules.zhengyi.employer.service.mapstruct.ZyEmployerUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author 政一
* @date 2020-06-26
**/
@Service
@RequiredArgsConstructor
public class ZyEmployerUserServiceImpl implements ZyEmployerUserService {

    private final ZyEmployerUserRepository zyEmployerUserRepository;
    private final ZyEmployerUserMapper zyEmployerUserMapper;

    @Override
    public Map<String,Object> queryAll(ZyEmployerUserQueryCriteria criteria, Pageable pageable){
        Page<ZyEmployerUser> page = zyEmployerUserRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(zyEmployerUserMapper::toDto));
    }

    @Override
    public List<ZyEmployerUserDto> queryAll(ZyEmployerUserQueryCriteria criteria){
        return zyEmployerUserMapper.toDto(zyEmployerUserRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ZyEmployerUserDto findById(String id) {
        ZyEmployerUser zyEmployerUser = zyEmployerUserRepository.findById(id).orElseGet(ZyEmployerUser::new);
        ValidationUtil.isNull(zyEmployerUser.getId(),"ZyEmployerUser","id",id);
        return zyEmployerUserMapper.toDto(zyEmployerUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZyEmployerUserDto create(ZyEmployerUser resources) {
        resources.setId(IdUtil.simpleUUID()); 
        return zyEmployerUserMapper.toDto(zyEmployerUserRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ZyEmployerUser resources) {
        ZyEmployerUser zyEmployerUser = zyEmployerUserRepository.findById(resources.getId()).orElseGet(ZyEmployerUser::new);
        ValidationUtil.isNull( zyEmployerUser.getId(),"ZyEmployerUser","id",resources.getId());
        zyEmployerUser.copy(resources);
        zyEmployerUserRepository.save(zyEmployerUser);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            zyEmployerUserRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<ZyEmployerUserDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ZyEmployerUserDto zyEmployerUser : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("姓名", zyEmployerUser.getName());
            map.put("电话", zyEmployerUser.getPhone());
            map.put("审核状态", zyEmployerUser.getAudit());
            map.put("禁用状态", zyEmployerUser.getStatus());
            map.put("删除状态", zyEmployerUser.getDel());
            map.put("营业执照", zyEmployerUser.getLicenseImg());
            map.put("创建时间", zyEmployerUser.getCreateTime());
            map.put("姓名", zyEmployerUser.getName());
            map.put("电话", zyEmployerUser.getPhone());
            map.put("审核状态", zyEmployerUser.getAudit());
            map.put("禁用状态", zyEmployerUser.getStatus());
            map.put("删除状态", zyEmployerUser.getDel());
            map.put("营业执照", zyEmployerUser.getLicenseImg());
            map.put("创建时间", zyEmployerUser.getCreateTime());
            map.put("姓名", zyEmployerUser.getName());
            map.put("电话", zyEmployerUser.getPhone());
            map.put("审核状态", zyEmployerUser.getAudit());
            map.put("禁用状态", zyEmployerUser.getStatus());
            map.put("删除状态", zyEmployerUser.getDel());
            map.put("营业执照", zyEmployerUser.getLicenseImg());
            map.put("创建时间", zyEmployerUser.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public void updateAudit(Integer audit, String id) {
        zyEmployerUserRepository.updateAudit(audit,id);
    }
}
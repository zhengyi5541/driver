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
package me.zhengjie.modules.zhengyi.driverDetails.service.impl;

import me.zhengjie.modules.zhengyi.driverDetails.domain.ZyDriverDetails;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.zhengyi.driverDetails.repository.ZyDriverDetailsRepository;
import me.zhengjie.modules.zhengyi.driverDetails.service.ZyDriverDetailsService;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsDto;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsQueryCriteria;
import me.zhengjie.modules.zhengyi.driverDetails.service.mapstruct.ZyDriverDetailsMapper;
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
* @date 2020-07-03
**/
@Service
@RequiredArgsConstructor
public class ZyDriverDetailsServiceImpl implements ZyDriverDetailsService {

    private final ZyDriverDetailsRepository zyDriverDetailsRepository;
    private final ZyDriverDetailsMapper zyDriverDetailsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZyDriverDetailsDto create(ZyDriverDetails resources) {
        resources.setId(IdUtil.simpleUUID());
        return zyDriverDetailsMapper.toDto(zyDriverDetailsRepository.save(resources));
    }

    @Override
    public ZyDriverDetailsDto getDriverDetails(String id) {
        ZyDriverDetails driverDetails = zyDriverDetailsRepository.getDriverDetails(id);
        return zyDriverDetailsMapper.toDto(driverDetails);
    }

}

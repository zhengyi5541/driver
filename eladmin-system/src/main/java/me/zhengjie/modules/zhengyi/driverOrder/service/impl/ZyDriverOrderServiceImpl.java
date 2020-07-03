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
package me.zhengjie.modules.zhengyi.driverOrder.service.impl;

import me.zhengjie.modules.zhengyi.driverOrder.domain.ZyDriverOrder;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.zhengyi.driverOrder.repository.ZyDriverOrderRepository;
import me.zhengjie.modules.zhengyi.driverOrder.service.ZyDriverOrderService;
import me.zhengjie.modules.zhengyi.driverOrder.service.dto.ZyDriverOrderDto;
import me.zhengjie.modules.zhengyi.driverOrder.service.dto.ZyDriverOrderQueryCriteria;
import me.zhengjie.modules.zhengyi.driverOrder.service.mapstruct.ZyDriverOrderMapper;
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
* @date 2020-06-05
**/
@Service
@RequiredArgsConstructor
public class ZyDriverOrderServiceImpl implements ZyDriverOrderService {

    private final ZyDriverOrderRepository zyDriverOrderRepository;
    private final ZyDriverOrderMapper zyDriverOrderMapper;

    @Override
    public Map<String,Object> queryAll(ZyDriverOrderQueryCriteria criteria, Pageable pageable){
        Page<ZyDriverOrder> page = zyDriverOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(zyDriverOrderMapper::toDto));
    }

    @Override
    public List<ZyDriverOrderDto> queryAll(ZyDriverOrderQueryCriteria criteria){
        return zyDriverOrderMapper.toDto(zyDriverOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ZyDriverOrderDto findById(String id) {
        ZyDriverOrder zyDriverOrder = zyDriverOrderRepository.findById(id).orElseGet(ZyDriverOrder::new);
        ValidationUtil.isNull(zyDriverOrder.getId(),"ZyDriverOrder","id",id);
        return zyDriverOrderMapper.toDto(zyDriverOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZyDriverOrderDto create(ZyDriverOrder resources) {
        resources.setId(IdUtil.simpleUUID());
        return zyDriverOrderMapper.toDto(zyDriverOrderRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ZyDriverOrder resources) {
        ZyDriverOrder zyDriverOrder = zyDriverOrderRepository.findById(resources.getId()).orElseGet(ZyDriverOrder::new);
        ValidationUtil.isNull( zyDriverOrder.getId(),"ZyDriverOrder","id",resources.getId());
        zyDriverOrder.copy(resources);
        zyDriverOrderRepository.save(zyDriverOrder);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            zyDriverOrderRepository.updateById(id);
        }
    }

    @Override
    public void download(List<ZyDriverOrderDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ZyDriverOrderDto zyDriverOrder : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("user_id", zyDriverOrder.getUserId());
            map.put("姓名", zyDriverOrder.getName());
            map.put("年龄", zyDriverOrder.getAge());
            map.put("驾龄", zyDriverOrder.getDrivingYear());
            map.put("电话", zyDriverOrder.getPhone());
            map.put("可接受运输类型", zyDriverOrder.getType());
            map.put("驾驶证类型", zyDriverOrder.getDrivingType());
            map.put("在职状态", zyDriverOrder.getWork());
            map.put("备注", zyDriverOrder.getContent());
            map.put("订单状态", zyDriverOrder.getHire());
            map.put("删除状态", zyDriverOrder.getDel());
            map.put("创建人", zyDriverOrder.getCreateBy());
            map.put("创建时间", zyDriverOrder.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public List<ZyDriverOrderDto> findAllOrder(String userId) {
        return zyDriverOrderMapper.toDto(zyDriverOrderRepository.findAllOrder(userId));
    }

    @Override
    public List<ZyDriverOrderDto> findAllOrderByHire(ZyDriverOrderQueryCriteria criteria) {
        List<ZyDriverOrder> all = zyDriverOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
        return zyDriverOrderMapper.toDto(all);
    }

    @Override
    public void updateHire(String id, Integer hire) {
        zyDriverOrderRepository.updateHire(id,hire);
    }
}

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
package me.zhengjie.modules.zhengyi.ownerOrder.service.impl;

import me.zhengjie.modules.zhengyi.ownerOrder.domain.ZyOwnerOrder;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.zhengyi.ownerOrder.repository.ZyOwnerOrderRepository;
import me.zhengjie.modules.zhengyi.ownerOrder.service.ZyOwnerOrderService;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderDto;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderQueryCriteria;
import me.zhengjie.modules.zhengyi.ownerOrder.service.mapstruct.ZyOwnerOrderMapper;
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
public class ZyOwnerOrderServiceImpl implements ZyOwnerOrderService {

    private final ZyOwnerOrderRepository zyOwnerOrderRepository;
    private final ZyOwnerOrderMapper zyOwnerOrderMapper;

    @Override
    public Map<String,Object> queryAll(ZyOwnerOrderQueryCriteria criteria, Pageable pageable){
        Page<ZyOwnerOrder> page = zyOwnerOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(zyOwnerOrderMapper::toDto));
    }

    @Override
    public List<ZyOwnerOrderDto> queryAll(ZyOwnerOrderQueryCriteria criteria){
        return zyOwnerOrderMapper.toDto(zyOwnerOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public ZyOwnerOrderDto findById(String id) {
        ZyOwnerOrder zyOwnerOrder = zyOwnerOrderRepository.findById(id).orElseGet(ZyOwnerOrder::new);
        ValidationUtil.isNull(zyOwnerOrder.getId(),"ZyOwnerOrder","id",id);
        return zyOwnerOrderMapper.toDto(zyOwnerOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ZyOwnerOrderDto create(ZyOwnerOrder resources) {
        resources.setId(IdUtil.simpleUUID());
        return zyOwnerOrderMapper.toDto(zyOwnerOrderRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ZyOwnerOrder resources) {
        ZyOwnerOrder zyOwnerOrder = zyOwnerOrderRepository.findById(resources.getId()).orElseGet(ZyOwnerOrder::new);
        ValidationUtil.isNull( zyOwnerOrder.getId(),"ZyOwnerOrder","id",resources.getId());
        zyOwnerOrder.copy(resources);
        zyOwnerOrderRepository.save(zyOwnerOrder);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            zyOwnerOrderRepository.updateById(id);
        }
    }

    @Override
    public void download(List<ZyOwnerOrderDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ZyOwnerOrderDto zyOwnerOrder : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("user_id", zyOwnerOrder.getUserId());
            map.put("名称", zyOwnerOrder.getName());
            map.put("电话", zyOwnerOrder.getPhone());
            map.put("需要驾驶证类型", zyOwnerOrder.getDrivingType());
            map.put("金额", zyOwnerOrder.getMoney());
            map.put("运输类型", zyOwnerOrder.getType());
            map.put("所需人数", zyOwnerOrder.getNum());
            map.put("备注", zyOwnerOrder.getContent());
            map.put("删除状态", zyOwnerOrder.getDel());
            map.put("完结状态", zyOwnerOrder.getStatus());
            map.put("创建人", zyOwnerOrder.getCreateBy());
            map.put("创建时间", zyOwnerOrder.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public List<ZyOwnerOrderDto> findAllOrder(String userId) {
        List<ZyOwnerOrder> allOrder = zyOwnerOrderRepository.findAllOrder(userId);
        return zyOwnerOrderMapper.toDto(allOrder);
    }

    @Override
    public List<ZyOwnerOrderDto> findAllOrderByStatus(ZyOwnerOrderQueryCriteria criteria){
        List<ZyOwnerOrder> allOrder = zyOwnerOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
        return zyOwnerOrderMapper.toDto(allOrder);
    }
}

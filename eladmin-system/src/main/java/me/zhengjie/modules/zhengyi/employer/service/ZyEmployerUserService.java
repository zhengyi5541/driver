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
package me.zhengjie.modules.zhengyi.employer.service;

import me.zhengjie.modules.zhengyi.employer.domain.ZyEmployerUser;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserDto;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @description 服务接口
* @author 政一
* @date 2020-06-26
**/
public interface ZyEmployerUserService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ZyEmployerUserQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ZyEmployerUserDto>
    */
    List<ZyEmployerUserDto> queryAll(ZyEmployerUserQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ZyEmployerUserDto
     */
    ZyEmployerUserDto findById(String id);

    /**
    * 创建
    * @param resources /
    * @return ZyEmployerUserDto
    */
    ZyEmployerUserDto create(ZyEmployerUser resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ZyEmployerUser resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(String[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<ZyEmployerUserDto> all, HttpServletResponse response) throws IOException;

    /**
     * 修改雇主状态
     * @param audit
     * @param id
     */
    void updateAudit(Integer audit,String id);
}
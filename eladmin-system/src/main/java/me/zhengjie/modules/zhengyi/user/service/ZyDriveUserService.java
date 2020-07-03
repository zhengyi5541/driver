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
package me.zhengjie.modules.zhengyi.user.service;

import me.zhengjie.modules.zhengyi.user.domain.ZyDriveUser;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserDto;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @description 服务接口
* @author 政一
* @date 2020-06-25
**/
public interface ZyDriveUserService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(ZyDriveUserQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<ZyDriveUserDto>
    */
    List<ZyDriveUserDto> queryAll(ZyDriveUserQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return ZyDriveUserDto
     */
    ZyDriveUserDto findById(String id);

    /**
    * 创建
    * @param resources /
    * @return ZyDriveUserDto
    */
    ZyDriveUserDto create(ZyDriveUser resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(ZyDriveUser resources);

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
    void download(List<ZyDriveUserDto> all, HttpServletResponse response) throws IOException;

    /**
     * 上传驾驶证照片
     * @param file 文件
     * @return /
     */
    String updateDriver(MultipartFile file);

    /**
     * 更改审核状态
     * @param audit 审核状态
     * @return /
     */
    void updateAudit(Integer audit,String id);

    /**
     * 删除旧的图片
     * @param path
     */
    void deleteOldPath(String path);
}
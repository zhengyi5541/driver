package me.zhengjie.modules.zhengyi.user.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.zhengyi.user.domain.ZyDriveUser;
import me.zhengjie.modules.zhengyi.user.service.dto.ZyDriveUserDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T13:26:36+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ZyDriveUserMapperImpl implements ZyDriveUserMapper {

    @Override
    public ZyDriveUser toEntity(ZyDriveUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        ZyDriveUser zyDriveUser = new ZyDriveUser();

        zyDriveUser.setId( dto.getId() );
        zyDriveUser.setName( dto.getName() );
        zyDriveUser.setImg( dto.getImg() );
        zyDriveUser.setAge( dto.getAge() );
        zyDriveUser.setDrivingYears( dto.getDrivingYears() );
        zyDriveUser.setPhone( dto.getPhone() );
        zyDriveUser.setDrivingType( dto.getDrivingType() );
        zyDriveUser.setWorkingState( dto.getWorkingState() );
        zyDriveUser.setStatus( dto.getStatus() );
        zyDriveUser.setDel( dto.getDel() );
        zyDriveUser.setAudit( dto.getAudit() );
        zyDriveUser.setDriverPositive( dto.getDriverPositive() );
        zyDriveUser.setDriverReverse( dto.getDriverReverse() );
        zyDriveUser.setCreateTime( dto.getCreateTime() );

        return zyDriveUser;
    }

    @Override
    public ZyDriveUserDto toDto(ZyDriveUser entity) {
        if ( entity == null ) {
            return null;
        }

        ZyDriveUserDto zyDriveUserDto = new ZyDriveUserDto();

        zyDriveUserDto.setId( entity.getId() );
        zyDriveUserDto.setName( entity.getName() );
        zyDriveUserDto.setImg( entity.getImg() );
        zyDriveUserDto.setAge( entity.getAge() );
        zyDriveUserDto.setDrivingYears( entity.getDrivingYears() );
        zyDriveUserDto.setPhone( entity.getPhone() );
        zyDriveUserDto.setDrivingType( entity.getDrivingType() );
        zyDriveUserDto.setWorkingState( entity.getWorkingState() );
        zyDriveUserDto.setStatus( entity.getStatus() );
        zyDriveUserDto.setDel( entity.getDel() );
        zyDriveUserDto.setAudit( entity.getAudit() );
        zyDriveUserDto.setDriverPositive( entity.getDriverPositive() );
        zyDriveUserDto.setDriverReverse( entity.getDriverReverse() );
        zyDriveUserDto.setCreateTime( entity.getCreateTime() );

        return zyDriveUserDto;
    }

    @Override
    public List<ZyDriveUser> toEntity(List<ZyDriveUserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ZyDriveUser> list = new ArrayList<ZyDriveUser>( dtoList.size() );
        for ( ZyDriveUserDto zyDriveUserDto : dtoList ) {
            list.add( toEntity( zyDriveUserDto ) );
        }

        return list;
    }

    @Override
    public List<ZyDriveUserDto> toDto(List<ZyDriveUser> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ZyDriveUserDto> list = new ArrayList<ZyDriveUserDto>( entityList.size() );
        for ( ZyDriveUser zyDriveUser : entityList ) {
            list.add( toDto( zyDriveUser ) );
        }

        return list;
    }
}

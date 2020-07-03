package me.zhengjie.modules.zhengyi.employer.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.zhengyi.employer.domain.ZyEmployerUser;
import me.zhengjie.modules.zhengyi.employer.service.dto.ZyEmployerUserDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T13:26:36+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ZyEmployerUserMapperImpl implements ZyEmployerUserMapper {

    @Override
    public ZyEmployerUser toEntity(ZyEmployerUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        ZyEmployerUser zyEmployerUser = new ZyEmployerUser();

        zyEmployerUser.setId( dto.getId() );
        zyEmployerUser.setName( dto.getName() );
        zyEmployerUser.setPhone( dto.getPhone() );
        zyEmployerUser.setAudit( dto.getAudit() );
        zyEmployerUser.setStatus( dto.getStatus() );
        zyEmployerUser.setDel( dto.getDel() );
        zyEmployerUser.setLicenseImg( dto.getLicenseImg() );
        zyEmployerUser.setCreateTime( dto.getCreateTime() );

        return zyEmployerUser;
    }

    @Override
    public ZyEmployerUserDto toDto(ZyEmployerUser entity) {
        if ( entity == null ) {
            return null;
        }

        ZyEmployerUserDto zyEmployerUserDto = new ZyEmployerUserDto();

        zyEmployerUserDto.setId( entity.getId() );
        zyEmployerUserDto.setName( entity.getName() );
        zyEmployerUserDto.setPhone( entity.getPhone() );
        zyEmployerUserDto.setAudit( entity.getAudit() );
        zyEmployerUserDto.setStatus( entity.getStatus() );
        zyEmployerUserDto.setDel( entity.getDel() );
        zyEmployerUserDto.setLicenseImg( entity.getLicenseImg() );
        zyEmployerUserDto.setCreateTime( entity.getCreateTime() );

        return zyEmployerUserDto;
    }

    @Override
    public List<ZyEmployerUser> toEntity(List<ZyEmployerUserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ZyEmployerUser> list = new ArrayList<ZyEmployerUser>( dtoList.size() );
        for ( ZyEmployerUserDto zyEmployerUserDto : dtoList ) {
            list.add( toEntity( zyEmployerUserDto ) );
        }

        return list;
    }

    @Override
    public List<ZyEmployerUserDto> toDto(List<ZyEmployerUser> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ZyEmployerUserDto> list = new ArrayList<ZyEmployerUserDto>( entityList.size() );
        for ( ZyEmployerUser zyEmployerUser : entityList ) {
            list.add( toDto( zyEmployerUser ) );
        }

        return list;
    }
}

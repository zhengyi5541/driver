package me.zhengjie.modules.zhengyi.driverDetails.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.zhengyi.driverDetails.domain.ZyDriverDetails;
import me.zhengjie.modules.zhengyi.driverDetails.service.dto.ZyDriverDetailsDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-03T15:12:30+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ZyDriverDetailsMapperImpl implements ZyDriverDetailsMapper {

    @Override
    public ZyDriverDetails toEntity(ZyDriverDetailsDto dto) {
        if ( dto == null ) {
            return null;
        }

        ZyDriverDetails zyDriverDetails = new ZyDriverDetails();

        zyDriverDetails.setId( dto.getId() );
        zyDriverDetails.setDriverOrderId( dto.getDriverOrderId() );
        zyDriverDetails.setOwnerId( dto.getOwnerId() );
        zyDriverDetails.setName( dto.getName() );
        zyDriverDetails.setType( dto.getType() );
        zyDriverDetails.setPhone( dto.getPhone() );
        zyDriverDetails.setDrivingType( dto.getDrivingType() );
        zyDriverDetails.setContent( dto.getContent() );
        zyDriverDetails.setOwnerName( dto.getOwnerName() );
        zyDriverDetails.setOwnerPhone( dto.getOwnerPhone() );

        return zyDriverDetails;
    }

    @Override
    public ZyDriverDetailsDto toDto(ZyDriverDetails entity) {
        if ( entity == null ) {
            return null;
        }

        ZyDriverDetailsDto zyDriverDetailsDto = new ZyDriverDetailsDto();

        zyDriverDetailsDto.setId( entity.getId() );
        zyDriverDetailsDto.setDriverOrderId( entity.getDriverOrderId() );
        zyDriverDetailsDto.setOwnerId( entity.getOwnerId() );
        zyDriverDetailsDto.setName( entity.getName() );
        zyDriverDetailsDto.setType( entity.getType() );
        zyDriverDetailsDto.setPhone( entity.getPhone() );
        zyDriverDetailsDto.setDrivingType( entity.getDrivingType() );
        zyDriverDetailsDto.setContent( entity.getContent() );
        zyDriverDetailsDto.setOwnerName( entity.getOwnerName() );
        zyDriverDetailsDto.setOwnerPhone( entity.getOwnerPhone() );

        return zyDriverDetailsDto;
    }

    @Override
    public List<ZyDriverDetails> toEntity(List<ZyDriverDetailsDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ZyDriverDetails> list = new ArrayList<ZyDriverDetails>( dtoList.size() );
        for ( ZyDriverDetailsDto zyDriverDetailsDto : dtoList ) {
            list.add( toEntity( zyDriverDetailsDto ) );
        }

        return list;
    }

    @Override
    public List<ZyDriverDetailsDto> toDto(List<ZyDriverDetails> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ZyDriverDetailsDto> list = new ArrayList<ZyDriverDetailsDto>( entityList.size() );
        for ( ZyDriverDetails zyDriverDetails : entityList ) {
            list.add( toDto( zyDriverDetails ) );
        }

        return list;
    }
}

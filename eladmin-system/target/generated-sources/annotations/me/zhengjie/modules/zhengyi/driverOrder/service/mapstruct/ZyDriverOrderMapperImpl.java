package me.zhengjie.modules.zhengyi.driverOrder.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.zhengyi.driverOrder.domain.ZyDriverOrder;
import me.zhengjie.modules.zhengyi.driverOrder.service.dto.ZyDriverOrderDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T13:26:36+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ZyDriverOrderMapperImpl implements ZyDriverOrderMapper {

    @Override
    public ZyDriverOrder toEntity(ZyDriverOrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        ZyDriverOrder zyDriverOrder = new ZyDriverOrder();

        zyDriverOrder.setId( dto.getId() );
        zyDriverOrder.setName( dto.getName() );
        zyDriverOrder.setAge( dto.getAge() );
        zyDriverOrder.setDrivingYear( dto.getDrivingYear() );
        zyDriverOrder.setPhone( dto.getPhone() );
        zyDriverOrder.setType( dto.getType() );
        zyDriverOrder.setDrivingType( dto.getDrivingType() );
        zyDriverOrder.setWork( dto.getWork() );
        zyDriverOrder.setContent( dto.getContent() );
        zyDriverOrder.setHire( dto.getHire() );
        zyDriverOrder.setDel( dto.getDel() );
        zyDriverOrder.setCreateBy( dto.getCreateBy() );
        zyDriverOrder.setCreateTime( dto.getCreateTime() );

        return zyDriverOrder;
    }

    @Override
    public ZyDriverOrderDto toDto(ZyDriverOrder entity) {
        if ( entity == null ) {
            return null;
        }

        ZyDriverOrderDto zyDriverOrderDto = new ZyDriverOrderDto();

        zyDriverOrderDto.setId( entity.getId() );
        zyDriverOrderDto.setName( entity.getName() );
        zyDriverOrderDto.setAge( entity.getAge() );
        zyDriverOrderDto.setDrivingYear( entity.getDrivingYear() );
        zyDriverOrderDto.setPhone( entity.getPhone() );
        zyDriverOrderDto.setType( entity.getType() );
        zyDriverOrderDto.setDrivingType( entity.getDrivingType() );
        zyDriverOrderDto.setWork( entity.getWork() );
        zyDriverOrderDto.setContent( entity.getContent() );
        zyDriverOrderDto.setHire( entity.getHire() );
        zyDriverOrderDto.setDel( entity.getDel() );
        zyDriverOrderDto.setCreateBy( entity.getCreateBy() );
        zyDriverOrderDto.setCreateTime( entity.getCreateTime() );

        return zyDriverOrderDto;
    }

    @Override
    public List<ZyDriverOrder> toEntity(List<ZyDriverOrderDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ZyDriverOrder> list = new ArrayList<ZyDriverOrder>( dtoList.size() );
        for ( ZyDriverOrderDto zyDriverOrderDto : dtoList ) {
            list.add( toEntity( zyDriverOrderDto ) );
        }

        return list;
    }

    @Override
    public List<ZyDriverOrderDto> toDto(List<ZyDriverOrder> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ZyDriverOrderDto> list = new ArrayList<ZyDriverOrderDto>( entityList.size() );
        for ( ZyDriverOrder zyDriverOrder : entityList ) {
            list.add( toDto( zyDriverOrder ) );
        }

        return list;
    }
}

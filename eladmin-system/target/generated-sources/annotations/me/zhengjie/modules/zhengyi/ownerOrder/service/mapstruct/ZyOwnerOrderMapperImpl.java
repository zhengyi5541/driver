package me.zhengjie.modules.zhengyi.ownerOrder.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.zhengyi.ownerOrder.domain.ZyOwnerOrder;
import me.zhengjie.modules.zhengyi.ownerOrder.service.dto.ZyOwnerOrderDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T13:26:36+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class ZyOwnerOrderMapperImpl implements ZyOwnerOrderMapper {

    @Override
    public ZyOwnerOrder toEntity(ZyOwnerOrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        ZyOwnerOrder zyOwnerOrder = new ZyOwnerOrder();

        zyOwnerOrder.setId( dto.getId() );
        zyOwnerOrder.setName( dto.getName() );
        zyOwnerOrder.setPhone( dto.getPhone() );
        zyOwnerOrder.setDrivingType( dto.getDrivingType() );
        zyOwnerOrder.setMoney( dto.getMoney() );
        zyOwnerOrder.setType( dto.getType() );
        zyOwnerOrder.setNum( dto.getNum() );
        zyOwnerOrder.setContent( dto.getContent() );
        zyOwnerOrder.setDel( dto.getDel() );
        zyOwnerOrder.setStatus( dto.getStatus() );
        zyOwnerOrder.setCreateBy( dto.getCreateBy() );
        zyOwnerOrder.setCreateTime( dto.getCreateTime() );

        return zyOwnerOrder;
    }

    @Override
    public ZyOwnerOrderDto toDto(ZyOwnerOrder entity) {
        if ( entity == null ) {
            return null;
        }

        ZyOwnerOrderDto zyOwnerOrderDto = new ZyOwnerOrderDto();

        zyOwnerOrderDto.setId( entity.getId() );
        zyOwnerOrderDto.setName( entity.getName() );
        zyOwnerOrderDto.setPhone( entity.getPhone() );
        zyOwnerOrderDto.setDrivingType( entity.getDrivingType() );
        zyOwnerOrderDto.setMoney( entity.getMoney() );
        zyOwnerOrderDto.setType( entity.getType() );
        zyOwnerOrderDto.setNum( entity.getNum() );
        zyOwnerOrderDto.setContent( entity.getContent() );
        zyOwnerOrderDto.setDel( entity.getDel() );
        zyOwnerOrderDto.setStatus( entity.getStatus() );
        zyOwnerOrderDto.setCreateBy( entity.getCreateBy() );
        zyOwnerOrderDto.setCreateTime( entity.getCreateTime() );

        return zyOwnerOrderDto;
    }

    @Override
    public List<ZyOwnerOrder> toEntity(List<ZyOwnerOrderDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ZyOwnerOrder> list = new ArrayList<ZyOwnerOrder>( dtoList.size() );
        for ( ZyOwnerOrderDto zyOwnerOrderDto : dtoList ) {
            list.add( toEntity( zyOwnerOrderDto ) );
        }

        return list;
    }

    @Override
    public List<ZyOwnerOrderDto> toDto(List<ZyOwnerOrder> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ZyOwnerOrderDto> list = new ArrayList<ZyOwnerOrderDto>( entityList.size() );
        for ( ZyOwnerOrder zyOwnerOrder : entityList ) {
            list.add( toDto( zyOwnerOrder ) );
        }

        return list;
    }
}

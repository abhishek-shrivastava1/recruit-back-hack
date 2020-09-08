package com.bitsplease.recruit.utils;

import com.bitsplease.recruit.dto.IdentityDto;
import com.bitsplease.recruit.dto.TimeAuditDto;
import com.bitsplease.recruit.dto.UserAuditDto;
import com.bitsplease.recruit.model.Identity;
import com.bitsplease.recruit.model.TimeAudit;
import com.bitsplease.recruit.model.UserAudit;
import org.springframework.stereotype.Service;

@Service
public class ConverterUtils {
    
    /**
     * @param s   Any dto extending {@link IdentityDto}
     * @param <T> Any Document extending {@link Identity}
     * @param <S> Any dto extending {@link IdentityDto}
     * @return New Document after converting Dto
     * @throws NullPointerException if s is null
     */
    public <T extends Identity, S extends IdentityDto> T convertToIdentityEntityFromDto(S s) {
        T t = (T)new Identity();
        t.setId(s.getId());
        return t;
    }
    
    /**
     * @param s   Any Document extending {@link Identity}
     * @param <T> Any Dto extending {@link IdentityDto}
     * @param <S> Any Document extending {@link Identity}
     * @return New Dto after converting given Document
     * @throws NullPointerException if s is null
     */
    public <T extends IdentityDto, S extends Identity> T convertToIdentityDtoFromEntity(S s) {
        T t = (T)new IdentityDto();
        t.setId(s.getId());
        return t;
    }
    
    /**
     * @param s   Any dto extending {@link TimeAuditDto}
     * @param <T> Any Document extending {@link TimeAudit}
     * @param <S> Any dto extending {@link TimeAuditDto}
     * @return New Document after converting Dto
     * @throws NullPointerException if s is null
     */
    public <T extends TimeAuditDto, S extends TimeAudit> T convertToTimeAuditDtoFromEntity(S s) {
        T t = (T)new TimeAuditDto();
        t = convertToIdentityDtoFromEntity(s);
        t.setCreatedDate(s.getCreatedDate());
        t.setUpdatedDate(s.getUpdatedDate());
        return t;
    }
    
    /**
     * @param s   Any Document extending {@link TimeAudit}
     * @param <T> Any Dto extending {@link TimeAuditDto}
     * @param <S> Any Document extending {@link TimeAudit}
     * @return New Dto after converting given Document
     * @throws NullPointerException if s is null
     */
    public <T extends UserAuditDto, S extends UserAudit> T convertToUserAuditDtoFromEntity(S s) {
        T t = (T)new UserAuditDto();
        t = convertToTimeAuditDtoFromEntity(s);
        t.setCreatedBy(s.getCreatedBy());
        t.setUpdatedBy(s.getUpdatedBy());
        return t;
    }
    
   /* public <T extends TimeAudit, S extends TimeAuditDto> T convertToTimeAuditEntityFromDto(S s) {
        T t = (T)new TimeAudit();
        t = convertToIdentityEntityFromEntity(t);
        t.setCreatedDate(s.getCreatedDate());
        t.setUpdatedDate(s.getUpdatedDate());
        return t;
    }
    
    public <T extends TimeAudit, S extends TimeAudit> T convertToTimeAuditEntityFromEntity(S s) {
        T t = (T)new TimeAudit();
        t = convertToIdentityEntityFromEntity(t);
        t.setCreatedDate(s.getCreatedDate());
        t.setUpdatedDate(s.getUpdatedDate());
        return t;
    }
    
    public <T extends UserAudit, S extends UserAuditDto> T convertToUserAuditEntityFromDto(S s) {
        T t = (T)new UserAudit();
        t = convertToTimeAuditEntityFromEntity(t);
        t.setCreatedBy(s.getCreatedBy());
        t.setUpdatedBy(s.getUpdatedBy());
        return t;
    }
    
    public <T extends TimeAudit, S extends TimeAudit> T convertToUserAuditEntityFromEntity(S s) {
        T t = (T)new UserAudit();
        t = convertToIdentityEntityFromEntity(t);
        t.setCreatedDate(s.getCreatedDate());
        t.setUpdatedDate(s.getUpdatedDate());
        return t;
    }*/
    
}

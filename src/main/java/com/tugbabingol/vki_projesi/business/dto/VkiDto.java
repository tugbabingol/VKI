package com.tugbabingol.vki_projesi.business.dto;


import com.tugbabingol.vki_projesi.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
@Data
public class VkiDto extends AuditingAwareBaseDto implements Serializable {//vjdksçk

    public static final Long serialVersionUID = 1L;

    @NotEmpty(message = "Adınız boş olamaz")
    private String userName;

    @NotEmpty(message = "Kilonuz boş olamaz")
    private Float user_Weight;

    @NotEmpty(message = "Boyunuz boş olamaz")
    private Float user_Height;


}

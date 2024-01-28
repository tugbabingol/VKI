package com.tugbabingol.vki_projesi.business.dto;


//import com.tugbabingol.vki_projesi.audit.AuditingAwareBaseDto;
import com.tugbabingol.vki_projesi.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VkiDto extends AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    @NotEmpty(message = "Adınız boş olamaz")
    private String userName;

    @NotEmpty(message = "Kilonuz boş olamaz")
    private Float userWeight;

    @NotEmpty(message = "Boyunuz boş olamaz")
    private Float userHeight;


}

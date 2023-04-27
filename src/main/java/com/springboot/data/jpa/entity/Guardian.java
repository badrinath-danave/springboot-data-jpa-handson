package com.springboot.data.jpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
	@AttributeOverride(
			name="name",
			column= @Column( name="guardian_name")
			),
	@AttributeOverride(
			name="email",
			column= @Column( name="guardian_email")
			),
	@AttributeOverride(
			name="mobileNo",
			column= @Column( name="guardian_mobileNo")
			)
})
@Builder
public class Guardian {

	
//	private String guardianName;
//	private String guardianEmail;
//	private String guardianMobileNo;
	
	private String name;
	private String email;
	private String mobileNo;
}

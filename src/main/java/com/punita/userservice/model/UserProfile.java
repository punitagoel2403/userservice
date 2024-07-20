package com.punita.userservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

	@Id
	private String userId;
	private String userName;
	private String location;
	private String emailId;
	private Date createdOn;
}

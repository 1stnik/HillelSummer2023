package com.hillel.springboot.mongo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@ToString
public class User {

	@Id
	private String userId;
	private String name;
	private Date creationDate = new Date();
	private String phone;
	private String email;
}

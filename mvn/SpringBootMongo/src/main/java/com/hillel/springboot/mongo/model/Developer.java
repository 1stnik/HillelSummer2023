package com.hillel.springboot.mongo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@ToString
public class Developer {

	@Id
	private String developerId;
	private String name;
	private String phone;
}

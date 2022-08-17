package com.UserLog.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
	private String name;
	private String desc;
	private Double price;
	private String size;
	private String photo;

}

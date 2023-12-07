package com.project.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

	private Integer planId;
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String categoryName;
}

package com.project.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanData {

	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer categoryId;
	private String createdBy;
	private String activeSw;
	private String categoryName;
	private String updatedBy;
}

package com.meetingplannerproject.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemanderEnregistrer {
	private Date date;
	private int debut;
	private int fin;
	private int nbrRequis;
	private Long reunionId;
}

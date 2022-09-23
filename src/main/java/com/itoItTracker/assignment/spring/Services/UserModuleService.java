package com.itoItTracker.assignment.spring.Services;

import java.util.List;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentsDto;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.TicketDto1;

public interface UserModuleService {
	
	ApiResponse createTicket(TicketDto ticketDto,Integer userId);
	List<HelperPojoClass> viewTicketsByUserId(Integer userId);
	TicketDto1 viewTicketsByTicketId(Integer userId,Integer ticketId);
	ApiResponse commentOnTicket(CommentsDto commentsDto,Integer ticketId,Integer userId);

}

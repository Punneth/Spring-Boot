package com.itoItTracker.assignment.spring.Services;

import java.util.List;
import java.util.Optional;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.UserDto;
import com.itoItTracker.assignment.spring.entity.Comments;

public interface ItTeamService {
	
	ApiResponse createUser(UserDto userDto);
	List<HelperPojoClass> ViewTicketList();
	List<UserDto> viewAllUsers();
	ApiResponse deleteUser(Integer userId);
	ApiResponse updateUser(UserDto userDto,Integer userId);
	List<Comments> viewTicketByTicketId(Integer ticketId);
	ApiResponse setAssignee(TicketDto ticketDto,Integer userId);
	String changeTheStatus(Integer ticketId,Integer statusId,Integer assigneeId);
	String changeThePriority(Integer ticketId,Integer priorityId,Integer adminID);
	String deleteTicket(Integer ticketId,Integer userId);
	UserDto viewUser(Optional<Integer> userId, Optional<String> emailId);

}

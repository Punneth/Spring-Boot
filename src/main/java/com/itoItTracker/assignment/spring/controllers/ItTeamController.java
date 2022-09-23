package com.itoItTracker.assignment.spring.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.UserDto;
import com.itoItTracker.assignment.spring.Services.ItTeamService;
import com.itoItTracker.assignment.spring.entity.Comments;

@RestController
@RequestMapping("/api/team")
public class ItTeamController {
	
	@Autowired
	private ItTeamService itTeamService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody UserDto userDto) {
		
		ApiResponse createdUser = this.itTeamService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<UserDto>> viewAllUsers() {
		
		return ResponseEntity.ok(this.itTeamService.viewAllUsers());
	}
	
	@GetMapping("/viewUser/")
	public ResponseEntity<UserDto> viewUser(@RequestParam ("userId") Optional<Integer> userId,@RequestParam Optional<String> emailId){
	
		UserDto userById = this.itTeamService.viewUser(userId,emailId);	
		return ResponseEntity.ok(userById);
	}
	
	@DeleteMapping("/deleteUser/")
	public ResponseEntity<ApiResponse> deleteUser(@RequestParam Integer userId) {
		
		ApiResponse apiResponse = this.itTeamService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody UserDto userDto,@RequestParam Integer userId){
		
		ApiResponse apiResponse = this.itTeamService.updateUser(userDto,userId);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
	
	@GetMapping("/ticketsList/")
	public ResponseEntity<List<HelperPojoClass>> ViewTicketList() {
		
		List<HelperPojoClass> tickets = itTeamService.ViewTicketList();
		return new ResponseEntity<List<HelperPojoClass>>(tickets,HttpStatus.OK);
	}
	
	@GetMapping("/ticket/")
	public ResponseEntity<List<Comments>> viewTicketByTicketId(@RequestParam Integer ticketId){
		
		List<Comments> comments = this.itTeamService.viewTicketByTicketId(ticketId);
		return new ResponseEntity<List<Comments>>(comments,HttpStatus.OK);
	}
	
	@PutMapping("/assignee")
	public ResponseEntity<ApiResponse> setAssignee(@RequestBody TicketDto ticketDto,@RequestParam Integer userId) {
		
		ApiResponse apiResponse = this.itTeamService.setAssignee(ticketDto, userId);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
	}

	@PutMapping("/status/")
	public ResponseEntity<String> changeTheStatus(@RequestParam Integer ticketId,@RequestParam Integer statusId,@RequestParam Integer assigneeId) {
		
		String message = this.itTeamService.changeTheStatus(ticketId, statusId, assigneeId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@PutMapping("/priority/")
	public ResponseEntity<String> changeThePriority(@RequestParam Integer ticketId, @RequestParam Integer priorityId, @RequestParam Integer assigneeId) {
		
		String message = this.itTeamService.changeThePriority(ticketId, priorityId, assigneeId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteTicket(@RequestParam Integer ticketId,@RequestParam Integer userId) {
		
		String message = itTeamService.deleteTicket(ticketId, userId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	

}

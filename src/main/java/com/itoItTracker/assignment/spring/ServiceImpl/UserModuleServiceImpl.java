package com.itoItTracker.assignment.spring.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentsDto;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.TicketDto1;
import com.itoItTracker.assignment.spring.Services.UserModuleService;
import com.itoItTracker.assignment.spring.entity.AdminTeam;
import com.itoItTracker.assignment.spring.entity.Category;
import com.itoItTracker.assignment.spring.entity.Comments;
import com.itoItTracker.assignment.spring.entity.Priority;
import com.itoItTracker.assignment.spring.entity.Status;
import com.itoItTracker.assignment.spring.entity.SubCategory;
import com.itoItTracker.assignment.spring.entity.Ticket;
import com.itoItTracker.assignment.spring.entity.User;
import com.itoItTracker.assignment.spring.exceptions.ResourceNotFoundException;
import com.itoItTracker.assignment.spring.repositories.AdminTeamRepo;
import com.itoItTracker.assignment.spring.repositories.CategoryRepo;
import com.itoItTracker.assignment.spring.repositories.CommentsRepo;
import com.itoItTracker.assignment.spring.repositories.PriorityRepo;
import com.itoItTracker.assignment.spring.repositories.StatusRepo;
import com.itoItTracker.assignment.spring.repositories.SubCategoryRepo;
import com.itoItTracker.assignment.spring.repositories.TicketRepo;
import com.itoItTracker.assignment.spring.repositories.UserRepo;

@Service
public class UserModuleServiceImpl implements UserModuleService {

	@Autowired
	private TicketDto1 ticketDto1;
	
	@Autowired
	private AdminTeamRepo adminTeamRepo;
	
	@Autowired
	private StatusRepo statusRepo;
	
	@Autowired
	private PriorityRepo priorityRepo;
	
	@Autowired
	private HelperPojoClass helperPojoClass;
	
	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TicketRepo ticketRepo;
		
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	SimpleDateFormat formateDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");
	Date date = new Date();

	@Override
	public ApiResponse createTicket(TicketDto ticketDto, Integer userId) {
		
		Ticket ticket = this.modelMapper.map(ticketDto, Ticket.class);
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		categoryRepo.findById(ticket.getCategoryId()).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id",ticket.getCategoryId()));
		SubCategory subCategory = subCategoryRepo.findById(ticket.getSubCategoryId()).orElseThrow(()->new ResourceNotFoundException("SubCategory", "SubCategory Id",ticket.getSubCategoryId()));
		int categoryId = subCategory.getCategoryId();
		String message =  null;
		
		if (categoryId==ticketDto.getCategoryId()) {
			
			Date date = new Date();
			String nwDate = formateDate.format(date);
			ticket.setReportedId(userId);
			ticket.setStatusId(1);
			ticket.setCategoryId(ticket.getCategoryId());
			ticket.setSubCategoryId(ticket.getSubCategoryId());
			ticket.setDescription(ticketDto.getDescription());
			ticket.setLastModifiedDateTime(nwDate);
			ticket.setCreateDateTime(nwDate);
					
			if (ticketDto.getPriorityId()!=null) {
				
				ticket.setPriorityId(ticketDto.getPriorityId());
			}else {
				
				ticket.setPriorityId(null);
			}
			
			this.ticketRepo.save(ticket);
			message =  "Ticket id "+ticket.getTicketId()+" Created Successfully. localhost:8080/api/user/viewTicketsByTicketId/?userId="+userId+"&ticketId="+ticket.getTicketId();
		}
		
		else {
			
			message="CategoryId and SubCategoryId mismatched";
		}
		return new ApiResponse(message);
	}
	
	@Override
	public List<HelperPojoClass> viewTicketsByUserId(Integer userId) {
		
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		List<Ticket> tickets = ticketRepo.findAll();
		List<HelperPojoClass> ticket2 = new ArrayList<>();
		
		for (Ticket ticket : tickets) {
			
			if(ticket.getReportedId()==userId) {
				
				helperPojoClass = new HelperPojoClass();
				Category categoryid = categoryRepo.getById(ticket.getCategoryId());
				helperPojoClass.setCategory(categoryid.getCategoryDesc());
				SubCategory subCategoryid = subCategoryRepo.getById(ticket.getSubCategoryId());
				helperPojoClass.setSubCategory(subCategoryid.getSubCategoryDesc());
				
				try {
					Priority priorityid = priorityRepo.getById(ticket.getPriorityId());
					helperPojoClass.setPriority(priorityid.getPriority());
					
				}catch(Exception ex) {
					
					helperPojoClass.setPriority(null);
				}
				
				Status status = statusRepo.getById(ticket.getStatusId());
				helperPojoClass.setStatus(status.getStatus());
				
				try {
					
					AdminTeam adminName = adminTeamRepo.getById(ticket.getAssigneeId());
					helperPojoClass.setAssignee(adminName.getName());
				}catch(Exception ex) {
					helperPojoClass.setAssignee(null);
				}
				
				helperPojoClass.setTicketId(ticket.getTicketId());
				helperPojoClass.setSubject(ticket.getSubject());
				String message = "localhost:8080/api/user/viewTicketsByTicketId/?userId="+userId+"&ticketId="+ticket.getTicketId();
				helperPojoClass.setUrl(message);
				ticket2.add(helperPojoClass);
			}
		}	
		return ticket2;
		
	}

	
	@Override
	public TicketDto1 viewTicketsByTicketId(Integer userId, Integer ticketId) {
		
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Ticket", "ticket Id", ticketId));
		
		if(ticket.getTicketId() ==ticketId && ticket.getReportedId()==userId) {
			
			ticketDto1.setAssigneeId(ticket.getAssigneeId());
			ticketDto1.setCreateDateTime(ticket.getCreateDateTime());
			ticketDto1.setDescription(ticket.getDescription());
			ticketDto1.setLastModifiedDateTime(ticket.getLastModifiedDateTime());
			ticketDto1.setReportedId(ticket.getReportedId());
			ticketDto1.setSubject(ticket.getSubject());
			ticketDto1.setTicketId(ticket.getTicketId());
			Category category = categoryRepo.getById(ticket.getCategoryId());
			ticketDto1.setCategoryId(category.getCategoryDesc());
			SubCategory subCategory = subCategoryRepo.getById(ticket.getSubCategoryId());
			ticketDto1.setSubCategoryId(subCategory.getSubCategoryDesc());
			Status status = statusRepo.getById(ticket.getStatusId());
			ticketDto1.setStatusId(status.getStatus());
			
			try {
				
				Priority priority = priorityRepo.getById(ticket.getPriorityId());
				ticketDto1.setPriorityId(priority.getPriority());
				
			}catch(Exception ex) {
				
			}
			
			TicketDto1 ticketDto1 = modelMapper.map(ticket, TicketDto1.class);
			
		}else {
			
			throw new ResourceNotFoundException("User id and ticket id does not match");
		}
		return ticketDto1;
	}

	
	@Override
	public ApiResponse commentOnTicket(CommentsDto commentsDto, Integer ticketId, Integer userId) {
		
		Comments comments = new Comments();
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user id", userId));
		Ticket ticket = this.ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Ticket", "ticket id", ticketId));
		
		comments.setTicketId(ticket.getTicketId());
		comments.setUserId(user.getUserId());
		comments.setTicket(ticket);
		comments.setUser(user);
		comments.setMessage(commentsDto.getMessage());
		commentsRepo.save(comments);
		String message = "Successfully added comment on "+ticketId;
		return new ApiResponse(message);
	}

}

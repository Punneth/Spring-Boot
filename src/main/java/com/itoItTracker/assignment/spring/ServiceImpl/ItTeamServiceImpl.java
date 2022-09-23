package com.itoItTracker.assignment.spring.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itoItTracker.assignment.spring.Dto.ApiResponse;
import com.itoItTracker.assignment.spring.Dto.CommentHelperClass;
import com.itoItTracker.assignment.spring.Dto.CommentsDtoClass;
import com.itoItTracker.assignment.spring.Dto.HelperPojoClass;
import com.itoItTracker.assignment.spring.Dto.TicketDto;
import com.itoItTracker.assignment.spring.Dto.UserDto;
import com.itoItTracker.assignment.spring.Services.ItTeamService;
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
public class ItTeamServiceImpl implements ItTeamService {
	
	@Autowired
	private CommentsDtoClass commentsDtoClass;
	
	@Autowired
	private CommentHelperClass commentHelperClass;
	
	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PriorityRepo priorityRepo;
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
	private StatusRepo statusRepo;
	
	@Autowired
	private AdminTeamRepo adminTeamRepo;
		
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	private SimpleDateFormat formateDate = new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");
	
	public static boolean isStringOnlyAlphabet(String name) {
		
		return ((name != null) && (!name.startsWith(" ")) && (name.matches("^[ a-zA-Z]*$"))&&(name.length()>=3));
	}

	public boolean isEmail(String email) {
		
		User user =null;
		String newEmail = null;
		
		try {
			
			user =userRepo.findByEmailId(email);
			newEmail = user.getEmailId();			
		} catch (Exception ex) {
			
			return false;
		}
		return true;
	}
	
	public boolean regexEmail(String email) {
		
		String regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-zA-Z]{4,10}+[\\.][a-zA-Z]{2,3}";
		Pattern pattern = Pattern.compile(regexp);
		 Matcher matcher = pattern.matcher(email); 
		 
		if (matcher.matches()) {
			
			return true;
		}
		return false;
	}
	
	@Override
	public ApiResponse createUser(UserDto userDto) {
		
		String message = null;
		if (isStringOnlyAlphabet(userDto.getName())) {
			
			try {
				
				if (regexEmail(userDto.getEmailId())) {
					if (!isEmail(userDto.getEmailId())) {
						
						Date date = new Date();
						String newDate = formateDate.format(date);
						User user = this.modelMapper.map(userDto, User.class);
						user.setCreateDateTime(newDate);
						user.setLastModifiedDateTime(newDate);
						User saveUser = this.userRepo.save(user);
						message = "User with "+userDto.getEmailId() + " created successfully localhost:8080/api/team/viewUser/?userId="+saveUser.getUserId();
						
					}else {
						
						message=userDto.getEmailId()+ " already exists. Please try with a new Email ID";
					}
					
				}else {
					
					message= "Invalid Email id";
				}
				
			}catch(NullPointerException ex) {
				return new ApiResponse("Please enter a email id");
		}
			
		}else {
			
			message = "Enter a valid user name";
		}
		
		return (new ApiResponse(message));
	}
		
	@Override
	public UserDto viewUser(Optional<Integer> userId, Optional<String> emailId) {
		
		UserDto userDto = new UserDto();
		String newEmailId = null;
		Integer newUserId =null;
		
		try {
			
			newUserId = Integer.valueOf(userId.get());
		}catch(Exception ex) {
			
		}
		
		try {
			
			newEmailId = String.valueOf(emailId.get());
			
		}catch(Exception ex) {
			newEmailId=null;
		}
		
		if (newUserId!=null && newEmailId!=null) {
			
			int variable = newUserId;
			String email1 = newEmailId;
			User user = this.userRepo.findById(variable).orElseThrow(()->new ResourceNotFoundException("No user found"));
			String emailId2 = user.getEmailId();
			
			if (emailId2.equals(email1)) {
				
				userDto = this.modelMapper.map(user, UserDto.class);
			}else {
				
				throw new ResourceNotFoundException("UserId and EmailId mismatched");
			}
		}
		
		else if (newUserId!=null && newEmailId==null ) {
				
				int variable = newUserId;
				User user = this.userRepo.findById(variable).orElseThrow(()->new ResourceNotFoundException("No user found"));
				userDto = this.modelMapper.map(user, UserDto.class);
			}
			else {
				
				Integer id = null;
				id = userRepo.findIdByEmail(newEmailId);
				User user = null;
				Integer variable = id;
				
				try {
					
					Optional<User> optionalUser = userRepo.findById(variable);
					user = optionalUser.get();
					
				}catch(Exception ex) {
					throw new ResourceNotFoundException("No user found");
				}
				
				userDto = this.modelMapper.map(user, UserDto.class);
			}
		
		return userDto;
	}
	
	@Override
	public List<UserDto> viewAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user ->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}
	
	@Override
	public ApiResponse updateUser(UserDto userDto,Integer userId) {
		
		Date date = new Date();
		String nwDate = formateDate.format(date);
		String message=null;
		
		if (isStringOnlyAlphabet(userDto.getName())) {
			
			User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
			user.setName(userDto.getName());
			user.setLastModifiedDateTime(nwDate);
			this.userRepo.save(user);	
			message = "User with "+ userId +" Updated successfully";
			
		}else {
			
			return new ApiResponse("Enter a valid User Name");
		}
		
		return new ApiResponse(message);
	}

	
	@Override
	public ApiResponse deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		List<Ticket> tickets = this.ticketRepo.findAllByReportedId(userId);
		this.userRepo.delete(user);
		
		try {
			ticketRepo.deleteAll(tickets);
		}catch(Exception ex) {
			System.out.println("Null value");
		}
		
		String message = "User with "+ userId +" deleted successfully";
		return new ApiResponse(message);
		
	}
	
	@Override
	public List<HelperPojoClass> ViewTicketList() {
		
		List<Ticket> tickets = ticketRepo.findAll();
		List<HelperPojoClass> ticket2=new ArrayList<>();
		
		if (tickets.isEmpty()) {
			throw new ResourceNotFoundException("No data Found");
			
		}else {
			
			for (Ticket ticket : tickets) {
				
				HelperPojoClass helperPojoClass = new HelperPojoClass();
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
				System.out.println(status.getStatus());
				helperPojoClass.setStatus(status.getStatus());
				
				try {
					
					AdminTeam adminName = adminTeamRepo.getById(ticket.getAssigneeId());
					helperPojoClass.setAssignee(adminName.getName());
					
				}catch(Exception ex) {
					helperPojoClass.setAssignee(null);
				}
				
				helperPojoClass.setTicketId(ticket.getTicketId());
				helperPojoClass.setSubject(ticket.getSubject());
				helperPojoClass.setSubject(ticket.getSubject());
				String message = "localhost:8080/api/user/viewTicketsByTicketId/?userId="+ticket.getReportedId()+"&ticketId="+ticket.getTicketId();
				helperPojoClass.setUrl(message);
				ticket2.add(helperPojoClass);
			}
			
		}
		return ticket2;
	}

	
	@Override
	public List<Comments> viewTicketByTicketId(Integer ticketId) {
		
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket Id"));
		List<Comments> comments = commentsRepo.findByTicket(ticket);
		
		List result = new ArrayList<>();
		commentsDtoClass = new CommentsDtoClass();
		commentsDtoClass.setTicketId(ticket.getTicketId());
		Category category = categoryRepo.getById(ticket.getCategoryId());
		commentsDtoClass.setCategory(category.getCategoryDesc());
		SubCategory subcategory = this.subCategoryRepo.getById(ticket.getSubCategoryId());
		commentsDtoClass.setSubCategory(subcategory.getSubCategoryDesc());
		
		try {
			
			Priority priority = priorityRepo.getById(ticket.getPriorityId());
			commentsDtoClass.setPriority(priority.getPriority());
			
		}catch(Exception ex) {
			commentsDtoClass.setPriority(null);
		}
		
		commentsDtoClass.setSubject(ticket.getSubject());
		Status status= statusRepo.getById(ticket.getStatusId());
		commentsDtoClass.setStatus(status.getStatus());
		
		List array = new ArrayList();
		for (Comments comment : comments) {
				
				commentHelperClass = new CommentHelperClass();
				commentHelperClass.setComment(comment.getMessage());
				commentHelperClass.setUserId(comment.getUser().getUserId());
				array.add(commentHelperClass);
		}
		
		commentsDtoClass.setComments(array);
		result.add(commentsDtoClass);
		
		return result;
	}

	@Override
	public ApiResponse setAssignee(TicketDto ticketDto,Integer userId) {
		
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Incorrect User Id"));
		adminTeamRepo.findById(ticketDto.getAssigneeId()).orElseThrow(()->new ResourceNotFoundException("Invalid Admin Id"));
		Ticket ticket = ticketRepo.findById(ticketDto.getTicketId()).orElseThrow(()->new ResourceNotFoundException("Incorrect Ticket Id"));
		String message=null;
		
		if (ticket.getReportedId()==userId) {
			
			Ticket fetchedTicket = this.modelMapper.map(ticketDto, Ticket.class);
			ticket.setAssigneeId(fetchedTicket.getAssigneeId());
			Date date = new Date();
			String nwDate = formateDate.format(date);
			ticket.setLastModifiedDateTime(nwDate);
			ticketRepo.save(ticket);
			message="Assignee set successfully";
			
		}else {
			message="Ticket id and user id mismatched";
		}
		
		return new ApiResponse(message);
	}

		
	@Override
	public String changeTheStatus(Integer ticketId,Integer statusId,Integer assigneeId) {
		
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket id"));
		String oldStatus=statusRepo.getById(ticket.getStatusId()).getStatus();
		adminTeamRepo.findById(assigneeId).orElseThrow(()->new ResourceNotFoundException("Invalid Admin id"));
		Status status = statusRepo.findById(statusId).orElseThrow(()->new ResourceNotFoundException("Invalid Status id"));
		String message = null;
		
		if (ticket.getStatusId()!=4) {
			
			String newStatus = status.getStatus();
			ticket.setStatusId(statusId);
			Date date = new Date();
			String nwDate = formateDate.format(date);
			ticket.setLastModifiedDateTime(nwDate);
			ticketRepo.save(ticket);
			message = "Status Changed from"+" "+oldStatus+" to "+newStatus;
			
		}else {
			
			message="Status is already Completed you can not change the status";
		}
		return message;
	}

	
	@Override
	public String changeThePriority(Integer ticketId,Integer priorityId,Integer assigneeId ) {
		
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket id"));
		String oldPriority = null;
		try {
			
			oldPriority = priorityRepo.getById(ticket.getPriorityId()).getPriority();
			
		}catch(Exception ex) {
			
		}
		
		adminTeamRepo.findById(assigneeId).orElseThrow(()->new ResourceNotFoundException("Invalid Admin id"));
		Priority priority = priorityRepo.findById(priorityId).orElseThrow(()->new ResourceNotFoundException("Invalid Priority id"));
		String newPriority = priority.getPriority();
		String message = null;
		
		if (ticket.getStatusId()==1) {
			
			ticket.setPriorityId(priorityId);
			Date date = new Date();
			String nwDate = formateDate.format(date);
			ticket.setLastModifiedDateTime(nwDate);
			message = "Priority Changed from"+" "+oldPriority+" to " + newPriority;
			ticketRepo.save(ticket);
			
		}	else {
			message="You can not able to change the Priority";
		}
		
		return message;
	}

	@Override
	public String deleteTicket(Integer ticketId, Integer userId) {
		
		Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("Invalid Ticket id"));
		userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid User Id"));
		String message = null;
		 SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy hh:mm aa");
		 Date date=null;
		 try {
			date=formatter.parse(ticket.getLastModifiedDateTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		 long newLastModifiedDateTime = date.getTime();
		 System.out.println(new Date(newLastModifiedDateTime));
		if (ticket.getTicketId()==ticketId && ticket.getReportedId()==userId) {
			if(ticket.getStatusId()==4) {
				
				if(System.currentTimeMillis()-newLastModifiedDateTime>=604800000) {
					ticketRepo.delete(ticket);
					message = "Ticket deleted Successfully";

				}else {
					message="Could not able to delete, LastModifiedDateTime is less than 7 days";
				}
			}else {
				message="Ticket status is not completed yet";
			}
						
		}else {
			message = "Ticket id and user id mismatched";
		}
		
		return message;
	}

}


package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.entity.Plan;
import in.ashokit.properties.AppProperties;
import in.ashokit.service.PlanService;
@RestController
public class PlanController {
	
	
	private PlanService planService;
	
	private AppProperties appProps;
	
	private Map<String,String>messages;
	
	
	
	public PlanController(PlanService planService, AppProperties appProps) {
		
		this.planService = planService;
		this.appProps = appProps;
		this.messages = appProps.getMessages();
	}
	
	
	
	
//	public PlanController(PlanService planService, AppProperties appProps) {
//		super();
//		this.planService = planService;
//		this.appProps = appProps;
//	}

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>>planCategories(){
		
		Map<Integer, String> Categories = planService.getPlanCategories();   
		
return new ResponseEntity<>(Categories , HttpStatus.OK);
//				return new ResponseEntity<>(Categories, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/Plan")
	public ResponseEntity<String>savePlan(@RequestBody Plan plan){
		
		String responsemsg = "";
		
		           
boolean isSaved = planService.savePlan(plan);
		
//		return new ResponseEntity<>(savePlan , HttpStatus.OK);
Map<String,String>messages = appProps.getMessages();
		
		if(isSaved) {
			
			
			responsemsg 	 = messages.get("PlanSaveSucc");
			
//			responsemsg = "Plan Saved";
			
		}else {
			responsemsg =  messages.get("PlanSaveFail");
			
		}
		
		return new ResponseEntity<>(responsemsg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		
		
		List<Plan> allPlans = planService.getAllPlans();
		
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
				
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan (@PathVariable Integer planId){
		
  Plan planById = planService.getPlanById(planId);
  
  return new  ResponseEntity<Plan>(planById , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> DeletePlan (@PathVariable Integer planId){
		
  boolean isDeleted = planService.deletePlanById(planId);
  
  Map<String, String>messages= appProps.getMessages();

  
//  return new  ResponseEntity<Plan>( deletePlanById , HttpStatus.OK);
  
  String msg = "";
  if(isDeleted) {
	  
	  msg = messages.get("planDeleteSucc");
	  
//	  msg = "Plan Deleted";
  }
  
  else {
//	  msg = "Plan not deleted";
	  msg = messages.get("planDeleteFail");

  }
	
  return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
//	@GetMapping("/plan/{planId}")
//	public ResponseEntity<Plan>editplan(@PathVariable Integer planId){
//		               
//		
//		       Plan plan = planService.getPlanById(planId);
//		       
//		       return new ResponseEntity<>(plan , HttpStatus.OK);
//		
//	}
//	
	
	@PutMapping("/plan")
	public ResponseEntity<String>updatePlan(@RequestBody Plan plan){
		        
		             boolean Isupdated = planService.updatePlan(plan);
		             Map<String, String>messages= appProps.getMessages();
		             
		             
		             
              String msg = "";
		             if(Isupdated) {
		            	 
		            	 msg = messages.get("planUpdateSucc");
		            	 
//		            	msg= "Plan is updated successfully" ;
		             }else {
//		            	 msg= "Plan is not updated successfully" ;
		            	 
		            	 msg = messages.get("PlanUpdatefail");
		             }
		             
		      return new ResponseEntity<>(msg , HttpStatus.OK);
		
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String>statusChange( @PathVariable Integer planId , @PathVariable String status){
		boolean planStatusChange = planService.planStatusChange(planId, status);
        Map<String, String>messages= appProps.getMessages();

		String msg = "";
		if(planStatusChange) {
//			msg = "status is changes successfully ";
			msg = messages.get("planStatusChange");
		}
		else {
//			msg = "status is not changes sucessfully";
			msg = messages.get("planStatusChangefail");

		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
//	@DeleteMapping("/plan/{planId}")
//	public ResponseEntity<String>Deleteplan(@PathVariable Integer planId){
//		               
//		
//		         boolean deletePlanById = planService.deletePlanById(planId);
//		         
//		         String msg = "";
//		         
//		         if(deletePlanById) {
//		        	 msg = "Plan Deleted";
//		         }
//		         else {
//		        	 msg = "Plan not Deleted";
//		         }
//		       
//		       return new ResponseEntity<>(msg, HttpStatus.OK);
//		
//	}
	
}

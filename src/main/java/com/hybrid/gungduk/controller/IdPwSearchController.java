package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.IdPwSearchDao;

@CrossOrigin(origins = "*")
@Controller
public class IdPwSearchController {

	@Autowired
	IdPwSearchDao idPwSearchDao;
	
	@RequestMapping(value = "/api/v1/searchId", method = RequestMethod.POST)
	public @ResponseBody String searchId(@RequestParam String phoneNum)throws NullPointerException{
		String phone = idPwSearchDao.searchId(phoneNum);
		try{
			if(phone.length() == 0){
				System.out.println("error");
				return "error";
			}else{
				return phone;
			}
		}catch(NullPointerException e){
			return "error";
		}
	}
	
	@RequestMapping(value = "/api/v1/searchPw", method = RequestMethod.POST)
	public @ResponseBody String searchPw(@RequestParam String id) throws NullPointerException{
		String iid = idPwSearchDao.searchPw(id);
		try{
			if(iid.length() == 0){
				System.out.println("error");
				return "error";
			}else{
				return iid;
			}
		}catch(NullPointerException e){
			return "error";
		}
	}
}

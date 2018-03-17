package com.hybrid.gungduk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.gungduk.dao.ModifyDao;
import com.hybrid.gungduk.dto.UserDto;

@CrossOrigin(origins = "*")
@Controller
public class ModifyController {

	@Autowired
	ModifyDao modifyDao;
	
	@RequestMapping(value = "/api/v1/modifyInfo", method = RequestMethod.POST)
	public @ResponseBody List<UserDto> modifyInfo(@RequestParam String id){
		return modifyDao.info(id);
	}
	
	@RequestMapping(value = "/api/v1/updateInfo", method = RequestMethod.POST)
	public @ResponseBody void updateInfo(@RequestParam String id, String pw, String phoneNum){
		modifyDao.updateInfo(id, pw, phoneNum);
	}
}

package com.inc.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/user/list")
	public String userList(Model model) {
		List<UserVo> userList = userDao.userList();
		model.addAttribute("userList", userList);
		return "user/list";
	}
}

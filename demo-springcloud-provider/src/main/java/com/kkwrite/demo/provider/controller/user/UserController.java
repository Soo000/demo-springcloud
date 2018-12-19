package com.kkwrite.demo.provider.controller.user;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkwrite.demo.provider.entity.user.User;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@GetMapping("/queryuserbyid")
	public User queryUserById(Integer userId, String username) {
		User user = new User(userId, username);
		user.setCreationTime(Calendar.getInstance().getTime());
		return user;
	}
	
	@GetMapping("/queryuserbyid2")
	public User queryUserById2(Integer userId, String username) {
		User user = new User(userId, username);
		user.setCreationTime(Calendar.getInstance().getTime());
		// 模拟业务处理需要3秒
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}

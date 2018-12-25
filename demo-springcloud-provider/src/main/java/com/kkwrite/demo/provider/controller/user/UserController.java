package com.kkwrite.demo.provider.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkwrite.demo.provider.dto.OutDTO;
import com.kkwrite.demo.provider.dto.user.UserDTO;
import com.kkwrite.demo.provider.exception.ServiceException;
import com.kkwrite.demo.provider.service.user.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserById/{userId}")
	public OutDTO getUserById(@PathVariable Long userId) {
		OutDTO outDTO = new OutDTO();
		try {
			UserDTO userDTO = userService.getUserById(userId);
			outDTO.setData(userDTO);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return outDTO;
	}
	
}

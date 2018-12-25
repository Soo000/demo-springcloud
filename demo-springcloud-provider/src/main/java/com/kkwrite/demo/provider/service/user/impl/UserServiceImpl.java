package com.kkwrite.demo.provider.service.user.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkwrite.demo.provider.dto.user.UserDTO;
import com.kkwrite.demo.provider.exception.ServiceException;
import com.kkwrite.demo.provider.pojo.UserDO;
import com.kkwrite.demo.provider.repository.UserRepository;
import com.kkwrite.demo.provider.service.user.UserService;

/** 
 * 用户服务接口实现
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:09:28 
 * @version 1.0.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO getUserById(Long userId) throws ServiceException {
		UserDTO userDTO = null;
		try {
			UserDO userDO = userRepository.findByUserId(userId);
			userDTO = new UserDTO();
			BeanUtils.copyProperties(userDO, userDTO);
		} catch (Exception e) {
			throw e;
		}
		return userDTO;
	}

	@Override
	public Integer getUserCount() throws ServiceException {
		try {
			return userRepository.getUserCount();
		} catch (Exception e) {
			throw e;
		}
	}

}

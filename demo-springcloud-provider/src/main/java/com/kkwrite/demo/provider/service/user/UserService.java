package com.kkwrite.demo.provider.service.user;

import com.kkwrite.demo.provider.dto.user.UserDTO;
import com.kkwrite.demo.provider.exception.ServiceException;

/** 
 * 用户服务接口
 *
 * @author Soosky Wang
 * @date 2018年12月25日 下午10:08:56 
 * @version 1.0.0
 */
public interface UserService {

	UserDTO getUserById(Long userId) throws ServiceException;
	
	Integer getUserCount() throws ServiceException;
	
}

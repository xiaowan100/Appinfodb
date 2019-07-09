package cn.appsys.service.deve;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

public interface UserService {
	public DevUser Login(String id,String pwd);
}

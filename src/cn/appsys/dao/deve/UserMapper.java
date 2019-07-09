package cn.appsys.dao.deve;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

public interface UserMapper {
	public DevUser Login(@Param("devCode") String id,@Param("devPassword") String pwd);
}

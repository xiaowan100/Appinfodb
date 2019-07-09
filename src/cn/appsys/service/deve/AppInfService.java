package cn.appsys.service.deve;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppInfService {
	/**
	 * 查询用户分页列表信息
	 * @param appInfo
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<AppInfo> queryUserListPage(
			AppInfo appInfo,
			@Param("from") Integer from,
			@Param("pageSize") Integer pageSize);

	int queryTotalCount(@Param("softwareName") String softwareName,@Param("status") Integer status,
			@Param("flatformName")  Integer flatformName,@Param("queryCategoryLevel1") Integer queryCategoryLevel1,
			@Param("queryCategoryLevel2") Integer queryCategoryLevel2,@Param("queryCategoryLevel3") Integer queryCategoryLevel3);
}

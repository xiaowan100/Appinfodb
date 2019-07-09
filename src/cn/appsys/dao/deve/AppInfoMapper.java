package cn.appsys.dao.deve;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;

public interface AppInfoMapper {
	/**
	 * 查询用户分页列表信息
	 * @param appInfo
	 * @param from
	 * @param pageSize
	 * @return
	 */
	List<AppInfo> queryUserListPage(
			@Param("appinfo")AppInfo appInfo,
			@Param("from") Integer from,
			@Param("pageSize") Integer pageSize);
	
	int queryTotalCount(@Param("softwareName") String softwareName,@Param("status") Integer status,
			@Param("flatformName")  Integer flatformName,@Param("categoryLevel1Name") Integer queryCategoryLevel1,
			@Param("categoryLevel2Name") Integer queryCategoryLevel2,@Param("categoryLevel3Name") Integer queryCategoryLevel3);
	
	List<DataDictionary> DictionaryAll();
	
	List<AppCategory> CategoryAll();
	
	List<AppVersion> VersionAll();

}

package cn.appsys.service.deve.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.deve.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.service.deve.AppInfService;

@Service("appInfService")
public class AppInfServiceImpl implements AppInfService{

	@Resource
	public AppInfoMapper appInfoMapper;
	
	@Override
	public List<AppInfo> queryUserListPage(AppInfo appInfo, Integer from,
			Integer pageSize) {
		return appInfoMapper.queryUserListPage(appInfo,from,pageSize);
	}

	@Override
	public int queryTotalCount(String softwareName, Integer status,
			Integer flatformName, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3) {
		return appInfoMapper.queryTotalCount(softwareName, status, flatformName, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
	}
}

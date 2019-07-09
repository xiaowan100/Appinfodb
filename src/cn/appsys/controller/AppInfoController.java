package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.page;
import cn.appsys.service.deve.AppInfService;

@Controller
@RequestMapping("/appInfo")
public class AppInfoController {

	@Resource
	public AppInfService appInfService;

	@RequestMapping("/APPlist")
	public String list(
			@RequestParam(value = "softwareName",required = false) String softwareName,
			@RequestParam(value = "status",required = false) Integer status,
			@RequestParam(value = "flatformName",required = false) Integer flatformName,
			@RequestParam(value = "categoryLevel1Name",required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "categoryLevel2Name",required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "categoryLevel3Name",required = false) Integer queryCategoryLevel3,
			@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
			Model model) {
		int totalCount = appInfService.queryTotalCount(softwareName, status,
				flatformName, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3);
		page page = new page();
		page.setCurrPageNo(pageIndex);
		page.setPageSize(5);
		page.setTotalCount(totalCount);
		int startPos = (page.getCurrPageNo() - 1) * page.getPageSize();
		AppInfo appInfo = null;
		if(softwareName != null){
			appInfo = new AppInfo(softwareName, status, queryCategoryLevel3, flatformName, queryCategoryLevel1, queryCategoryLevel2);
		}
		
		List<AppInfo> list = appInfService.queryUserListPage(appInfo, startPos, page.getPageSize());
		model.addAttribute("pages", page);
		model.addAttribute("appInfoList", list);
		return "developer/appinfolist";
	}
}

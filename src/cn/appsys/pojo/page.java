package cn.appsys.pojo;

/**
 * 鍒嗛〉鎵�闇�瑕佺殑瀹炰綋绫�
 * @author Administrator
 *
 */
public class page {
	private Integer currPageNo; // 褰撳墠椤电爜 curr鏄痗urrent鍗曡瘝鐨勭畝鍐欙紝褰撳墠鐨勬剰鎬�
	private Integer pageSize; // 姣忎竴椤垫樉绀虹殑鏁版嵁琛屾暟锛岄〉闈㈠ぇ灏�
	private Integer totalCount; // 鎬荤殑璁板綍鏁般��
	private Integer totalPageCount; // 鎬荤殑椤垫暟
	public Integer getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			//鏍规嵁鎬昏褰曟暟浠ュ強姣忛〉鏄剧ず鏁版嵁琛屾暟锛岃绠楁�荤殑椤垫暟锛屽锛氭�昏褰曟暟鏄�50锛屾瘡椤垫樉绀�5鏉¤褰曢棶锛岄〉鏁版槸澶氬皯
			this.totalPageCount = this.totalCount % this.pageSize == 0 
					? this.totalCount / this.pageSize 
					: this.totalCount / this.pageSize+1;
		}
		
	}
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	
	
}

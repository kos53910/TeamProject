package com.gt.s.common;

public abstract class CommonUtils {
	
	
	//파일 패쓰----------------------
	public static final String SP_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\spend";

	public static final String BU_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\business";

	public static final String RE_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\resignation";

	public static final String VA_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\vacation";

	public static final String DR_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\draft";

	public static final String GE_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\employee";
	
	public static final String CO_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\contract";
	
	public static final String PO_FILE_UPLOAD_PATH = "\\\\192.168.0.35\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\project";
	
	
	
	public static final String SP_IMG_UPLOAD_PATH = "C:\\Users\\kosmo\\Desktop\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\imgupload\\spend";
	public static final int SP_IMG_FILE_SIZE = 10*1024*1024;
	public static final String SP_EN_CODE = "UTF-8";
	
	public static final String BU_IMG_UPLOAD_PATH = "C:\\Users\\kosmo\\Desktop\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\imgupload\\spend";
	public static final int BU_IMG_FILE_SIZE = 10*1024*1024;
	public static final String BU_EN_CODE = "UTF-8";
	
	public static final String RE_IMG_UPLOAD_PATH = "C:\\00.KOSMO129\\30.web\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\resignation";
	public static final int RE_IMG_FILE_SIZE = 10*1024*1024;
	public static final String RE_EN_CODE = "UTF-8";
	
	public static final String VA_IMG_UPLOAD_PATH = "C:\\00.KOSMO129\\30.web\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\vacation";
	public static final int VA_IMG_FILE_SIZE = 10*1024*1024;
	public static final String VA_EN_CODE = "UTF-8";
	
	public static final String DR_IMG_UPLOAD_PATH = "C:\\00.KOSMO129\\30.web\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\vacation";
	public static final int DR_IMG_FILE_SIZE = 10*1024*1024;
	public static final String DR_EN_CODE = "UTF-8";
	
	public static final String GE_IMG_UPLOAD_PATH = "C:\\00.KOSMO129\\30.web\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\vacation";
	public static final int GE_IMG_FILE_SIZE = 10*1024*1024;
	public static final String GE_EN_CODE = "UTF-8";
	
	public static final String CO_IMG_UPLOAD_PATH = "C:\\Users\\kosmo\\Desktop\\Legacy\\el_project_legacy_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\final_goats\\fileupload\\contract";
	public static final int CO_IMG_FILE_SIZE = 10*1024*1024;
	public static final String CO_EN_CODE = "UTF-8";
	
	public static final int VACATION_PAGE_SIZE = 3;
	public static final int VACATION_GROUP_SIZE = 3;
	public static final int VACATION_CUR_PAGE = 1;
	public static final int VACATION_TOTAL_COUNT = 0;
	
	public static final String[] s = {"소모품", "복리후생", "교통비", "운반비", "보험료", "접대비", "도서비", "수수료"
			, "교육훈련비", "기타", "식비", "숙박비", "제경비"};
			
	public static final int ACCOUNT_PAGE_SIZE = 10;
	public static final int ACCOUNT_GROUP_SIZE = 10;
	public static final int ACCOUNT_CUR_PAGE = 1;
	public static final int ACCOUNT_TOTAL_COUNT = 0;
	
}

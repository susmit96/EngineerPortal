package com.sysenc.portal.view;

import java.util.ArrayList;
import java.util.List;

import com.sysenc.portal.model.EngineerInformation;

import lombok.Data;

@Data
public class EngineerInformationViewModel {

	/*ID*/
	private String engineerId;

	/*氏名*/
	private String name;

	/*住所*/
	private String address;

	/*メールアドレス*/
	private String email;

	/*電話番号*/
	private String phoneNumber;

	/*スキル*/
	private String skill;

	/*コメント*/
	private String comment;

	private String registerDate;

	/*スキルシートファイルアップロード*/
	private String fileUpload;

	List<EngineerInformation> engineerInfoList = new ArrayList<EngineerInformation>();

	private EngineerInformation engineerInfo;

}

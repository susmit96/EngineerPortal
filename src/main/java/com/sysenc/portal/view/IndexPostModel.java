package com.sysenc.portal.view;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class IndexPostModel {

	/*ID*/
	private String id;

	@NotBlank
	/*氏名*/
	private String name;

	/*性別*/
	private String gender;

	@NotBlank
	/*住所*/
	private String address;

	@NotBlank
	@Email
	/*メールアドレス*/
	private String email;

	@NotBlank
	/*電話番号*/
	private String phoneNumber;

	@NotBlank
	/*スキル*/
	private String skill;

	@NotBlank
	/*コメント*/
	private String comment;

	/*スキルシートファイルアップロード*/
	private String fileUpload;

}

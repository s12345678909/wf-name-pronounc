package com.wf.hackathon;

import io.swagger.annotations.ApiModel;

@ApiModel
public  enum Test {



	ENGLISH("ENGLISH"),
	HINDI("HINDI"),
	RUSSIAN("RUSSIAN"),
	CHINESE("CHINESE"),
	ARABIC("ARABIC"),
	SPANISH("SPANISH"),
	FRENCH("FRENCH");

	    private String str;

	    Test(String str){
	       this.str = str;
	    }


	
}

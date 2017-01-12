package com.de16b.vaiuu.myapplication.parser;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.de16b.vaiuu.myapplication.holder.AllCollectionList;
import com.de16b.vaiuu.myapplication.model.CollectionListModel;

public class CollectionListParser {
	private static String NAME="name";
	private static String MOBILE="mobile";
	private static String PHOTO="photo";
	private static String EMAIL="email";
	private static String FACEBOOK="facebook";
	private static String LINKDIN="Linkdin";
	private static String SKYPE="skype";
	private static String VIBER="viber";
	private static String TWITTER="twitter";





	public static boolean connect(Context con, String result)
			throws JSONException, IOException {

		AllCollectionList.removeArabicList();
		if (result.length() < 1) {
			return false;

		}

		final JSONArray mainJsonObject = new JSONArray(result);

//		final JSONObject banner = mainJsonObject.getJSONObject("banner");
//		final JSONArray banner_list = mainJsonObject.getJSONArray(result);

		CollectionListModel abbriListModel;
		for (int i = 0; i < mainJsonObject.length(); i++) {
			JSONObject banner_list_jsonObject = mainJsonObject.getJSONObject(i);

			abbriListModel = new CollectionListModel();
			AllCollectionList allArabicList = new AllCollectionList();
			abbriListModel.setName(banner_list_jsonObject.getString(NAME));
			abbriListModel.setEmail(banner_list_jsonObject.getString(EMAIL));

			abbriListModel.setFacebook(banner_list_jsonObject.getString(FACEBOOK));
			abbriListModel.setLinkdin(banner_list_jsonObject.getString(LINKDIN));
			abbriListModel.setMobile(banner_list_jsonObject.getString(MOBILE));
			abbriListModel.setPhoto(banner_list_jsonObject.getString(PHOTO));
			abbriListModel.setSkype(banner_list_jsonObject.getString(SKYPE));
			abbriListModel.setViber(banner_list_jsonObject.getString(VIBER));
			abbriListModel.setTwitter(banner_list_jsonObject.getString(TWITTER));



			
			allArabicList.setArabicList(abbriListModel);
			abbriListModel = null;
		}

		
		return true;
	}
}

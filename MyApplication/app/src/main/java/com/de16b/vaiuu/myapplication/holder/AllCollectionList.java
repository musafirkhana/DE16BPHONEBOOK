package com.de16b.vaiuu.myapplication.holder;

import java.util.Vector;

import com.de16b.vaiuu.myapplication.model.CollectionListModel;

public class AllCollectionList {

	public static Vector<CollectionListModel> arabicListModels = new Vector<CollectionListModel>();

	public static Vector<CollectionListModel> getAllArabicList() {
		return arabicListModels;
	}

	public static void setAllArabicList(Vector<CollectionListModel> arabicListModels) {
		AllCollectionList.arabicListModels = arabicListModels;
	}

	public static CollectionListModel getArabicList(int pos) {
		return arabicListModels.elementAt(pos);
	}

	public static void setArabicList(CollectionListModel arabicListModels) {
		AllCollectionList.arabicListModels.addElement(arabicListModels);
	}

	public static void removeArabicList() {
		AllCollectionList.arabicListModels.removeAllElements();
	}

}

package com.lida.test;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @Author lida
 * @Date 2021/11/21 0021 9:27
 */
public class StringToUserPeopertyEditor extends PropertyEditorSupport implements PropertyEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		user.setName(text);
		super.setValue(user);

		StringToUserPeopertyEditor stringToUserPeopertyEditor = new StringToUserPeopertyEditor();
		stringToUserPeopertyEditor.setAsText("4");
		User value = (User) stringToUserPeopertyEditor.getValue();
		System.out.println(value);
	}
}

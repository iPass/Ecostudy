package com.ecostudy.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CommonUtils {

	public static boolean isCEORole(int role) {
		return (Constants.ROLE_CEO & role) != 0;
	}

	public static String getCharacterDataFromElement(Element e) {

		NodeList list = e.getChildNodes();
		String data;

		for (int index = 0; index < list.getLength(); index++) {
			if (list.item(index) instanceof CharacterData) {
				CharacterData child = (CharacterData) list.item(index);
				data = child.getData();

				if (data != null && data.trim().length() > 0)
					return child.getData();
			}
		}
		return "";
	}

	public static String createSignature(HashMap<String, String> arrKeys) {
		String value;
		String privateKey = "private";
		String encryptSignature;
		StringBuilder signature;

		List<String> list;

		signature = new StringBuilder();
		list = new ArrayList<String>(arrKeys.keySet());
		// Sort key as a-z order
		Collections.sort(list);

		for (String key : list) {
			value = arrKeys.get(key);
			signature.append(key);
			signature.append("=");
			signature.append(value);
			signature.append("&");
		}
		// TODO get private key
		signature.append(privateKey);

		// Encrypt with MD5 algorithms
		encryptSignature = MD5Hashing(signature.toString());

		return encryptSignature;
	}

	private static String MD5Hashing(String value) {
		MessageDigest md;
		StringBuffer hexString;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(value.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format
			hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return hexString.toString();
	}

}

package dJavaFirstTest;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

	private static boolean isUpperCase(String str) {
		return Pattern.compile("^[A-Z]").matcher(str).find();
	}

	public static boolean firstCharIsUpperCase(String str) {
		if (str == null || str == "") {
			return false;
		}
		Matcher matcher = Pattern.compile("(.)", Pattern.DOTALL).matcher(str);
		if (matcher.find()) {
			String firstChar = matcher.group(1);
			if (isUpperCase(firstChar)) {
				return true;
			}
		}

		return false;
	}

	public static int getNumberFilesOf(File folder) {
		if (folder == null || !folder.isDirectory()) {
			return 0;
		}

		int count = 0;
		File[] files = folder.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					count += getNumberFilesOf(file);
				} else {
					count++;
				}
			}
		}
		return count;
	}
}

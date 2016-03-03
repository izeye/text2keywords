package com.izeye.text2keywords.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by izeye on 16. 3. 3..
 */
public abstract class JarResourceUtils {

	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static List<String> readLines(String resourcePath) {
		return readLines(resourcePath, DEFAULT_CHARSET);
	}

	public static List<String> readLines(String resourcePath, Charset charset) {
		try (InputStream is = getInputStream(resourcePath)) {
			return IOUtils.readLines(is, charset);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static String toString(String resourcePath) {
		return toString(resourcePath, DEFAULT_CHARSET);
	}

	public static String toString(String resourcePath, Charset charset) {
		try (InputStream is = getInputStream(resourcePath)) {
			return IOUtils.toString(is, charset);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static InputStream getInputStream(String resourcePath) {
		try {
			return new ClassPathResource(resourcePath).getInputStream();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}

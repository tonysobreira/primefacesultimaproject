/*
 * $Id$
 */
package br.com.base.ultima.i18n;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.omnifaces.util.Faces;

/**
 * 国际化(internationalization)
 */
@Named
@SessionScoped
public class I18n implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 语言与地区的映射 */
	private Map<String, Locale> languageMap;

	@PostConstruct
	public void init() {
		languageMap = new HashMap<String, Locale>();
		languageMap.put("zh_CN", Locale.SIMPLIFIED_CHINESE);
		languageMap.put("zh_TW", Locale.TRADITIONAL_CHINESE);
		languageMap.put("zh", Locale.CHINESE);
		languageMap.put("en_US", Locale.US);
		languageMap.put("en", Locale.ENGLISH);
	}

	/**
	 * 设置用户会话使用的语言
	 *
	 * @param language 语言
	 */
	public void setLanguage(String language) {
		Locale theLocale = languageMap.get(language);
		if (theLocale != null) {
			Faces.setLocale(theLocale);
		}
	}
}

package br.com.base.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {
	private static final long serialVersionUID = 1L;

	/** Tema padrão：ultima-dark-blue */
	public static final String DEFAULT_THEME = "ultima-dark-blue";
	/** Tamanho da fonte padrão：layout-compact */
	public static final String DEFAULT_FONT_SIZE = "layout-compact";
	/** Estilo de posição do menu padrão：static */
	public static final String DEFAULT_MENU_MODE = "static";
	/** Estilo de fundo do menu padrão：menu-layout-static */
	public static final String DEFAULT_MENU_COLOR = "layout-menu-dark";
	/** Modo de configuração do usuário padrão：inline */
	public static final String DEFAULT_PROFILE = "top";
	/**
	 * Tema de layout (outros tópicos
	 * opcionais：ultima-blue/ultima-blue-grey/ultima-brown/ultima-cyan/ultima-dark-blue/
	 * ultima-dark-green/ultima-green/ultima-grey/ultima-indigo/ultima-purple-amber/ultima-purple-cyan/ultima-teal)
	 */
	private String theme;
	/**
	 * Arquivos de estilo CSS de layout (outros estilos
	 * opcionais：layout-blue/layout-blue-grey/layout-brown/layout-cyan/
	 * layout-dark-blue/layout-dark-green/layout-green/layout-grey/layout-indigo/layout-purple-amber/layout-purple-cyan/layout-teal)
	 */
	private String layoutCss;// = "css/layout-indigo.css";
	private String themeColor;// = "#3F51B5";
	/** Tamanho da fonte(layout-compact) */
	private String fontSize;// = "layout-compact";
	/** Estilo do menu(static/overlay/horizontal) */
	private String menuMode;// = "static";
	/**
	 * Estilo de posição do menu(layout-wrapper menu-layout-static/layout-wrapper
	 * menu-layout-overlay/layout-wrapper menu-layout-static menu-layout-horizontal)
	 */
	private String menuModeClass;
	/** Estilo de fundo do menu(""/layout-menu-dark) */
	private String menuColor; // = "";
	/** Modo de configuração do usuário(inline/top) */
	private String profile; // = "inline";
	private Map<String, String> layoutMap;
	private Map<String, String> themeColorMap;
	private Map<String, String> menuModeClassMap;

	@PostConstruct
	public void init() {
		layoutMap = new HashMap<>();
		layoutMap.put("ultima-blue", "css/layout-blue.css");
		layoutMap.put("ultima-blue-grey", "css/layout-blue-grey.css");
		layoutMap.put("ultima-brown", "css/layout-brown.css");
		layoutMap.put("ultima-cyan", "css/layout-cyan.css");
		layoutMap.put("ultima-dark-blue", "css/layout-dark-blue.css");
		layoutMap.put("ultima-dark-green", "css/layout-dark-green.css");
		layoutMap.put("ultima-green", "css/layout-green.css");
		layoutMap.put("ultima-grey", "css/layout-grey.css");
		layoutMap.put("ultima-indigo", "css/layout-indigo.css");
		layoutMap.put("ultima-purple-amber", "css/layout-purple-amber.css");
		layoutMap.put("ultima-purple-cyan", "css/layout-purple-cyan.css");
		layoutMap.put("ultima-teal", "css/layout-teal.css");

		themeColorMap = new HashMap<>();
		themeColorMap.put("ultima-blue", "#03A9F4");
		themeColorMap.put("ultima-blue-grey", "#607D8B");
		themeColorMap.put("ultima-brown", "#795548");
		themeColorMap.put("ultima-cyan", "#00bcd4");
		themeColorMap.put("ultima-dark-blue", "");
		themeColorMap.put("ultima-dark-green", "");
		themeColorMap.put("ultima-green", "#4CAF50");
		themeColorMap.put("ultima-grey", "");
		themeColorMap.put("ultima-indigo", "#3F51B5");
		themeColorMap.put("ultima-purple-amber", "#673AB7");
		themeColorMap.put("ultima-purple-cyan", "#673AB7");
		themeColorMap.put("ultima-teal", "#009688");

		menuModeClassMap = new HashMap<>();
		menuModeClassMap.put("static", "layout-wrapper menu-layout-static");
		menuModeClassMap.put("overlay", "layout-wrapper menu-layout-overlay");
		menuModeClassMap.put("horizontal", "layout-wrapper menu-layout-static menu-layout-horizontal");

		setTheme(DEFAULT_THEME);
		setFontSize(DEFAULT_FONT_SIZE);
		setMenuMode(DEFAULT_MENU_MODE);
		setMenuColor(DEFAULT_MENU_COLOR);
		setProfile(DEFAULT_PROFILE);
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
		// Redefinir o CSS do layout da página com base nas alterações de cores do tema
		layoutCss = layoutMap.get(theme);
		themeColor = themeColorMap.get(theme);
	}

	public String getLayoutCss() {
		return layoutCss;
	}

	public void setLayoutCss(String layoutCss) {
		this.layoutCss = layoutCss;
	}

	public String getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getMenuMode() {
		return menuMode;
	}

	public void setMenuMode(String menuMode) {
		this.menuMode = menuMode;
		menuModeClass = menuModeClassMap.get(menuMode);
	}

	public String getMenuModeClass() {
		return menuModeClass;
	}

	public void setMenuModeClass(String menuModeClass) {
		this.menuModeClass = menuModeClass;
	}

	public String getMenuColor() {
		return menuColor;
	}

	public void setMenuColor(String menuColor) {
		this.menuColor = menuColor;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}

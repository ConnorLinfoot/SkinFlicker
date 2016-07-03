package com.connorlinfoot.skinflicker;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigHandler {
	private File configFile;
	private Configuration config;

	public ConfigHandler(File file) {
		configFile = file;
		config = new Configuration(configFile);

		config.load();
		getRate();
		doHat();
		doJacket();
		doSleeves();
		doPants();
		config.save();
	}

	public Property rateProp() {
		return config.get(Configuration.CATEGORY_CLIENT, "Flicker Rate", 10, "Rate to do the flicker in ticks");
	}

	public int getRate() {
		return rateProp().getInt();
	}

	public Property flickerHatProp() {
		return config.get(Configuration.CATEGORY_CLIENT, "Flicker Hat", false);
	}

	public boolean doHat() {
		return flickerHatProp().getBoolean();
	}

	public Property flickerJacketProp() {
		return config.get(Configuration.CATEGORY_CLIENT, "Flicker Jacket", false);
	}

	public boolean doJacket() {
		return flickerJacketProp().getBoolean();
	}

	public Property flickerSleevesProp() {
		return config.get(Configuration.CATEGORY_CLIENT, "Flicker Sleeves", false);
	}

	public boolean doSleeves() {
		return flickerSleevesProp().getBoolean();
	}

	public Property flickerPantsProp() {
		return config.get(Configuration.CATEGORY_CLIENT, "Flicker Pants", false);
	}

	public boolean doPants() {
		return flickerPantsProp().getBoolean();
	}

	public Configuration getConfig() {
		return config;
	}

}

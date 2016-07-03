package com.connorlinfoot.skinflicker;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

/**
 * File created by Connor Linfoot on 03/07/16.
 * Copyright © 2016. All rights reserved.
 * This file along with any other assets may
 * not be reproduced or distributed in any
 * way without written permission of the author.
 */
public class ConfigGUI extends GuiConfig {

	public ConfigGUI(GuiScreen parentScreen) {
		super(parentScreen, new ConfigElement(SkinFlicker.getSkinFlicker().getConfigHandler().getConfig().getCategory(Configuration.CATEGORY_CLIENT)).getChildElements(), SkinFlicker.MODID, false, false, "SkinFlicker Configuration", "");
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		SkinFlicker.getSkinFlicker().getConfigHandler().getConfig().save();
	}

}
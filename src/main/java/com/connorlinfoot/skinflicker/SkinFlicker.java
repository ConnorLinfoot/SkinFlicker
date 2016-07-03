package com.connorlinfoot.skinflicker;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = SkinFlicker.MODID, version = SkinFlicker.VERSION, guiFactory = "com.connorlinfoot.skinflicker.GuiFact")
public class SkinFlicker {
	public static final String MODID = "skinflicker";
	public static final String VERSION = "1.0.1";
	private int counter = 0;
	private ConfigHandler configHandler;
	private static SkinFlicker skinFlicker;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		skinFlicker = this;
		configHandler = new ConfigHandler(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = false)
	public void onTick(TickEvent.ClientTickEvent event) {
		counter++;
		if (counter >= configHandler.getRate()) {
			counter = 0;
			if (configHandler.doHat())
				Minecraft.getMinecraft().gameSettings.switchModelPartEnabled(EnumPlayerModelParts.HAT);

			if (configHandler.doJacket())
				Minecraft.getMinecraft().gameSettings.switchModelPartEnabled(EnumPlayerModelParts.JACKET);

			if (configHandler.doSleeves()) {
				Minecraft.getMinecraft().gameSettings.switchModelPartEnabled(EnumPlayerModelParts.LEFT_SLEEVE);
				Minecraft.getMinecraft().gameSettings.switchModelPartEnabled(EnumPlayerModelParts.RIGHT_SLEEVE);
			}

			if (configHandler.doPants()) {
				Minecraft.getMinecraft().gameSettings.switchModelPartEnabled(EnumPlayerModelParts.LEFT_PANTS_LEG);
				Minecraft.getMinecraft().gameSettings.switchModelPartEnabled(EnumPlayerModelParts.RIGHT_PANTS_LEG);
			}
		}
	}

	public static SkinFlicker getSkinFlicker() {
		return skinFlicker;
	}

	public ConfigHandler getConfigHandler() {
		return configHandler;
	}

}

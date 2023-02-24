package com.samplepanel;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import java.awt.image.BufferedImage;

import java.net.URL;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;

@PluginDescriptor(name = "Sample Panel")

public class SamplePanel extends Plugin {

	@Inject
	private ClientToolbar clientToolbar;
	
	private NavigationButton navButton;

	private SamplePanelUI samplePanel;

	@Override
	protected void startUp() throws Exception {
		samplePanel = new SamplePanelUI();

		final BufferedImage icon = ImageIO.read(new URL("https://oldschool.runescape.wiki/images/Black_mask_detail.png?5b902"));

		navButton = NavigationButton.builder()
		.tooltip("Sample Plugin Panel")
		.icon(icon)
		.priority(99)
		.panel(samplePanel)
		.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception {
		samplePanel.removeAll();
		clientToolbar.removeNavigation(navButton);
		samplePanel = null;
	}
}

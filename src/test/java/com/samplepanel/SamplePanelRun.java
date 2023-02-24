package com.samplepanel;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SamplePanelRun
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SamplePanel.class);
		RuneLite.main(args);
	}
}
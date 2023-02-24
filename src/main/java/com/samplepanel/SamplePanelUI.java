package com.samplepanel;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;


class SampleButton extends JButton {
	protected SampleButton(String text) {
		super();
		this.setFocusPainted(false);
		this.setText(text);
	}
}
class SamplePanelUI extends PluginPanel {
	JPanel titlePanel = new JPanel(new BorderLayout(5, 5));
	JLabel title = new JLabel ("Test Label!", JLabel.CENTER);
	JLabel testLabel = new JLabel ("VVV Click This Button! VVV", JLabel.CENTER);

	JPanel buttonsSubPanel = new JPanel(new GridLayout(2, 1, 5, 5));

	SampleButton testButton = new SampleButton("Click Me!");
	
	protected SamplePanelUI() {
		super(false);

		this.setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());

		title.setFont(new Font(title.getFont().getName(), Font.BOLD, 24));

		testLabel.setForeground(ColorScheme.GRAND_EXCHANGE_ALCH);
		testButton.setBackground(ColorScheme.BRAND_ORANGE);
		testButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		testButton.addActionListener(click -> {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
				} catch (IOException | URISyntaxException ee) {
					ee.printStackTrace();
				}
			}
		});

		this.add(titlePanel, BorderLayout.NORTH);
		titlePanel.add(title);

		this.add(buttonsSubPanel, BorderLayout.SOUTH);
		buttonsSubPanel.add(testLabel);
		buttonsSubPanel.add(testButton);
	}
}
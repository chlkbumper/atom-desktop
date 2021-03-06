package me.atom.windowsj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextPane;

/**
 * 
 * TransparentTextarea.java created by Guillaume Cendre (aka chlkbumper)
 *
 *	This class creates a custom JTextPane. It make it (almost -_-)
 * transparent and set its initial text.
 *
 */

public class TransparentTextArea extends JTextPane {

	private static final long serialVersionUID = 1L;

	public TransparentTextArea() {
        setOpaque(false);
        setText("Je suis Atom, votre assistant personnel. En quoi puis-je vous aider ?" + '\n' +
        		"(C) Copyright 2013 Guillaume Cendre");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255, 0));
        Insets insets = getInsets();
        int x = insets.left;
        int y = insets.top;
        int width = getWidth() - (insets.left + insets.right);
        int height = getHeight() - (insets.top + insets.bottom);
        g.fillRect(x, y, width, height);
        super.paintComponent(g);
    }

}

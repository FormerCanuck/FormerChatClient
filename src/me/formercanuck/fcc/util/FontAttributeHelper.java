package me.formercanuck.fcc.util;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class FontAttributeHelper {

    private static FontAttributeHelper fontAttributeHelper = null;

    private FontAttributeHelper() {
    }

    public static FontAttributeHelper get() {
        if (fontAttributeHelper == null) fontAttributeHelper = new FontAttributeHelper();
        return fontAttributeHelper;
    }

    private SimpleAttributeSet getAttributeSetWithColor(Color color) {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attributeSet, color);
        return attributeSet;
    }

    public SimpleAttributeSet pink() {
        return getAttributeSetWithColor(Color.PINK);
    }
}

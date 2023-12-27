/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.framework.CioIntentVisualization;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;

public class CioIntentVisualizationImpl
implements CioIntentVisualization {
    private static final Color[] DEFAULT_COLORS = new Color[0];
    private static final Image[] DEFAULT_ICONS = new Image[0];
    private static final String DEFAULT_TEXT;
    public static final CioIntentVisualization DEFAULT;
    public static final CioIntentVisualization NOT_AVAILABLE;
    private final Color[] contextColors;
    private final Image[] icons;
    private final Color[] iconColors;
    private final Color[] iconGlowColors;
    private final String text;
    private final Color[] textColors;
    private final Color[] textGlowColors;

    public CioIntentVisualizationImpl(Color[] colorArray, Image[] imageArray, Color[] colorArray2, Color[] colorArray3, String string, Color[] colorArray4, Color[] colorArray5) {
        this.contextColors = CioIntentVisualizationImpl.firstNonNullOrDefault(colorArray, DEFAULT_COLORS);
        this.icons = CioIntentVisualizationImpl.firstNonNullOrDefault(imageArray, DEFAULT_ICONS);
        this.iconColors = CioIntentVisualizationImpl.firstNonNullOrDefault(colorArray2, DEFAULT_COLORS);
        this.iconGlowColors = CioIntentVisualizationImpl.firstNonNullOrDefault(colorArray3, DEFAULT_COLORS);
        this.text = CioIntentVisualizationImpl.firstNonNullOrDefault(string, "");
        this.textColors = CioIntentVisualizationImpl.firstNonNullOrDefault(colorArray4, DEFAULT_COLORS);
        this.textGlowColors = CioIntentVisualizationImpl.firstNonNullOrDefault(colorArray5, DEFAULT_COLORS);
    }

    private static Color[] firstNonNullOrDefault(Color[] colorArray, Color[] colorArray2) {
        return colorArray != null ? colorArray : colorArray2;
    }

    private static Image[] firstNonNullOrDefault(Image[] imageArray, Image[] imageArray2) {
        return imageArray != null ? imageArray : imageArray2;
    }

    private static String firstNonNullOrDefault(String string, String string2) {
        return string != null ? string : string2;
    }

    @Override
    public Color[] getContextColors() {
        return this.contextColors;
    }

    @Override
    public Image[] getIcons() {
        return this.icons;
    }

    @Override
    public Color[] getIconColors() {
        return this.iconColors;
    }

    @Override
    public Color[] getIconGlowColors() {
        return this.iconGlowColors;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public Color[] getTextColors() {
        return this.textColors;
    }

    @Override
    public Color[] getTextGlowColors() {
        return this.textGlowColors;
    }

    static {
        DEFAULT = new CioIntentVisualizationImpl(null, null, null, null, null, null, null);
        NOT_AVAILABLE = null;
    }
}


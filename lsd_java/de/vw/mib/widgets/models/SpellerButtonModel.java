/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.speller.SpellerElement;

public interface SpellerButtonModel
extends ButtonModel,
WidgetCloneable {
    public static final int PID_BASE;
    public static final int PID_ACTIVATE_KEY_LONG_PRESSED_ON_LONG_PRESSED;
    public static final int PID_IMAGE_SUBSPELLER_INDICATOR_REF;
    public static final int PID_IMAGES_SUBSPELLER_INDICATOR;
    public static final int PID_TEMPLATE_NAME;
    public static final int PID_TEXT_FROM_ALPHABET_ENABLED;
    public static final int PID_STATE_OFFSET;
    public static final int PID_COUNT_SPELLER_BUTTON;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_SPELLERBUTTON;
    public static final int SID_BASE;
    public static final int SID_ACTIVATE_KEY_LONG_PRESSED_ON_LONG_PRESSED;
    public static final int SID_TEXT_FROM_ALPHABET_ENALBED;
    public static final int SID_COUNT_SPELLER_BUTTON;
    public static final int DEFAULT_STATE_OFFSET;

    default public boolean is_activateKeyLongPressedOnLongPressed() {
    }

    default public void set_activateKeyLongPressedOnLongPressed(boolean bl) {
    }

    default public StaticImageModel get_imageSubspellerIndicatorRef() {
    }

    default public void set_imageSubspellerIndicatorRef(StaticImageModel staticImageModel) {
    }

    default public Image[] get_imagesSubspellerIndicator() {
    }

    default public void set_imagesSubspellerIndicator(Image[] imageArray) {
    }

    default public int get_stateOffset() {
    }

    default public void set_stateOffset(int n) {
    }

    default public String get_templateName() {
    }

    default public void set_templateName(String string) {
    }

    default public boolean is_textFromAlphabetEnabled() {
    }

    default public void set_textFromAlphabetEnabled(boolean bl) {
    }

    default public SpellerElement getSpellerElement() {
    }

    default public void setSpellerElement(SpellerElement spellerElement) {
    }

    default public boolean isSubspellerEnabled() {
    }

    default public void setSubspellerEnabled(boolean bl) {
    }
}


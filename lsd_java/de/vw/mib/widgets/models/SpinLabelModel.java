/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.interfaces.Draggable;
import de.vw.mib.widgets.models.AbstractTextModel;

public interface SpinLabelModel
extends AbstractTextModel,
Draggable {
    public static final int PID_BASE;
    public static final int PID_SEPARATOR_IMAGE;
    public static final int PID_BACKGROUND_IMAGE;
    public static final int PID_SPIN_DIRECTION_UP;
    public static final int PID_VALUES;
    public static final int PID_MODE;
    public static final int PID_SELECTED_INDEX;
    public static final int PID_CYCLIC;
    public static final int PID_CHARACTER_OFFSET;
    public static final int PID_COUNT_SPIN_LABEL;
    public static final int ALIGNMENTHORIZONTAL_LEFT;
    public static final int ALIGNMENTHORIZONTAL_CENTER;
    public static final int ALIGNMENTHORIZONTAL_RIGHT;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_FLIPPING_ANIMATION;
    public static final int EASING_INDEX_COUNT_SPINLABEL;
    public static final int SID_BASE;
    public static final int SID_SPIN_DIRECTION_UP;
    public static final int SID_CYCLIC;
    public static final int SID_DISABLE_SELECTION_ANIMATION;
    public static final int SID_COUNT_SPIN_LABEL;
    public static final int MODE_DEFAULT;
    public static final int MODE_VALUES;
    public static final int MODE_NUMBER_INTERVAL;

    default public void set_separatorImage(Image image) {
    }

    default public Image get_separatorImage() {
    }

    default public void set_backgroundImage(Image image) {
    }

    default public Image get_backgroundImage() {
    }

    default public void set_mode(int n) {
    }

    default public int get_mode() {
    }

    default public void set_cyclic(boolean bl) {
    }

    default public boolean is_cyclic() {
    }

    default public void set_values(String[] stringArray) {
    }

    default public String[] get_values() {
    }

    default public void set_selectedIndex(int n) {
    }

    default public int get_selectedIndex() {
    }

    default public void set_spinDirectionUp(boolean bl) {
    }

    default public boolean is_spinDirectionUp() {
    }

    default public void set_characterOffset(int n) {
    }

    default public int get_characterOffset() {
    }

    default public int getScrollPosition() {
    }

    default public int getItemHeight() {
    }

    default public int getMaxScrollPosition() {
    }

    default public int getSelectionValue() {
    }

    default public int getLastIndex() {
    }

    default public TextLayout getTextLayout(int n) {
    }
}


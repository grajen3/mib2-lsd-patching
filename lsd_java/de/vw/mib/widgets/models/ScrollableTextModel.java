/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.interfaces.Draggable;
import de.vw.mib.widgets.models.AbstractTextModel;

public interface ScrollableTextModel
extends AbstractTextModel,
Adjustable,
AdjustmentListener,
Draggable {
    public static final int PID_BASE;
    public static final int PID_FIRST_LINE_INDEX;
    public static final int PID_TAB_POSITIONS;
    public static final int PID_TEXT_COLORS;
    public static final int PID_COUNT_SCROLLABLETEXT;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_SNAP;
    public static final int EASING_INDEX_COUNT_SCROLLABLE_TEXT;
    public static final int SID_BASE;
    public static final int SID_COUNT_SCROLLABLETEXT;

    default public int get_firstLineIndex() {
    }

    default public void set_firstLineIndex(int n) {
    }

    default public int[] get_tabPositions() {
    }

    default public void set_tabPositions(int[] nArray) {
    }

    default public int getFirstVisibleLineIndex() {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.widgets.interfaces.Adjustable;

public interface AdjustmentListener {
    public static final int ADJUSTMENT_DEFAULT;
    public static final int ADJUSTMENT_STARTED;
    public static final int ADJUSTMENT_FINISHED;
    public static final int ADJUSTMENT_NEXT_PAGE;
    public static final int ADJUSTMENT_PREV_PAGE;

    default public void adjustmentValueChanged(Adjustable adjustable, int n) {
    }
}


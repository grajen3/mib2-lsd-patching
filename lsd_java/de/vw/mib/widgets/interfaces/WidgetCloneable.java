/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.widgets.interfaces.WidgetCloneData;

public interface WidgetCloneable {
    default public void setCloneData(WidgetCloneData widgetCloneData) {
    }

    default public WidgetCloneData getCloneData() {
    }
}


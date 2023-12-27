/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.widgets.interfaces.WidgetCloneable;

public interface WidgetCloneFactory {
    default public WidgetCloneable createWidgetCloneable(WidgetCloneable widgetCloneable) {
    }

    default public void destroyWidgetCloneable(WidgetCloneable widgetCloneable) {
    }
}


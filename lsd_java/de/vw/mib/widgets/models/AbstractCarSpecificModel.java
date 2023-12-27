/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.car.AbstractConfigData;
import de.vw.mib.widgets.car.RawConfigDataProxy;
import de.vw.mib.widgets.models.WidgetModel;

public interface AbstractCarSpecificModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_COUNT_ABSTRACT_CAR_SPECIFIC;
    public static final int SID_BASE;
    public static final int SID_COUNT_ABSTRACT_CAR_SPECIFIC;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_ABSTRACT_CAR_SPECIFIC;

    default public AbstractConfigData getConfigData() {
    }

    default public void setRawConfigData(RawConfigDataProxy rawConfigDataProxy) {
    }
}


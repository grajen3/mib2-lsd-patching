/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue;

import generated.de.vw.mib.asl.internal.car.tbt.ASLCarTBTPropertyManager;

public abstract class Common {
    public static final int ACC_BUFFER_SIZE;
    public static final int IRIS_SEGS_SIZE;
    public static final int HISTORY_GRAPH_SIZE;
    public static final double CONSUMPTION_VALUE_MAX;

    static {
        IRIS_SEGS_SIZE = ASLCarTBTPropertyManager.IRIS_SEGMENTS_VALUES__DEFAULT_VALUE.length;
        HISTORY_GRAPH_SIZE = ASLCarTBTPropertyManager.CONSUMPTION_STATISTICS__1__CONSUMPTION_VALUES__1__DEFAULT_VALUE.length;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.core.IEnum;

public interface SpiBtState
extends IEnum {
    public static final int BT_UNKNOWN;
    public static final int BT_ACTIVE;
    public static final int BT_NOT_READY;
    public static final int BT_NOT_ACTIVE;
    public static final int BT_NOT_AVAILABLE_CODING;
    public static final int BT_NOT_AVAILABLE_ADAPTATION;
    public static final int BT_NOT_AVAILABLE_FEC;
    public static final int BT_NOT_AVAILABLE_ERROR;
}


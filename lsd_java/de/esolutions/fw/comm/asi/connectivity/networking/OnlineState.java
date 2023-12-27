/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.IEnum;

public interface OnlineState
extends IEnum {
    public static final int ONLINE_STATE_UNKNOWN;
    public static final int ONLINE_STATE_BLOCKED;
    public static final int ONLINE_STATE_PENDING;
    public static final int ONLINE_STATE_IDLE_ALLOWED;
    public static final int ONLINE_STATE_CONNECTED_ALLOWED;
}


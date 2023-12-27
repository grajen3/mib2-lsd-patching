/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.core.IEnum;

public interface ShutdownRequest
extends IEnum {
    public static final int ONOFF_SHUTDOWN_NONE;
    public static final int ONOFF_SHUTDOWN_NORMAL;
    public static final int ONOFF_SHUTDOWN_RESTART;
    public static final int ONOFF_SHUTDOWN_FAST;
    public static final int ONOFF_SHUTDOWN_FINAL;
}


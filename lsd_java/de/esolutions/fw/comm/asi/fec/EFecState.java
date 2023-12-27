/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.IEnum;

public interface EFecState
extends IEnum {
    public static final int eStateNotAvailable;
    public static final int eNoPermission;
    public static final int ePermissionGranted;
    public static final int ePermissionTemporarilyWithdrawn;
    public static final int ePermissionWithdrawn;
    public static final int ePermissionIllegal;
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

import de.esolutions.fw.comm.core.IEnum;

public interface eSimLockstate
extends IEnum {
    public static final int SIM_LOCKSTATE_NOT_KNOWN;
    public static final int SIM_LOCKSTATE_UNLOCK_IN_PROGRESS;
    public static final int SIM_LOCKSTATE_NO_LOCK;
    public static final int SIM_LOCKSTATE_PIN_REQUIRED;
    public static final int SIM_LOCKSTATE_PIN2_REQUIRED;
    public static final int SIM_LOCKSTATE_PUK_REQUIRED;
    public static final int SIM_LOCKSTATE_PUK2_REQUIRED;
    public static final int SIM_LOCKSTATE_PUK_BLOCKED;
    public static final int SIM_LOCKSTATE_PUK2_BLOCKED;
    public static final int SIM_LOCKSTATE_NO_FUNCTION;
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.core.IEnum;

public interface LicenseState
extends IEnum {
    public static final int LICENSE_STATE_ACTIVATED;
    public static final int LICENSE_STATE_NOT_ACTIVATED;
    public static final int LICENSE_STATE_NOT_LICENSED;
    public static final int LICENSE_STATE_EXPIRED;
    public static final int LICENSE_STATE_OFFERED;
    public static final int LICENSE_STATE_LICENSE_ERROR;
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.IEnum;

public interface EFecCheckResult
extends IEnum {
    public static final int eFecValid;
    public static final int eFecSignatureFailed;
    public static final int eFecVcrnTemporarilyFailed;
    public static final int eFecDateFailed;
    public static final int eFecValidityFailed;
}


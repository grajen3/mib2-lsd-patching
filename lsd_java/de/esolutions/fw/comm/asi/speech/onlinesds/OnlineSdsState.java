/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds;

import de.esolutions.fw.comm.core.IEnum;

public interface OnlineSdsState
extends IEnum {
    public static final int OS_STATE_OK;
    public static final int OS_STATE_SKIPPED_OK;
    public static final int OS_STATE_ERROR_NO_ONLINE_RESULT;
    public static final int OS_STATE_ERROR_NO_CONNECTION;
    public static final int OS_STATE_ERROR_GENERAL;
    public static final int OS_STATE_QUERY_REQUIRED;
}


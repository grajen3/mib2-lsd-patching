/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.core.IEnum;

public interface Result
extends IEnum {
    public static final int RESULT_OK;
    public static final int RESULT_UNSPECIFIED_ERROR;
    public static final int RESULT_LOCATOR_NOT_FOUND;
    public static final int RESULT_SYSTEM_NOT_READY;
    public static final int RESULT_IMAGE_IO_ERROR;
}


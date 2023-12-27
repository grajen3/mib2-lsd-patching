/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore;

import de.esolutions.fw.comm.core.IEnum;

public interface PictureStoreResult
extends IEnum {
    public static final int RESULT_SUCCESS;
    public static final int RESULT_NOSLOTAVAILABLE;
    public static final int RESULT_IOERROR;
    public static final int RESULT_PICTURENOTFOUND;
    public static final int RESULT_INTERNALERROR;
    public static final int RESULT_WRONG_PARAMETER;
}


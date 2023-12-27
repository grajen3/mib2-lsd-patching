/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContainer;

public interface HASContextResults {
    public static final int RESULT_CODE_TIMED_OUT;
    public static final int RESULT_CODE_NOT_IMPLEMENTED;
    public static final int RESULT_CODE_NOT_READY;
    public static final int RESULT_CODE_OK;
    public static final int RESULT_CODE_ERROR;
    public static final int RESULT_CODE_NOT_ALLOWED;

    default public void callResult(int n, int n2, int n3, HASContainer hASContainer) {
    }
}


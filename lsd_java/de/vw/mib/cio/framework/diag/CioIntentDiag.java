/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.framework.diag;

import de.vw.mib.cio.CioIntent;

public interface CioIntentDiag
extends CioIntent {
    default public String getAppName() {
    }

    default public String getAppInstanceName() {
    }

    default public String getCioExecutor() {
    }

    default public int getRank() {
    }
}


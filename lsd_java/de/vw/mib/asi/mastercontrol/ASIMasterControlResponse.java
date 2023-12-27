/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol;

import de.vw.mib.asi.ASIResponse;

public interface ASIMasterControlResponse
extends ASIResponse {
    default public void factoryReset() {
    }

    default public void enterAppContext(int n, String string) {
    }
}


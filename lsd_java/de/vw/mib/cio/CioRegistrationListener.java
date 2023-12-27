/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioIntent;

public interface CioRegistrationListener {
    default public void cioRegistered(String string, CioIntent cioIntent) {
    }

    default public void cioUnregistered(String string, CioIntent cioIntent) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;

public interface CioFactory {
    default public CioParametersCreator createPayload() {
    }

    default public CioParametersCreator createActionParameters(CioIntent cioIntent) {
    }

    default public CioCreator createCio(String string, String string2) {
    }

    default public CioCreator createForwardingCio(String string, String string2, CioIntent cioIntent) {
    }
}


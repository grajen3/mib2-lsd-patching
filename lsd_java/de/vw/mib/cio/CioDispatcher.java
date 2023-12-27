/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

public interface CioDispatcher {
    default public void dispatch(CioIntent cioIntent) {
    }

    default public void dispatch(CioIntent cioIntent, CioActionParameters cioActionParameters) {
    }

    default public void dispatch(ContentInformationObject contentInformationObject) {
    }
}


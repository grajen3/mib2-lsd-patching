/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioPayload;
import de.vw.mib.cio.ContentInformationObject;

public interface CioCreator {
    default public CioCreator setActionId(int n) {
    }

    default public CioCreator setCioIntentName(String string) {
    }

    default public CioCreator setCioName(String string) {
    }

    default public CioCreator setPayload(CioPayload cioPayload) {
    }

    default public CioCreator setPayloadData(Object object) {
    }

    default public CioIntent finishCallbackCioIntent(CioExecutor cioExecutor) {
    }

    default public ContentInformationObject register(String string, CioExecutor cioExecutor) {
    }

    default public ContentInformationObject register(String string, String string2, CioExecutor cioExecutor) {
    }
}


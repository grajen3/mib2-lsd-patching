/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioPayload;

public interface CioParametersCreator {
    default public CioActionParameters finish() {
    }

    default public CioActionParameters finishActionParams() {
    }

    default public CioPayload finishPayload() {
    }

    default public CioParametersCreator setBoolean(String string, boolean bl) {
    }

    default public CioParametersCreator setCioIntent(String string, CioIntent cioIntent) {
    }

    default public CioParametersCreator setFloat(String string, float f2) {
    }

    default public CioParametersCreator setInt(String string, int n) {
    }

    default public CioParametersCreator setLong(String string, long l) {
    }

    default public CioParametersCreator setObject(String string, Object object) {
    }

    default public CioParametersCreator setString(String string, String string2) {
    }
}


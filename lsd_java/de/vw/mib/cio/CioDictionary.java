/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;

public interface CioDictionary {
    public static final String ANY_USAGE;

    default public CioIntent getCioIntent(String string) {
    }

    default public CioIntent getCioIntent(String string, CioIntent cioIntent) {
    }

    default public CioIntent getCioIntent(String string, String string2) {
    }

    default public CioIntent getCioIntent(String string, String string2, boolean bl) {
    }

    default public CioIntent getCioIntent(String string, String string2, CioIntent cioIntent) {
    }

    default public CioIntent getCioIntent(String string, String string2, CioIntent cioIntent, boolean bl) {
    }

    default public CioIntent[] getCioIntents(String string) {
    }

    default public CioIntent[] getCioIntents(String string, String string2) {
    }

    default public CioIntent[] getCioIntents(String string, String string2, boolean bl) {
    }

    default public CioIntent[] getCioIntentsByFilter(String string) {
    }

    default public void addCioRegistrationListener(String string, CioRegistrationListener cioRegistrationListener) {
    }

    default public void removeCioRegistrationListener(String string, CioRegistrationListener cioRegistrationListener) {
    }
}


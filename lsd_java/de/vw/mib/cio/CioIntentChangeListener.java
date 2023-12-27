/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioIntent;

public interface CioIntentChangeListener {
    default public void cioAvailabilityStateChanged(CioIntent cioIntent, boolean bl) {
    }
}


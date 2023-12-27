/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;

public interface SpellerHandler {
    default public void onActivated(ISpellerContext iSpellerContext) {
    }

    default public void onLocationSaved(ISpellerContext iSpellerContext) {
    }

    default public void onLocationDiscarded(ISpellerContext iSpellerContext) {
    }

    default public void onContext(ISpellerContext iSpellerContext) {
    }
}


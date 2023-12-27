/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.speller;

import de.vw.mib.asl.internal.navigation.speller.SpellerContext;

public interface SpellerHandler {
    default public void onActivated(SpellerContext spellerContext) {
    }

    default public void onLocationSaved(SpellerContext spellerContext) {
    }

    default public void onLocationDiscarded(SpellerContext spellerContext) {
    }

    default public void onContext(SpellerContext spellerContext) {
    }
}


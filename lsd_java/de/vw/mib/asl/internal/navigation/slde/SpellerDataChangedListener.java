/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.properties.values.SpellerData;

public interface SpellerDataChangedListener {
    default public void spellerDataChanged(SpellerData spellerData) {
    }

    default public void spellerTextChanged(SpellerData spellerData) {
    }

    default public void initXt9Finished() {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer$Callback;

public interface AsiaInputInitializer {
    default public void initialize(AsiaInput asiaInput, AsiaInputInitializer$Callback asiaInputInitializer$Callback) {
    }

    default public boolean isInitialized() {
    }

    default public void reset() {
    }
}


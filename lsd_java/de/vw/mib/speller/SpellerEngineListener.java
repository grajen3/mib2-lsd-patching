/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller;

import de.vw.mib.speller.SpellerEngine;

public interface SpellerEngineListener {
    default public void notifySpellerDataChanged(SpellerEngine spellerEngine) {
    }
}


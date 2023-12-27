/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.hwr;

import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.speller.hwr.HWREngineListener;

public interface HWRManager {
    default public HWREngine initHWREngine(HWREngineListener hWREngineListener) {
    }
}


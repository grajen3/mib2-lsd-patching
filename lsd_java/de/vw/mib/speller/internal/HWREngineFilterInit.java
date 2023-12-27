/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.hwr.HWREngine;

public interface HWREngineFilterInit
extends HWREngine {
    default public void setFilter(SpellerFilter spellerFilter) {
    }
}


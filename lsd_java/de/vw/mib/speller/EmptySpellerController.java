/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller;

import de.vw.mib.speller.SpellerController;
import de.vw.mib.speller.SpellerEngine;
import de.vw.mib.speller.SpellerEngineListener;
import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.filter.SpellerFilterListener;
import de.vw.mib.speller.hwr.HWREngine;
import de.vw.mib.speller.hwr.HWREngineListener;

public class EmptySpellerController
implements SpellerController {
    @Override
    public HWREngine initHWREngine(int n, HWREngineListener hWREngineListener) {
        return null;
    }

    @Override
    public SpellerFilter initSpellerFilter(int n, SpellerFilterListener spellerFilterListener) {
        return null;
    }

    @Override
    public SpellerEngine initSpellerEngine(int n, SpellerEngineListener spellerEngineListener) {
        return null;
    }
}


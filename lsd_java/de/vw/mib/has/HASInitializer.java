/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;

public interface HASInitializer {
    default public void init(HASFactory hASFactory, HASEngineAPI hASEngineAPI) {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;

public interface HASAPI {
    default public HASEngineAPI getEngine() {
    }

    default public HASFactory getFactory() {
    }
}


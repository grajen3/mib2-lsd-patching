/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASContextResults;
import de.vw.mib.has.HASDataElementFactory;
import de.vw.mib.has.HASDatapool;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.HASRegistry;

public interface HASEngineAPI {
    default public void init(HASFactory hASFactory) {
    }

    default public HASClock getClock() {
    }

    default public HASDatapool getDatapool() {
    }

    default public HASRegistry getRegistry() {
    }

    default public HASContextResults getCallResults() {
    }

    default public HASDataElementFactory getDataElementFactory() {
    }

    default public HASBaseContainerFactory getBaseContainerFactory() {
    }

    default public HASContainerMarshaller createBaseContainerMarshaller(int n, int n2) {
    }
}


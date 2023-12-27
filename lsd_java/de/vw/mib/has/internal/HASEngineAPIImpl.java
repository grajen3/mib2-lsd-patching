/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASContextResults;
import de.vw.mib.has.HASDataElementFactory;
import de.vw.mib.has.HASDatapool;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.HASRegistry;
import de.vw.mib.has.internal.HASBaseContainerMarshallerImpl;
import de.vw.mib.has.internal.HASManager;

public final class HASEngineAPIImpl
implements HASEngineAPI {
    private HASClock clock;
    private HASDatapool datapool;
    private HASRegistry registry;
    private HASContextResults resultHandler;
    private HASDataElementFactory dataElementFactory;
    private HASBaseContainerFactory baseContainerFactory;

    @Override
    public void init(HASFactory hASFactory) {
        HASManager hASManager = HASManager.getInstance();
        hASManager.init(hASFactory);
        this.clock = hASManager.getClock();
        this.datapool = hASManager.getDatapool();
        this.registry = hASManager.getRegistry();
        this.resultHandler = hASManager.getCallsBridge();
        this.dataElementFactory = hASManager.getDataElementFactory();
        this.baseContainerFactory = hASManager.getBaseContainerFactory();
    }

    @Override
    public HASClock getClock() {
        return this.clock;
    }

    @Override
    public HASDatapool getDatapool() {
        return this.datapool;
    }

    @Override
    public HASRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public HASContextResults getCallResults() {
        return this.resultHandler;
    }

    @Override
    public HASDataElementFactory getDataElementFactory() {
        return this.dataElementFactory;
    }

    @Override
    public HASBaseContainerFactory getBaseContainerFactory() {
        return this.baseContainerFactory;
    }

    @Override
    public HASContainerMarshaller createBaseContainerMarshaller(int n, int n2) {
        return new HASBaseContainerMarshallerImpl(n, n2);
    }
}


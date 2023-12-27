/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASClient;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.internal.HASBridge;
import de.vw.mib.has.internal.HASCallsBridge;
import de.vw.mib.has.internal.HASClockImpl;
import de.vw.mib.has.internal.HASContainerBuilder;
import de.vw.mib.has.internal.HASDataElementFactoryImpl;
import de.vw.mib.has.internal.HASDataPoolImpl;
import de.vw.mib.has.internal.HASRegistryImpl;
import de.vw.mib.has.internal.containers.HASBaseContainerFactoryImpl;
import org.dsi.ifc.has.DSIHAS;

public final class HASManager {
    private HASClockImpl clock = new HASClockImpl();
    private final HASContainerBuilder builder = new HASContainerBuilder();
    private final HASBaseContainerFactory baseContainerFactory = new HASBaseContainerFactoryImpl();
    private final HASRegistryImpl registry = new HASRegistryImpl();
    private final HASDataPoolImpl datapool = new HASDataPoolImpl(this.builder, this.registry);
    private final HASCallsBridge callsBridge = new HASCallsBridge();
    private final HASDataElementFactoryImpl dataElementFactory = new HASDataElementFactoryImpl();
    private HASFactory factory;
    private static final HASManager INSTANCE = new HASManager();

    private HASManager() {
        this.clock.addConsumer(this.datapool);
        this.clock.addConsumer(this.callsBridge);
    }

    public static HASManager getInstance() {
        return INSTANCE;
    }

    void init(HASFactory hASFactory) {
        this.factory = hASFactory;
        this.builder.init(hASFactory);
    }

    HASDataPoolImpl getDatapool() {
        return this.datapool;
    }

    HASFactory getFactory() {
        return this.factory;
    }

    HASRegistryImpl getRegistry() {
        return this.registry;
    }

    HASCallsBridge getCallsBridge() {
        return this.callsBridge;
    }

    HASDataElementFactoryImpl getDataElementFactory() {
        return this.dataElementFactory;
    }

    HASBaseContainerFactory getBaseContainerFactory() {
        return this.baseContainerFactory;
    }

    HASClockImpl getClock() {
        return this.clock;
    }

    HASBridge createBridge(HASClient hASClient, DSIHAS dSIHAS) {
        HASBridge hASBridge = new HASBridge(hASClient, this.registry, this.datapool, this.builder, this.callsBridge, dSIHAS);
        this.datapool.addObserver(hASBridge);
        return hASBridge;
    }

    void dismissBridge(HASBridge hASBridge) {
        this.datapool.removeObserver(hASBridge);
    }
}


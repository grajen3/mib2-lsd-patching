/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilitiesImpl;
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilitiesImpl;

class InstrumentClusterPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$instrumentcluster$persistence$InstrumentClusterPersistableFactory;

    InstrumentClusterPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new AudioSD_ASGCapabilitiesImpl(this.module);
            }
            case 2: {
                return new SDSSD_ASGCapabilitiesImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module InstrumentCluster").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                AudioSD_ASGCapabilitiesImpl audioSD_ASGCapabilitiesImpl = new AudioSD_ASGCapabilitiesImpl(this.module);
                handlerFactory.createCommonHandler(audioSD_ASGCapabilitiesImpl).finish();
                return audioSD_ASGCapabilitiesImpl;
            }
            case 2: {
                SDSSD_ASGCapabilitiesImpl sDSSD_ASGCapabilitiesImpl = new SDSSD_ASGCapabilitiesImpl(this.module);
                handlerFactory.createCommonHandler(sDSSD_ASGCapabilitiesImpl).finish();
                return sDSSD_ASGCapabilitiesImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module InstrumentCluster").toString());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$instrumentcluster$persistence$InstrumentClusterPersistableFactory == null ? (class$de$vw$mib$asl$instrumentcluster$persistence$InstrumentClusterPersistableFactory = InstrumentClusterPersistableFactory.class$("de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterPersistableFactory")) : class$de$vw$mib$asl$instrumentcluster$persistence$InstrumentClusterPersistableFactory).desiredAssertionStatus();
    }
}


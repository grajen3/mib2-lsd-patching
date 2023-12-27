/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettingsImpl;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.ComponentPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.DabPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistenceImpl;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsImpl;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.SatImageImpl;
import de.vw.mib.asl.amfm.persistence.SatPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.ServicePersistenceImpl;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistenceImpl;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class AmFmPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmPersistableFactory;

    AmFmPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new RadioAmFmSettingsImpl(this.module);
            }
            case 2: {
                return new AmFmStationPersistenceImpl(this.module);
            }
            case 3: {
                return new AmFmPresetPersistenceImpl(this.module);
            }
            case 4: {
                return new ResourceLocatorPersistenceImpl(this.module);
            }
            case 5: {
                return new AmFmPresetSettingsImpl(this.module);
            }
            case 6: {
                return new AmFmFixedStationListPersistenceImpl(this.module);
            }
            case 7: {
                return new AmFmFixedStationPersistenceImpl(this.module);
            }
            case 8: {
                return new DabPersistenceImpl(this.module);
            }
            case 9: {
                return new FrequencyPersistenceImpl(this.module);
            }
            case 10: {
                return new EnsemblePersistenceImpl(this.module);
            }
            case 11: {
                return new ServicePersistenceImpl(this.module);
            }
            case 12: {
                return new ComponentPersistenceImpl(this.module);
            }
            case 13: {
                return new DabPresetPersistenceImpl(this.module);
            }
            case 14: {
                return new SatPersistenceImpl(this.module);
            }
            case 15: {
                return new StationInfoPersistenceImpl(this.module);
            }
            case 16: {
                return new SatImageImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module AmFm").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                RadioAmFmSettingsImpl radioAmFmSettingsImpl = new RadioAmFmSettingsImpl(this.module);
                handlerFactory.createCommonHandler(radioAmFmSettingsImpl).finish();
                handlerFactory.createUserHandler(radioAmFmSettingsImpl).finish();
                return radioAmFmSettingsImpl;
            }
            case 2: {
                AmFmStationPersistenceImpl amFmStationPersistenceImpl = new AmFmStationPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(amFmStationPersistenceImpl).finish();
                return amFmStationPersistenceImpl;
            }
            case 3: {
                AmFmPresetPersistenceImpl amFmPresetPersistenceImpl = new AmFmPresetPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(amFmPresetPersistenceImpl).finish();
                return amFmPresetPersistenceImpl;
            }
            case 4: {
                ResourceLocatorPersistenceImpl resourceLocatorPersistenceImpl = new ResourceLocatorPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(resourceLocatorPersistenceImpl).finish();
                return resourceLocatorPersistenceImpl;
            }
            case 5: {
                AmFmPresetSettingsImpl amFmPresetSettingsImpl = new AmFmPresetSettingsImpl(this.module);
                handlerFactory.createCommonHandler(amFmPresetSettingsImpl).finish();
                handlerFactory.createUserHandler(amFmPresetSettingsImpl).finish();
                return amFmPresetSettingsImpl;
            }
            case 6: {
                AmFmFixedStationListPersistenceImpl amFmFixedStationListPersistenceImpl = new AmFmFixedStationListPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(amFmFixedStationListPersistenceImpl).finish();
                handlerFactory.createUserHandler(amFmFixedStationListPersistenceImpl).finish();
                return amFmFixedStationListPersistenceImpl;
            }
            case 7: {
                AmFmFixedStationPersistenceImpl amFmFixedStationPersistenceImpl = new AmFmFixedStationPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(amFmFixedStationPersistenceImpl).finish();
                return amFmFixedStationPersistenceImpl;
            }
            case 8: {
                DabPersistenceImpl dabPersistenceImpl = new DabPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(dabPersistenceImpl).finish();
                handlerFactory.createUserHandler(dabPersistenceImpl).finish();
                return dabPersistenceImpl;
            }
            case 9: {
                FrequencyPersistenceImpl frequencyPersistenceImpl = new FrequencyPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(frequencyPersistenceImpl).finish();
                return frequencyPersistenceImpl;
            }
            case 10: {
                EnsemblePersistenceImpl ensemblePersistenceImpl = new EnsemblePersistenceImpl(this.module);
                handlerFactory.createCommonHandler(ensemblePersistenceImpl).finish();
                return ensemblePersistenceImpl;
            }
            case 11: {
                ServicePersistenceImpl servicePersistenceImpl = new ServicePersistenceImpl(this.module);
                handlerFactory.createCommonHandler(servicePersistenceImpl).finish();
                return servicePersistenceImpl;
            }
            case 12: {
                ComponentPersistenceImpl componentPersistenceImpl = new ComponentPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(componentPersistenceImpl).finish();
                return componentPersistenceImpl;
            }
            case 13: {
                DabPresetPersistenceImpl dabPresetPersistenceImpl = new DabPresetPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(dabPresetPersistenceImpl).finish();
                return dabPresetPersistenceImpl;
            }
            case 14: {
                SatPersistenceImpl satPersistenceImpl = new SatPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(satPersistenceImpl).finish();
                handlerFactory.createUserHandler(satPersistenceImpl).finish();
                return satPersistenceImpl;
            }
            case 15: {
                StationInfoPersistenceImpl stationInfoPersistenceImpl = new StationInfoPersistenceImpl(this.module);
                handlerFactory.createCommonHandler(stationInfoPersistenceImpl).finish();
                return stationInfoPersistenceImpl;
            }
            case 16: {
                SatImageImpl satImageImpl = new SatImageImpl(this.module);
                handlerFactory.createCommonHandler(satImageImpl).finish();
                return satImageImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module AmFm").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmPersistableFactory == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmPersistableFactory = AmFmPersistableFactory.class$("de.vw.mib.asl.amfm.persistence.AmFmPersistableFactory")) : class$de$vw$mib$asl$amfm$persistence$AmFmPersistableFactory).desiredAssertionStatus();
    }
}


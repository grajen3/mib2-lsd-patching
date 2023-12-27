/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistenceUserHandler;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettingsHandler;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettingsUserHandler;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.ComponentPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.DabPersistenceUserHandler;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistenceHandler;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsHandler;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsUserHandler;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.SatImage;
import de.vw.mib.asl.amfm.persistence.SatImageHandler;
import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.SatPersistenceHandler;
import de.vw.mib.asl.amfm.persistence.SatPersistenceUserHandler;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistenceHandler;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistenceHandler;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

class AmFmHandlerFactory
implements HandlerFactory {
    private final Logger logger;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmHandlerFactory;

    AmFmHandlerFactory(Logger logger, PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && logger == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.logger = logger;
        this.module = persistenceModule;
    }

    @Override
    public PersistenceDataHandler createCommonHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new RadioAmFmSettingsHandler((RadioAmFmSettings)persistable, this.logger, this.module);
            }
            case 2: {
                return new AmFmStationPersistenceHandler((AmFmStationPersistence)persistable, this.logger, this.module);
            }
            case 3: {
                return new AmFmPresetPersistenceHandler((AmFmPresetPersistence)persistable, this.logger, this.module);
            }
            case 4: {
                return new ResourceLocatorPersistenceHandler((ResourceLocatorPersistence)persistable, this.logger, this.module);
            }
            case 5: {
                return new AmFmPresetSettingsHandler((AmFmPresetSettings)persistable, this.logger, this.module);
            }
            case 6: {
                return new AmFmFixedStationListPersistenceHandler((AmFmFixedStationListPersistence)persistable, this.logger, this.module);
            }
            case 7: {
                return new AmFmFixedStationPersistenceHandler((AmFmFixedStationPersistence)persistable, this.logger, this.module);
            }
            case 8: {
                return new DabPersistenceHandler((DabPersistence)persistable, this.logger, this.module);
            }
            case 9: {
                return new FrequencyPersistenceHandler((FrequencyPersistence)persistable, this.logger, this.module);
            }
            case 10: {
                return new EnsemblePersistenceHandler((EnsemblePersistence)persistable, this.logger, this.module);
            }
            case 11: {
                return new ServicePersistenceHandler((ServicePersistence)persistable, this.logger, this.module);
            }
            case 12: {
                return new ComponentPersistenceHandler((ComponentPersistence)persistable, this.logger, this.module);
            }
            case 13: {
                return new DabPresetPersistenceHandler((DabPresetPersistence)persistable, this.logger, this.module);
            }
            case 14: {
                return new SatPersistenceHandler((SatPersistence)persistable, this.logger, this.module);
            }
            case 15: {
                return new StationInfoPersistenceHandler((StationInfoPersistence)persistable, this.logger, this.module);
            }
            case 16: {
                return new SatImageHandler((SatImage)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'AmFm'").toString());
    }

    @Override
    public PersistenceDataHandler createUserHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new RadioAmFmSettingsUserHandler((RadioAmFmSettings)persistable, this.logger, this.module);
            }
            case 5: {
                return new AmFmPresetSettingsUserHandler((AmFmPresetSettings)persistable, this.logger, this.module);
            }
            case 6: {
                return new AmFmFixedStationListPersistenceUserHandler((AmFmFixedStationListPersistence)persistable, this.logger, this.module);
            }
            case 8: {
                return new DabPersistenceUserHandler((DabPersistence)persistable, this.logger, this.module);
            }
            case 14: {
                return new SatPersistenceUserHandler((SatPersistence)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'AmFm'").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmHandlerFactory == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmHandlerFactory = AmFmHandlerFactory.class$("de.vw.mib.asl.amfm.persistence.AmFmHandlerFactory")) : class$de$vw$mib$asl$amfm$persistence$AmFmHandlerFactory).desiredAssertionStatus();
    }
}


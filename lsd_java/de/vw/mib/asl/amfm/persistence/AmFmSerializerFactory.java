/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettingsSerializer;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.ComponentPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.DabPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsSerializer;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.SatImageSerializer;
import de.vw.mib.asl.amfm.persistence.SatPersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.ServicePersistenceSerializer;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistenceSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;

class AmFmSerializerFactory
implements PersistableSerializerFactory {
    AmFmSerializerFactory() {
    }

    @Override
    public PersistableSerializer createSerializer(int n) {
        switch (n) {
            case 1: {
                return new RadioAmFmSettingsSerializer(this);
            }
            case 2: {
                return new AmFmStationPersistenceSerializer(this);
            }
            case 3: {
                return new AmFmPresetPersistenceSerializer(this);
            }
            case 4: {
                return new ResourceLocatorPersistenceSerializer(this);
            }
            case 5: {
                return new AmFmPresetSettingsSerializer(this);
            }
            case 6: {
                return new AmFmFixedStationListPersistenceSerializer(this);
            }
            case 7: {
                return new AmFmFixedStationPersistenceSerializer(this);
            }
            case 8: {
                return new DabPersistenceSerializer(this);
            }
            case 9: {
                return new FrequencyPersistenceSerializer(this);
            }
            case 10: {
                return new EnsemblePersistenceSerializer(this);
            }
            case 11: {
                return new ServicePersistenceSerializer(this);
            }
            case 12: {
                return new ComponentPersistenceSerializer(this);
            }
            case 13: {
                return new DabPresetPersistenceSerializer(this);
            }
            case 14: {
                return new SatPersistenceSerializer(this);
            }
            case 15: {
                return new StationInfoPersistenceSerializer(this);
            }
            case 16: {
                return new SatImageSerializer(this);
            }
        }
        throw new PersistenceException("The persistable ID 'persistableId' is unknown in the module AmFm");
    }
}


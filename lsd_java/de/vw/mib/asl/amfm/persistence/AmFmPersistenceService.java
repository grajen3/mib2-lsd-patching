/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.SatImage;
import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;

public interface AmFmPersistenceService
extends ModulePersistenceService {
    default public RadioAmFmSettings loadRadioAmFmSettings() {
    }

    default public AmFmPresetSettings loadAmFmPresetSettings() {
    }

    default public AmFmFixedStationListPersistence loadAmFmFixedStationListPersistence() {
    }

    default public DabPersistence loadDabPersistence() {
    }

    default public SatPersistence loadSatPersistence() {
    }

    default public RadioAmFmSettings createRadioAmFmSettings() {
    }

    default public AmFmStationPersistence createAmFmStationPersistence() {
    }

    default public AmFmPresetPersistence createAmFmPresetPersistence() {
    }

    default public ResourceLocatorPersistence createResourceLocatorPersistence() {
    }

    default public AmFmPresetSettings createAmFmPresetSettings() {
    }

    default public AmFmFixedStationListPersistence createAmFmFixedStationListPersistence() {
    }

    default public AmFmFixedStationPersistence createAmFmFixedStationPersistence() {
    }

    default public DabPersistence createDabPersistence() {
    }

    default public FrequencyPersistence createFrequencyPersistence() {
    }

    default public EnsemblePersistence createEnsemblePersistence() {
    }

    default public ServicePersistence createServicePersistence() {
    }

    default public ComponentPersistence createComponentPersistence() {
    }

    default public DabPresetPersistence createDabPresetPersistence() {
    }

    default public SatPersistence createSatPersistence() {
    }

    default public StationInfoPersistence createStationInfoPersistence() {
    }

    default public SatImage createSatImage() {
    }
}


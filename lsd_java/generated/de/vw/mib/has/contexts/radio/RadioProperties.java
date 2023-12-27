/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.radio;

import de.vw.mib.has.HASContextProperties;
import generated.de.vw.mib.has.containers.RadioBandsContainer;
import generated.de.vw.mib.has.containers.RadioFrequencyRangesContainer;
import generated.de.vw.mib.has.containers.RadioPresetsContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.RadioStationsContainer;
import generated.de.vw.mib.has.containers.RadioTextContainer;
import generated.de.vw.mib.has.containers.TrafficAnnouncementContainer;

public interface RadioProperties
extends HASContextProperties {
    default public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
    }

    default public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    default public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    default public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    default public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
    }

    default public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
    }

    default public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
    }

    default public void updateRadioText(RadioTextContainer radioTextContainer) {
    }
}


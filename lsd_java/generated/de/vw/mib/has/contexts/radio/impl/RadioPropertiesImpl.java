/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.radio.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.RadioBandsContainer;
import generated.de.vw.mib.has.containers.RadioFrequencyRangesContainer;
import generated.de.vw.mib.has.containers.RadioPresetsContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.RadioStationsContainer;
import generated.de.vw.mib.has.containers.RadioTextContainer;
import generated.de.vw.mib.has.containers.TrafficAnnouncementContainer;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;
import generated.de.vw.mib.has.contexts.radio.RadioProperties;

public class RadioPropertiesImpl
extends AbstractContextProperties
implements RadioProperties {
    public RadioPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
        this.updateProperty(28, radioBandsContainer);
    }

    @Override
    public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
        this.updateProperty(31, radioStationsContainer);
    }

    @Override
    public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
        this.updateProperty(32, radioStationsContainer);
    }

    @Override
    public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
        this.updateProperty(33, radioStationsContainer);
    }

    @Override
    public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
        this.updateProperty(34, radioStationsContainer);
    }

    @Override
    public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
        this.updateProperty(35, radioStationsContainer);
    }

    @Override
    public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
        this.updateProperty(36, radioPresetsContainer);
    }

    @Override
    public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
        this.updateProperty(37, radioPresetsContainer);
    }

    @Override
    public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
        this.updateProperty(38, radioPresetsContainer);
    }

    @Override
    public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
        this.updateProperty(39, radioStationInfoContainer);
    }

    @Override
    public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
        this.updateProperty(40, radioFrequencyRangesContainer);
    }

    @Override
    public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
        this.updateProperty(48, trafficAnnouncementContainer);
    }

    @Override
    public void updateRadioText(RadioTextContainer radioTextContainer) {
        this.updateProperty(49, radioTextContainer);
    }
}


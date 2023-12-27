/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers;

import de.vw.mib.has.HASContainer;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.AppConnectDeviceContainer;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.containers.ContextStateContainer;
import generated.de.vw.mib.has.containers.ContextStatesContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;
import generated.de.vw.mib.has.containers.GuidanceRemainingContainer;
import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.ImportGPXResultContainer;
import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.containers.LastDestinationsContainer;
import generated.de.vw.mib.has.containers.ListPageDataContainer;
import generated.de.vw.mib.has.containers.ListPageRequestContainer;
import generated.de.vw.mib.has.containers.ListStateContainer;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;
import generated.de.vw.mib.has.containers.MediaPlayInfoContainer;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.MediaSourceStateContainer;
import generated.de.vw.mib.has.containers.MediaSourcesContainer;
import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.containers.RadioBandsContainer;
import generated.de.vw.mib.has.containers.RadioFrequencyContainer;
import generated.de.vw.mib.has.containers.RadioFrequencyRangesContainer;
import generated.de.vw.mib.has.containers.RadioPresetContainer;
import generated.de.vw.mib.has.containers.RadioPresetIndexContainer;
import generated.de.vw.mib.has.containers.RadioPresetsContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.RadioStationsContainer;
import generated.de.vw.mib.has.containers.RadioTextContainer;
import generated.de.vw.mib.has.containers.SoundVolumeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangesContainer;
import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;
import generated.de.vw.mib.has.containers.ThinkBlueDataContainer;
import generated.de.vw.mib.has.containers.ThinkBlueEventContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.containers.TrackPositionContainer;
import generated.de.vw.mib.has.containers.TrafficAnnouncementContainer;
import generated.de.vw.mib.has.containers.VehicleStateContainer;
import generated.de.vw.mib.has.containers.VehicleStatesContainer;

public interface ContainerFactory {
    default public HASContainer createContainer(int n) {
    }

    default public ContextStateContainer createContextStateContainer() {
    }

    default public ContextStatesContainer createContextStatesContainer() {
    }

    default public ListStateContainer createListStateContainer() {
    }

    default public ListPageRequestContainer createListPageRequestContainer() {
    }

    default public ListPageDataContainer createListPageDataContainer() {
    }

    default public AddressContainer createAddressContainer() {
    }

    default public ContactContainer createContactContainer() {
    }

    default public DisplayDimensionContainer createDisplayDimensionContainer() {
    }

    default public MediaBrowserEntryContainer createMediaBrowserEntryContainer() {
    }

    default public TrackInfoContainer createTrackInfoContainer() {
    }

    default public MediaPlayInfoContainer createMediaPlayInfoContainer() {
    }

    default public MediaPlayModeContainer createMediaPlayModeContainer() {
    }

    default public GuidanceRemainingContainer createGuidanceRemainingContainer() {
    }

    default public RadioStationInfoContainer createRadioStationInfoContainer() {
    }

    default public SoundVolumeContainer createSoundVolumeContainer() {
    }

    default public SoundVolumeRangeContainer createSoundVolumeRangeContainer() {
    }

    default public SoundVolumeRangesContainer createSoundVolumeRangesContainer() {
    }

    default public RadioBandContainer createRadioBandContainer() {
    }

    default public TrackPositionContainer createTrackPositionContainer() {
    }

    default public MediaSourceStateContainer createMediaSourceStateContainer() {
    }

    default public MediaSourcesContainer createMediaSourcesContainer() {
    }

    default public MediaSourceContainer createMediaSourceContainer() {
    }

    default public RadioBandsContainer createRadioBandsContainer() {
    }

    default public LastDestinationContainer createLastDestinationContainer() {
    }

    default public LastDestinationsContainer createLastDestinationsContainer() {
    }

    default public RadioStationsContainer createRadioStationsContainer() {
    }

    default public RadioPresetContainer createRadioPresetContainer() {
    }

    default public RadioPresetsContainer createRadioPresetsContainer() {
    }

    default public RadioFrequencyRangesContainer createRadioFrequencyRangesContainer() {
    }

    default public RadioFrequencyContainer createRadioFrequencyContainer() {
    }

    default public ThinkBlueDataContainer createThinkBlueDataContainer() {
    }

    default public RadioPresetIndexContainer createRadioPresetIndexContainer() {
    }

    default public BalanceFaderContainer createBalanceFaderContainer() {
    }

    default public BalanceFaderRangesContainer createBalanceFaderRangesContainer() {
    }

    default public MediaBrowserPathContainer createMediaBrowserPathContainer() {
    }

    default public TrafficAnnouncementContainer createTrafficAnnouncementContainer() {
    }

    default public RadioTextContainer createRadioTextContainer() {
    }

    default public EncodedVehicleTypeContainer createEncodedVehicleTypeContainer() {
    }

    default public ThinkBlueEventContainer createThinkBlueEventContainer() {
    }

    default public ImportGPXDataContainer createImportGPXDataContainer() {
    }

    default public ImportGPXResultContainer createImportGPXResultContainer() {
    }

    default public VehicleStateContainer createVehicleStateContainer() {
    }

    default public VehicleStatesContainer createVehicleStatesContainer() {
    }

    default public AppConnectDeviceContainer createAppConnectDeviceContainer() {
    }

    default public MediaCapabilitiesContainer createMediaCapabilitiesContainer() {
    }

    default public StartGuidanceResultContainer createStartGuidanceResultContainer() {
    }

    default public AmbientLightContainer createAmbientLightContainer() {
    }
}


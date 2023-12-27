/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.AppConnectDeviceContainer;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.containers.ContainerFactory;
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
import generated.de.vw.mib.has.containers.impl.AddressContainerImpl;
import generated.de.vw.mib.has.containers.impl.AmbientLightContainerImpl;
import generated.de.vw.mib.has.containers.impl.AppConnectDeviceContainerImpl;
import generated.de.vw.mib.has.containers.impl.BalanceFaderContainerImpl;
import generated.de.vw.mib.has.containers.impl.BalanceFaderRangesContainerImpl;
import generated.de.vw.mib.has.containers.impl.ContactContainerImpl;
import generated.de.vw.mib.has.containers.impl.ContextStateContainerImpl;
import generated.de.vw.mib.has.containers.impl.ContextStatesContainerImpl;
import generated.de.vw.mib.has.containers.impl.DisplayDimensionContainerImpl;
import generated.de.vw.mib.has.containers.impl.EncodedVehicleTypeContainerImpl;
import generated.de.vw.mib.has.containers.impl.GuidanceRemainingContainerImpl;
import generated.de.vw.mib.has.containers.impl.ImportGPXDataContainerImpl;
import generated.de.vw.mib.has.containers.impl.ImportGPXResultContainerImpl;
import generated.de.vw.mib.has.containers.impl.LastDestinationContainerImpl;
import generated.de.vw.mib.has.containers.impl.LastDestinationsContainerImpl;
import generated.de.vw.mib.has.containers.impl.ListPageDataContainerImpl;
import generated.de.vw.mib.has.containers.impl.ListPageRequestContainerImpl;
import generated.de.vw.mib.has.containers.impl.ListStateContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaBrowserEntryContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaBrowserPathContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaCapabilitiesContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaPlayInfoContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaPlayModeContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaSourceContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaSourceStateContainerImpl;
import generated.de.vw.mib.has.containers.impl.MediaSourcesContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioBandContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioBandsContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioFrequencyContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioFrequencyRangesContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioPresetContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioPresetIndexContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioPresetsContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioStationInfoContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioStationsContainerImpl;
import generated.de.vw.mib.has.containers.impl.RadioTextContainerImpl;
import generated.de.vw.mib.has.containers.impl.SoundVolumeContainerImpl;
import generated.de.vw.mib.has.containers.impl.SoundVolumeRangeContainerImpl;
import generated.de.vw.mib.has.containers.impl.SoundVolumeRangesContainerImpl;
import generated.de.vw.mib.has.containers.impl.StartGuidanceResultContainerImpl;
import generated.de.vw.mib.has.containers.impl.ThinkBlueDataContainerImpl;
import generated.de.vw.mib.has.containers.impl.ThinkBlueEventContainerImpl;
import generated.de.vw.mib.has.containers.impl.TrackInfoContainerImpl;
import generated.de.vw.mib.has.containers.impl.TrackPositionContainerImpl;
import generated.de.vw.mib.has.containers.impl.TrafficAnnouncementContainerImpl;
import generated.de.vw.mib.has.containers.impl.VehicleStateContainerImpl;
import generated.de.vw.mib.has.containers.impl.VehicleStatesContainerImpl;

public final class ContainerFactoryImpl
implements ContainerFactory {
    @Override
    public HASContainer createContainer(int n) {
        HASContainer hASContainer;
        switch (n) {
            case 0x1000000: {
                hASContainer = this.createContextStateContainer();
                break;
            }
            case 0x1000001: {
                hASContainer = this.createContextStatesContainer();
                break;
            }
            case 0x1000002: {
                hASContainer = this.createListStateContainer();
                break;
            }
            case 0x1000003: {
                hASContainer = this.createListPageRequestContainer();
                break;
            }
            case 0x1000004: {
                hASContainer = this.createListPageDataContainer();
                break;
            }
            case 1: {
                hASContainer = this.createAddressContainer();
                break;
            }
            case 8: {
                hASContainer = this.createContactContainer();
                break;
            }
            case 13: {
                hASContainer = this.createDisplayDimensionContainer();
                break;
            }
            case 21: {
                hASContainer = this.createMediaBrowserEntryContainer();
                break;
            }
            case 22: {
                hASContainer = this.createTrackInfoContainer();
                break;
            }
            case 23: {
                hASContainer = this.createMediaPlayInfoContainer();
                break;
            }
            case 24: {
                hASContainer = this.createMediaPlayModeContainer();
                break;
            }
            case 25: {
                hASContainer = this.createGuidanceRemainingContainer();
                break;
            }
            case 26: {
                hASContainer = this.createRadioStationInfoContainer();
                break;
            }
            case 27: {
                hASContainer = this.createSoundVolumeContainer();
                break;
            }
            case 28: {
                hASContainer = this.createSoundVolumeRangeContainer();
                break;
            }
            case 29: {
                hASContainer = this.createSoundVolumeRangesContainer();
                break;
            }
            case 30: {
                hASContainer = this.createRadioBandContainer();
                break;
            }
            case 31: {
                hASContainer = this.createTrackPositionContainer();
                break;
            }
            case 32: {
                hASContainer = this.createMediaSourceStateContainer();
                break;
            }
            case 33: {
                hASContainer = this.createMediaSourcesContainer();
                break;
            }
            case 34: {
                hASContainer = this.createMediaSourceContainer();
                break;
            }
            case 35: {
                hASContainer = this.createRadioBandsContainer();
                break;
            }
            case 36: {
                hASContainer = this.createLastDestinationContainer();
                break;
            }
            case 37: {
                hASContainer = this.createLastDestinationsContainer();
                break;
            }
            case 39: {
                hASContainer = this.createRadioStationsContainer();
                break;
            }
            case 40: {
                hASContainer = this.createRadioPresetContainer();
                break;
            }
            case 41: {
                hASContainer = this.createRadioPresetsContainer();
                break;
            }
            case 42: {
                hASContainer = this.createRadioFrequencyRangesContainer();
                break;
            }
            case 43: {
                hASContainer = this.createRadioFrequencyContainer();
                break;
            }
            case 44: {
                hASContainer = this.createThinkBlueDataContainer();
                break;
            }
            case 45: {
                hASContainer = this.createRadioPresetIndexContainer();
                break;
            }
            case 48: {
                hASContainer = this.createBalanceFaderContainer();
                break;
            }
            case 49: {
                hASContainer = this.createBalanceFaderRangesContainer();
                break;
            }
            case 50: {
                hASContainer = this.createMediaBrowserPathContainer();
                break;
            }
            case 51: {
                hASContainer = this.createTrafficAnnouncementContainer();
                break;
            }
            case 52: {
                hASContainer = this.createRadioTextContainer();
                break;
            }
            case 53: {
                hASContainer = this.createEncodedVehicleTypeContainer();
                break;
            }
            case 54: {
                hASContainer = this.createThinkBlueEventContainer();
                break;
            }
            case 59: {
                hASContainer = this.createImportGPXDataContainer();
                break;
            }
            case 60: {
                hASContainer = this.createImportGPXResultContainer();
                break;
            }
            case 62: {
                hASContainer = this.createVehicleStateContainer();
                break;
            }
            case 63: {
                hASContainer = this.createVehicleStatesContainer();
                break;
            }
            case 64: {
                hASContainer = this.createAppConnectDeviceContainer();
                break;
            }
            case 66: {
                hASContainer = this.createMediaCapabilitiesContainer();
                break;
            }
            case 67: {
                hASContainer = this.createStartGuidanceResultContainer();
                break;
            }
            case 68: {
                hASContainer = this.createAmbientLightContainer();
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("No complex container with id ").append(n).toString());
            }
        }
        return hASContainer;
    }

    @Override
    public ContextStateContainer createContextStateContainer() {
        return new ContextStateContainerImpl();
    }

    @Override
    public ContextStatesContainer createContextStatesContainer() {
        return new ContextStatesContainerImpl();
    }

    @Override
    public ListStateContainer createListStateContainer() {
        return new ListStateContainerImpl();
    }

    @Override
    public ListPageRequestContainer createListPageRequestContainer() {
        return new ListPageRequestContainerImpl();
    }

    @Override
    public ListPageDataContainer createListPageDataContainer() {
        return new ListPageDataContainerImpl();
    }

    @Override
    public AddressContainer createAddressContainer() {
        return new AddressContainerImpl();
    }

    @Override
    public ContactContainer createContactContainer() {
        return new ContactContainerImpl();
    }

    @Override
    public DisplayDimensionContainer createDisplayDimensionContainer() {
        return new DisplayDimensionContainerImpl();
    }

    @Override
    public MediaBrowserEntryContainer createMediaBrowserEntryContainer() {
        return new MediaBrowserEntryContainerImpl();
    }

    @Override
    public TrackInfoContainer createTrackInfoContainer() {
        return new TrackInfoContainerImpl();
    }

    @Override
    public MediaPlayInfoContainer createMediaPlayInfoContainer() {
        return new MediaPlayInfoContainerImpl();
    }

    @Override
    public MediaPlayModeContainer createMediaPlayModeContainer() {
        return new MediaPlayModeContainerImpl();
    }

    @Override
    public GuidanceRemainingContainer createGuidanceRemainingContainer() {
        return new GuidanceRemainingContainerImpl();
    }

    @Override
    public RadioStationInfoContainer createRadioStationInfoContainer() {
        return new RadioStationInfoContainerImpl();
    }

    @Override
    public SoundVolumeContainer createSoundVolumeContainer() {
        return new SoundVolumeContainerImpl();
    }

    @Override
    public SoundVolumeRangeContainer createSoundVolumeRangeContainer() {
        return new SoundVolumeRangeContainerImpl();
    }

    @Override
    public SoundVolumeRangesContainer createSoundVolumeRangesContainer() {
        return new SoundVolumeRangesContainerImpl();
    }

    @Override
    public RadioBandContainer createRadioBandContainer() {
        return new RadioBandContainerImpl();
    }

    @Override
    public TrackPositionContainer createTrackPositionContainer() {
        return new TrackPositionContainerImpl();
    }

    @Override
    public MediaSourceStateContainer createMediaSourceStateContainer() {
        return new MediaSourceStateContainerImpl();
    }

    @Override
    public MediaSourcesContainer createMediaSourcesContainer() {
        return new MediaSourcesContainerImpl();
    }

    @Override
    public MediaSourceContainer createMediaSourceContainer() {
        return new MediaSourceContainerImpl();
    }

    @Override
    public RadioBandsContainer createRadioBandsContainer() {
        return new RadioBandsContainerImpl();
    }

    @Override
    public LastDestinationContainer createLastDestinationContainer() {
        return new LastDestinationContainerImpl();
    }

    @Override
    public LastDestinationsContainer createLastDestinationsContainer() {
        return new LastDestinationsContainerImpl();
    }

    @Override
    public RadioStationsContainer createRadioStationsContainer() {
        return new RadioStationsContainerImpl();
    }

    @Override
    public RadioPresetContainer createRadioPresetContainer() {
        return new RadioPresetContainerImpl();
    }

    @Override
    public RadioPresetsContainer createRadioPresetsContainer() {
        return new RadioPresetsContainerImpl();
    }

    @Override
    public RadioFrequencyRangesContainer createRadioFrequencyRangesContainer() {
        return new RadioFrequencyRangesContainerImpl();
    }

    @Override
    public RadioFrequencyContainer createRadioFrequencyContainer() {
        return new RadioFrequencyContainerImpl();
    }

    @Override
    public ThinkBlueDataContainer createThinkBlueDataContainer() {
        return new ThinkBlueDataContainerImpl();
    }

    @Override
    public RadioPresetIndexContainer createRadioPresetIndexContainer() {
        return new RadioPresetIndexContainerImpl();
    }

    @Override
    public BalanceFaderContainer createBalanceFaderContainer() {
        return new BalanceFaderContainerImpl();
    }

    @Override
    public BalanceFaderRangesContainer createBalanceFaderRangesContainer() {
        return new BalanceFaderRangesContainerImpl();
    }

    @Override
    public MediaBrowserPathContainer createMediaBrowserPathContainer() {
        return new MediaBrowserPathContainerImpl();
    }

    @Override
    public TrafficAnnouncementContainer createTrafficAnnouncementContainer() {
        return new TrafficAnnouncementContainerImpl();
    }

    @Override
    public RadioTextContainer createRadioTextContainer() {
        return new RadioTextContainerImpl();
    }

    @Override
    public EncodedVehicleTypeContainer createEncodedVehicleTypeContainer() {
        return new EncodedVehicleTypeContainerImpl();
    }

    @Override
    public ThinkBlueEventContainer createThinkBlueEventContainer() {
        return new ThinkBlueEventContainerImpl();
    }

    @Override
    public ImportGPXDataContainer createImportGPXDataContainer() {
        return new ImportGPXDataContainerImpl();
    }

    @Override
    public ImportGPXResultContainer createImportGPXResultContainer() {
        return new ImportGPXResultContainerImpl();
    }

    @Override
    public VehicleStateContainer createVehicleStateContainer() {
        return new VehicleStateContainerImpl();
    }

    @Override
    public VehicleStatesContainer createVehicleStatesContainer() {
        return new VehicleStatesContainerImpl();
    }

    @Override
    public AppConnectDeviceContainer createAppConnectDeviceContainer() {
        return new AppConnectDeviceContainerImpl();
    }

    @Override
    public MediaCapabilitiesContainer createMediaCapabilitiesContainer() {
        return new MediaCapabilitiesContainerImpl();
    }

    @Override
    public StartGuidanceResultContainer createStartGuidanceResultContainer() {
        return new StartGuidanceResultContainerImpl();
    }

    @Override
    public AmbientLightContainer createAmbientLightContainer() {
        return new AmbientLightContainerImpl();
    }
}


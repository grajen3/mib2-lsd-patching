/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has;

import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.has.HASClient;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.has.HASListRequest;
import generated.de.vw.mib.has.HASListRequestImpl;
import generated.de.vw.mib.has.containers.ListPageRequestContainer;
import generated.de.vw.mib.has.containers.impl.AddressContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.AmbientLightContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.AppConnectDeviceContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.BalanceFaderContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.BalanceFaderRangesContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ContactContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ContainerFactoryImpl;
import generated.de.vw.mib.has.containers.impl.ContextStateContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ContextStatesContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.DisplayDimensionContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.EncodedVehicleTypeContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.GuidanceRemainingContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ImportGPXDataContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ImportGPXResultContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.LastDestinationContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.LastDestinationsContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ListPageDataContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ListPageRequestContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ListStateContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaBrowserEntryContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaBrowserPathContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaCapabilitiesContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaPlayInfoContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaPlayModeContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaSourceContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaSourceStateContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.MediaSourcesContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioBandContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioBandsContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioFrequencyContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioFrequencyRangesContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioPresetContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioPresetIndexContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioPresetsContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioStationInfoContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioStationsContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.RadioTextContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.SoundVolumeContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.SoundVolumeRangeContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.SoundVolumeRangesContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.StartGuidanceResultContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ThinkBlueDataContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.ThinkBlueEventContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.TrackInfoContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.TrackPositionContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.TrafficAnnouncementContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.VehicleStateContainerMarshaller;
import generated.de.vw.mib.has.containers.impl.VehicleStatesContainerMarshaller;

public final class HASFactoryImpl
implements HASFactory {
    private static final HASClient[] CLIENTS = new HASClient[]{new HASClient(0, "EXLAP", true), new HASClient(1, "OnlineServices", false), new HASClient(5, "HMISDK", false)};
    public static final String VERSION;
    private final IntObjectOptHashMap marshallers = new IntObjectOptHashMap();
    private final ContainerFactoryImpl containerFactory = new ContainerFactoryImpl();
    private HASEngineAPI engine;

    @Override
    public void setEngine(HASEngineAPI hASEngineAPI) {
        this.engine = hASEngineAPI;
    }

    @Override
    public HASContainer createContainer(int n) {
        return this.containerFactory.createContainer(n);
    }

    @Override
    public Object getContainerFactory() {
        return this.containerFactory;
    }

    @Override
    public synchronized HASContainerMarshaller createContainerMarshaller(int n) {
        HASContainerMarshaller hASContainerMarshaller = (HASContainerMarshaller)this.marshallers.get(n);
        if (null == hASContainerMarshaller) {
            int n2;
            switch (n) {
                case 0x1000000: {
                    hASContainerMarshaller = new ContextStateContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 0x1000001: {
                    hASContainerMarshaller = new ContextStatesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 0x1000002: {
                    hASContainerMarshaller = new ListStateContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 0x1000003: {
                    hASContainerMarshaller = new ListPageRequestContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 0x1000004: {
                    hASContainerMarshaller = new ListPageDataContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 1: {
                    hASContainerMarshaller = new AddressContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 2: {
                    n2 = 11;
                    break;
                }
                case 3: {
                    n2 = 12;
                    break;
                }
                case 4: {
                    n2 = 13;
                    break;
                }
                case 5: {
                    n2 = 14;
                    break;
                }
                case 6: {
                    n2 = 15;
                    break;
                }
                case 7: {
                    n2 = 16;
                    break;
                }
                case 8: {
                    hASContainerMarshaller = new ContactContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 9: {
                    n2 = 20;
                    break;
                }
                case 10: {
                    n2 = 22;
                    break;
                }
                case 11: {
                    n2 = 23;
                    break;
                }
                case 12: {
                    n2 = 24;
                    break;
                }
                case 13: {
                    hASContainerMarshaller = new DisplayDimensionContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 14: {
                    n2 = 27;
                    break;
                }
                case 15: {
                    n2 = 28;
                    break;
                }
                case 16: {
                    n2 = 29;
                    break;
                }
                case 17: {
                    n2 = 30;
                    break;
                }
                case 18: {
                    n2 = 31;
                    break;
                }
                case 19: {
                    n2 = 32;
                    break;
                }
                case 20: {
                    n2 = 33;
                    break;
                }
                case 21: {
                    hASContainerMarshaller = new MediaBrowserEntryContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 22: {
                    hASContainerMarshaller = new TrackInfoContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 23: {
                    hASContainerMarshaller = new MediaPlayInfoContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 24: {
                    hASContainerMarshaller = new MediaPlayModeContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 25: {
                    hASContainerMarshaller = new GuidanceRemainingContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 26: {
                    hASContainerMarshaller = new RadioStationInfoContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 27: {
                    hASContainerMarshaller = new SoundVolumeContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 28: {
                    hASContainerMarshaller = new SoundVolumeRangeContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 29: {
                    hASContainerMarshaller = new SoundVolumeRangesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 30: {
                    hASContainerMarshaller = new RadioBandContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 31: {
                    hASContainerMarshaller = new TrackPositionContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 32: {
                    hASContainerMarshaller = new MediaSourceStateContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 33: {
                    hASContainerMarshaller = new MediaSourcesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 34: {
                    hASContainerMarshaller = new MediaSourceContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 35: {
                    hASContainerMarshaller = new RadioBandsContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 36: {
                    hASContainerMarshaller = new LastDestinationContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 37: {
                    hASContainerMarshaller = new LastDestinationsContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 38: {
                    n2 = 77;
                    break;
                }
                case 39: {
                    hASContainerMarshaller = new RadioStationsContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 40: {
                    hASContainerMarshaller = new RadioPresetContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 41: {
                    hASContainerMarshaller = new RadioPresetsContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 42: {
                    hASContainerMarshaller = new RadioFrequencyRangesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 43: {
                    hASContainerMarshaller = new RadioFrequencyContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 44: {
                    hASContainerMarshaller = new ThinkBlueDataContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 45: {
                    hASContainerMarshaller = new RadioPresetIndexContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 46: {
                    n2 = 102;
                    break;
                }
                case 47: {
                    n2 = 103;
                    break;
                }
                case 48: {
                    hASContainerMarshaller = new BalanceFaderContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 49: {
                    hASContainerMarshaller = new BalanceFaderRangesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 50: {
                    hASContainerMarshaller = new MediaBrowserPathContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 51: {
                    hASContainerMarshaller = new TrafficAnnouncementContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 52: {
                    hASContainerMarshaller = new RadioTextContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 53: {
                    hASContainerMarshaller = new EncodedVehicleTypeContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 54: {
                    hASContainerMarshaller = new ThinkBlueEventContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 59: {
                    hASContainerMarshaller = new ImportGPXDataContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 60: {
                    hASContainerMarshaller = new ImportGPXResultContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 62: {
                    hASContainerMarshaller = new VehicleStateContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 63: {
                    hASContainerMarshaller = new VehicleStatesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 64: {
                    hASContainerMarshaller = new AppConnectDeviceContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 65: {
                    n2 = 150;
                    break;
                }
                case 66: {
                    hASContainerMarshaller = new MediaCapabilitiesContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 67: {
                    hASContainerMarshaller = new StartGuidanceResultContainerMarshaller();
                    n2 = -1;
                    break;
                }
                case 68: {
                    hASContainerMarshaller = new AmbientLightContainerMarshaller();
                    n2 = -1;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("Illegal containerId ").append(n).toString());
                }
            }
            if (null == hASContainerMarshaller) {
                hASContainerMarshaller = this.engine.createBaseContainerMarshaller(n, n2);
            }
            this.marshallers.put(n, hASContainerMarshaller);
        }
        return hASContainerMarshaller;
    }

    @Override
    public HASListRequest createListRequest(int n, HASInvocation hASInvocation) {
        int n2 = ((ListPageRequestContainer)hASInvocation.getArgument()).getOffset();
        HASListRequestImpl hASListRequestImpl = new HASListRequestImpl(this.containerFactory.createListPageDataContainer(), n, hASInvocation.getActionId(), hASInvocation.getContext().getResultsImpl());
        hASListRequestImpl.setOffset(n2);
        return hASListRequestImpl;
    }

    @Override
    public HASClient[] getClients() {
        return CLIENTS;
    }

    @Override
    public String getVersion() {
        return "1.5.3";
    }
}


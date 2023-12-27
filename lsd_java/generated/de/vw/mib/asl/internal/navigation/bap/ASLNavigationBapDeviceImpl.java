/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapAddressListTransformer;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapFavoriteDestTransformer;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapLaneGuidanceTransformer;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapLastDestTransformer;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapManeuverDescriptorTransformer;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapNavBookTransformer;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTMCinfoTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapCompassInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapCompassInfoTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapCurrentAltitudeCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapCurrentAltitudeTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDestinationInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDestinationInfoTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDistanceToDestinationCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDistanceToDestinationTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDistanceToNextManeuverCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDistanceToNextManeuverTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapMapScaleCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapMapScaleTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapNavBookSpellerResultCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapNavBookSpellerResultTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapOnlineNavigationStateCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapOnlineNavigationStateTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapRemainingTravelTimeCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapRemainingTravelTimeTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapStopoverInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapStopoverInfoTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapOrientationsCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapOrientationsTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapTypesCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapTypesTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapViewsCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapSupportedMapViewsTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTimeToDestinationCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTimeToDestinationTransformer;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTurnToInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTurnToInfoTransformer;

public final class ASLNavigationBapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationBapDeviceImpl INSTANCE = new ASLNavigationBapDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(22);
    private ASLListFactory listFactory;

    private ASLNavigationBapDeviceImpl() {
    }

    public static ASLNavigationBapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Bap";
    }

    @Override
    public int getTargetId() {
        return 10038;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(739, this);
        aSLListRegistry.registerASLDevice(740, this);
        aSLListRegistry.registerASLDevice(741, this);
        aSLListRegistry.registerASLDevice(742, this);
        aSLListRegistry.registerASLDevice(743, this);
        aSLListRegistry.registerASLDevice(744, this);
        aSLListRegistry.registerASLDevice(745, this);
        aSLListRegistry.registerASLDevice(746, this);
        aSLListRegistry.registerASLDevice(747, this);
        aSLListRegistry.registerASLDevice(748, this);
        aSLListRegistry.registerASLDevice(749, this);
        aSLListRegistry.registerASLDevice(753930240, this);
        aSLListRegistry.registerASLDevice(750, this);
        aSLListRegistry.registerASLDevice(751, this);
        aSLListRegistry.registerASLDevice(3795, this);
        aSLListRegistry.registerASLDevice(3796, this);
        aSLListRegistry.registerASLDevice(3797, this);
        aSLListRegistry.registerASLDevice(3798, this);
        aSLListRegistry.registerASLDevice(3799, this);
        aSLListRegistry.registerASLDevice(3800, this);
        aSLListRegistry.registerASLDevice(3801, this);
        aSLListRegistry.registerASLDevice(3802, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1341521856, 10038);
        serviceRegister.registerService(-1324744640, 10038);
        serviceRegister.registerService(-1307967424, 10038);
        serviceRegister.registerService(-1291190208, 10038);
        serviceRegister.registerService(-1274412992, 10038);
        serviceRegister.registerService(-1107230656, 10038);
        serviceRegister.registerService(-1090453440, 10038);
        serviceRegister.registerService(-1073676224, 10038);
        serviceRegister.registerService(-1056899008, 10038);
        serviceRegister.registerService(-1040121792, 10038);
        serviceRegister.registerService(-1023344576, 10038);
        serviceRegister.registerService(-1006567360, 10038);
        serviceRegister.registerService(-989790144, 10038);
        serviceRegister.registerService(-973012928, 10038);
        serviceRegister.registerService(-956235712, 10038);
        serviceRegister.registerService(-939458496, 10038);
        serviceRegister.registerService(-922681280, 10038);
        serviceRegister.registerService(-905904064, 10038);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 739: {
                nArray = ListColumnsUtil.getSimpleIntArray(13);
                break;
            }
            case 740: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 741: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 742: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 743: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 744: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 745: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 746: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 747: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 748: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 749: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1110060: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 750: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 751: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3795: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3796: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3797: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3798: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3799: {
                nArray = ListColumnsUtil.getSimpleIntArray(9);
                break;
            }
            case 3800: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3801: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3802: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Bap: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLNavigationBapDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationBapDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 739: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapAddressListTransformer(), n, "Navigation.Bap", "addressList");
                break;
            }
            case 740: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapFavoriteDestTransformer(), n, "Navigation.Bap", "favoriteDest");
                break;
            }
            case 741: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapDistanceToNextManeuverTransformer(), n, "Navigation.Bap", "DistanceToNextManeuver");
                genericASLList.updateList(new NavigationBapDistanceToNextManeuverCollector[]{new NavigationBapDistanceToNextManeuverCollector()});
                break;
            }
            case 742: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapLaneGuidanceTransformer(), n, "Navigation.Bap", "LaneGuidance");
                break;
            }
            case 743: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapTMCinfoTransformer(), n, "Navigation.Bap", "TMCinfo");
                break;
            }
            case 744: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapTurnToInfoTransformer(), n, "Navigation.Bap", "TurnToInfo");
                genericASLList.updateList(new NavigationBapTurnToInfoCollector[]{new NavigationBapTurnToInfoCollector()});
                break;
            }
            case 745: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapLastDestTransformer(), n, "Navigation.Bap", "lastDest");
                break;
            }
            case 746: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapNavBookTransformer(), n, "Navigation.Bap", "navBook");
                break;
            }
            case 747: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapNavBookSpellerResultTransformer(), n, "Navigation.Bap", "navBookSpellerResult");
                genericASLList.updateList(new NavigationBapNavBookSpellerResultCollector[]{new NavigationBapNavBookSpellerResultCollector()});
                break;
            }
            case 748: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapCompassInfoTransformer(), n, "Navigation.Bap", "CompassInfo");
                genericASLList.updateList(new NavigationBapCompassInfoCollector[]{new NavigationBapCompassInfoCollector()});
                break;
            }
            case 749: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapDistanceToDestinationTransformer(), n, "Navigation.Bap", "DistanceToDestination");
                genericASLList.updateList(new NavigationBapDistanceToDestinationCollector[]{new NavigationBapDistanceToDestinationCollector()});
                break;
            }
            case 1110060: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapRemainingTravelTimeTransformer(), n, "Navigation.Bap", "RemainingTravelTime");
                genericASLList.updateList(new NavigationBapRemainingTravelTimeCollector[]{new NavigationBapRemainingTravelTimeCollector()});
                break;
            }
            case 750: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapTimeToDestinationTransformer(), n, "Navigation.Bap", "TimeToDestination");
                genericASLList.updateList(new NavigationBapTimeToDestinationCollector[]{new NavigationBapTimeToDestinationCollector()});
                break;
            }
            case 751: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapManeuverDescriptorTransformer(), n, "Navigation.Bap", "ManeuverDescriptor");
                break;
            }
            case 3795: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapSupportedMapTypesTransformer(), n, "Navigation.Bap", "SupportedMapTypes");
                genericASLList.updateList(new NavigationBapSupportedMapTypesCollector[]{new NavigationBapSupportedMapTypesCollector()});
                break;
            }
            case 3796: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapSupportedMapViewsTransformer(), n, "Navigation.Bap", "SupportedMapViews");
                genericASLList.updateList(new NavigationBapSupportedMapViewsCollector[]{new NavigationBapSupportedMapViewsCollector()});
                break;
            }
            case 3797: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapSupportedMapOrientationsTransformer(), n, "Navigation.Bap", "SupportedMapOrientations");
                genericASLList.updateList(new NavigationBapSupportedMapOrientationsCollector[]{new NavigationBapSupportedMapOrientationsCollector()});
                break;
            }
            case 3798: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapMapScaleTransformer(), n, "Navigation.Bap", "MapScale");
                genericASLList.updateList(new NavigationBapMapScaleCollector[]{new NavigationBapMapScaleCollector()});
                break;
            }
            case 3799: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapDestinationInfoTransformer(), n, "Navigation.Bap", "DestinationInfo");
                genericASLList.updateList(new NavigationBapDestinationInfoCollector[]{new NavigationBapDestinationInfoCollector()});
                break;
            }
            case 3800: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapStopoverInfoTransformer(), n, "Navigation.Bap", "StopoverInfo");
                genericASLList.updateList(new NavigationBapStopoverInfoCollector[]{new NavigationBapStopoverInfoCollector()});
                break;
            }
            case 3801: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapCurrentAltitudeTransformer(), n, "Navigation.Bap", "CurrentAltitude");
                genericASLList.updateList(new NavigationBapCurrentAltitudeCollector[]{new NavigationBapCurrentAltitudeCollector()});
                break;
            }
            case 3802: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBapOnlineNavigationStateTransformer(), n, "Navigation.Bap", "OnlineNavigationState");
                genericASLList.updateList(new NavigationBapOnlineNavigationStateCollector[]{new NavigationBapOnlineNavigationStateCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Bap: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


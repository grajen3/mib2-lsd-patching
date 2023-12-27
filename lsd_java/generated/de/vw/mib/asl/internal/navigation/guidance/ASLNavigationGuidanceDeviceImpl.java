/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.guidance;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceAlternativeRouteSegmentIconsTransformer;
import de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceCalculatedRouteDetailsTransformer;
import de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceVZEVZAIconsTransformer;
import de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceVZEVZAInfoTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceCalculationProgressesCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceCalculationProgressesTransformer;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceEstimatedTimeArivalCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceEstimatedTimeArivalTransformer;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceFinalDestinationInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceFinalDestinationInfoTransformer;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceGuidanceInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceGuidanceInfoTransformer;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceLaneGuidanceCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceLaneGuidanceTransformer;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceRouteListDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceSavedGuidanceInfoDetailCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceSavedGuidanceInfoDetailTransformer;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceStatusLineInformationCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceStatusLineInformationTransformer;

public final class ASLNavigationGuidanceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationGuidanceDeviceImpl INSTANCE = new ASLNavigationGuidanceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(12);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_GEN;

    private ASLNavigationGuidanceDeviceImpl() {
    }

    public static ASLNavigationGuidanceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Guidance";
    }

    @Override
    public int getTargetId() {
        return 10044;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(822, this);
        aSLListRegistry.registerASLDevice(823, this);
        aSLListRegistry.registerASLDevice(824, this);
        aSLListRegistry.registerASLDevice(825, this);
        aSLListRegistry.registerASLDevice(826, this);
        aSLListRegistry.registerASLDevice(827, this);
        aSLListRegistry.registerASLDevice(-101773312, this);
        aSLListRegistry.registerASLDevice(828, this);
        aSLListRegistry.registerASLDevice(829, this);
        aSLListRegistry.registerASLDevice(831, this);
        aSLListRegistry.registerASLDevice(833, this);
        aSLListRegistry.registerASLDevice(-2131750912, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1376256064, 10044);
        serviceRegister.registerService(100794432, 10044);
        serviceRegister.registerService(-855048128, 10044);
        serviceRegister.registerService(117571648, 10044);
        serviceRegister.registerService(134348864, 10044);
        serviceRegister.registerService(151126080, 10044);
        serviceRegister.registerService(167903296, 10044);
        serviceRegister.registerService(184680512, 10044);
        serviceRegister.registerService(201457728, 10044);
        serviceRegister.registerService(268566592, 10044);
        serviceRegister.registerService(285343808, 10044);
        serviceRegister.registerService(1959333952, 10044);
        serviceRegister.registerService(335675456, 10044);
        serviceRegister.registerService(352452672, 10044);
        serviceRegister.registerService(369229888, 10044);
        serviceRegister.registerService(386007104, 10044);
        serviceRegister.registerService(402784320, 10044);
        serviceRegister.registerService(419561536, 10044);
        serviceRegister.registerService(436338752, 10044);
        serviceRegister.registerService(453115968, 10044);
        serviceRegister.registerService(469893184, 10044);
        serviceRegister.registerService(-569835456, 10044);
        serviceRegister.registerService(520618048, 10044);
        serviceRegister.registerService(486670400, 10044);
        serviceRegister.registerService(503447616, 10044);
        serviceRegister.registerService(0x74070040, 10044);
        serviceRegister.registerService(520224832, 10044);
        serviceRegister.registerService(0x20020040, 10044);
        serviceRegister.registerService(1963393088, 10044);
        serviceRegister.registerService(553779264, 10044);
        serviceRegister.registerService(0x22020040, 10044);
        serviceRegister.registerService(1590235200, 10044);
        serviceRegister.registerService(587333696, 10044);
        serviceRegister.registerService(986255424, 10044);
        serviceRegister.registerService(1003032640, 10044);
        serviceRegister.registerService(1019809856, 10044);
        serviceRegister.registerService(1036587072, 10044);
        serviceRegister.registerService(0x24020040, 10044);
        serviceRegister.registerService(620888128, 10044);
        serviceRegister.registerService(637665344, 10044);
        serviceRegister.registerService(1090912320, 10044);
        serviceRegister.registerService(-536346560, 10044);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 822: {
                nArray = ListColumnsUtil.getIntArrayByBits(3711, 10);
                break;
            }
            case 823: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 824: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 825: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 826: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 827: {
                nArray = ListColumnsUtil.getIntArrayByBits(0xFFDFFFFFFL, 35);
                break;
            }
            case 1110009: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 828: {
                nArray = ListColumnsUtil.getSimpleIntArray(18);
                break;
            }
            case 829: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 831: {
                nArray = ListColumnsUtil.getSimpleIntArray(15);
                break;
            }
            case 833: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1110144: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Guidance: ").append(n).toString());
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
        return ASLNavigationGuidanceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationGuidanceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 822: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceCalculatedRouteDetailsTransformer(), n, "Navigation.Guidance", "CalculatedRouteDetails");
                break;
            }
            case 823: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceCalculationProgressesTransformer(), n, "Navigation.Guidance", "CalculationProgresses");
                genericASLList.updateList(new NavigationGuidanceCalculationProgressesCollector[]{new NavigationGuidanceCalculationProgressesCollector()});
                break;
            }
            case 824: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceAlternativeRouteSegmentIconsTransformer(), n, "Navigation.Guidance", "AlternativeRouteSegmentIcons");
                break;
            }
            case 825: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceStatusLineInformationTransformer(), n, "Navigation.Guidance", "StatusLineInformation");
                genericASLList.updateList(new NavigationGuidanceStatusLineInformationCollector[]{new NavigationGuidanceStatusLineInformationCollector()});
                break;
            }
            case 826: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceEstimatedTimeArivalTransformer(), n, "Navigation.Guidance", "EstimatedTimeArival");
                genericASLList.updateList(new NavigationGuidanceEstimatedTimeArivalCollector[]{new NavigationGuidanceEstimatedTimeArivalCollector()});
                break;
            }
            case 827: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceGuidanceInfoTransformer(), n, "Navigation.Guidance", "GuidanceInfo");
                genericASLList.updateList(new NavigationGuidanceGuidanceInfoCollector[]{new NavigationGuidanceGuidanceInfoCollector()});
                break;
            }
            case 1110009: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceFinalDestinationInfoTransformer(), n, "Navigation.Guidance", "FinalDestinationInfo");
                genericASLList.updateList(new NavigationGuidanceFinalDestinationInfoCollector[]{new NavigationGuidanceFinalDestinationInfoCollector()});
                break;
            }
            case 828: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceSavedGuidanceInfoDetailTransformer(), n, "Navigation.Guidance", "SavedGuidanceInfoDetail");
                genericASLList.updateList(new NavigationGuidanceSavedGuidanceInfoDetailCollector[]{new NavigationGuidanceSavedGuidanceInfoDetailCollector()});
                break;
            }
            case 829: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceLaneGuidanceTransformer(), n, "Navigation.Guidance", "LaneGuidance");
                genericASLList.updateList(new NavigationGuidanceLaneGuidanceCollector[]{new NavigationGuidanceLaneGuidanceCollector()});
                break;
            }
            case 831: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationGuidanceDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "RouteListDetails"), n, "Navigation.Guidance", "RouteListDetails");
                genericASLList.updateList(new NavigationGuidanceRouteListDetailsCollector[]{new NavigationGuidanceRouteListDetailsCollector()});
                break;
            }
            case 833: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceVZEVZAInfoTransformer(), n, "Navigation.Guidance", "VZEVZAInfo");
                break;
            }
            case 1110144: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationGuidanceVZEVZAIconsTransformer(), n, "Navigation.Guidance", "VZEVZAIcons");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Guidance: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 831: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.guidance.transformer.";
                string2 = "NavigationGuidanceRouteListDetailsTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.Guidance: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.Guidance", string);
    }
}


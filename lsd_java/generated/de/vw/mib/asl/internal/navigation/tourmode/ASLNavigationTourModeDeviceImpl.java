/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.tourmode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourListTransformer;
import de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourMemListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationPOIDataCollector;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationPOIDataTransformer;
import generated.de.vw.mib.asl.internal.navigation.tourmode.transformer.NavigationTourModeTourModeLocationTransformer;

public final class ASLNavigationTourModeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationTourModeDeviceImpl INSTANCE = new ASLNavigationTourModeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLNavigationTourModeDeviceImpl() {
    }

    public static ASLNavigationTourModeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.TourMode";
    }

    @Override
    public int getTargetId() {
        return 10059;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1006, this);
        aSLListRegistry.registerASLDevice(-17887232, this);
        aSLListRegistry.registerASLDevice(-1110016, this);
        aSLListRegistry.registerASLDevice(1000, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-301858752, 10059);
        serviceRegister.registerService(-285081536, 10059);
        serviceRegister.registerService(-268304320, 10059);
        serviceRegister.registerService(-251527104, 10059);
        serviceRegister.registerService(-234749888, 10059);
        serviceRegister.registerService(-217972672, 10059);
        serviceRegister.registerService(-201195456, 10059);
        serviceRegister.registerService(-184418240, 10059);
        serviceRegister.registerService(-167641024, 10059);
        serviceRegister.registerService(-150863808, 10059);
        serviceRegister.registerService(-134086592, 10059);
        serviceRegister.registerService(-117309376, 10059);
        serviceRegister.registerService(-100532160, 10059);
        serviceRegister.registerService(-83754944, 10059);
        serviceRegister.registerService(-66977728, 10059);
        serviceRegister.registerService(-50200512, 10059);
        serviceRegister.registerService(-33423296, 10059);
        serviceRegister.registerService(-16646080, 10059);
        serviceRegister.registerService(1980170304, 10059);
        serviceRegister.registerService(604504128, 10059);
        serviceRegister.registerService(196672, 10059);
        serviceRegister.registerService(16973888, 10059);
        serviceRegister.registerService(33751104, 10059);
        serviceRegister.registerService(0x3030040, 10059);
        serviceRegister.registerService(0x4030040, 10059);
        serviceRegister.registerService(84082752, 10059);
        serviceRegister.registerService(100859968, 10059);
        serviceRegister.registerService(117637184, 10059);
        serviceRegister.registerService(432607296, 10059);
        serviceRegister.registerService(499716160, 10059);
        serviceRegister.registerService(516493376, 10059);
        serviceRegister.registerService(533270592, 10059);
        serviceRegister.registerService(1472794688, 10059);
        serviceRegister.registerService(1489571904, 10059);
        serviceRegister.registerService(1791561792, 10059);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1006: {
                nArray = ListColumnsUtil.getIntArrayByBits(-6397, 24);
                break;
            }
            case 1110014: {
                nArray = ListColumnsUtil.getSimpleIntArray(32);
                break;
            }
            case 1110015: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1000: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.TourMode: ").append(n).toString());
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
        return ASLNavigationTourModeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationTourModeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1006: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTourModeTourListTransformer(), n, "Navigation.TourMode", "TourList");
                break;
            }
            case 1110014: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTourModeTourModeLocationTransformer(), n, "Navigation.TourMode", "TourModeLocation");
                genericASLList.updateList(new NavigationTourModeTourModeLocationCollector[]{new NavigationTourModeTourModeLocationCollector()});
                break;
            }
            case 1110015: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTourModeTourModeLocationPOIDataTransformer(), n, "Navigation.TourMode", "TourModeLocationPOIData");
                genericASLList.updateList(new NavigationTourModeTourModeLocationPOIDataCollector[]{new NavigationTourModeTourModeLocationPOIDataCollector()});
                break;
            }
            case 1000: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationTourModeTourMemListTransformer(), n, "Navigation.TourMode", "TourMemList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.TourMode: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


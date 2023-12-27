/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.ss;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSManeuverViewDataTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSCompassDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSCompassDataTransformer;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSGPSViewerDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSGPSViewerDataTransformer;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSManeuverExitViewDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSManeuverExitViewDataTransformer;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSSymbolDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.NavigationMapSSSymbolDataTransformer;

public final class ASLNavigationMapSSDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMapSSDeviceImpl INSTANCE = new ASLNavigationMapSSDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLNavigationMapSSDeviceImpl() {
    }

    public static ASLNavigationMapSSDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Map.SS";
    }

    @Override
    public int getTargetId() {
        return 10049;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(859, this);
        aSLListRegistry.registerASLDevice(860, this);
        aSLListRegistry.registerASLDevice(861, this);
        aSLListRegistry.registerASLDevice(862, this);
        aSLListRegistry.registerASLDevice(863, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(956432448, 10049);
        serviceRegister.registerService(973209664, 10049);
        serviceRegister.registerService(989986880, 10049);
        serviceRegister.registerService(1006764096, 10049);
        serviceRegister.registerService(1023541312, 10049);
        serviceRegister.registerService(1040318528, 10049);
        serviceRegister.registerService(1057095744, 10049);
        serviceRegister.registerService(0x40020040, 10049);
        serviceRegister.registerService(1090650176, 10049);
        serviceRegister.registerService(0x42020040, 10049);
        serviceRegister.registerService(1124204608, 10049);
        serviceRegister.registerService(0x44020040, 10049);
        serviceRegister.registerService(185204800, 10049);
        serviceRegister.registerService(403308608, 10049);
        serviceRegister.registerService(80285760, 10049);
        serviceRegister.registerService(97062976, 10049);
        serviceRegister.registerService(164171840, 10049);
        serviceRegister.registerService(969478208, 10049);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 859: {
                nArray = ListColumnsUtil.getIntArrayByBits(5, 2);
                break;
            }
            case 860: {
                nArray = ListColumnsUtil.getSimpleIntArray(21);
                break;
            }
            case 861: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 862: {
                nArray = ListColumnsUtil.getSimpleIntArray(20);
                break;
            }
            case 863: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.SS: ").append(n).toString());
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
        return ASLNavigationMapSSDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationMapSSDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 859: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMapSSCompassDataTransformer(), n, "Navigation.Map.SS", "CompassData");
                genericASLList.updateList(new NavigationMapSSCompassDataCollector[]{new NavigationMapSSCompassDataCollector()});
                break;
            }
            case 860: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMapSSGPSViewerDataTransformer(), n, "Navigation.Map.SS", "GPSViewerData");
                genericASLList.updateList(new NavigationMapSSGPSViewerDataCollector[]{new NavigationMapSSGPSViewerDataCollector()});
                break;
            }
            case 861: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMapSSSymbolDataTransformer(), n, "Navigation.Map.SS", "SymbolData");
                genericASLList.updateList(new NavigationMapSSSymbolDataCollector[]{new NavigationMapSSSymbolDataCollector()});
                break;
            }
            case 862: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMapSSManeuverViewDataTransformer(), n, "Navigation.Map.SS", "ManeuverViewData");
                break;
            }
            case 863: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMapSSManeuverExitViewDataTransformer(), n, "Navigation.Map.SS", "ManeuverExitViewData");
                genericASLList.updateList(new NavigationMapSSManeuverExitViewDataCollector[]{new NavigationMapSSManeuverExitViewDataCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Map.SS: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


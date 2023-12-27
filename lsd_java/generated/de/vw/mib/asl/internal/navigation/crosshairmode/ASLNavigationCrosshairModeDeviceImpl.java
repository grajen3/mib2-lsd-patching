/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.crosshairmode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.crosshairmode.transformer.NavigationCrosshairModeLocationInfoCollector;

public final class ASLNavigationCrosshairModeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationCrosshairModeDeviceImpl INSTANCE = new ASLNavigationCrosshairModeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_GEN;

    private ASLNavigationCrosshairModeDeviceImpl() {
    }

    public static ASLNavigationCrosshairModeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.CrosshairMode";
    }

    @Override
    public int getTargetId() {
        return 10133;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(938479616, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(889782336, 10133);
        serviceRegister.registerService(906559552, 10133);
        serviceRegister.registerService(923336768, 10133);
        serviceRegister.registerService(1191772224, 10133);
        serviceRegister.registerService(940113984, 10133);
        serviceRegister.registerService(956891200, 10133);
        serviceRegister.registerService(1091108928, 10133);
        serviceRegister.registerService(-318177216, 10133);
        serviceRegister.registerService(487260224, 10133);
        serviceRegister.registerService(1393229888, 10133);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110071: {
                nArray = ListColumnsUtil.getSimpleIntArray(19);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.CrosshairMode: ").append(n).toString());
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
        return ASLNavigationCrosshairModeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationCrosshairModeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110071: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationCrosshairModeDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "LocationInfo"), n, "Navigation.CrosshairMode", "LocationInfo");
                genericASLList.updateList(new NavigationCrosshairModeLocationInfoCollector[]{new NavigationCrosshairModeLocationInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.CrosshairMode: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1110071: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.crosshairmode.transformer.";
                string2 = "NavigationCrosshairModeLocationInfoTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.CrosshairMode: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.CrosshairMode", string);
    }
}


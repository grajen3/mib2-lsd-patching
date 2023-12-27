/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.setup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupGasStationListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupDemoStartLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupDemoStartLocationTransformer;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupGasStationNoneOptionCollector;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupGasStationNoneOptionTransformer;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupHomeLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.setup.transformer.NavigationSetupHomeLocationTransformer;

public final class ASLNavigationSetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationSetupDeviceImpl INSTANCE = new ASLNavigationSetupDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(4);
    private ASLListFactory listFactory;

    private ASLNavigationSetupDeviceImpl() {
    }

    public static ASLNavigationSetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Setup";
    }

    @Override
    public int getTargetId() {
        return 10056;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(983, this);
        aSLListRegistry.registerASLDevice(984, this);
        aSLListRegistry.registerASLDevice(2847, this);
        aSLListRegistry.registerASLDevice(2848, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-855506880, 10056);
        serviceRegister.registerService(-838729664, 10056);
        serviceRegister.registerService(-821952448, 10056);
        serviceRegister.registerService(-805175232, 10056);
        serviceRegister.registerService(-788398016, 10056);
        serviceRegister.registerService(-771620800, 10056);
        serviceRegister.registerService(-754843584, 10056);
        serviceRegister.registerService(-738066368, 10056);
        serviceRegister.registerService(935923776, 10056);
        serviceRegister.registerService(1103695936, 10056);
        serviceRegister.registerService(-721289152, 10056);
        serviceRegister.registerService(1120473152, 10056);
        serviceRegister.registerService(-704511936, 10056);
        serviceRegister.registerService(-687734720, 10056);
        serviceRegister.registerService(-670957504, 10056);
        serviceRegister.registerService(-654180288, 10056);
        serviceRegister.registerService(-620625856, 10056);
        serviceRegister.registerService(-603848640, 10056);
        serviceRegister.registerService(-587071424, 10056);
        serviceRegister.registerService(-570294208, 10056);
        serviceRegister.registerService(-553516992, 10056);
        serviceRegister.registerService(-536739776, 10056);
        serviceRegister.registerService(-503185344, 10056);
        serviceRegister.registerService(-486408128, 10056);
        serviceRegister.registerService(550047808, 10056);
        serviceRegister.registerService(1690898496, 10056);
        serviceRegister.registerService(-469630912, 10056);
        serviceRegister.registerService(-452853696, 10056);
        serviceRegister.registerService(-436076480, 10056);
        serviceRegister.registerService(-419299264, 10056);
        serviceRegister.registerService(-385744832, 10056);
        serviceRegister.registerService(952700992, 10056);
        serviceRegister.registerService(-368967616, 10056);
        serviceRegister.registerService(134873152, 10056);
        serviceRegister.registerService(151650368, 10056);
        serviceRegister.registerService(1707675712, 10056);
        serviceRegister.registerService(1724452928, 10056);
        serviceRegister.registerService(1741230144, 10056);
        serviceRegister.registerService(482938944, 10056);
        serviceRegister.registerService(1758007360, 10056);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 983: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 984: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2847: {
                nArray = ListColumnsUtil.getSimpleIntArray(32);
                break;
            }
            case 2848: {
                nArray = ListColumnsUtil.getSimpleIntArray(32);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Setup: ").append(n).toString());
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
        return ASLNavigationSetupDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationSetupDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 983: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSetupGasStationNoneOptionTransformer(), n, "Navigation.Setup", "GasStationNoneOption");
                genericASLList.updateList(new NavigationSetupGasStationNoneOptionCollector[]{new NavigationSetupGasStationNoneOptionCollector()});
                break;
            }
            case 984: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSetupGasStationListTransformer(), n, "Navigation.Setup", "GasStationList");
                break;
            }
            case 2847: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSetupHomeLocationTransformer(), n, "Navigation.Setup", "HomeLocation");
                genericASLList.updateList(new NavigationSetupHomeLocationCollector[]{new NavigationSetupHomeLocationCollector()});
                break;
            }
            case 2848: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSetupDemoStartLocationTransformer(), n, "Navigation.Setup", "DemoStartLocation");
                genericASLList.updateList(new NavigationSetupDemoStartLocationCollector[]{new NavigationSetupDemoStartLocationCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Setup: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


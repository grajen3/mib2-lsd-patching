/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryAddressbookDestMemListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryContactAddressSlotListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryContactListSearchResultListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryContactListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemFilteredListSlotListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemFilteredListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryLastDestMemListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryOnlineDestMemListTransformer;
import de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryTopDestMemListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemLocationTransformer;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemOnlineImportCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestMemOnlineImportTransformer;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsTransformer;

public final class ASLNavigationMemoryDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMemoryDeviceImpl INSTANCE = new ASLNavigationMemoryDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(13);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLNavigationMemoryDeviceImpl() {
    }

    public static ASLNavigationMemoryDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Memory";
    }

    @Override
    public int getTargetId() {
        return 10051;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(904, this);
        aSLListRegistry.registerASLDevice(905, this);
        aSLListRegistry.registerASLDevice(906, this);
        aSLListRegistry.registerASLDevice(907, this);
        aSLListRegistry.registerASLDevice(908, this);
        aSLListRegistry.registerASLDevice(909, this);
        aSLListRegistry.registerASLDevice(-2098196480, this);
        aSLListRegistry.registerASLDevice(910, this);
        aSLListRegistry.registerASLDevice(3632, this);
        aSLListRegistry.registerASLDevice(-118550528, this);
        aSLListRegistry.registerASLDevice(881, this);
        aSLListRegistry.registerASLDevice(883, this);
        aSLListRegistry.registerASLDevice(903, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1476526144, 10051);
        serviceRegister.registerService(1526857792, 10051);
        serviceRegister.registerService(1543635008, 10051);
        serviceRegister.registerService(1560412224, 10051);
        serviceRegister.registerService(1577189440, 10051);
        serviceRegister.registerService(1593966656, 10051);
        serviceRegister.registerService(1610743872, 10051);
        serviceRegister.registerService(1627521088, 10051);
        serviceRegister.registerService(1644298304, 10051);
        serviceRegister.registerService(1661075520, 10051);
        serviceRegister.registerService(1677852736, 10051);
        serviceRegister.registerService(1694629952, 10051);
        serviceRegister.registerService(1711407168, 10051);
        serviceRegister.registerService(1728184384, 10051);
        serviceRegister.registerService(1744961600, 10051);
        serviceRegister.registerService(1761738816, 10051);
        serviceRegister.registerService(1778516032, 10051);
        serviceRegister.registerService(1795293248, 10051);
        serviceRegister.registerService(923271232, 10051);
        serviceRegister.registerService(1828847680, 10051);
        serviceRegister.registerService(-2147024832, 10051);
        serviceRegister.registerService(1845624896, 10051);
        serviceRegister.registerService(1862402112, 10051);
        serviceRegister.registerService(1879179328, 10051);
        serviceRegister.registerService(1895956544, 10051);
        serviceRegister.registerService(1912733760, 10051);
        serviceRegister.registerService(1929510976, 10051);
        serviceRegister.registerService(1946288192, 10051);
        serviceRegister.registerService(1963065408, 10051);
        serviceRegister.registerService(1979842624, 10051);
        serviceRegister.registerService(1996619840, 10051);
        serviceRegister.registerService(2013397056, 10051);
        serviceRegister.registerService(2030174272, 10051);
        serviceRegister.registerService(2046951488, 10051);
        serviceRegister.registerService(2063728704, 10051);
        serviceRegister.registerService(2080505920, 10051);
        serviceRegister.registerService(2097283136, 10051);
        serviceRegister.registerService(2114060352, 10051);
        serviceRegister.registerService(2130837568, 10051);
        serviceRegister.registerService(-2147352512, 10051);
        serviceRegister.registerService(-2130575296, 10051);
        serviceRegister.registerService(-2113798080, 10051);
        serviceRegister.registerService(-2097020864, 10051);
        serviceRegister.registerService(-2080243648, 10051);
        serviceRegister.registerService(1070141504, 10051);
        serviceRegister.registerService(0x40060040, 10051);
        serviceRegister.registerService(-2063466432, 10051);
        serviceRegister.registerService(-2046689216, 10051);
        serviceRegister.registerService(-2029912000, 10051);
        serviceRegister.registerService(214503488, 10051);
        serviceRegister.registerService(231280704, 10051);
        serviceRegister.registerService(248057920, 10051);
        serviceRegister.registerService(315166784, 10051);
        serviceRegister.registerService(331944000, 10051);
        serviceRegister.registerService(382275648, 10051);
        serviceRegister.registerService(399052864, 10051);
        serviceRegister.registerService(415830080, 10051);
        serviceRegister.registerService(1456017472, 10051);
        serviceRegister.registerService(1892225088, 10051);
        serviceRegister.registerService(1841893440, 10051);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 904: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 905: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 906: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 907: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 908: {
                nArray = ListColumnsUtil.getIntArrayByBits(9, 2);
                break;
            }
            case 909: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1110146: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 910: {
                nArray = ListColumnsUtil.getSimpleIntArray(23);
                break;
            }
            case 3632: {
                nArray = ListColumnsUtil.getIntArrayByBits((long)0, 32);
                break;
            }
            case 1110008: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 881: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 883: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 903: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Memory: ").append(n).toString());
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
        return ASLNavigationMemoryDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationMemoryDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 904: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryAddressbookDestMemListTransformer(), n, "Navigation.Memory", "AddressbookDestMemList");
                break;
            }
            case 905: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryContactListTransformer(), n, "Navigation.Memory", "ContactList");
                break;
            }
            case 906: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryDestMemFilteredListTransformer(), n, "Navigation.Memory", "DestMemFilteredList");
                break;
            }
            case 907: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryContactListSearchResultListTransformer(), n, "Navigation.Memory", "ContactListSearchResultList");
                break;
            }
            case 908: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryLastDestMemListTransformer(), n, "Navigation.Memory", "LastDestMemList");
                break;
            }
            case 909: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryTopDestMemListTransformer(), n, "Navigation.Memory", "TopDestMemList");
                break;
            }
            case 1110146: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryOnlineDestMemListTransformer(), n, "Navigation.Memory", "OnlineDestMemList");
                break;
            }
            case 910: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryDestinationDetailsTransformer(), n, "Navigation.Memory", "DestinationDetails");
                genericASLList.updateList(new NavigationMemoryDestinationDetailsCollector[]{new NavigationMemoryDestinationDetailsCollector()});
                break;
            }
            case 3632: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryDestMemLocationTransformer(), n, "Navigation.Memory", "DestMemLocation");
                genericASLList.updateList(new NavigationMemoryDestMemLocationCollector[]{new NavigationMemoryDestMemLocationCollector()});
                break;
            }
            case 1110008: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryDestMemOnlineImportTransformer(), n, "Navigation.Memory", "DestMemOnlineImport");
                genericASLList.updateList(new NavigationMemoryDestMemOnlineImportCollector[]{new NavigationMemoryDestMemOnlineImportCollector()});
                break;
            }
            case 881: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryContactAddressSlotListTransformer(), n, "Navigation.Memory", "ContactAddressSlotList");
                break;
            }
            case 883: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationMemoryDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "AddressbookDestMemItemSlotList"), n, "Navigation.Memory", "AddressbookDestMemItemSlotList");
                break;
            }
            case 903: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMemoryDestMemFilteredListSlotListTransformer(), n, "Navigation.Memory", "DestMemFilteredListSlotList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Memory: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 883: {
                string3 = "de.vw.mib.asl.internal.navigation.memory.transformer.";
                string2 = "NavigationMemoryAddressbookDestMemItemSlotListTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.Memory: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.Memory", string);
    }
}


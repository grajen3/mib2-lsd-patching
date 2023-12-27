/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.destlist;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationDestInputDestListDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationDestInputDestListDeviceImpl INSTANCE = new ASLNavigationDestInputDestListDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLNavigationDestInputDestListDeviceImpl() {
    }

    public static ASLNavigationDestInputDestListDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.DestInput.DestList";
    }

    @Override
    public int getTargetId() {
        return 10043;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3009, this);
        aSLListRegistry.registerASLDevice(2994, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-16711616, 10043);
        serviceRegister.registerService(131136, 10043);
        serviceRegister.registerService(16908352, 10043);
        serviceRegister.registerService(0x2020040, 10043);
        serviceRegister.registerService(50462784, 10043);
        serviceRegister.registerService(0x4020040, 10043);
        serviceRegister.registerService(84017216, 10043);
        serviceRegister.registerService(-620167104, 10043);
        serviceRegister.registerService(-603389888, 10043);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3009: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 2994: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.DestInput.DestList: ").append(n).toString());
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
        return ASLNavigationDestInputDestListDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationDestInputDestListDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3009: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDestListDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "DestinationListAll"), n, "Navigation.DestInput.DestList", "DestinationListAll");
                break;
            }
            case 2994: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDestListDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "DestinationListData"), n, "Navigation.DestInput.DestList", "DestinationListData");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.DestInput.DestList: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 3009: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.destlist.transformer.";
                string2 = "NavigationDestInputDestListDestinationListAllTransformer";
                break;
            }
            case 2994: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.destlist.transformer.";
                string2 = "NavigationDestInputDestListDestinationListDataTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.DestInput.DestList: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.DestInput.DestList", string);
    }
}


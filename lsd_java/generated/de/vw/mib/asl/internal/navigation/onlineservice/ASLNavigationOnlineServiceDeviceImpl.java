/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.onlineservice;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer.NavigationOnlineServiceStreetViewAvailabilityPointCollector;
import generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer.NavigationOnlineServiceStreetViewAvailabilityPointTransformer;
import generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer.NavigationOnlineServiceStreetViewLocationDataCollector;
import generated.de.vw.mib.asl.internal.navigation.onlineservice.transformer.NavigationOnlineServiceStreetViewLocationDataTransformer;

public final class ASLNavigationOnlineServiceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationOnlineServiceDeviceImpl INSTANCE = new ASLNavigationOnlineServiceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationOnlineServiceDeviceImpl() {
    }

    public static ASLNavigationOnlineServiceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.OnlineService";
    }

    @Override
    public int getTargetId() {
        return 10142;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3775, this);
        aSLListRegistry.registerASLDevice(3869, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1728708672, 10142);
        serviceRegister.registerService(1745485888, 10142);
        serviceRegister.registerService(-1526071232, 10142);
        serviceRegister.registerService(-1509294016, 10142);
        serviceRegister.registerService(-1442185152, 10142);
        serviceRegister.registerService(-1375076288, 10142);
        serviceRegister.registerService(-1408630720, 10142);
        serviceRegister.registerService(-1391853504, 10142);
        serviceRegister.registerService(-838205376, 10142);
        serviceRegister.registerService(147394624, 10142);
        serviceRegister.registerService(684265536, 10142);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3775: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 3869: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.OnlineService: ").append(n).toString());
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
        return ASLNavigationOnlineServiceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationOnlineServiceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3775: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationOnlineServiceStreetViewLocationDataTransformer(), n, "Navigation.OnlineService", "StreetViewLocationData");
                genericASLList.updateList(new NavigationOnlineServiceStreetViewLocationDataCollector[]{new NavigationOnlineServiceStreetViewLocationDataCollector()});
                break;
            }
            case 3869: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationOnlineServiceStreetViewAvailabilityPointTransformer(), n, "Navigation.OnlineService", "StreetViewAvailabilityPoint");
                genericASLList.updateList(new NavigationOnlineServiceStreetViewAvailabilityPointCollector[]{new NavigationOnlineServiceStreetViewAvailabilityPointCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.OnlineService: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


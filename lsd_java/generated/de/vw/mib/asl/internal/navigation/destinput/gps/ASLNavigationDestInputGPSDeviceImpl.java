/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput.gps;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSCoordinatesCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSCoordinatesTransformer;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSMapInputLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.gps.transformer.NavigationDestInputGPSMapInputLocationTransformer;

public final class ASLNavigationDestInputGPSDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationDestInputGPSDeviceImpl INSTANCE = new ASLNavigationDestInputGPSDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationDestInputGPSDeviceImpl() {
    }

    public static ASLNavigationDestInputGPSDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.DestInput.GPS";
    }

    @Override
    public int getTargetId() {
        return 10138;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3558, this);
        aSLListRegistry.registerASLDevice(3570, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-150405056, 10138);
        serviceRegister.registerService(-133627840, 10138);
        serviceRegister.registerService(-116850624, 10138);
        serviceRegister.registerService(-100073408, 10138);
        serviceRegister.registerService(-83296192, 10138);
        serviceRegister.registerService(-66518976, 10138);
        serviceRegister.registerService(-49741760, 10138);
        serviceRegister.registerService(-16187328, 10138);
        serviceRegister.registerService(503971904, 10138);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3558: {
                nArray = ListColumnsUtil.getSimpleIntArray(23);
                break;
            }
            case 3570: {
                nArray = ListColumnsUtil.getSimpleIntArray(32);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.DestInput.GPS: ").append(n).toString());
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
        return ASLNavigationDestInputGPSDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationDestInputGPSDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3558: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationDestInputGPSCoordinatesTransformer(), n, "Navigation.DestInput.GPS", "Coordinates");
                genericASLList.updateList(new NavigationDestInputGPSCoordinatesCollector[]{new NavigationDestInputGPSCoordinatesCollector()});
                break;
            }
            case 3570: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationDestInputGPSMapInputLocationTransformer(), n, "Navigation.DestInput.GPS", "MapInputLocation");
                genericASLList.updateList(new NavigationDestInputGPSMapInputLocationCollector[]{new NavigationDestInputGPSMapInputLocationCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.DestInput.GPS: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


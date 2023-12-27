/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.waypointmode.transformer.NavigationWayPointModeTrackListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationWayPointModeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationWayPointModeDeviceImpl INSTANCE = new ASLNavigationWayPointModeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLNavigationWayPointModeDeviceImpl() {
    }

    public static ASLNavigationWayPointModeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.WayPointMode";
    }

    @Override
    public int getTargetId() {
        return 10154;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(4087, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1594556480, 10154);
        serviceRegister.registerService(1510670400, 10154);
        serviceRegister.registerService(1527447616, 10154);
        serviceRegister.registerService(1544224832, 10154);
        serviceRegister.registerService(1611333696, 10154);
        serviceRegister.registerService(1628110912, 10154);
        serviceRegister.registerService(1644888128, 10154);
        serviceRegister.registerService(1661665344, 10154);
        serviceRegister.registerService(2131427392, 10154);
        serviceRegister.registerService(-1911881664, 10154);
        serviceRegister.registerService(1795883072, 10154);
        serviceRegister.registerService(1812660288, 10154);
        serviceRegister.registerService(1997209664, 10154);
        serviceRegister.registerService(2013986880, 10154);
        serviceRegister.registerService(2030764096, 10154);
        serviceRegister.registerService(2047541312, 10154);
        serviceRegister.registerService(2064318528, 10154);
        serviceRegister.registerService(2081095744, 10154);
        serviceRegister.registerService(2097872960, 10154);
        serviceRegister.registerService(1053364288, 10154);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 4087: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.WayPointMode: ").append(n).toString());
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
        return ASLNavigationWayPointModeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationWayPointModeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 4087: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationWayPointModeTrackListTransformer(), n, "Navigation.WayPointMode", "TrackList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.WayPointMode: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


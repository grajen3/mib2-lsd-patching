/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.routeoptions;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.routeoptions.transformer.NavigationRouteOptionsVignetteCountryListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.routeoptions.transformer.NavigationRouteOptionsRoadTypesAvoidedCollector;
import generated.de.vw.mib.asl.internal.navigation.routeoptions.transformer.NavigationRouteOptionsRoadTypesAvoidedTransformer;

public final class ASLNavigationRouteOptionsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationRouteOptionsDeviceImpl INSTANCE = new ASLNavigationRouteOptionsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationRouteOptionsDeviceImpl() {
    }

    public static ASLNavigationRouteOptionsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.RouteOptions";
    }

    @Override
    public int getTargetId() {
        return 10055;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(960, this);
        aSLListRegistry.registerASLDevice(961, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1023279040, 10055);
        serviceRegister.registerService(-989724608, 10055);
        serviceRegister.registerService(1271468096, 10055);
        serviceRegister.registerService(1556680768, 10055);
        serviceRegister.registerService(1573457984, 10055);
        serviceRegister.registerService(1388908608, 10055);
        serviceRegister.registerService(-972947392, 10055);
        serviceRegister.registerService(-956170176, 10055);
        serviceRegister.registerService(-939392960, 10055);
        serviceRegister.registerService(-922615744, 10055);
        serviceRegister.registerService(-905838528, 10055);
        serviceRegister.registerService(-889061312, 10055);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 960: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 961: {
                nArray = ListColumnsUtil.getIntArrayByBits(62, 5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.RouteOptions: ").append(n).toString());
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
        return ASLNavigationRouteOptionsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationRouteOptionsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 960: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationRouteOptionsVignetteCountryListTransformer(), n, "Navigation.RouteOptions", "VignetteCountryList");
                break;
            }
            case 961: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationRouteOptionsRoadTypesAvoidedTransformer(), n, "Navigation.RouteOptions", "RoadTypesAvoided");
                genericASLList.updateList(new NavigationRouteOptionsRoadTypesAvoidedCollector[]{new NavigationRouteOptionsRoadTypesAvoidedCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.RouteOptions: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.homedestinput;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.homedestinput.transformer.NavigationHomeDestInputHomeDestinationDetailCollector;
import generated.de.vw.mib.asl.internal.navigation.homedestinput.transformer.NavigationHomeDestInputHomeDestinationDetailTransformer;

public final class ASLNavigationHomeDestInputDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationHomeDestInputDeviceImpl INSTANCE = new ASLNavigationHomeDestInputDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLNavigationHomeDestInputDeviceImpl() {
    }

    public static ASLNavigationHomeDestInputDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.HomeDestInput";
    }

    @Override
    public int getTargetId() {
        return 10045;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(837, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(671219776, 10045);
        serviceRegister.registerService(687996992, 10045);
        serviceRegister.registerService(704774208, 10045);
        serviceRegister.registerService(721551424, 10045);
        serviceRegister.registerService(738328640, 10045);
        serviceRegister.registerService(755105856, 10045);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 837: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.HomeDestInput: ").append(n).toString());
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
        return ASLNavigationHomeDestInputDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationHomeDestInputDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 837: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationHomeDestInputHomeDestinationDetailTransformer(), n, "Navigation.HomeDestInput", "HomeDestinationDetail");
                genericASLList.updateList(new NavigationHomeDestInputHomeDestinationDetailCollector[]{new NavigationHomeDestInputHomeDestinationDetailCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.HomeDestInput: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


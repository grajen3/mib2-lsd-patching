/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.borderchange;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.borderchange.transformer.NavigationBorderChangeBorderCrossInfoTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.borderchange.transformer.NavigationBorderChangeNewCountryCollector;
import generated.de.vw.mib.asl.internal.navigation.borderchange.transformer.NavigationBorderChangeNewCountryTransformer;

public final class ASLNavigationBorderChangeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationBorderChangeDeviceImpl INSTANCE = new ASLNavigationBorderChangeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationBorderChangeDeviceImpl() {
    }

    public static ASLNavigationBorderChangeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.BorderChange";
    }

    @Override
    public int getTargetId() {
        return 10040;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(760, this);
        aSLListRegistry.registerASLDevice(761, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 760: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 761: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.BorderChange: ").append(n).toString());
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
        return ASLNavigationBorderChangeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationBorderChangeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 760: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBorderChangeNewCountryTransformer(), n, "Navigation.BorderChange", "NewCountry");
                genericASLList.updateList(new NavigationBorderChangeNewCountryCollector[]{new NavigationBorderChangeNewCountryCollector()});
                break;
            }
            case 761: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationBorderChangeBorderCrossInfoTransformer(), n, "Navigation.BorderChange", "BorderCrossInfo");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.BorderChange: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


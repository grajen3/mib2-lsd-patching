/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.via;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationViaDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationViaDeviceImpl INSTANCE = new ASLNavigationViaDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLNavigationViaDeviceImpl() {
    }

    public static ASLNavigationViaDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Via";
    }

    @Override
    public int getTargetId() {
        return 10061;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1021, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(335740992, 10061);
        serviceRegister.registerService(352518208, 10061);
        serviceRegister.registerService(369295424, 10061);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1021: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Via: ").append(n).toString());
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
        return ASLNavigationViaDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationViaDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1021: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationViaDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "ViaList"), n, "Navigation.Via", "ViaList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Via: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 1021: {
                string3 = "de.vw.mib.asl.internal.navigation.via.transformer.";
                string2 = "NavigationViaViaListTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.Via: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.Via", string);
    }
}


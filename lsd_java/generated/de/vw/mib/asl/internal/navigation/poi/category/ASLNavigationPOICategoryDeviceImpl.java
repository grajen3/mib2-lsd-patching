/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.poi.category;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.poi.category.transformer.NavigationPOICategoryListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.poi.category.transformer.NavigationPOICategorySelectedItemCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.category.transformer.NavigationPOICategorySelectedItemTransformer;

public final class ASLNavigationPOICategoryDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationPOICategoryDeviceImpl INSTANCE = new ASLNavigationPOICategoryDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationPOICategoryDeviceImpl() {
    }

    public static ASLNavigationPOICategoryDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.POI.Category";
    }

    @Override
    public int getTargetId() {
        return 12113;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1410330624, this);
        aSLListRegistry.registerASLDevice(-1393553408, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1623789632, 12113);
        serviceRegister.registerService(1640566848, 12113);
        serviceRegister.registerService(1657344064, 12113);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110187: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 1110188: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.POI.Category: ").append(n).toString());
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
        return ASLNavigationPOICategoryDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationPOICategoryDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110187: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOICategoryListTransformer(), n, "Navigation.POI.Category", "List");
                break;
            }
            case 1110188: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationPOICategorySelectedItemTransformer(), n, "Navigation.POI.Category", "SelectedItem");
                genericASLList.updateList(new NavigationPOICategorySelectedItemCollector[]{new NavigationPOICategorySelectedItemCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.POI.Category: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


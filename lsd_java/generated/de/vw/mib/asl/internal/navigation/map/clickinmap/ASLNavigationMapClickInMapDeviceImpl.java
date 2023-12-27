/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.clickinmap;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.map.clickinmap.transformer.NavigationMapClickInMapClickInMapDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.clickinmap.transformer.NavigationMapClickInMapClickInMapDataTransformer;

public final class ASLNavigationMapClickInMapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMapClickInMapDeviceImpl INSTANCE = new ASLNavigationMapClickInMapDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLNavigationMapClickInMapDeviceImpl() {
    }

    public static ASLNavigationMapClickInMapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Map.ClickInMap";
    }

    @Override
    public int getTargetId() {
        return 12112;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1896869888, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1288245312, 12112);
        serviceRegister.registerService(1305022528, 12112);
        serviceRegister.registerService(1338576960, 12112);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110158: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.ClickInMap: ").append(n).toString());
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
        return ASLNavigationMapClickInMapDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationMapClickInMapDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110158: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationMapClickInMapClickInMapDataTransformer(), n, "Navigation.Map.ClickInMap", "ClickInMapData");
                genericASLList.updateList(new NavigationMapClickInMapClickInMapDataCollector[]{new NavigationMapClickInMapClickInMapDataCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Map.ClickInMap: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


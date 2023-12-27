/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.homescreen;

import de.vw.mib.asl.internal.homescreen.transformer.HomeScreenCurrentlyActiveAppInformationTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLHomeScreenDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLHomeScreenDeviceImpl INSTANCE = new ASLHomeScreenDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLHomeScreenDeviceImpl() {
    }

    public static ASLHomeScreenDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "HomeScreen";
    }

    @Override
    public int getTargetId() {
        return 15901;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1309980160, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1547417024, 15901);
        serviceRegister.registerService(-1580971456, 15901);
        serviceRegister.registerService(-1564194240, 15901);
        serviceRegister.registerService(-1597748672, 15901);
        serviceRegister.registerService(-1513862592, 15901);
        serviceRegister.registerService(-1497085376, 15901);
        serviceRegister.registerService(-1480308160, 15901);
        serviceRegister.registerService(-1463530944, 15901);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 4910001: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HomeScreen: ").append(n).toString());
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
        return ASLHomeScreenDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLHomeScreenDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 4910001: {
                genericASLList = aSLListFactory.createGenericASLList(new HomeScreenCurrentlyActiveAppInformationTransformer(), n, "HomeScreen", "CurrentlyActiveAppInformation");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device HomeScreen: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


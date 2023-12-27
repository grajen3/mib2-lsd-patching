/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.system.backstack;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.system.backstack.transformer.SystemBackstackBackstackEntryCollector;

public final class ASLSystemBackstackDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSystemBackstackDeviceImpl INSTANCE = new ASLSystemBackstackDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_GEN;

    private ASLSystemBackstackDeviceImpl() {
    }

    public static ASLSystemBackstackDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "System.Backstack";
    }

    @Override
    public int getTargetId() {
        return 10137;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3508, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-938934208, 10137);
        serviceRegister.registerService(923402304, 10137);
        serviceRegister.registerService(-905379776, 10137);
        serviceRegister.registerService(-922156992, 10137);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3508: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device System.Backstack: ").append(n).toString());
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
        return ASLSystemBackstackDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSystemBackstackDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3508: {
                genericASLList = aSLListFactory.createGenericASLList(ASLSystemBackstackDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "backstackEntry"), n, "System.Backstack", "backstackEntry");
                genericASLList.updateList(new SystemBackstackBackstackEntryCollector[]{new SystemBackstackBackstackEntryCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device System.Backstack: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 3508: {
                string3 = "generated.de.vw.mib.asl.internal.system.backstack.transformer.";
                string2 = "SystemBackstackBackstackEntryTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device System.Backstack: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "System.Backstack", string);
    }
}


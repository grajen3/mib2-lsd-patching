/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.hwr;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.hwr.transformer.HWRTimeoutCollector;
import generated.de.vw.mib.asl.internal.hwr.transformer.HWRTimeoutTransformer;

public final class ASLHWRDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLHWRDeviceImpl INSTANCE = new ASLHWRDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLHWRDeviceImpl() {
    }

    public static ASLHWRDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "HWR";
    }

    @Override
    public int getTargetId() {
        return 10140;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3999, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(772407360, 10140);
        serviceRegister.registerService(789184576, 10140);
        serviceRegister.registerService(805961792, 10140);
        serviceRegister.registerService(202047552, 10140);
        serviceRegister.registerService(655040576, 10140);
        serviceRegister.registerService(671817792, 10140);
        serviceRegister.registerService(688595008, 10140);
        serviceRegister.registerService(218824768, 10140);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3999: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HWR: ").append(n).toString());
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
        return ASLHWRDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLHWRDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3999: {
                genericASLList = aSLListFactory.createGenericASLList(new HWRTimeoutTransformer(), n, "HWR", "Timeout");
                genericASLList.updateList(new HWRTimeoutCollector[]{new HWRTimeoutCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device HWR: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


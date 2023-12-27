/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.call;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallForwardingsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallSettingsCollector;
import generated.de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallSettingsTransformer;

public final class ASLPhoneSetupCallDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupCallDeviceImpl INSTANCE = new ASLPhoneSetupCallDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLPhoneSetupCallDeviceImpl() {
    }

    public static ASLPhoneSetupCallDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Call";
    }

    @Override
    public int getTargetId() {
        return 10091;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1210, this);
        aSLListRegistry.registerASLDevice(1211, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-335347648, 10091);
        serviceRegister.registerService(-318570432, 10091);
        serviceRegister.registerService(-301793216, 10091);
        serviceRegister.registerService(-285016000, 10091);
        serviceRegister.registerService(-268238784, 10091);
        serviceRegister.registerService(-251461568, 10091);
        serviceRegister.registerService(-1034152640, 10091);
        serviceRegister.registerService(-217907136, 10091);
        serviceRegister.registerService(-201129920, 10091);
        serviceRegister.registerService(-184352704, 10091);
        serviceRegister.registerService(-167575488, 10091);
        serviceRegister.registerService(-150798272, 10091);
        serviceRegister.registerService(-134021056, 10091);
        serviceRegister.registerService(-665053888, 10091);
        serviceRegister.registerService(-100466624, 10091);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1210: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1211: {
                nArray = ListColumnsUtil.getIntArrayByBits(125, 6);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Call: ").append(n).toString());
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
        return ASLPhoneSetupCallDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneSetupCallDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1210: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupCallCallForwardingsTransformer(), n, "Phone.Setup.Call", "callForwardings");
                break;
            }
            case 1211: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupCallCallSettingsTransformer(), n, "Phone.Setup.Call", "callSettings");
                genericASLList.updateList(new PhoneSetupCallCallSettingsCollector[]{new PhoneSetupCallCallSettingsCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Setup.Call: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


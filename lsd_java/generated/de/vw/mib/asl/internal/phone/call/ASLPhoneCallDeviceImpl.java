/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallCallInformationsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.call.transformer.PhoneCallIncomingCallInformationsCollector;
import generated.de.vw.mib.asl.internal.phone.call.transformer.PhoneCallIncomingCallInformationsTransformer;

public final class ASLPhoneCallDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneCallDeviceImpl INSTANCE = new ASLPhoneCallDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLPhoneCallDeviceImpl() {
    }

    public static ASLPhoneCallDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Call";
    }

    @Override
    public int getTargetId() {
        return 10075;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1158, this);
        aSLListRegistry.registerASLDevice(1159, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1627193280, 10075);
        serviceRegister.registerService(-1610416064, 10075);
        serviceRegister.registerService(-1492516800, 10075);
        serviceRegister.registerService(-1067707072, 10075);
        serviceRegister.registerService(1426587712, 10075);
        serviceRegister.registerService(-430172864, 10075);
        serviceRegister.registerService(-1560084416, 10075);
        serviceRegister.registerService(-1543307200, 10075);
        serviceRegister.registerService(-1526529984, 10075);
        serviceRegister.registerService(-1509752768, 10075);
        serviceRegister.registerService(-1475739584, 10075);
        serviceRegister.registerService(-1492975552, 10075);
        serviceRegister.registerService(-1476198336, 10075);
        serviceRegister.registerService(-1459421120, 10075);
        serviceRegister.registerService(-1442643904, 10075);
        serviceRegister.registerService(-1425866688, 10075);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1158: {
                nArray = ListColumnsUtil.getIntArrayByBits(-572784896, 20);
                break;
            }
            case 1159: {
                nArray = ListColumnsUtil.getIntArrayByBits(31719, 12);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Call: ").append(n).toString());
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
        return ASLPhoneCallDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneCallDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1158: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallCallInformationsTransformer(), n, "Phone.Call", "callInformations");
                break;
            }
            case 1159: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneCallIncomingCallInformationsTransformer(), n, "Phone.Call", "incomingCallInformations");
                genericASLList.updateList(new PhoneCallIncomingCallInformationsCollector[]{new PhoneCallIncomingCallInformationsCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Call: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


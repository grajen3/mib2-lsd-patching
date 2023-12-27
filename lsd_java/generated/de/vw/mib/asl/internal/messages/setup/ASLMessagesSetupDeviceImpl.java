/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.setup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.messages.setup.transformer.MessagesSetupAccountInformationsTransformer;
import de.vw.mib.asl.internal.messages.setup.transformer.MessagesSetupInternalRingtonesTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMessagesSetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesSetupDeviceImpl INSTANCE = new ASLMessagesSetupDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLMessagesSetupDeviceImpl() {
    }

    public static ASLMessagesSetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages.Setup";
    }

    @Override
    public int getTargetId() {
        return 10032;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(478, this);
        aSLListRegistry.registerASLDevice(477, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1598354112, 10032);
        serviceRegister.registerService(-1212478144, 10032);
        serviceRegister.registerService(-1946091456, 10032);
        serviceRegister.registerService(-1929314240, 10032);
        serviceRegister.registerService(-1912537024, 10032);
        serviceRegister.registerService(-1895759808, 10032);
        serviceRegister.registerService(-1581576896, 10032);
        serviceRegister.registerService(-1878982592, 10032);
        serviceRegister.registerService(-1862205376, 10032);
        serviceRegister.registerService(-1845428160, 10032);
        serviceRegister.registerService(-1828650944, 10032);
        serviceRegister.registerService(-1811873728, 10032);
        serviceRegister.registerService(-1795096512, 10032);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 478: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 477: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup: ").append(n).toString());
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
        return ASLMessagesSetupDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMessagesSetupDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 478: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesSetupAccountInformationsTransformer(), n, "Messages.Setup", "accountInformations");
                break;
            }
            case 477: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesSetupInternalRingtonesTransformer(), n, "Messages.Setup", "internalRingtones");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Messages.Setup: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


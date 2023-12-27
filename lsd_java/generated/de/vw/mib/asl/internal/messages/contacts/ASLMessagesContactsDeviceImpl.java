/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.contacts;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactNumbersTransformer;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactsTransformer;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageReceiverContactsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMessagesContactsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesContactsDeviceImpl INSTANCE = new ASLMessagesContactsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLMessagesContactsDeviceImpl() {
    }

    public static ASLMessagesContactsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages.Contacts";
    }

    @Override
    public int getTargetId() {
        return 10030;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(468, this);
        aSLListRegistry.registerGrammar(3, 468, 1, true);
        aSLListRegistry.registerASLDevice(469, this);
        aSLListRegistry.registerGrammar(4, 469, -1, true);
        aSLListRegistry.registerASLDevice(-1193145088, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1531245248, 10030);
        serviceRegister.registerService(2080440384, 10030);
        serviceRegister.registerService(2113994816, 10030);
        serviceRegister.registerService(2130772032, 10030);
        serviceRegister.registerService(-2147418048, 10030);
        serviceRegister.registerService(-519438272, 10030);
        serviceRegister.registerService(-502661056, 10030);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 468: {
                nArray = ListColumnsUtil.getIntArrayByBits(14, 3);
                break;
            }
            case 469: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 910008: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Contacts: ").append(n).toString());
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
        return ASLMessagesContactsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMessagesContactsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 468: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesContactsMessageContactNumbersTransformer(), n, "Messages.Contacts", "messageContactNumbers");
                genericASLList.setSpeechListIds(new int[]{3});
                break;
            }
            case 469: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesContactsMessageContactsTransformer(), n, "Messages.Contacts", "messageContacts");
                genericASLList.setSpeechListIds(new int[]{4});
                break;
            }
            case 910008: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesContactsMessageReceiverContactsTransformer(), n, "Messages.Contacts", "messageReceiverContacts");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Messages.Contacts: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


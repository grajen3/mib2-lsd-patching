/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.contacts.search;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.messages.contacts.search.transformer.MessagesContactsSearchSpellerPreviewListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMessagesContactsSearchDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesContactsSearchDeviceImpl INSTANCE = new ASLMessagesContactsSearchDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLMessagesContactsSearchDeviceImpl() {
    }

    public static ASLMessagesContactsSearchDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages.Contacts.Search";
    }

    @Override
    public int getTargetId() {
        return 11901;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1058927360, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1514468032, 11901);
        serviceRegister.registerService(-1497690816, 11901);
        serviceRegister.registerService(-1480913600, 11901);
        serviceRegister.registerService(-1464136384, 11901);
        serviceRegister.registerService(-1447359168, 11901);
        serviceRegister.registerService(-1262809792, 11901);
        serviceRegister.registerService(-1296364224, 11901);
        serviceRegister.registerService(-1413804736, 11901);
        serviceRegister.registerService(-1279587008, 11901);
        serviceRegister.registerService(-1397027520, 11901);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 910016: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Contacts.Search: ").append(n).toString());
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
        return ASLMessagesContactsSearchDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMessagesContactsSearchDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 910016: {
                genericASLList = aSLListFactory.createGenericASLList(new MessagesContactsSearchSpellerPreviewListTransformer(), n, "Messages.Contacts.Search", "spellerPreviewList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Messages.Contacts.Search: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


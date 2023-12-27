/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.contacts.search;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.contacts.search.transformer.PhoneContactsSearchSpellerPreviewListTransformer;
import de.vw.mib.asl.internal.phone.contacts.search.transformer.PhoneContactsSearchSpellerResultListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneContactsSearchDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneContactsSearchDeviceImpl INSTANCE = new ASLPhoneContactsSearchDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLPhoneContactsSearchDeviceImpl() {
    }

    public static ASLPhoneContactsSearchDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Contacts.Search";
    }

    @Override
    public int getTargetId() {
        return 10084;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3683, this);
        aSLListRegistry.registerASLDevice(3899, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-956104640, 10084);
        serviceRegister.registerService(-939327424, 10084);
        serviceRegister.registerService(-922550208, 10084);
        serviceRegister.registerService(-905772992, 10084);
        serviceRegister.registerService(-334888896, 10084);
        serviceRegister.registerService(1292501056, 10084);
        serviceRegister.registerService(-732162752, 10084);
        serviceRegister.registerService(-855441344, 10084);
        serviceRegister.registerService(-950266560, 10084);
        serviceRegister.registerService(-838664128, 10084);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3683: {
                nArray = ListColumnsUtil.getIntArrayByBits(126, 6);
                break;
            }
            case 3899: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Contacts.Search: ").append(n).toString());
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
        return ASLPhoneContactsSearchDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneContactsSearchDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3683: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsSearchSpellerPreviewListTransformer(), n, "Phone.Contacts.Search", "spellerPreviewList");
                break;
            }
            case 3899: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsSearchSpellerResultListTransformer(), n, "Phone.Contacts.Search", "spellerResultList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Contacts.Search: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


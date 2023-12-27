/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bap.contacts;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.bap.contacts.transformer.PhoneBAPContactsContactDetailsTransformer;
import de.vw.mib.asl.internal.phone.bap.contacts.transformer.PhoneBAPContactsContactsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneBAPContactsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneBAPContactsDeviceImpl INSTANCE = new ASLPhoneBAPContactsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLPhoneBAPContactsDeviceImpl() {
    }

    public static ASLPhoneBAPContactsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.BAP.Contacts";
    }

    @Override
    public int getTargetId() {
        return 10069;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1109, this);
        aSLListRegistry.registerASLDevice(1110, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1761804352, 10069);
        serviceRegister.registerService(1778581568, 10069);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1109: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 1110: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.BAP.Contacts: ").append(n).toString());
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
        return ASLPhoneBAPContactsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneBAPContactsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1109: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBAPContactsContactsTransformer(), n, "Phone.BAP.Contacts", "contacts");
                break;
            }
            case 1110: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBAPContactsContactDetailsTransformer(), n, "Phone.BAP.Contacts", "contactDetails");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.BAP.Contacts: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


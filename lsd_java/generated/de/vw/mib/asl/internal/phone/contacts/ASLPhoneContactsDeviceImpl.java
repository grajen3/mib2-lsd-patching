/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsContactsTransformer;
import de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactAddressTransformer;
import de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactEMailAddressTransformer;
import de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactNumbersTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactCollector;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactTransformer;

public final class ASLPhoneContactsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneContactsDeviceImpl INSTANCE = new ASLPhoneContactsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLPhoneContactsDeviceImpl() {
    }

    public static ASLPhoneContactsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Contacts";
    }

    @Override
    public int getTargetId() {
        return 10083;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1186, this);
        aSLListRegistry.registerASLDevice(1187, this);
        aSLListRegistry.registerASLDevice(1188, this);
        aSLListRegistry.registerASLDevice(1189, this);
        aSLListRegistry.registerASLDevice(1190, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-933489344, 10083);
        serviceRegister.registerService(-1023213504, 10083);
        serviceRegister.registerService(-1006436288, 10083);
        serviceRegister.registerService(-989659072, 10083);
        serviceRegister.registerService(-972881856, 10083);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1186: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1187: {
                nArray = ListColumnsUtil.getIntArrayByBits(191, 7);
                break;
            }
            case 1188: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 1189: {
                nArray = ListColumnsUtil.getIntArrayByBits(62, 5);
                break;
            }
            case 1190: {
                nArray = ListColumnsUtil.getIntArrayByBits(2039, 10);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Contacts: ").append(n).toString());
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
        return ASLPhoneContactsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneContactsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1186: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsSelectedContactEMailAddressTransformer(), n, "Phone.Contacts", "selectedContactEMailAddress");
                break;
            }
            case 1187: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsSelectedContactAddressTransformer(), n, "Phone.Contacts", "selectedContactAddress");
                break;
            }
            case 1188: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsSelectedContactTransformer(), n, "Phone.Contacts", "selectedContact");
                genericASLList.updateList(new PhoneContactsSelectedContactCollector[]{new PhoneContactsSelectedContactCollector()});
                break;
            }
            case 1189: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsSelectedContactNumbersTransformer(), n, "Phone.Contacts", "selectedContactNumbers");
                break;
            }
            case 1190: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneContactsContactsTransformer(), n, "Phone.Contacts", "contacts");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Contacts: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


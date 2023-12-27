/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bap.contactsspeller;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.bap.contactsspeller.transformer.PhoneBAPContactsSpellerSpellerResultCollector;
import generated.de.vw.mib.asl.internal.phone.bap.contactsspeller.transformer.PhoneBAPContactsSpellerSpellerResultTransformer;

public final class ASLPhoneBAPContactsSpellerDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneBAPContactsSpellerDeviceImpl INSTANCE = new ASLPhoneBAPContactsSpellerDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLPhoneBAPContactsSpellerDeviceImpl() {
    }

    public static ASLPhoneBAPContactsSpellerDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.BAP.ContactsSpeller";
    }

    @Override
    public int getTargetId() {
        return 10070;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1111, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1795358784, 10070);
        serviceRegister.registerService(1812136000, 10070);
        serviceRegister.registerService(1828913216, 10070);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1111: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.BAP.ContactsSpeller: ").append(n).toString());
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
        return ASLPhoneBAPContactsSpellerDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneBAPContactsSpellerDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1111: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneBAPContactsSpellerSpellerResultTransformer(), n, "Phone.BAP.ContactsSpeller", "spellerResult");
                genericASLList.updateList(new PhoneBAPContactsSpellerSpellerResultCollector[]{new PhoneBAPContactsSpellerSpellerResultCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.BAP.ContactsSpeller: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


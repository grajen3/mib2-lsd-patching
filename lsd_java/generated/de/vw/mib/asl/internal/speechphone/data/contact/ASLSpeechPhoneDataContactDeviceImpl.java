/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.data.contact;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactAcceptedCallsListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactCallstackDetailListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactCallstackListSelectedItemTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactCallstackListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactContactDetailListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactContactListSelectedItemTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactContactListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactDialedNumbersListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactMissedCallsListTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactNumberListSelectedItemTransformer;
import de.vw.mib.asl.internal.speechphone.data.contact.transformer.SpeechPhoneDataContactNumberListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneDataContactDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneDataContactDeviceImpl INSTANCE = new ASLSpeechPhoneDataContactDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(11);
    private ASLListFactory listFactory;

    private ASLSpeechPhoneDataContactDeviceImpl() {
    }

    public static ASLSpeechPhoneDataContactDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.Data.Contact";
    }

    @Override
    public int getTargetId() {
        return 14909;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-2018952448, this);
        aSLListRegistry.registerASLDevice(-2002175232, this);
        aSLListRegistry.registerASLDevice(-1985398016, this);
        aSLListRegistry.registerASLDevice(-1968620800, this);
        aSLListRegistry.registerASLDevice(-1951843584, this);
        aSLListRegistry.registerASLDevice(-1935066368, this);
        aSLListRegistry.registerASLDevice(-1750516992, this);
        aSLListRegistry.registerASLDevice(-1733739776, this);
        aSLListRegistry.registerASLDevice(-1716962560, this);
        aSLListRegistry.registerASLDevice(-1918289152, this);
        aSLListRegistry.registerASLDevice(-1851180288, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3910023: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 3910024: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 3910025: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 3910026: {
                nArray = ListColumnsUtil.getIntArrayByBits(-65024, 17);
                break;
            }
            case 3910027: {
                nArray = ListColumnsUtil.getSimpleIntArray(14);
                break;
            }
            case 3910028: {
                nArray = ListColumnsUtil.getSimpleIntArray(15);
                break;
            }
            case 3910039: {
                nArray = ListColumnsUtil.getSimpleIntArray(13);
                break;
            }
            case 3910040: {
                nArray = ListColumnsUtil.getSimpleIntArray(13);
                break;
            }
            case 3910041: {
                nArray = ListColumnsUtil.getSimpleIntArray(13);
                break;
            }
            case 3910029: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3910033: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Data.Contact: ").append(n).toString());
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
        return ASLSpeechPhoneDataContactDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechPhoneDataContactDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3910023: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactContactListTransformer(), n, "SpeechPhone.Data.Contact", "ContactList");
                break;
            }
            case 3910024: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactContactDetailListTransformer(), n, "SpeechPhone.Data.Contact", "ContactDetailList");
                break;
            }
            case 3910025: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactContactListSelectedItemTransformer(), n, "SpeechPhone.Data.Contact", "ContactListSelectedItem");
                break;
            }
            case 3910026: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactCallstackListTransformer(), n, "SpeechPhone.Data.Contact", "CallstackList");
                break;
            }
            case 3910027: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactCallstackDetailListTransformer(), n, "SpeechPhone.Data.Contact", "CallstackDetailList");
                break;
            }
            case 3910028: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactCallstackListSelectedItemTransformer(), n, "SpeechPhone.Data.Contact", "CallstackListSelectedItem");
                break;
            }
            case 3910039: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactMissedCallsListTransformer(), n, "SpeechPhone.Data.Contact", "MissedCallsList");
                break;
            }
            case 3910040: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactDialedNumbersListTransformer(), n, "SpeechPhone.Data.Contact", "DialedNumbersList");
                break;
            }
            case 3910041: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactAcceptedCallsListTransformer(), n, "SpeechPhone.Data.Contact", "AcceptedCallsList");
                break;
            }
            case 3910029: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactNumberListTransformer(), n, "SpeechPhone.Data.Contact", "NumberList");
                break;
            }
            case 3910033: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechPhoneDataContactNumberListSelectedItemTransformer(), n, "SpeechPhone.Data.Contact", "NumberListSelectedItem");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechPhone.Data.Contact: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


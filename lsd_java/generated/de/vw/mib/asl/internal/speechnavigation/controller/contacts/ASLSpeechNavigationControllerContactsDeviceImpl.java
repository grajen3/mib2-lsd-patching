/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.contacts;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.SpeechNavigationControllerContactsAddressesTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.SpeechNavigationControllerContactsContactsDetailTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.SpeechNavigationControllerContactsContactsTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.SpeechNavigationControllerContactsSelectedAddressesTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.contacts.transformer.SpeechNavigationControllerContactsSelectedContactTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerContactsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerContactsDeviceImpl INSTANCE = new ASLSpeechNavigationControllerContactsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerContactsDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerContactsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.Contacts";
    }

    @Override
    public int getTargetId() {
        return 14422;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1678259200, this);
        aSLListRegistry.registerASLDevice(1695036416, this);
        aSLListRegistry.registerASLDevice(1711813632, this);
        aSLListRegistry.registerASLDevice(1745368064, this);
        aSLListRegistry.registerASLDevice(1762145280, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1679740096, 14422);
        serviceRegister.registerService(-1646185664, 14422);
        serviceRegister.registerService(-1629408448, 14422);
        serviceRegister.registerService(-1662962880, 14422);
        serviceRegister.registerService(-169790656, 14422);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410020: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 3410021: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 3410022: {
                nArray = ListColumnsUtil.getIntArrayByBits(30, 4);
                break;
            }
            case 3410024: {
                nArray = ListColumnsUtil.getIntArrayByBits(11, 3);
                break;
            }
            case 3410025: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Contacts: ").append(n).toString());
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
        return ASLSpeechNavigationControllerContactsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerContactsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410020: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerContactsContactsTransformer(), n, "SpeechNavigation.Controller.Contacts", "Contacts");
                break;
            }
            case 3410021: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerContactsContactsDetailTransformer(), n, "SpeechNavigation.Controller.Contacts", "ContactsDetail");
                break;
            }
            case 3410022: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerContactsSelectedContactTransformer(), n, "SpeechNavigation.Controller.Contacts", "SelectedContact");
                break;
            }
            case 3410024: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerContactsAddressesTransformer(), n, "SpeechNavigation.Controller.Contacts", "Addresses");
                break;
            }
            case 3410025: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerContactsSelectedAddressesTransformer(), n, "SpeechNavigation.Controller.Contacts", "SelectedAddresses");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.Contacts: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.NavBookSpellerResult;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.PhoneBookSpellerResult;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.AddressListASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.NavBookASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.NavBookWindowedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.NavBookWindowedCachedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.PhoneBookASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.PhoneBookContactDetailsASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.PhoneBookWindowedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.asl.PhoneBookWindowedCachedASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Iterator;
import java.util.List;

public class AddressbookASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements AddressbookService,
NavBookSpellerResult,
PhoneBookSpellerResult {
    private APIFactoryInterface apiFactory;
    private static final int[] ADDRESSBOOK_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{728, 1108};
    private static final int[] ADDRESSBOOK_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{747, 1111, 739, 746, 1109, 1110};
    private static final int[] ADDRESSBOOK_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{127, 125, 126, 123, 67, 70, 71, 72};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$addressbook$AddressbookService;

    public AddressbookASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, ADDRESSBOOK_HMI_EVENT_IDS_TO_LISTEN_TO);
        this.register();
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$addressbook$AddressbookService == null ? (class$de$vw$mib$bap$mqbab2$common$api$addressbook$AddressbookService = AddressbookASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService")) : class$de$vw$mib$bap$mqbab2$common$api$addressbook$AddressbookService;
    }

    @Override
    public Iterator getAddressBook() {
        return new AddressListASLDataPoolIterator();
    }

    @Override
    public int getNumberOfElementsInNavBook() {
        return ListManager.getASLList(746).getSize();
    }

    @Override
    public Iterator getNavBook() {
        return new NavBookASLDataPoolIterator();
    }

    @Override
    public Iterator getWindowedNavBook(int[] nArray) {
        return new NavBookWindowedASLDataPoolIterator(nArray);
    }

    @Override
    public Iterator getWindowedCachedNavBook(int[] nArray) {
        return new NavBookWindowedCachedASLDataPoolIterator(nArray);
    }

    @Override
    public String getNavBookSpellerResultValidChars() {
        ASLList aSLList = ListManager.getASLList(747);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getString(0, object);
    }

    @Override
    public int getNavBookSpellerResultNumberOfEntries() {
        ASLList aSLList = ListManager.getASLList(747);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(1, object);
    }

    @Override
    public int getNavBookSpellerResultIdOfFirstEntry() {
        ASLList aSLList = ListManager.getASLList(747);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(2, object);
    }

    @Override
    public int getNavBookSpellerResultPositionOfFirstEntry() {
        ASLList aSLList = ListManager.getASLList(747);
        Object object = aSLList.getRowItem(0);
        return aSLList.getListTransformer().getInt(3, object);
    }

    @Override
    public NavBookSpellerResult getNavBookSpellerResult() {
        return this;
    }

    @Override
    public final int getNavBookNumberOfEntries() {
        return this.getDataPool().getInteger(728, -1);
    }

    @Override
    public int getNumberOfElementsInPhoneBook() {
        return ListManager.getASLList(1109).getSize();
    }

    @Override
    public Iterator getPhoneBookContacts() {
        return new PhoneBookASLDataPoolIterator();
    }

    @Override
    public Iterator getWindowedPhoneBookContacts(int[] nArray) {
        return new PhoneBookWindowedASLDataPoolIterator(nArray);
    }

    @Override
    public Iterator getWindowedCachedPhoneBookContacts(int[] nArray) {
        return new PhoneBookWindowedCachedASLDataPoolIterator(nArray);
    }

    @Override
    public Iterator getPhoneBookContactDetails() {
        return new PhoneBookContactDetailsASLDataPoolIterator();
    }

    @Override
    public int getPhoneBookNumberOEntries() {
        return this.getDataPool().getInteger(1108, -1);
    }

    @Override
    public String getPhoneBookSpellerResultNextValidChars() {
        return AddressbookASLDataAdapter.getStringListValue(1111, 0);
    }

    @Override
    public int getPhoneBookSpellerResultNumberOfMatchingEntries() {
        return AddressbookASLDataAdapter.getIntegerListValue(1111, 1);
    }

    @Override
    public long getPhoneBookSpellerResultIdOfFirstEntry() {
        return AddressbookASLDataAdapter.getLongListValue(1111, 2);
    }

    @Override
    public int getPhoneBookSpellerResultPositionOfFirstEntry() {
        return AddressbookASLDataAdapter.getIntegerListValue(1111, 3);
    }

    @Override
    public PhoneBookSpellerResult getPhoneBookSpellerResult() {
        return this;
    }

    @Override
    public void getDetailsForPhoneBookEntry(long l) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1778581568, eventGeneric);
    }

    @Override
    public void getAddressBookData(long[] lArray, int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setObject(0, lArray);
        eventGeneric.setInt(1, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1023344576, eventGeneric);
    }

    @Override
    public void startPhoneBookSpeller() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1795358784);
    }

    @Override
    public void stopPhoneBookSpeller() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1812136000);
    }

    @Override
    public void matchStringWithPhoneBookSpeller(String string) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setString(0, string);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1828913216, eventGeneric);
    }

    @Override
    public void startNavBookSpeller() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-956235712);
    }

    @Override
    public void stopNavBookSpeller() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-939458496);
    }

    @Override
    public void matchStringWithNavBookSpeller(String string) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setString(0, string);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-973012928, eventGeneric);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                AddressbookServiceListener addressbookServiceListener = (AddressbookServiceListener)iterator.next();
                addressbookServiceListener.updateAddressbookData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return ADDRESSBOOK_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return ADDRESSBOOK_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addAddressbookServiceListener(AddressbookServiceListener addressbookServiceListener, int[] nArray) {
        this.registerServiceListener((Object)addressbookServiceListener, nArray);
    }

    @Override
    public void removeAddressbookServiceListener(AddressbookServiceListener addressbookServiceListener, int[] nArray) {
        this.removeServiceListener(addressbookServiceListener, nArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


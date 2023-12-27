/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookAddressListElement;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookNavBookElement;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookPhoneBookElement;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationFavoriteDestinationElement;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationLastDestinationElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_Data;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_StatusArray;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.Iterator;

public class AddressList
extends Function
implements TimerNotifier,
Array,
ASLNavSDConstants,
NavigationServiceListener,
AddressbookServiceListener {
    private int currentNumberOfElements = 0;
    private FsgArrayListComplete fullLastDestList = null;
    private Address_List_GetArray lastAddressListGetArray = null;
    private Timer aslRequestTimer;
    private static final int TIMER_ASL_UPDATE_TIME;
    private static final int TIMER_ASL_ACTION_NOTHING;
    private static final int TIMER_ASL_ACTION_WAIT_FOR_ADDRESS_DATA;
    private Timer timer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int WINDOW_LIST_POS_OFFSET;
    private static final int ADDRESS_LIST_POS_OFFSET;
    private static final int MAX_NUMBER_OF_REQUESTED_DETAIL_ENTRIES;
    private static final int UNKNOWN_NUMBER_OF_ELEMENTS;
    private static final int MIN_NUMBER_OF_ELEMENTS_WITHOUT_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    protected static final int[] ADDRESSBOOK_LISTENER_IDS;
    protected static final int[] ADDRESSBOOK_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Address_List_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getAddressbookService().addAddressbookServiceListener(this, ADDRESSBOOK_LISTENER_IDS);
        this.getAddressbookService().addHMIEventListener(this, ADDRESSBOOK_LISTENER_HMI_EVENT_IDS);
        this.aslRequestTimer = this.getTimerService().createTimer(this, 2000);
        this.timer = this.getTimerService().createTimer(this, 1000);
        this.currentNumberOfElements = this.computeTotalNumberOfElements();
        this.setNumberOfAddressListEntries(new Integer(this.currentNumberOfElements));
        return this.getAddressListFullRangeUpdate();
    }

    protected Address_List_ChangedArray dequeueBAPEntity() {
        return (Address_List_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Address_List_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Address_List_ChangedArray = AddressList.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$Address_List_ChangedArray);
    }

    protected void setNumberOfAddressListEntries(Integer n) {
        int[] nArray = new int[]{41};
        this.context.updateStages(this, nArray, n);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 29: {
                this.setFullLastDestList((FsgArrayListComplete)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 33;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void process(int n) {
        int n2 = this.computeTotalNumberOfElements();
        if (n2 != this.currentNumberOfElements) {
            this.currentNumberOfElements = n2;
            this.addressListDataChanged();
            this.setNumberOfAddressListEntries(new Integer(this.currentNumberOfElements));
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        Address_List_GetArray address_List_GetArray = (Address_List_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(address_List_GetArray)) {
            int n;
            boolean bl;
            switch (address_List_GetArray.otherListType) {
                case 0: {
                    bl = true;
                    n = (int)this.fullLastDestList.getInternalUserId(address_List_GetArray.otherList_Reference);
                    break;
                }
                case 1: {
                    bl = true;
                    n = address_List_GetArray.otherList_Reference - 1;
                    break;
                }
                case 2: {
                    bl = true;
                    n = address_List_GetArray.otherList_Reference - 1;
                    break;
                }
                case 3: {
                    bl = true;
                    n = address_List_GetArray.otherList_Reference - 1;
                    break;
                }
                default: {
                    bl = false;
                    n = 0;
                }
            }
            if (bl) {
                if (address_List_GetArray.otherList_Reference == 0 && address_List_GetArray.getArrayHeader().start == 0) {
                    n = 0;
                }
                long[] lArray = null;
                switch (address_List_GetArray.otherListType) {
                    case 0: {
                        lArray = this.checkAndReturnTheEntriesForLastDestinations(n, address_List_GetArray.getArrayHeader().elements);
                        break;
                    }
                    case 1: {
                        this.checkAndReturnTheEntriesForFavoriteDestinations(n, address_List_GetArray.getArrayHeader().elements);
                        break;
                    }
                    case 2: {
                        this.checkAndReturnTheEntriesForNavBook(n, address_List_GetArray.getArrayHeader().elements);
                        break;
                    }
                    case 3: {
                        this.checkAndReturnTheEntriesForPhoneBook(n, address_List_GetArray.getArrayHeader().elements);
                        break;
                    }
                    default: {
                        lArray = null;
                    }
                }
                if (lArray == null) {
                    this.transmitStatus(AddressList.getAddressListEmptyList(address_List_GetArray));
                } else {
                    this.getAddressbookService().getAddressBookData(lArray, address_List_GetArray.otherListType);
                    this.lastAddressListGetArray = address_List_GetArray;
                    this.aslRequestTimer.retrigger(new Integer(1));
                }
            } else {
                this.transmitStatus(AddressList.getAddressListEmptyList(address_List_GetArray));
            }
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
        this.getArrayRequestTracker().requestAcknowledge();
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.aslRequestTimer.stop();
        this.timer.stop();
        this.getArrayRequestTracker().reset();
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getAddressbookService().removeAddressbookServiceListener(this, ADDRESSBOOK_LISTENER_IDS);
        this.getAddressbookService().removeHMIEventListener(this, ADDRESSBOOK_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    protected void addressListDataFilled() {
        if (this.aslRequestTimer.isRunning()) {
            Address_List_StatusArray address_List_StatusArray = new Address_List_StatusArray();
            address_List_StatusArray.setArrayHeader(this.lastAddressListGetArray.getArrayHeader());
            ArrayHeader arrayHeader = address_List_StatusArray.getArrayHeader();
            this.fillTheAddressListData(address_List_StatusArray);
            address_List_StatusArray.asg_Id = this.lastAddressListGetArray.asg_Id;
            address_List_StatusArray.taid = this.lastAddressListGetArray.taid;
            address_List_StatusArray.otherListType = this.lastAddressListGetArray.otherListType;
            address_List_StatusArray.otherList_Reference = this.lastAddressListGetArray.otherList_Reference;
            arrayHeader.elements = address_List_StatusArray.getArrayData().size();
            arrayHeader.mode.arrayDirectionIsBackward = false;
            arrayHeader.mode.shift = false;
            switch (this.lastAddressListGetArray.otherListType) {
                case 0: {
                    address_List_StatusArray.totalNumListElements = this.getNavigationService().getNumberOfElementsInLastDestinations();
                    break;
                }
                case 1: {
                    address_List_StatusArray.totalNumListElements = this.getNavigationService().getNumberOfElementsInFavoriteDestinations();
                    break;
                }
                case 2: {
                    address_List_StatusArray.totalNumListElements = this.getAddressbookService().getNavBookNumberOfEntries();
                    break;
                }
                case 3: {
                    address_List_StatusArray.totalNumListElements = this.getAddressbookService().getNumberOfElementsInPhoneBook();
                    break;
                }
                default: {
                    address_List_StatusArray.totalNumListElements = -65536;
                }
            }
            this.transmitStatus(address_List_StatusArray);
            this.aslRequestTimer.setUserInfo(new Integer(0));
            this.lastAddressListGetArray = null;
        }
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 129: {
                this.addressListDataChanged();
                break;
            }
            case 1: {
                if (this.lastAddressListGetArray != null) {
                    this.getDelegate().getArrayListener(this).requestError(65, this);
                }
                this.lastAddressListGetArray = null;
                break;
            }
        }
    }

    private void transmitStatus(Address_List_StatusArray address_List_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(address_List_StatusArray);
    }

    private Address_List_ChangedArray getAddressListFullRangeUpdate() {
        Address_List_ChangedArray address_List_ChangedArray = this.dequeueBAPEntity();
        address_List_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return address_List_ChangedArray;
    }

    private long[] checkAndReturnTheEntriesForLastDestinations(int n, int n2) {
        long[] lArray;
        NavigationService navigationService = this.getNavigationService();
        int n3 = navigationService.getNumberOfElementsInLastDestinations();
        if (n2 <= 0 || n < 0 || n >= n3) {
            lArray = null;
        } else {
            int n4 = n2 > 2 || n + n2 >= n3 ? Math.min(2, n3 - n) : n2;
            int n5 = n;
            int[] nArray = new int[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                nArray[i2] = n5++;
            }
            Iterator iterator = navigationService.getWindowedCachedLastDestinations(nArray);
            int n6 = 0;
            lArray = new long[n4];
            while (iterator.hasNext()) {
                NavigationLastDestinationElement navigationLastDestinationElement = (NavigationLastDestinationElement)iterator.next();
                lArray[n6] = navigationLastDestinationElement.getContactEntryId();
                ++n6;
            }
        }
        return lArray;
    }

    private long[] checkAndReturnTheEntriesForFavoriteDestinations(int n, int n2) {
        long[] lArray;
        NavigationService navigationService = this.getNavigationService();
        int n3 = navigationService.getNumberOfElementsInFavoriteDestinations();
        if (n2 <= 0 || n < 0 || n >= n3) {
            lArray = null;
        } else {
            int n4 = n2 > 2 || n + n2 >= n3 ? Math.min(2, n3 - n) : n2;
            int n5 = n;
            int[] nArray = new int[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                nArray[i2] = n5++;
            }
            Iterator iterator = navigationService.getWindowedCachedFavoriteDestinations(nArray);
            int n6 = 0;
            lArray = new long[n4];
            while (iterator.hasNext()) {
                NavigationFavoriteDestinationElement navigationFavoriteDestinationElement = (NavigationFavoriteDestinationElement)iterator.next();
                lArray[n6] = navigationFavoriteDestinationElement.getContactEntryId();
                ++n6;
            }
        }
        return lArray;
    }

    private long[] checkAndReturnTheEntriesForNavBook(int n, int n2) {
        long[] lArray;
        AddressbookService addressbookService = this.getAddressbookService();
        int n3 = addressbookService.getNumberOfElementsInNavBook();
        if (n2 <= 0 || n < 0 || n >= n3) {
            lArray = null;
        } else {
            int n4 = n2 > 2 || n + n2 >= n3 ? Math.min(2, n3 - n) : n2;
            int n5 = n;
            int[] nArray = new int[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                nArray[i2] = n5++;
            }
            Iterator iterator = addressbookService.getWindowedCachedNavBook(nArray);
            int n6 = 0;
            lArray = new long[n4];
            while (iterator.hasNext()) {
                AddressbookNavBookElement addressbookNavBookElement = (AddressbookNavBookElement)iterator.next();
                lArray[n6] = addressbookNavBookElement.getEntryId();
                ++n6;
            }
        }
        return lArray;
    }

    private long[] checkAndReturnTheEntriesForPhoneBook(int n, int n2) {
        long[] lArray;
        AddressbookService addressbookService = this.getAddressbookService();
        int n3 = addressbookService.getNumberOfElementsInPhoneBook();
        if (n2 <= 0 || n < 0 || n >= n3) {
            lArray = null;
        } else {
            int n4 = n2 > 2 || n + n2 >= n3 ? Math.min(2, n3 - n) : n2;
            int n5 = n;
            int[] nArray = new int[n4];
            for (int i2 = 0; i2 < n4; ++i2) {
                nArray[i2] = n5++;
            }
            Iterator iterator = addressbookService.getWindowedCachedPhoneBookContacts(nArray);
            int n6 = 0;
            lArray = new long[n4];
            while (iterator.hasNext()) {
                AddressbookPhoneBookElement addressbookPhoneBookElement = (AddressbookPhoneBookElement)iterator.next();
                lArray[n6] = addressbookPhoneBookElement.getContactEntryId();
                ++n6;
            }
        }
        return lArray;
    }

    protected void fillTheAddressListData(Address_List_StatusArray address_List_StatusArray) {
        Iterator iterator = this.getAddressbookService().getAddressBook();
        int n = 1;
        BAPArrayData bAPArrayData = address_List_StatusArray.getArrayData();
        while (iterator.hasNext()) {
            Address_List_Data address_List_Data = new Address_List_Data(address_List_StatusArray.getArrayHeader());
            AddressbookAddressListElement addressbookAddressListElement = (AddressbookAddressListElement)iterator.next();
            address_List_Data.setPos(n++);
            address_List_Data.lastName.setContent(addressbookAddressListElement.getLastName());
            address_List_Data.firstName.setContent(addressbookAddressListElement.getFirstName());
            address_List_Data.street.setContent(addressbookAddressListElement.getStreet());
            address_List_Data.city.setContent(addressbookAddressListElement.getCity());
            address_List_Data.region.setContent(addressbookAddressListElement.getRegion());
            address_List_Data.postalCode.setContent(addressbookAddressListElement.getPostalCode());
            address_List_Data.country.setContent(addressbookAddressListElement.getCountry());
            address_List_Data.coordinates.setContent(addressbookAddressListElement.getCoordinates());
            address_List_Data.poi_Description.setContent(addressbookAddressListElement.getPoiDescriptions());
            address_List_Data.poi_Type = addressbookAddressListElement.getPoiType();
            address_List_Data.address_Type = addressbookAddressListElement.getAddressType();
            bAPArrayData.add(address_List_Data);
        }
        address_List_StatusArray.getArrayHeader().mode.arrayPositionIsTransmitted = bAPArrayData.size() != 0 && (address_List_StatusArray.getArrayHeader().mode.shift || address_List_StatusArray.getArrayHeader().elements != 1 || address_List_StatusArray.getArrayHeader().start != 0);
    }

    private int computeTotalNumberOfElements() {
        NavigationService navigationService = this.getNavigationService();
        AddressbookService addressbookService = this.getAddressbookService();
        Iterator iterator = navigationService.getLastDestinations();
        Iterator iterator2 = navigationService.getFavoriteDestinations();
        Iterator iterator3 = addressbookService.getPhoneBookContacts();
        Iterator iterator4 = addressbookService.getNavBook();
        int n = 0;
        while (iterator.hasNext()) {
            iterator.next();
            ++n;
        }
        while (iterator2.hasNext()) {
            iterator2.next();
            ++n;
        }
        while (iterator3.hasNext()) {
            iterator3.next();
            ++n;
        }
        while (iterator4.hasNext()) {
            iterator4.next();
            ++n;
        }
        return n;
    }

    private static Address_List_StatusArray getAddressListEmptyList(Address_List_GetArray address_List_GetArray) {
        Address_List_StatusArray address_List_StatusArray = new Address_List_StatusArray();
        address_List_StatusArray.setArrayHeader(address_List_GetArray.getArrayHeader());
        address_List_StatusArray.totalNumListElements = 0;
        address_List_StatusArray.getArrayHeader().elements = 0;
        return address_List_StatusArray;
    }

    private Address_List_ChangedArray searchForChangeContent() {
        return this.getAddressListFullRangeUpdate();
    }

    private void addressListDataChanged() {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(129));
        } else {
            Address_List_ChangedArray address_List_ChangedArray = this.searchForChangeContent();
            if (address_List_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(address_List_ChangedArray);
                this.timer.retrigger(new Integer(128));
            }
        }
    }

    protected void setFullLastDestList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullLastDestList = fsgArrayListComplete;
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 67: {
                this.addressListDataFilled();
                break;
            }
        }
    }

    @Override
    public void updateAddressbookData(AddressbookService addressbookService, int n) {
        this.process(-1);
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        NAVIGATION_LISTENER_IDS = new int[]{745, 740};
        ADDRESSBOOK_LISTENER_IDS = new int[]{739, 1109};
        ADDRESSBOOK_LISTENER_HMI_EVENT_IDS = new int[]{67};
    }
}


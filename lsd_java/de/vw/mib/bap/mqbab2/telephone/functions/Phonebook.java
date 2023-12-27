/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookPhoneBookContactDetailsElement;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookPhoneBookElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$BAPArrayListDelegate;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.PbState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_Data;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_GetArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_StatusArray;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public class Phonebook
extends Function
implements TimerNotifier,
FsgArrayListWindowed$BAPArrayListDelegate,
Array,
ASLTelephoneConstants,
AddressbookServiceListener {
    private FsgArrayListWindowed _windowedArrayList;
    private static final int TRANSMIT_LONG_POS_THRESHOLD;
    private static final int POS_OFFSET;
    private Phonebook_GetArray lastPhonebookGetArray = null;
    private int pbDownloadStatus = 2;
    private Timer aslRequestTimer = null;
    private static final int TIMER_ASL_UPDATE_TIME;
    private static final int TIMER_ASL_ACTION_NOTHING;
    private static final int TIMER_ASL_ACTION_WAIT_FOR_VIEW_CHANGE;
    private static final int TIMER_ASL_ACTION_WAIT_DETAIL_INFO;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_OVERVIEW_DATA;
    private static final int MAX_ELEMENTS_DETAIL_INFO_DATA;
    private static final int MAX_ELEMENTS_LIGHT_DETAIL_INFO_DATA;
    private static final int MAX_ELEMENTS_DETAIL_INFO_DATA2;
    private static final int MAX_ELEMENTS_POS_DATA;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    protected static final int[] ADDRESSBOOK_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getAddressbookService().addHMIEventListener(this, ADDRESSBOOK_LISTENER_HMI_EVENT_IDS);
        this.aslRequestTimer = this.getTimerService().createTimer(this, 2000);
        this.timer = this.getTimerService().createTimer(this, 400);
        this._windowedArrayList = new FsgArrayListWindowed(1109, this);
        this._windowedArrayList.initialize();
        return this.getPhonebookFullRangeUpdate();
    }

    protected Phonebook_ChangedArray dequeueBAPEntity() {
        return (Phonebook_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_ChangedArray = Phonebook.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 51: {
                this.setPhoneBookStateStatus((PbState_Status)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 52;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void process(int n) {
    }

    private void aslphonebookListChanged() {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(129));
        } else {
            Phonebook_ChangedArray phonebook_ChangedArray = this.searchForChangeContent();
            if (phonebook_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(phonebook_ChangedArray);
                this.timer.retrigger(new Integer(128));
            }
        }
    }

    private static Phonebook_StatusArray getEmptyArray(Phonebook_GetArray phonebook_GetArray) {
        Phonebook_StatusArray phonebook_StatusArray = new Phonebook_StatusArray();
        phonebook_StatusArray.setArrayHeader(phonebook_GetArray.getArrayHeader());
        phonebook_StatusArray.asg_Id = phonebook_GetArray.asg_Id;
        phonebook_StatusArray.taid = phonebook_GetArray.taid;
        phonebook_StatusArray.totalNumListElements = 0;
        phonebook_StatusArray.getArrayHeader().elements = 0;
        return phonebook_StatusArray;
    }

    private boolean isContactsDownloadInProgress() {
        return this.pbDownloadStatus == 1;
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        Phonebook_GetArray phonebook_GetArray = (Phonebook_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(phonebook_GetArray)) {
            int n = Phonebook.maximumElementsForRecordAddress(phonebook_GetArray.getArrayHeader().getRecordAddress());
            if (phonebook_GetArray.getArrayHeader().getNumberOfElements() > n) {
                arrayListener.requestError(67, this);
            } else if (this.isContactsDownloadInProgress()) {
                this.getArrayRequestTracker().reportStatusArray(Phonebook.getEmptyArray(phonebook_GetArray));
            } else if (!this.aslRequestTimer.isRunning()) {
                FsgArrayRequestData fsgArrayRequestData = this.computeArrayRequestData(this._windowedArrayList, phonebook_GetArray);
                if (this._windowedArrayList.getSize() != 0 && this.checkAndRequestPhonebookDetailInfo(phonebook_GetArray.getArrayHeader().getRecordAddress(), fsgArrayRequestData.getStartOfList())) {
                    this.lastPhonebookGetArray = phonebook_GetArray;
                    this.aslRequestTimer.retrigger(new Integer(2));
                } else {
                    this._requestWindowedGetArrayRequest(phonebook_GetArray);
                }
            }
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(69, this);
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
        this.getAddressbookService().removeHMIEventListener(this, ADDRESSBOOK_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    private Phonebook_ChangedArray searchForChangeContent() {
        return this.getPhonebookFullRangeUpdate();
    }

    private void transmitStatus(Phonebook_StatusArray phonebook_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(phonebook_StatusArray);
    }

    private Phonebook_ChangedArray getPhonebookFullRangeUpdate() {
        Phonebook_ChangedArray phonebook_ChangedArray = this.dequeueBAPEntity();
        phonebook_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return phonebook_ChangedArray;
    }

    private void _requestWindowedGetArrayRequest(Phonebook_GetArray phonebook_GetArray) {
        this.aslRequestTimer.retrigger(new Integer(1));
        this._windowedArrayList.processGetArray(phonebook_GetArray);
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 5;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 1;
                break;
            }
            case 15: {
                n2 = 20;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static boolean isDetailInformationForRecordAddressNeeded(int n) {
        boolean bl;
        switch (n) {
            case 0: 
            case 2: 
            case 3: 
            case 4: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private boolean checkAndRequestPhonebookDetailInfo(int n, int n2) {
        boolean bl;
        if (Phonebook.isDetailInformationForRecordAddressNeeded(n)) {
            if (n2 < 0) {
                bl = false;
            } else {
                Iterator iterator = this.getAddressbookService().getWindowedPhoneBookContacts(new int[]{n2});
                AddressbookPhoneBookElement addressbookPhoneBookElement = (AddressbookPhoneBookElement)iterator.next();
                this.getAddressbookService().getDetailsForPhoneBookEntry(addressbookPhoneBookElement.getContactEntryId());
                bl = true;
            }
        } else {
            bl = false;
        }
        return bl;
    }

    private int mapToBAPNumberType(int n) {
        int n2;
        if (n != -1) {
            int n3 = 6944;
            int n4 = n & 0xFFFFE4DF;
            switch (n4) {
                case 8: {
                    n2 = 0;
                    break;
                }
                case 64: {
                    n2 = 2;
                    break;
                }
                case 2: {
                    n2 = 0;
                    break;
                }
                case 4: {
                    n2 = 0;
                    break;
                }
                case 16: {
                    n2 = 5;
                    break;
                }
                case 128: {
                    n2 = 6;
                    break;
                }
                case 1024: {
                    n2 = 7;
                    break;
                }
                case 3: {
                    n2 = 3;
                    break;
                }
                case 5: {
                    n2 = 4;
                    break;
                }
                case 66: {
                    n2 = 0;
                    break;
                }
                case 68: {
                    n2 = 0;
                    break;
                }
                case 18: {
                    n2 = 13;
                    break;
                }
                case 20: {
                    n2 = 14;
                    break;
                }
                default: {
                    n2 = 0;
                    break;
                }
            }
        } else {
            n2 = 0;
        }
        return n2;
    }

    protected void newContactsDetailInformation() {
        if (this.aslRequestTimer.isRunning()) {
            this._requestWindowedGetArrayRequest(this.lastPhonebookGetArray);
        }
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 129: {
                this.aslphonebookListChanged();
                break;
            }
            case 1: {
                if (this.lastPhonebookGetArray != null) {
                    Phonebook_StatusArray phonebook_StatusArray = Phonebook.getEmptyArray(this.lastPhonebookGetArray);
                    phonebook_StatusArray.totalNumListElements = this._windowedArrayList.getSize();
                    this.transmitStatus(phonebook_StatusArray);
                    break;
                }
                this.getDelegate().getArrayListener(this).requestError(66, this);
                break;
            }
            case 2: {
                if (this.lastPhonebookGetArray == null) break;
                break;
            }
        }
    }

    private void setAnyVoiceTag(Phonebook_Data phonebook_Data, int n) {
        phonebook_Data.anyVoiceTag.anyVoiceTagAvailable = (n & 1) == 1;
        phonebook_Data.anyVoiceTag.voiceTagForStandardNumberAvailable = (n & 2) == 2;
    }

    private void setAddressIndication(Phonebook_Data phonebook_Data, int n) {
        phonebook_Data.adressIndication.defaultAddressAvailable = (n & 1) == 1;
        phonebook_Data.adressIndication.defaultAddressIsSuitedAsNavigationDestaination = (n & 2) == 2;
        phonebook_Data.adressIndication.privateAddressAvailable = (n & 4) == 4;
        phonebook_Data.adressIndication.privateAddressIsSuitedAsNavigationDestaination = (n & 8) == 8;
        phonebook_Data.adressIndication.businessAddressAvailable = (n & 0x10) == 16;
        phonebook_Data.adressIndication.businessAddressIsSuitedAsNavigationDestaination = (n & 0x20) == 32;
    }

    protected void setPhoneBookStateStatus(PbState_Status pbState_Status) {
        this.pbDownloadStatus = pbState_Status.downloadState;
    }

    @Override
    public void getArrayAnswer(FsgArrayListWindowed fsgArrayListWindowed, FsgArrayPosIdIterator fsgArrayPosIdIterator, FsgArrayRequestData fsgArrayRequestData, int[] nArray, BAPGetArray bAPGetArray) {
        Phonebook_StatusArray phonebook_StatusArray = new Phonebook_StatusArray();
        Phonebook_GetArray phonebook_GetArray = (Phonebook_GetArray)bAPGetArray;
        fsgArrayRequestData.setStatusArrayHeaderData(phonebook_StatusArray, phonebook_GetArray, fsgArrayListWindowed);
        Iterator iterator = this.getAddressbookService().getWindowedPhoneBookContacts(nArray);
        BAPArrayData bAPArrayData = phonebook_StatusArray.getArrayData();
        while (iterator.hasNext() && fsgArrayPosIdIterator.hasNext()) {
            int n = fsgArrayPosIdIterator.next() + 1;
            AddressbookPhoneBookElement addressbookPhoneBookElement = (AddressbookPhoneBookElement)iterator.next();
            Phonebook_Data phonebook_Data = new Phonebook_Data(phonebook_StatusArray.getArrayHeader(), addressbookPhoneBookElement.getContactTelNumberCount());
            phonebook_Data.setPos(n);
            phonebook_Data.pbName.setContent(addressbookPhoneBookElement.getContactName());
            phonebook_Data.storage = addressbookPhoneBookElement.getContactStorageType();
            this.setAnyVoiceTag(phonebook_Data, addressbookPhoneBookElement.getContactAnyVoiceTag());
            this.setAddressIndication(phonebook_Data, addressbookPhoneBookElement.getContactEntryMetaData());
            Iterator iterator2 = this.getAddressbookService().getPhoneBookContactDetails();
            if (Phonebook.isDetailInformationForRecordAddressNeeded(phonebook_StatusArray.getArrayHeader().getRecordAddress()) && iterator2.hasNext()) {
                int n2 = 0;
                while (iterator2.hasNext()) {
                    AddressbookPhoneBookContactDetailsElement addressbookPhoneBookContactDetailsElement = (AddressbookPhoneBookContactDetailsElement)iterator2.next();
                    if (addressbookPhoneBookContactDetailsElement.getContactDetailsNumber() == null || addressbookPhoneBookContactDetailsElement.getContactDetailsNumber().length() == 0) continue;
                    phonebook_Data.telNumberN[n2].setContent(addressbookPhoneBookContactDetailsElement.getContactDetailsNumber());
                    phonebook_Data.voiceTagN[n2].voiceTagAvailable = addressbookPhoneBookContactDetailsElement.getContactDetailsVoiceTag();
                    phonebook_Data.numberTypeN[n2] = this.mapToBAPNumberType(addressbookPhoneBookContactDetailsElement.getContactDetailsNumberType());
                    ++n2;
                }
                phonebook_Data.telNumberQuantity = n2;
            }
            bAPArrayData.add(phonebook_Data);
        }
        fsgArrayRequestData.setTransmissionPosForArbitraryArray(phonebook_StatusArray);
        this.transmitStatus(phonebook_StatusArray);
        this.aslRequestTimer.stop();
    }

    @Override
    public FsgArrayRequestData computeArrayRequestData(FsgArrayListWindowed fsgArrayListWindowed, BAPGetArray bAPGetArray) {
        return FsgArrayRequestData.computeArrayRequestData(bAPGetArray.getArrayHeader(), fsgArrayListWindowed.getSize(), bAPGetArray.getArrayHeader().start - 1, Phonebook.maximumElementsForRecordAddress(bAPGetArray.getArrayHeader().getRecordAddress()));
    }

    @Override
    public void listWasChanged(FsgArrayListWindowed fsgArrayListWindowed) {
        this.aslphonebookListChanged();
    }

    @Override
    public void listCacheCleared(FsgArrayListWindowed fsgArrayListWindowed) {
        this.aslphonebookListChanged();
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 123: {
                this.newContactsDetailInformation();
                break;
            }
        }
    }

    @Override
    public void updateAddressbookData(AddressbookService addressbookService, int n) {
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
        ADDRESSBOOK_LISTENER_HMI_EVENT_IDS = new int[]{123};
    }
}


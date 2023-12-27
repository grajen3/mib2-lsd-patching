/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsHandling;
import de.vw.mib.asl.internal.phone.contacts.PhoneSearchFetcher;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DataSet;

public class StateContactsHandlingContactHandling
extends AbstractHsmState {
    private final HsmPhoneContactsHandling target;
    private static final int EV_ASL_INT_RESP_GET_ENTRY_RESULT;
    private int sortingType = 0;
    private int genDescType1 = 1;
    private int genDescType2 = 5;
    DataSet selectedDataSet = null;
    AdbEntry selectedAdbEntry = null;

    public StateContactsHandlingContactHandling(HsmPhoneContactsHandling hsmPhoneContactsHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneContactsHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742790: {
                if (!PhoneUtil.setTelephoneListStyle(this.target.dsiAdbList, this.target.filterType, this.genDescType1, this.genDescType2, true)) break;
                ASLPhoneData.getInstance().newContactsSortOrderInitiated = true;
                PhoneUtil.updateContactsSize(0);
                break;
            }
            case 3500006: {
                this.target.filterType = 0;
                this.genDescType1 = 1;
                this.genDescType2 = 5;
                PhoneUtil.setTelephoneListStyle(this.target.dsiAdbList, this.target.filterType, this.genDescType1, this.genDescType2, false);
                break;
            }
            case 1073742788: {
                this.selectedAdbEntry = null;
                this.selectedDataSet = null;
                this.target.selectedContactEntryId = eventGeneric.getLong(0);
                this.target.singleNumberSelectedContact = !ListManager.getGenericASLList(1190).getListTransformer().getBoolean(8, ListManager.getGenericASLList(1190).getListItemByIdCacheOnly(this.target.selectedContactEntryId));
                PhoneUtil.getContactsDetails(this.target, 5261, -863567616, this.target.selectedContactEntryId, true);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(5261, 5250, -1863436800);
                eventGeneric2.setLong(0, this.target.selectedContactEntryId);
                this.target.send(eventGeneric2);
                break;
            }
            case 3600017: {
                this.selectedDataSet = (DataSet)eventGeneric.getObject(0);
                this.updateSelectedContactDataIfPossible();
                break;
            }
            case 100300: {
                if (eventGeneric.getResult() != 0) break;
                ASLPhoneData.getInstance().adbEntryContactsCached = this.selectedAdbEntry = (AdbEntry)eventGeneric.getObject(1);
                this.updateSelectedContactDataIfPossible();
                break;
            }
            case 1073742789: {
                this.sortingType = eventGeneric.getInt(0);
                switch (this.sortingType) {
                    case 1: {
                        this.target.filterType = 1;
                        this.genDescType1 = 2;
                        this.genDescType2 = 1;
                        ASLPhoneData.getInstance().contactsSortedByCriteria = 1;
                        break;
                    }
                    case 2: {
                        this.target.filterType = 2;
                        this.genDescType1 = 3;
                        this.genDescType2 = 1;
                        ASLPhoneData.getInstance().contactsSortedByCriteria = 2;
                        break;
                    }
                    default: {
                        this.sortingType = 0;
                        this.target.filterType = 0;
                        this.genDescType1 = 1;
                        this.genDescType2 = 5;
                        ASLPhoneData.getInstance().contactsSortedByCriteria = 0;
                    }
                }
                if (!PhoneUtil.setTelephoneListStyle(this.target.dsiAdbList, this.target.filterType, this.genDescType1, this.genDescType2, true)) break;
                ASLPhoneData.getInstance().newContactsSortOrderInitiated = true;
                break;
            }
            case 1073742787: {
                this.target.dsiAdbUserProfile.restartDownload();
                break;
            }
            case 1075141832: {
                int n = eventGeneric.getInt(0);
                AddressData addressData = (AddressData)ListManager.getGenericASLList(1187).getDSIObjects()[n];
                NavAddress navAddress = new NavAddress();
                navAddress.setCity(addressData.getLocality());
                navAddress.setCountry(addressData.getCountry());
                navAddress.setStreet(addressData.getStreet());
                navAddress.setZip(addressData.getPostalCode());
                navAddress.setState(addressData.getRegion());
                ASLNavigationServices aSLNavigationServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(null);
                if (!Util.isNullOrEmpty(addressData.getGeoPosition())) {
                    int[] nArray = aSLNavigationServices.parseGeoPositionVCard3_0(addressData.getGeoPosition());
                    navAddress.setLatitude(nArray[0]);
                    navAddress.setLongitude(nArray[1]);
                }
                aSLNavigationServices.startGuidance(new NavAddress[]{navAddress}, true, 2);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void updateSelectedContactDataIfPossible() {
        if (this.selectedDataSet != null && this.selectedAdbEntry != null) {
            this.target.setSelectedContactInformation(this.selectedDataSet);
            PhoneUtil.updateSelectedContactData(this.selectedAdbEntry, this.target);
        }
    }

    public void dsiAdbUserProfileUpdateDownloadState(int n, int n2, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("UpdateDownloadState received in StateContactsHandlingContactHandling");
        }
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                if (ASLPhoneData.viewSizeContacts.getPhone() != 0) break;
                this.target.updateDownloadStatus(1);
                break;
            }
            default: {
                if (ASLPhoneData.viewSizeContacts.getAll() == 0) {
                    this.target.updateDownloadStatus(2);
                    break;
                }
                if (ASLPhoneData.viewSizeContacts.getPhone() == 0) {
                    this.target.updateDownloadStatus(4);
                    break;
                }
                this.target.updateDownloadStatus(3);
            }
        }
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        ASLPhoneData.viewSizeContacts = adbViewSize;
        if (adbViewSize != null) {
            if (PhoneSearchFetcher.spellerHandle <= -1) {
                PhoneUtil.updateContactsSize(adbViewSize.phone);
                ListManager.getGenericASLList(1190).updateStringIndex(ASLPhoneData.getInstance().characterInfos.getIndices(), ASLPhoneData.getInstance().characterInfos.getCharacters());
            }
            if (adbViewSize.getPhone() == 0) {
                if (!ASLPhoneData.getInstance().downloadInProgress) {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1180, 0);
                    AbstractASLHsmTarget.writeIntegerToDatapool(-1277031168, 0);
                    AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
                    AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
                    if (adbViewSize.getAll() == 0) {
                        this.target.updateDownloadStatus(2);
                    } else {
                        this.target.updateDownloadStatus(4);
                    }
                    if (this.target.isTraceEnabled()) {
                        this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by updateViewSize(phone=0)").log();
                    }
                }
            } else {
                this.target.updateDownloadStatus(3);
            }
        }
    }

    public void dsiAdbEditUpdateNewEntryAvailable(boolean bl, int n) {
        AbstractASLHsmTarget.writeBooleanToDatapool(1185, bl);
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("GetViewWindowResult received in StateContactsHandlingContactHandling");
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(1180, 0);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1277031168, 0);
        if (n == 0) {
            PhoneUtil.updateContactsSize(n2);
            if (!Util.isNullOrEmpty(dataSetArray)) {
                ListManager.getGenericASLList(1190).updateListItems(dataSetArray[0].entryPosition, dataSetArray);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("updated ").append(dataSetArray.length).append(" listitems in StateContactsHandlingContactHandling").log();
                }
            } else {
                ListManager.getGenericASLList(1190).setSize(0);
                if (this.target.isTraceEnabled()) {
                    this.target.trace("changed listsize to 0 in StateContactsHandlingContactHandling");
                }
            }
            AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by getViewWindowResult").log();
            }
        }
    }

    public void dsiAdbListSetListStyleResult(int n) {
        if (n == 0) {
            switch (this.sortingType) {
                case 0: {
                    ASLPhoneData.getInstance().contactsSortedByCriteria = 0;
                    break;
                }
                case 1: {
                    ASLPhoneData.getInstance().contactsSortedByCriteria = 1;
                    break;
                }
                case 2: {
                    ASLPhoneData.getInstance().contactsSortedByCriteria = 2;
                    break;
                }
                default: {
                    ASLPhoneData.getInstance().contactsSortedByCriteria = 0;
                }
            }
            AbstractASLHsmTarget.writeIntegerToDatapool(1182, this.sortingType);
        }
    }

    public void dsiAdbListInvalidData(int n) {
        if (n != 3 && ASLPhoneData.getInstance().newContactsSortOrderInitiated) {
            PhoneUtil.setTelephoneListStyle(this.target.dsiAdbList, this.target.filterType, this.genDescType1, this.genDescType2, true);
            ASLPhoneData.getInstance().newContactsSortOrderInitiated = false;
        }
        if (ASLPhoneData.viewSizeContacts != null) {
            int n2 = PhoneSearchFetcher.spellerHandle <= -1 ? ASLPhoneData.viewSizeContacts.phone : PhoneSearchFetcher.spelleredListSize;
            PhoneUtil.updateContactsSize(0);
            PhoneUtil.updateContactsSize(n2);
            if (n == 0 && n2 != 0) {
                AbstractASLHsmTarget.writeBooleanToDatapool(3230, true);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, true);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to true by invalidData(==unspecific)").log();
                }
            }
        }
        if (ASLPhoneData.viewSizeContacts == null || ASLPhoneData.viewSizeContacts.phone == 0) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1180, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(-1277031168, 0);
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1192, false);
    }

    public void dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("GetSpellerViewWindowResult received in StateContactsHandlingContactHandling");
        }
        if (n == 0) {
            PhoneUtil.updateContactsSize(n3);
            if (!Util.isNullOrEmpty(dataSetArray)) {
                ListManager.getGenericASLList(1190).updateListItems(dataSetArray[0].entryPosition, dataSetArray);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("updated ").append(dataSetArray.length).append(" listitems in StateContactsHandlingContactHandling").log();
                }
            } else {
                ListManager.getGenericASLList(1190).setSize(0);
                if (this.target.isTraceEnabled()) {
                    this.target.trace("changed listsize to 0 in StateContactsHandlingContactHandling");
                }
            }
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by getSpellerViewWindowResult").log();
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(1180, 0);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1277031168, 0);
    }
}


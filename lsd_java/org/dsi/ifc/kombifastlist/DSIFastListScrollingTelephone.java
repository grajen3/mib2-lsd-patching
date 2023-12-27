/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public interface DSIFastListScrollingTelephone
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INDICATIONPHONEBOOK;
    public static final int IN_INDICATIONGETINITIALSTELEPHONE;
    public static final int IN_INDICATIONNOTIFYFAVORITELISTPUSH;
    public static final int IN_INDICATIONNOTIFYCOMBINEDNUMBERSPUSH;
    public static final int IN_INDICATIONNOTIFYCURRENTLISTSIZETELEPHONE;
    public static final int IN_INDICATIONPHONEBOOKJOBS;
    public static final int RT_PUSHFUNCTIONAVAILABILITYTELEPHONE;
    public static final int RT_PUSHMOSTOPERATIONSTATETELEPHONE;
    public static final int RT_RESPONSEPHONEBOOK;
    public static final int RT_RESPONSEPHONEBOOKARRAY;
    public static final int RT_RESPONSEGETINITIALSTELEPHONE;
    public static final int RT_PUSHUPDATEFAVORITELIST;
    public static final int RT_PUSHCOMBINEDNUMBERS;
    public static final int RT_PUSHCURRENTLISTSIZETELEPHONE;
    public static final int RT_RESPONSEPHONEBOOKJOBS;
    public static final int RT_RESPONSENOTIFYCOMBINEDNUMBERSPUSH;
    public static final int RT_RESPONSENOTIFYCURRENTLISTSIZES;
    public static final int RT_RESPONSENOTIFYFAVORITELISTPUSH;
    public static final int FUNCTIONAVAILABILITY_PHONEBOOK;
    public static final int FUNCTIONAVAILABILITY_GETINITIALS;
    public static final int FUNCTIONAVAILABILITY_FAVORITELISTPUSH;
    public static final int FUNCTIONAVAILABILITY_COMBINEDNUMBERSPUSH;
    public static final int FUNCTIONAVAILABILITY_PHONEBOOKJOBS;
    public static final int OPSTATE_NORMAL;
    public static final int OPSTATE_OFFSTBY;
    public static final int OPSTATE_INITIALISING;
    public static final int OPSTATE_DEFECTIVE;
    public static final int ASGID_DEFAULT;
    public static final int ASGID_INSTRUMENTCLUSTER;
    public static final int ASGID_HEADUPDISPLAY;
    public static final int RECORDADDRESSPHONEBOOK_FULL;
    public static final int RECORDADDRESSPHONEBOOK_PBNAMESTORAGEANYVOICETAGTELNUMBERQUANTITYADDRESSINDICATION;
    public static final int RECORDADDRESSPHONEBOOK_TELNUMBERNVOICETAGNRESERVENNUMBERTYPEN;
    public static final int RECORDADDRESSPHONEBOOK_PBNAMEANYVOICETAGTELNUMBERQUANTITYVOICETAGNRESERVENNUMBERTYPEN;
    public static final int RECORDADDRESSPHONEBOOK_ANYVOICETAGTELNUMBERQUANTITYTELNUMBERNVOICETAGNRESERVENNUMBERTYPEN;
    public static final int RECORDADDRESSPHONEBOOK_POS;
    public static final int JOBMODIFICATION_NEW;
    public static final int JOBMODIFICATION_CHANGE;
    public static final int JOBMODIFICATION_CANCEL;
    public static final int REQUESTEDLIST_PHONEBOOK;
    public static final int REQUESTEDLIST_COMBINEDNUMBERS;
    public static final int REQUESTEDLIST_DIALEDNUMBERS;
    public static final int REQUESTEDLIST_FAVORITELIST;
    public static final int REQUESTEDLIST_MISSEDCALLS;
    public static final int REQUESTEDLIST_RECEIVEDCALLS;
    public static final int MODE_SHIFT;
    public static final int MODE_ARRAYDIRECTION;
    public static final int MODE_ARRAYPOSTRANSMITTED;
    public static final int MODE_INDEXSIZE;
    public static final int MODE_CENTERPOSITION;
    public static final int MODE_INDEXSIZE64BIT;
    public static final int SENDREASON_REQUESTED;
    public static final int SENDREASON_CHANGEDARRAY;
    public static final int SENDREASON_JOBLIST;
    public static final int JOBSRESULT_JOBEXECUTEDSUCCESSFULLY;
    public static final int JOBSRESULT_JOBCANCELLEDDUETOERRORSINREQUEST;
    public static final int JOBSRESULT_JOBCANCELLEDBYFSG;
    public static final int JOBSRESULT_JOBCANCELLEDSUCCESSFULLYBZASG;
    public static final int JOBSRESULT_JOBCANCELLEDUNSUCCESSFULLYALREADYINEXECUTION;
    public static final int JOBSRESULT_ALLJOBSEXECUTEDSUCCESSFULLY;
    public static final int JOBSRESULT_ALLJOBSCANCELLED;
    public static final int STORAGEPB_UNDEFINED;
    public static final int STORAGEPB_SIM;
    public static final int STORAGEPB_MOBILEEQUIPMENT;
    public static final int STORAGEPB_LOCALPUBLIC;
    public static final int STORAGEPB_LOCALPRIVATE;
    public static final int ANYVOICETAG_AVAILABILITY;
    public static final int ANYVOICETAG_AVAILABLEFORSTANDARDNUMBER;
    public static final int VOICETAG_AVAILABLE;
    public static final int NUMBERTYPE_UNKNOWNNUMBERTYPE;
    public static final int NUMBERTYPE_GENERAL;
    public static final int NUMBERTYPE_MOBILE;
    public static final int NUMBERTYPE_OFFICE;
    public static final int NUMBERTYPE_HOME;
    public static final int NUMBERTYPE_FAX;
    public static final int NUMBERTYPE_PAGER;
    public static final int NUMBERTYPE_CAR;
    public static final int NUMBERTYPE_SIM;
    public static final int NUMBERTYPE_MAINOFFICE;
    public static final int NUMBERTYPE_MAINHOME;
    public static final int NUMBERTYPE_CELLOFFICE;
    public static final int NUMBERTYPE_CELLHOME;
    public static final int NUMBERTYPE_FAXOFFICE;
    public static final int NUMBERTYPE_FAXHOME;
    public static final int CALLMODE_UNKNOWNCALLMODE;
    public static final int CALLMODE_MISSEDCALL;
    public static final int CALLMODE_RECEIVEDCALL;
    public static final int CALLMODE_DIALEDNUMBER;

    default public void pushFunctionAvailabilityTelephone(int n) {
    }

    default public void pushMOSTOperationStateTelephone(short s) {
    }

    default public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    default public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
    }

    default public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    default public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
    }

    default public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
    }

    default public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
    }

    default public void responsePhonebookJobs(int n, int n2, int n3) {
    }

    default public void responseNotifyCombinedNumbersPush(boolean bl) {
    }

    default public void responseNotifyCurrentListSizes(boolean bl) {
    }

    default public void responseNotifyFavoriteListPush(boolean bl) {
    }
}


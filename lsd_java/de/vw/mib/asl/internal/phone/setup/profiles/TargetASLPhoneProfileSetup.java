/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.profiles;

import de.vw.mib.asl.api.media.ASLMediaFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.contacts.PhoneSearchFetcher;
import de.vw.mib.asl.internal.phone.setup.profiles.transformer.PhoneSetupProfilesUserProfileInformationsCollector;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.IndexInformation;
import org.dsi.ifc.organizer.ProfileInfo;

public class TargetASLPhoneProfileSetup
extends TripleMobileEquipment {
    private static final int EV_ENTRYINFO_TIMER;
    private static final int EV_ENTRYINFO_TIMEOUT;
    protected DSIAdbUserProfile dsiAdbUserProfile;
    protected DSIAdbSetup dsiAdbSetup;
    protected DSIAdbList dsiAdbList;
    protected DSIAdbEdit dsiAdbEdit;
    protected DSIListener dsiAdbUserProfileListener;
    protected DSIListener dsiAdbSetupListener;
    protected DSIListener dsiAdbListListener;
    protected ProfileInfo[] profileInfoArray;
    protected int indexOfActiveProfile = -1;
    protected int contactsOfActiveProfile;
    private DownloadInfo downloadCountME = new DownloadInfo();
    private DownloadInfo downloadCountOPP = new DownloadInfo();
    private DownloadInfo downloadCountSIM = new DownloadInfo();
    private int downloadCountAll = 0;
    private ASLAPISpellerBinding spellerHsmProfileName;
    private int hmiSortOrder;
    private boolean sortOrderPending = false;
    private final boolean downloadSuccessful;
    private final HashMap profileContacts = new HashMap();
    private boolean isDownloadActive = false;
    private boolean isDownload2ndPhoneActive = false;
    int maxDownload = 0;
    int currentDownload = 0;
    private boolean alreadyRegistered = false;
    private ArrayList userProfileInformation = new ArrayList();
    private int lastDownloadState = -1;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;

    public TargetASLPhoneProfileSetup(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.downloadSuccessful = false;
    }

    @Override
    public int getDefaultTargetId() {
        return 5278;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbUserProfile = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
            this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 0);
            this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 0);
            this.dsiAdbUserProfileListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            this.dsiAdbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener, this.dsiAdbUserProfileListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLPhoneProfileSetup.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 0, this.dsiAdbListListener);
            this.addObserver(-66912192);
            this.addObserver(-50134976);
            this.addObserver(262208);
            this.addObserver(-1677066176);
            this.addObserver(0x2040040);
            this.addObserver(0x3040040);
            this.addObserver(0x4040040);
            this.addObserver(-648276672);
            this.addObserver(0x8040040);
            this.addObserver(0x5040040);
            this.addObserver(0x6040040);
            this.addObserver(0x9040040);
            this.addObserver(-16580544);
            this.addObserver(-267780032);
            this.addObserver(513622272);
            this.spellerHsmProfileName = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1222, -648276672, 0x4040040, 0x8040040);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiAdbUserProfile.setNotification(new int[]{2, 7, 6, 5, 8, 9}, this.dsiAdbUserProfileListener);
        this.dsiAdbSetup.setNotification(new int[]{2, 3}, this.dsiAdbSetupListener);
        this.dsiAdbList.setNotification(2, this.dsiAdbListListener);
    }

    @Override
    protected void powerOn() {
        this.init();
        this.setNotification();
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 4300062: {
                break;
            }
            case 1073742844: {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.profileInfoArray.length; ++i2) {
                    if (i2 == 0 || i2 == this.indexOfActiveProfile) continue;
                    arrayList.add(new Integer(this.profileInfoArray[i2].num));
                }
                int[] nArray = new int[arrayList.size()];
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    nArray[i3] = (Integer)arrayList.get(i3);
                }
                this.dsiAdbUserProfile.deleteProfiles(nArray);
                break;
            }
            case 1073742845: {
                int n = eventGeneric.getInt(0);
                int n2 = ((PhoneSetupProfilesUserProfileInformationsCollector)this.userProfileInformation.get((int)n)).profileNumber;
                this.dsiAdbUserProfile.deleteProfiles(new int[]{n2});
                ArrayList arrayList = new ArrayList();
                this.userProfileInformation.remove(n);
                ListManager.getGenericASLList(1221).updateList(arrayList.toArray());
                this.userProfileInformation = arrayList;
                break;
            }
            case 0x40000400: {
                boolean bl = eventGeneric.getBoolean(0);
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(1220, bl);
                this.dsiAdbSetup.setPictureVisibility(bl);
                break;
            }
            case 1073744624: {
                if (this.hmiSortOrder == eventGeneric.getInt(0)) break;
                this.hmiSortOrder = eventGeneric.getInt(0);
                if (!this.sortOrderPending) {
                    this.sortOrderPending = true;
                    switch (this.hmiSortOrder) {
                        case 0: {
                            ASLPhoneData.getInstance().addressbookSortOrder = 1;
                            break;
                        }
                        case 1: {
                            ASLPhoneData.getInstance().addressbookSortOrder = 2;
                            break;
                        }
                        case 2: {
                            ASLPhoneData.getInstance().addressbookSortOrder = 3;
                            break;
                        }
                        default: {
                            this.error("unknown sort order set");
                        }
                    }
                    this.dsiAdbSetup.setSortOrder(ASLPhoneData.getInstance().addressbookSortOrder);
                    TargetASLPhoneProfileSetup.writeIntegerToDatapool(3931, this.hmiSortOrder);
                    break;
                }
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(3931, this.sortOrderDSIToASL(ASLPhoneData.getInstance().addressbookSortOrder));
                break;
            }
            case 0x40000405: 
            case 0x40000406: {
                this.spellerHsmProfileName.initSpeller(ASLPhoneData.getInstance().SIMName);
                this.enabledOKButton();
                break;
            }
            case 0x40000409: {
                String string = this.spellerHsmProfileName.getSpellerData().getEnteredText();
                this.getPrimary().requestSetSIMName(string);
                break;
            }
            case 0x40000404: 
            case 0x40000408: 
            case 1075141849: {
                this.spellerHsmProfileName.handleEvent(eventGeneric);
                this.enabledOKButton();
                break;
            }
            case 0x40000402: {
                this.dsiAdbUserProfile.entryMeter();
                break;
            }
            case 1073742847: {
                int n = eventGeneric.getInt(0);
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(1216, n);
                int n3 = 0;
                switch (n) {
                    case 0: {
                        n3 = 1;
                        break;
                    }
                    case 1: {
                        n3 = 2;
                        break;
                    }
                    case 2: {
                        n3 = 3;
                        break;
                    }
                }
                if (n3 == 0) break;
                this.getPrimary().requestSetOptimizationMode(n3);
                break;
            }
            case 1073744540: {
                this.dsiAdbEdit.deleteEntries(new long[0], 10, 1);
                break;
            }
            case 100001: {
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(1178, this.contactsOfActiveProfile);
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(1179, this.contactsOfActiveProfile);
                break;
            }
        }
    }

    private int getDownloadCount() {
        this.downloadCountAll = 0;
        if (this.downloadCountME.numberOfItems != -1) {
            this.downloadCountAll += this.downloadCountME.numberOfItems;
        }
        if (this.downloadCountSIM.numberOfItems != -1) {
            this.downloadCountAll += this.downloadCountSIM.numberOfItems;
        }
        if (this.downloadCountOPP.numberOfItems != -1) {
            this.downloadCountAll += this.downloadCountOPP.numberOfItems;
        }
        if (this.downloadCountAll != 0) {
            if (!this.isDownloadActive) {
                this.writeMaxDownload(this.downloadCountME.count + this.downloadCountOPP.count + this.downloadCountSIM.count);
            } else {
                this.writeMaxDownload(this.downloadCountAll);
            }
        } else {
            this.writeMaxDownload(ASLPhoneData.MAX_PROFILE_CONTACTS);
        }
        if (!this.isDownloadActive) {
            this.writeMaxDownload(this.downloadCountME.count + this.downloadCountOPP.count + this.downloadCountSIM.count);
        }
        return this.downloadCountME.count + this.downloadCountOPP.count + this.downloadCountSIM.count;
    }

    protected void enabledOKButton() {
        String string = this.spellerHsmProfileName.getSpellerData().getEnteredText();
        TargetASLPhoneProfileSetup.writeBooleanToDatapool(1223, !ASLPhoneData.getInstance().SIMName.equals(string) && string.length() > 0);
    }

    public void dsiAdbSetupUpdateSortOrder(int n, int n2) {
        ASLPhoneData.getInstance().addressbookSortOrder = n;
        this.sortOrderPending = false;
        this.hmiSortOrder = this.sortOrderDSIToASL(n);
        ASLPhoneData.getInstance().newContactsSortOrderInitiated = true;
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(3931, this.hmiSortOrder);
    }

    private int sortOrderDSIToASL(int n) {
        int n2 = 2;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 0: {
                break;
            }
            default: {
                this.error("unknown sort order set");
            }
        }
        return n2;
    }

    public void dsiAdbUserProfileUpdateProfileInfo(ProfileInfo[] profileInfoArray, int n, int n2) {
        if (this.profileInfoArray == null || this.profileInfoArray[this.indexOfActiveProfile].getNum() != profileInfoArray[n].getNum()) {
            this.downloadCountAll = 0;
            this.downloadCountME.count = 0;
            this.downloadCountME.numberOfItems = -1;
            this.downloadCountOPP.count = 0;
            this.downloadCountOPP.numberOfItems = -1;
            this.downloadCountSIM.count = 0;
            this.downloadCountSIM.numberOfItems = -1;
            TargetASLPhoneProfileSetup.writeBooleanToDatapool(-696052480, false);
        }
        if (this.downloadCountME.getNumberOfItems() == -1 && this.downloadCountOPP.getNumberOfItems() == -1 && this.downloadCountSIM.getNumberOfItems() == -1) {
            this.retriggerOrStartTimer(-1585053440, (long)0, false);
        }
        this.profileInfoArray = profileInfoArray;
        this.indexOfActiveProfile = n;
        if (!ASLPhoneData.getInstance().adrdlConnected) {
            ASLPhoneData.getInstance().internalPrimarySIMProfileNum = ASLPhoneData.getInstance().telMode == 0 ? profileInfoArray[n].getNum() : -1;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < profileInfoArray.length; ++i2) {
            if (i2 == 0 || i2 == this.indexOfActiveProfile || ASLPhoneData.getInstance().adrdlConnected && profileInfoArray[i2].getNum() == ASLPhoneData.getInstance().internalPrimarySIMProfileNum) continue;
            arrayList.add(profileInfoArray[i2]);
        }
        Object[] objectArray = new PhoneSetupProfilesUserProfileInformationsCollector[arrayList.size()];
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            objectArray[i3] = new PhoneSetupProfilesUserProfileInformationsCollector();
            ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).profileName = ((ProfileInfo)arrayList.get(i3)).getName();
            ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).profileNumber = ((ProfileInfo)arrayList.get(i3)).getNum();
            ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).downloaded = this.profileContacts.get(new Integer(((ProfileInfo)arrayList.get(i3)).getNum())) != null ? (Integer)this.profileContacts.get(new Integer(((ProfileInfo)arrayList.get(i3)).getNum())) : 0;
            ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).downloadMax = ASLPhoneData.MAX_PROFILE_CONTACTS;
        }
        this.userProfileInformation = new ArrayList(Arrays.asList(objectArray));
        ListManager.getGenericASLList(1221).updateList(objectArray);
        if (!Util.isNullOrEmpty(profileInfoArray) && n != 0) {
            TargetASLPhoneProfileSetup.writeBooleanToDatapool(1218, true);
        } else {
            TargetASLPhoneProfileSetup.writeBooleanToDatapool(1218, false);
        }
        this.dsiAdbUserProfile.entryMeter();
    }

    public void dsiAdbUserProfileUpdateDownloadState2ndPhone(int n, int n2, int n3) {
        switch (n) {
            case 0: {
                if (this.isDownloadActive) break;
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(3017, true);
                this.isDownload2ndPhoneActive = true;
                break;
            }
            case 1: 
            case 2: 
            case 3: {
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(3017, true);
                this.isDownload2ndPhoneActive = true;
                break;
            }
            case 4: 
            case 5: 
            case 6: {
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(3017, this.isDownloadActive);
                this.isDownload2ndPhoneActive = false;
                break;
            }
            default: {
                this.isDownload2ndPhoneActive = false;
                this.error("invalid downloadState2ndPhone! ", n);
            }
        }
    }

    public void dsiAdbUserProfileUpdateDownloadState(int n, int n2, int n3) {
        switch (n) {
            case 0: {
                this.isDownloadActive = true;
                this.writeCurrentDownload(0);
                this.downloadCountME.count = 0;
                this.downloadCountOPP.count = 0;
                this.downloadCountSIM.count = 0;
                this.downloadCountME.numberOfItems = 0;
                this.downloadCountOPP.numberOfItems = 0;
                this.downloadCountSIM.numberOfItems = 0;
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 2);
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 2);
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(3017, true);
                AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
                if (this.isTraceEnabled()) {
                    this.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by updateDownloadState(PENDING)").log();
                }
                ASLPhoneData.getInstance().downloadInProgress = true;
                this.stopTimer(-1585053440);
                break;
            }
            case 1: {
                AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
                if (this.isTraceEnabled()) {
                    this.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by updateDownloadState(PENDING)").log();
                }
                ASLPhoneData.getInstance().downloadInProgress = true;
            }
            case 2: 
            case 3: {
                this.isDownloadActive = true;
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 1);
                TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 1);
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(3017, true);
                this.stopTimer(-1585053440);
                break;
            }
            case 4: 
            case 5: 
            case 6: {
                this.isDownloadActive = false;
                if (n == 4) {
                    if (this.lastDownloadState != 3) {
                        if (n2 == 1) {
                            this.sendHMIEvent(434);
                        } else if (this.downloadCountOPP.count > 0) {
                            this.sendHMIEvent(-662498048);
                        } else {
                            this.sendHMIEvent(135);
                        }
                    }
                    this.sendHMIEvent(171);
                }
                this.writeCurrentDownload(this.getDownloadCount());
                if (n != 4) {
                    TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 0);
                    TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 0);
                }
                TargetASLPhoneProfileSetup.writeBooleanToDatapool(3017, this.isDownload2ndPhoneActive);
                ASLPhoneData.getInstance().downloadInProgress = false;
                this.dsiAdbUserProfile.entryMeter();
                break;
            }
            default: {
                this.error("invalid downloadState! ", n);
            }
        }
        this.lastDownloadState = n;
    }

    public void dsiAdbUserProfileUpdateDownloadCountMe(DownloadInfo downloadInfo, int n) {
        if (!this.isDownload2ndPhoneActive) {
            this.downloadCountME = downloadInfo;
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 1);
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 1);
            this.writeCurrentDownload(this.getDownloadCount());
        }
    }

    public void dsiAdbUserProfileUpdateDownloadCountOpp(DownloadInfo downloadInfo, int n) {
        if (!this.isDownload2ndPhoneActive) {
            this.downloadCountOPP = downloadInfo;
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 1);
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 1);
            this.writeCurrentDownload(this.getDownloadCount());
        }
    }

    public void dsiAdbUserProfileUpdateDownloadCountSim(DownloadInfo downloadInfo, int n) {
        if (!this.isDownload2ndPhoneActive) {
            this.downloadCountSIM = downloadInfo;
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 1);
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 1);
            this.writeCurrentDownload(this.getDownloadCount());
        }
    }

    public void dsiAdbUserProfileEntryMeterResult(int n, EntryMeter[] entryMeterArray) {
        this.profileContacts.clear();
        try {
            Object[] objectArray = (PhoneSetupProfilesUserProfileInformationsCollector[])this.userProfileInformation.toArray(new PhoneSetupProfilesUserProfileInformationsCollector[0]);
            if (entryMeterArray != null) {
                for (int i2 = 0; i2 < entryMeterArray.length; ++i2) {
                    for (int i3 = 0; i3 < objectArray.length; ++i3) {
                        if (objectArray[i3] == null || entryMeterArray[i2] == null || ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).profileNumber != entryMeterArray[i2].profile) continue;
                        ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).downloaded = entryMeterArray[i2].localEntries + entryMeterArray[i2].meEntries + entryMeterArray[i2].oppEntries + entryMeterArray[i2].simEntries;
                        ((PhoneSetupProfilesUserProfileInformationsCollector)objectArray[i3]).downloadMax = ASLPhoneData.MAX_PROFILE_CONTACTS;
                        break;
                    }
                    if (this.indexOfActiveProfile != -1 && !Util.isNullOrEmpty(this.profileInfoArray) && entryMeterArray[i2].getProfile() == this.profileInfoArray[this.indexOfActiveProfile].getNum()) {
                        this.contactsOfActiveProfile = entryMeterArray[i2].localEntries + entryMeterArray[i2].meEntries + entryMeterArray[i2].oppEntries + entryMeterArray[i2].simEntries;
                        this.writeCurrentDownload(this.getDownloadCount());
                        TargetASLPhoneProfileSetup.writeBooleanToDatapool(-696052480, entryMeterArray[i2].oppEntries > 0);
                    }
                    this.profileContacts.put(new Integer(entryMeterArray[i2].profile), new Integer(entryMeterArray[i2].localEntries + entryMeterArray[i2].meEntries + entryMeterArray[i2].oppEntries + entryMeterArray[i2].simEntries));
                }
            }
            this.userProfileInformation = new ArrayList(Arrays.asList(objectArray));
            ListManager.getGenericASLList(1221).updateList(objectArray);
        }
        catch (ClassCastException classCastException) {
            // empty catch block
        }
    }

    public void dsiAdbListInvalidData(int n) {
        this.sortOrderPending = false;
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(3931, this.sortOrderDSIToASL(ASLPhoneData.getInstance().addressbookSortOrder));
        if (!this.isDownloadActive && n != 3) {
            this.dsiAdbUserProfile.entryMeter();
        }
        if (n == 2) {
            if (!ASLPhoneData.getInstance().downloadInProgress) {
                // empty if block
            }
        } else if (ASLPhoneData.getInstance().connected) {
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(1180, 2);
            TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1277031168, 2);
        }
    }

    public void dsiAdbSetupSetSortOrderResult(int n) {
        this.sortOrderPending = false;
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(3931, this.sortOrderDSIToASL(ASLPhoneData.getInstance().addressbookSortOrder));
    }

    public void dsiAdbSetupUpdatePictureVisibility(boolean bl, int n) {
        TargetASLPhoneProfileSetup.writeBooleanToDatapool(1220, bl);
    }

    public void dsiAdbListUpdateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        if (!Util.isNullOrEmpty(indexInformationArray)) {
            for (int i2 = 0; i2 < indexInformationArray.length; ++i2) {
                IndexInformation indexInformation = indexInformationArray[i2];
                if (indexInformation.getViewtype() != 1) continue;
                ASLPhoneData.getInstance().characterInfos = !Util.isNullOrEmpty(indexInformation.getCharacterInfo()) ? ASLMediaFactory.getMediaApi().convertCharacterInfo(indexInformation.getCharacterInfo()) : ASLPhoneData.getInstance().defaultCharacterInfo;
            }
        } else {
            ASLPhoneData.getInstance().characterInfos = ASLPhoneData.getInstance().defaultCharacterInfo;
        }
        if (PhoneSearchFetcher.spellerHandle <= -1) {
            ListManager.getGenericASLList(1190).updateStringIndex(ASLPhoneData.getInstance().characterInfos.getIndices(), ASLPhoneData.getInstance().characterInfos.getCharacters());
        }
    }

    private void writeCurrentDownload(int n) {
        if (n > this.maxDownload) {
            n = this.maxDownload;
        }
        this.currentDownload = n;
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(1178, n);
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1310585600, n);
    }

    private void writeMaxDownload(int n) {
        this.maxDownload = n < ASLPhoneData.MAX_PROFILE_CONTACTS ? n : ASLPhoneData.MAX_PROFILE_CONTACTS;
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(1179, n);
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1293808384, n);
        if (this.currentDownload > n) {
            this.currentDownload = n;
        }
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(1178, this.currentDownload);
        TargetASLPhoneProfileSetup.writeIntegerToDatapool(-1310585600, this.currentDownload);
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
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


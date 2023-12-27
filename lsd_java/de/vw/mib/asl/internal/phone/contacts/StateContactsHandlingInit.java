/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.api.media.ASLMediaFactory;
import de.vw.mib.asl.api.phone.callback.ContactlistUpdates;
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
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public class StateContactsHandlingInit
extends AbstractHsmState {
    private final HsmPhoneContactsHandling target;

    public StateContactsHandlingInit(HsmPhoneContactsHandling hsmPhoneContactsHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneContactsHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 4: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace("StateContactsHandlingInit.handle(HSM_EXIT)");
                break;
            }
            case 3: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace("StateContactsHandlingInit.handle(HSM_START)");
                }
                this.target.init();
                this.target.setNotification();
                break;
            }
            case 100001: {
                ContactlistUpdates contactlistUpdates = (ContactlistUpdates)eventGeneric.getObject(0);
                this.target.addContactlistUpdates(contactlistUpdates);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace("StateContactsHandlingInit.dsiAdbSetupUpdateAdbState(): ", n);
        }
        if (n == 2 && !this.target.getHsm().isActive(this.target.stateContactHandling)) {
            this.trans(this.target.stateInitList);
            ASLPhoneData.viewSizeContacts = new AdbViewSize(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            PhoneUtil.updateContactsSize(0);
            this.target.dsiAdbList.setNotification(this.target.dsiAdbListListener);
        }
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
            ListManager.getGenericASLList(469).updateStringIndex(ASLPhoneData.getInstance().characterInfos.getIndices(), ASLPhoneData.getInstance().characterInfos.getCharacters());
        }
    }

    public void dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        this.target.error("GetSpellerViewWindowResult received in StateContactsHandlingInit occured, but not allowed. This should always be consumed in StaeContactsHandlingContactHandling!");
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.target.error("GetViewWindowResult received in StateContactsHandlingInit occured, but not allowed. This should always be consumed in StaeContactsHandlingContactHandling!");
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        this.target.error("UpdateViewSize received in StateContactsHandlingInit occured, but not allowed. This should always be consumed in StaeContactsHandlingContactHandling!");
    }
}


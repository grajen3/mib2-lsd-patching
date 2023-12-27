/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsHandling;
import de.vw.mib.asl.internal.phone.contacts.PhoneSearchFetcher;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.DataSet;

public class StateContactsHandlingInitList
extends AbstractHsmState {
    private final HsmPhoneContactsHandling target;

    public StateContactsHandlingInitList(HsmPhoneContactsHandling hsmPhoneContactsHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneContactsHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                GenericASLList genericASLList = ListManager.getGenericASLList(1190);
                genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), new PhoneSearchFetcher(this.target), 10, 0);
                genericASLList.setColumn4ObjectId(2);
                genericASLList.setFetchTimeout(0);
                PhoneUtil.setTelephoneListStyle(this.target.dsiAdbList, this.target.filterType, 1, 5, true);
                this.trans(this.target.stateContactHandling);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        this.target.error("GetSpellerViewWindowResult received in StateContactsHandlingInitList occured, but not allowed. This should always be consumed in StaeContactsHandlingContactHandling!");
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.target.error("GetViewWindowResult received in StateContactsHandlingInitList occured, but not allowed. This should always be consumed in StaeContactsHandlingContactHandling!");
    }
}


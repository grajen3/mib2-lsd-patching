/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.util.HashSet;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class VicsFmTextHandler {
    private final VicsTarget target;
    protected HashSet fmTextResourcesLoaded = new HashSet();
    protected final GenericASLList fmTextTopicsList;
    protected final GenericASLList fmTextDetailsResourceList;

    public VicsFmTextHandler(VicsTarget vicsTarget, GenericASLList genericASLList, GenericASLList genericASLList2) {
        this.target = vicsTarget;
        this.fmTextTopicsList = genericASLList;
        this.fmTextDetailsResourceList = genericASLList2;
    }

    protected void handleFmTextEnterContext() {
        this.target.traceMsg("enter fm text context.", this);
        this.fmTextTopicsList.clear();
        this.target.vicsTrafficLists.updateTrafficMessages(this.target.currentInfos);
        Object[] objectArray = this.target.vicsTrafficLists.getFmTextMessages();
        this.fmTextNotifiyModelIfMessagesAreAvailable((TrafficMessage[])objectArray);
        this.fmTextTopicsList.updateList(objectArray);
        this.target.quitModelWaitState(1520063744, 0);
    }

    private void fmTextNotifiyModelIfMessagesAreAvailable(TrafficMessage[] trafficMessageArray) {
        boolean bl;
        boolean bl2 = bl = trafficMessageArray.length > 0;
        if (bl) {
            VicsTarget.writeBooleanToDatapool(362435840, true);
        } else {
            VicsTarget.writeBooleanToDatapool(362435840, false);
        }
    }

    protected void handleFmTextTrafficMessageSelected(EventGeneric eventGeneric) {
        this.fmTextDetailsResourceList.clear();
        int n = eventGeneric.getInt(0);
        this.target.selectedMessage = this.target.vicsTrafficLists.getFmTextMessages().length > 0 ? this.target.vicsTrafficLists.getFmTextMessages()[n] : null;
        this.target.traceMsg(new StringBuffer().append("Traffic message selected. ListIndex: ").append(n).append("\nMessage: ").append(this.target.selectedMessage).toString(), this);
        boolean bl = this.target.notfiyModelIfMessageExpired(362435840, 4);
        if (bl) {
            this.fmTextRequestResourcesForMessage();
        } else {
            this.target.quitModelWaitState(1520063744, 0);
        }
    }

    private void fmTextRequestResourcesForMessage() {
        int[] nArray = this.target.selectedMessage.detailContentIDs;
        this.fmTextResourcesLoaded.clear();
        if (nArray.length > 0) {
            VicsTarget.writeIntegerToDatapool(312104192, 1);
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            this.fmTextResourcesLoaded = this.target.requestResourceInformation(n, this.fmTextResourcesLoaded);
        }
    }
}


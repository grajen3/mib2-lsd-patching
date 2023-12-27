/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.messaging.FolderEntry;

public class StateMessagingWaitForSynch
extends AbstractHsmState {
    private HsmPhoneSMSHandling target;
    private boolean messageDomainAvailableSet = false;
    private int retryCounter = 0;

    public StateMessagingWaitForSynch(HsmPhoneSMSHandling hsmPhoneSMSHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneSMSHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.retryCounter = 0;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiMessagingUpdateSynchInProgress(boolean bl, int n) {
        if (!bl) {
            // empty if block
        }
    }

    public void dsiMessagingServiceConfigurationChangeFolderViewModeResponse(int n) {
        if (n == 0) {
            this.target.handleGetSortingFolder(5);
            this.target.handleChangeFolder(-1, null, true);
        } else {
            this.target.error("StateMessagingWaitForSynch: ChangeFolderViewMode failed, so messaging can not be activated! We transfer back to main state");
            this.trans(this.target.stateMessageHandling);
        }
    }

    public HsmState dsiMessagingChangeFolderResponse(FolderEntry folderEntry, int n) {
        if (n == 0) {
            this.trans(this.target.stateMessageHandling);
            AbstractASLHsmTarget.writeBooleanToDatapool(-991818496, this.target.isSMSAvailable);
            this.target.messagesAvailable.onAvailableChanged(this.target.isSMSAvailable);
            if (!this.messageDomainAvailableSet) {
                AbstractASLHsmTarget.writeIntegerToDatapool(1675, 1);
                this.messageDomainAvailableSet = true;
            }
            return this.myParent;
        }
        this.target.error("StateMessagingWaitForSynch: ChangeFolder failed, so messaging can not be activated! We transfer back to main state");
        this.trans(this.target.stateMessageHandling);
        return null;
    }

    public void dsiMessagingServiceConfigurationAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1009: {
                this.target.error("StateMessagingWaitForSynch: ChangeFolderViewMode failed, so messaging can not be activated! We transfer back to main state");
                this.trans(this.target.stateMessageHandling);
                break;
            }
        }
    }

    public void dsiMessagingAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1000: {
                if (this.retryCounter++ < 5) {
                    this.target.handleGetSortingFolder(5);
                    this.target.handleChangeFolder(-1, null, true);
                    this.target.warn("StateMessagingWaitForSynch: changeFolderRequest() failed, retrying...");
                    break;
                }
                this.target.error("StateMessagingWaitForSynch: changeFolderRequest() failed (including retries), so messaging can not be activated! We transfer back to main state");
                this.trans(this.target.stateMessageHandling);
                break;
            }
        }
    }
}


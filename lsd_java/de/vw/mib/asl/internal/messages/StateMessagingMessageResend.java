/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageSendErrorCollector;
import java.util.ArrayList;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.RecipientList;

public class StateMessagingMessageResend
extends AbstractHsmState {
    private HsmPhoneSMSHandling target;

    public StateMessagingMessageResend(HsmPhoneSMSHandling hsmPhoneSMSHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneSMSHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            default: 
        }
        hsmState = this.myParent;
        return hsmState;
    }

    public void dsiMessagingGetMessageContentsResponse(int n, MessageDetails messageDetails) {
        if (n == 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < messageDetails.getRecipientsTo().length; ++i2) {
                arrayList.add(messageDetails.getRecipientsTo()[i2].address);
            }
            RecipientList recipientList = new RecipientList();
            recipientList.to = (String[])arrayList.toArray(new String[arrayList.size()]);
            this.target.handleSendMessage(messageDetails.getType(), recipientList, messageDetails.getSubject(), messageDetails.getBody(), messageDetails.getAttachments(), messageDetails.getMessagingAccountID());
        } else {
            this.sendMessageFailed();
        }
    }

    public void dsiMessagingSendMessageResponse(int n, int n2) {
        if (n == 0 || n == 12) {
            this.trans(this.target.stateMessageHandling);
        } else {
            this.sendMessageFailed();
        }
    }

    private void sendMessageFailed() {
        Object[] objectArray = (MessagesMessageSendErrorCollector[])ListManager.getGenericASLList(-1126036224).getDSIObjects();
        objectArray[0].messages_send_error_amount_of_messages = 1;
        objectArray[0].messages_send_error_number_of_messages_with_error = 1;
        ListManager.getGenericASLList(-1126036224).updateList(objectArray);
        this.target.sendHMIEvent(64);
        this.trans(this.target.stateMessageHandling);
    }

    public HsmState dsiMessagingAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1004: {
                this.sendMessageFailed();
                break;
            }
            default: {
                return this.getParent();
            }
        }
        return null;
    }
}


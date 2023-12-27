/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.messages2;

import de.vw.mib.asl.api.messages.services.available.MessagesAvailableUpdate;
import de.vw.mib.asl.api.messages.services.detail.Message;
import de.vw.mib.asl.api.messages.services.detail.MessageKey;
import de.vw.mib.asl.api.messages.services.detail.MessageResponse;
import de.vw.mib.asl.api.messages.services.status.MessagesUpdates;
import de.vw.mib.asl.api.phone.callback.PhoneConnectedUpdate;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechphone.messages2.MessageAction$1;
import de.vw.mib.asl.internal.speechphone.messages2.MessageAction$UnreadMessage;
import de.vw.mib.asl.internal.speechphone.messages2.start.MessagingParameters;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.timer.Timer;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class MessageAction
implements RecognizedEventConsumer,
ModelEventConsumer,
PhoneConnectedUpdate,
MessagesAvailableUpdate,
MessagesUpdates,
MessageResponse {
    private final SpeechPhoneLogger2 logger;
    final MessagingParameters connections;
    private boolean connected = false;
    private boolean available = false;
    private static final int MESSAGE_LIST_INITIAL_LENGTH;
    public static final String MESSAGE_READ_PAUSE_TIMER_NAME;
    private static final long MESSAGE_READ_PAUSE_TIMEOUT_MILLIS;
    protected ObjectArrayList messagesList;
    private int messageNumber = 0;

    public MessageAction(MessagingParameters messagingParameters) {
        this.logger = new SpeechPhoneLogger2(messagingParameters.classifiedLogger(), "MessageAction");
        this.connections = messagingParameters;
        this.connections.phoneService().registerPhoneConnectedUpdates(this);
        this.connections.messageAvailableService().register(this);
        this.messagesList = new ObjectArrayList(10);
        MessageKey[] messageKeyArray = this.connections.messagesStatusService().registerWithHistory(this);
        for (int i2 = 0; i2 < messageKeyArray.length; ++i2) {
            this.messagesList.add(new MessageAction$UnreadMessage(this, messageKeyArray[i2].getAccountID(), messageKeyArray[i2].getMessageID()));
        }
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        if (this.connected) {
            if (this.available) {
                int n = eventGeneric.getReceiverEventId();
                switch (n) {
                    case 1077641889: {
                        Timer timer = this.connections.timerManager().createTimer("Message read pause timer", 0, false, new MessageAction$1(this), this.connections.threadSwitchingTarget());
                        timer.start();
                        break;
                    }
                    default: {
                        this.logger.error(new StringBuffer().append("unhandled model event: ").append(n).toString());
                        break;
                    }
                }
            } else {
                this.reactToNotAvailable();
            }
        } else {
            this.reactToNotConnected();
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (this.connected) {
            if (this.available) {
                switch (n) {
                    case 1077641862: {
                        if (this.messagesList.size() == 0) {
                            this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-777438464);
                            break;
                        }
                        this.connections.aslPropertyManager().valueChangedInteger(-2119615744, this.messagesList.size());
                        this.resetMessageIndex();
                        this.showFirstMessage();
                        break;
                    }
                    case 1077641885: {
                        if (this.messagesList.size() == 0) {
                            this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-710329600);
                            break;
                        }
                        this.incrementMessageIndex();
                        this.showFirstMessage();
                        break;
                    }
                    case 1077641886: {
                        this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-743884032);
                        break;
                    }
                    default: {
                        this.logger.error(new StringBuffer().append("unhandled recognized event: ").append(n).toString());
                        break;
                    }
                }
            } else {
                this.reactToNotAvailable();
            }
        } else {
            this.reactToNotConnected();
        }
    }

    @Override
    public void onChange(boolean bl) {
        this.connected = bl;
        if (!bl) {
            this.messagesList.clear();
        }
    }

    @Override
    public void onAvailableChanged(boolean bl) {
        this.available = bl;
        if (!this.available) {
            this.messagesList.clear();
        }
    }

    private void resetMessageIndex() {
        this.messageNumber = 1;
        this.connections.aslPropertyManager().valueChangedInteger(-1616299264, this.messageNumber);
    }

    private void incrementMessageIndex() {
        ++this.messageNumber;
        this.connections.aslPropertyManager().valueChangedInteger(-1616299264, this.messageNumber);
    }

    protected void showFirstMessage() {
        MessageAction$UnreadMessage messageAction$UnreadMessage = (MessageAction$UnreadMessage)this.messagesList.get(0);
        this.connections.messageDetailService().requestMessage(messageAction$UnreadMessage.accountId, messageAction$UnreadMessage.messageID, this);
    }

    @Override
    public void response(Message message) {
        this.setMessageTime(message.getUnixTime());
        this.setContactOrNumber(message);
        this.connections.aslPropertyManager().valueChangedInteger(-1549190400, this.getMessageAndType(message));
        if (this.messageNumber == 1) {
            this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-693552384);
        } else {
            this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-743884032);
        }
        this.markAsReadFirstMessage();
    }

    private void markAsReadFirstMessage() {
        MessageAction$UnreadMessage messageAction$UnreadMessage = (MessageAction$UnreadMessage)this.messagesList.get(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Removing message (by hand): ").append(messageAction$UnreadMessage.messageID).toString());
        }
        this.messagesList.remove(0);
        this.connections.messagesStatusService().markMessageRead(messageAction$UnreadMessage.accountId, messageAction$UnreadMessage.messageID);
    }

    private void reactToNotConnected() {
        this.connections.aslPropertyManager().valueChangedInteger(2057911040, 11);
        this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-1968620800);
    }

    private void reactToNotAvailable() {
        this.connections.systemEventDispatcher().createAndSubmitHMIEvent(-794215680);
    }

    @Override
    public void onNewMessage(int n, String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Message is added to internal list: ").append(string).toString());
        }
        this.messagesList.add(new MessageAction$UnreadMessage(this, n, string));
    }

    @Override
    public void onMessageRead(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Message was marked as read: ").append(string).toString());
        }
        MessageAction$UnreadMessage messageAction$UnreadMessage = null;
        Iterator iterator = this.messagesList.iterator();
        while (iterator.hasNext()) {
            MessageAction$UnreadMessage messageAction$UnreadMessage2 = (MessageAction$UnreadMessage)iterator.next();
            if (!messageAction$UnreadMessage2.messageID.equals(string)) continue;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("Message removed: ").append(string).toString());
            }
            messageAction$UnreadMessage = messageAction$UnreadMessage2;
            break;
        }
        if (messageAction$UnreadMessage != null) {
            this.messagesList.removeValue(messageAction$UnreadMessage);
        }
    }

    private int getMessageAndType(Message message) {
        if (message.isVcard()) {
            this.connections.aslPropertyManager().valueChangedString(-1565967616, message.getVCardContactName());
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("VCard Message");
            }
            return 3;
        }
        if (message.getMessageType() == 5) {
            if (this.connections.configurationManager().isFeatureFlagSet(463)) {
                this.connections.aslPropertyManager().valueChangedString(-1565967616, message.getBody());
                if (message.getBody().length() == 0) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace("Empty MMS");
                    }
                    return 1;
                }
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("MMS Message");
                }
                return 4;
            }
            this.connections.aslPropertyManager().valueChangedString(-1565967616, "");
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("MMS Message not readable on STD Targets");
            }
            return 4;
        }
        if (message.getMessageType() == 1) {
            this.connections.aslPropertyManager().valueChangedString(-1565967616, message.getBody());
            if (message.getBody().length() == 0) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Empty SMS");
                }
                return 1;
            }
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("SMS Message");
            }
            return 2;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Message not readable");
        }
        this.connections.aslPropertyManager().valueChangedString(-1565967616, "");
        return 0;
    }

    private void setMessageTime(long l) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Message timestamp is ").append(l).toString());
        }
        if (l <= 0L) {
            this.connections.aslPropertyManager().valueChangedInteger(-1532413184, 0);
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(l);
            int n = gregorianCalendar.get(5);
            int n2 = gregorianCalendar.get(2);
            int n3 = gregorianCalendar.get(1);
            int n4 = gregorianCalendar.get(11);
            int n5 = gregorianCalendar.get(12);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("Message Date: ").append(n3).append("-").append(n2 + 1).append("-").append(n).append(", ").append(n4).append(":").append(n5).toString());
            }
            this.connections.aslPropertyManager().valueChangedInteger(-1515635968, n);
            this.connections.aslPropertyManager().valueChangedInteger(-1498858752, n2 + 1);
            this.connections.aslPropertyManager().valueChangedInteger(-1482081536, n4);
            this.connections.aslPropertyManager().valueChangedInteger(-1465304320, n5);
            if (this.connections.aslTimeAndDateServiceTarget() != null) {
                int[] nArray = this.connections.aslTimeAndDateServiceTarget().getCurrentDateAndTimeAsIntArray();
                if (nArray != null && nArray.length >= 3) {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("Today is: ").append(nArray[2]).append(".").append(nArray[1]).append(".").append(nArray[0]).toString());
                    }
                    if (n == nArray[2] && n2 == nArray[1] - 1 && n3 == nArray[0]) {
                        this.messageFromToday();
                    } else {
                        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(nArray[0], nArray[1] - 1, nArray[2]);
                        gregorianCalendar2.add(5, -1);
                        if (n == gregorianCalendar2.get(5) && n2 == gregorianCalendar2.get(2) && n3 == gregorianCalendar2.get(1)) {
                            this.messageFromYesterday();
                        } else {
                            this.messageOlderThanYesterday();
                        }
                    }
                } else {
                    this.messageOlderThanYesterday();
                }
            } else {
                this.messageOlderThanYesterday();
            }
        }
    }

    private void messageFromToday() {
        this.connections.aslPropertyManager().valueChangedInteger(-1532413184, 1);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Message is from today");
        }
    }

    private void messageFromYesterday() {
        this.connections.aslPropertyManager().valueChangedInteger(-1532413184, 2);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Message is from yesterday");
        }
    }

    private void messageOlderThanYesterday() {
        this.connections.aslPropertyManager().valueChangedInteger(-1532413184, 3);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Message is from before yesterday or fallback");
        }
    }

    private void setContactOrNumber(Message message) {
        String string = message.getContactName();
        long l = message.getAdbEntryId();
        boolean bl = string != null && string.length() > 0 && l > 0L;
        this.connections.aslPropertyManager().valueChangedLong(-1448527104, message.getAdbEntryId());
        if (bl) {
            this.connections.aslPropertyManager().valueChangedString(-1599522048, message.getContactName());
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Message contact available");
            }
        } else {
            this.connections.aslPropertyManager().valueChangedString(-1599522048, message.getPhoneNumber());
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Message contact not available");
            }
        }
        this.connections.aslPropertyManager().valueChangedBoolean(-1582744832, bl);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.messages.services.detail.Message;
import de.vw.mib.asl.api.messages.services.detail.MessageDetailService;
import de.vw.mib.asl.api.messages.services.detail.MessageKey;
import de.vw.mib.asl.api.messages.services.detail.MessageResponse;
import de.vw.mib.asl.api.messages.services.status.MessagesStatusService;
import de.vw.mib.asl.api.messages.services.status.MessagesUpdates;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.messages.AbstractASLMessagesTarget;
import de.vw.mib.asl.internal.messages.TargetASLMessagesService$MessageServiceTask;
import de.vw.mib.asl.internal.messages.api.impl.MessageImpl;
import de.vw.mib.asl.internal.messages.api.impl.MessageKeyImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;
import org.dsi.ifc.organizer.DSIAdbVCardExchangeListener;

public class TargetASLMessagesService
extends AbstractASLMessagesTarget
implements MessageDetailService,
MessagesStatusService {
    private DSIMessaging dsiMessaging;
    private DSIMessagingListener dsiMessagingListener;
    private boolean alreadyRegistered = false;
    private DSIAdbVCardExchange dsiAdbVCardExchange;
    private DSIAdbVCardExchangeListener dsiAdbVCardExchangeListener;
    private final HashMap listeners = new HashMap();
    private final LinkedList taskQueue = new LinkedList();
    private TargetASLMessagesService$MessageServiceTask runningTask = null;
    private MessageDetails pendingMessageDetails;
    private final LinkedHashSet history = new LinkedHashSet();
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessaging;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchange;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$services$detail$MessageDetailService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService;

    public TargetASLMessagesService(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 567677696;
    }

    private void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiMessaging = (DSIMessaging)dSIProxy.getService(this, class$org$dsi$ifc$messaging$DSIMessaging == null ? (class$org$dsi$ifc$messaging$DSIMessaging = TargetASLMessagesService.class$("org.dsi.ifc.messaging.DSIMessaging")) : class$org$dsi$ifc$messaging$DSIMessaging);
            this.dsiAdbVCardExchange = (DSIAdbVCardExchange)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = TargetASLMessagesService.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange);
            this.dsiMessagingListener = (DSIMessagingListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$messaging$DSIMessagingListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingListener = TargetASLMessagesService.class$("org.dsi.ifc.messaging.DSIMessagingListener")) : class$org$dsi$ifc$messaging$DSIMessagingListener);
            this.dsiAdbVCardExchangeListener = (DSIAdbVCardExchangeListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = TargetASLMessagesService.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$messaging$DSIMessagingListener == null ? (class$org$dsi$ifc$messaging$DSIMessagingListener = TargetASLMessagesService.class$("org.dsi.ifc.messaging.DSIMessagingListener")) : class$org$dsi$ifc$messaging$DSIMessagingListener, this.dsiMessagingListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = TargetASLMessagesService.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener, this.dsiAdbVCardExchangeListener);
            ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$messages$services$detail$MessageDetailService == null ? (class$de$vw$mib$asl$api$messages$services$detail$MessageDetailService = TargetASLMessagesService.class$("de.vw.mib.asl.api.messages.services.detail.MessageDetailService")) : class$de$vw$mib$asl$api$messages$services$detail$MessageDetailService, this);
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService == null ? (class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService = TargetASLMessagesService.class$("de.vw.mib.asl.api.messages.services.status.MessagesStatusService")) : class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService, this);
        }
        this.alreadyRegistered = true;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                break;
            }
        }
    }

    @Override
    public void register(MessagesUpdates messagesUpdates) {
        MessagesUpdates messagesUpdates2 = (MessagesUpdates)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(messagesUpdates);
        this.listeners.put(messagesUpdates, messagesUpdates2);
    }

    @Override
    public MessageKey[] registerWithHistory(MessagesUpdates messagesUpdates) {
        this.register(messagesUpdates);
        return this.getMessageHistory();
    }

    @Override
    public MessageKey[] getMessageHistory() {
        return (MessageKey[])this.history.toArray(new MessageKey[this.history.size()]);
    }

    @Override
    public void unregister(MessagesUpdates messagesUpdates) {
        this.listeners.remove(messagesUpdates);
    }

    @Override
    public void markMessageRead(int n, String string) {
        this.dsiMessaging.setMessageReadStatusRequest(string, true);
    }

    @Override
    public void markMessageRead(MessageKey messageKey) {
        this.markMessageRead(messageKey.getAccountID(), messageKey.getMessageID());
    }

    @Override
    public void requestMessage(int n, String string, MessageResponse messageResponse) {
        TargetASLMessagesService$MessageServiceTask targetASLMessagesService$MessageServiceTask = new TargetASLMessagesService$MessageServiceTask(n, string, messageResponse);
        this.taskQueue.add(targetASLMessagesService$MessageServiceTask);
        this.checkForTasks();
    }

    @Override
    public void requestMessage(MessageKey messageKey, MessageResponse messageResponse) {
        this.requestMessage(messageKey.getAccountID(), messageKey.getMessageID(), messageResponse);
    }

    private void checkForTasks() {
        if (this.runningTask == null && !this.taskQueue.isEmpty()) {
            this.runningTask = (TargetASLMessagesService$MessageServiceTask)this.taskQueue.pop();
            this.dsiMessaging.getMessageContentsRequest(this.runningTask.getAccountID(), this.runningTask.getMessageID(), 0);
        }
    }

    private void onNewMessage(int n, String string) {
        Iterator iterator = this.listeners.values().iterator();
        while (iterator.hasNext()) {
            MessagesUpdates messagesUpdates = (MessagesUpdates)iterator.next();
            messagesUpdates.onNewMessage(n, string);
        }
    }

    private void onMessageRead(String string) {
        Iterator iterator = this.listeners.values().iterator();
        while (iterator.hasNext()) {
            MessagesUpdates messagesUpdates = (MessagesUpdates)iterator.next();
            messagesUpdates.onMessageRead(string);
        }
    }

    private void callback(Message message) {
        try {
            this.runningTask.getCallback().response(message);
        }
        catch (Exception exception) {
            this.error(exception);
        }
        this.runningTask = null;
        this.checkForTasks();
    }

    private static boolean hasVcard(MessageDetails messageDetails) {
        if (!Util.isNullOrEmpty(messageDetails.attachments)) {
            for (int i2 = 0; i2 < messageDetails.attachments.length; ++i2) {
                AttachmentInformation attachmentInformation = messageDetails.attachments[i2];
                if (!attachmentInformation.mimeType.equalsIgnoreCase("text/x-vcard")) continue;
                return true;
            }
        }
        return false;
    }

    private Message createMessage(MessageDetails messageDetails, String string) {
        return new MessageImpl(messageDetails.messagingAccountID, messageDetails.messageID, messageDetails.body, messageDetails.dateTime, messageDetails.sender.name, messageDetails.sender.address, messageDetails.sender.adbEntryID, messageDetails.type, string, string != null, string != null);
    }

    public void dsiMessagingSetMessageReadStatusResponse(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1694564416);
        this.sendSafe(eventGeneric);
    }

    public void dsiMessagingIndicateMessageStatus(StatusInformation statusInformation) {
        if (statusInformation.status == 3) {
            this.onMessageRead(statusInformation.messageId);
        }
        if (statusInformation.status == 1) {
            Iterator iterator = this.history.iterator();
            while (iterator.hasNext()) {
                MessageKey messageKey = (MessageKey)iterator.next();
                if (!messageKey.getMessageID().equals(statusInformation.getMessageId())) continue;
                iterator.remove();
                if (!this.isTraceEnabled()) continue;
                this.trace().append("remove message from history: ").append(messageKey).log();
            }
        }
    }

    public void dsiAdbVCardExchangeParseVCardResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0 && !Util.isNullOrEmpty(adbEntryArray)) {
            this.callback(this.createMessage(this.pendingMessageDetails, adbEntryArray[0].getCombinedName()));
        } else {
            this.callback(this.createMessage(this.pendingMessageDetails, null));
        }
    }

    public void dsiAdbVCardExchangeAsyncException(int n, String string, int n2) {
        if (n2 == 1005) {
            this.callback(this.createMessage(this.pendingMessageDetails, null));
        }
    }

    public void dsiMessagingIndicateNewMessage(boolean bl, String string, int n, int n2) {
        MessageKeyImpl messageKeyImpl;
        if (bl && (n2 == 1 || n2 == 3 || n2 == 5) && !this.history.contains(messageKeyImpl = new MessageKeyImpl(n, string))) {
            this.history.add(messageKeyImpl);
            this.onNewMessage(n, string);
        }
    }

    public void dsiMessagingGetMessageContentsResponse(int n, MessageDetails messageDetails) {
        if (n == 0) {
            if (TargetASLMessagesService.hasVcard(messageDetails)) {
                this.pendingMessageDetails = messageDetails;
                this.dsiAdbVCardExchange.parseVCard(messageDetails.getAttachments()[0].getAttachmentPath().getUrl());
            } else {
                this.callback(this.createMessage(messageDetails, null));
            }
        } else {
            this.callback(null);
        }
    }

    public void dsiMessagingAsyncException(int n, String string, int n2) {
        if (n2 == 1004) {
            this.callback(null);
        }
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


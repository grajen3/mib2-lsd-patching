/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.messages2;

import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.internal.speechphone.messages2.MessageAction;
import de.vw.mib.asl.internal.speechphone.messages2.start.MessagingParameters;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class SpeechPhoneMessagesStartTarget
implements Target {
    private final SpeechPhoneLogger2 logger;
    private ResultControllerRouter registry;
    private final GenericEvents genericEvents;

    public SpeechPhoneMessagesStartTarget(MessagingParameters messagingParameters) {
        this.logger = new SpeechPhoneLogger2(messagingParameters.classifiedLogger(), "SpeechPhoneMessagesStartTarget");
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("starting up..");
        }
        this.genericEvents = messagingParameters.genericEvents();
        try {
            messagingParameters.eventDispatcher().registerTarget(this.getTargetId(), this, messagingParameters.taskId());
        }
        catch (Exception exception) {
            this.logger.error("Couldn't register internal target");
        }
        this.registry = messagingParameters.resultControllerRouter();
        MessageAction messageAction = new MessageAction(messagingParameters);
        messagingParameters.serviceRegister().addObserver(-1585300672, this.getTargetId());
        this.registry.register(messageAction, -2038285504);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.registry != null) {
            this.registry.onEvent(eventGeneric);
        }
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return 1700010240;
    }

    @Override
    public void setTargetId(int n) {
    }
}


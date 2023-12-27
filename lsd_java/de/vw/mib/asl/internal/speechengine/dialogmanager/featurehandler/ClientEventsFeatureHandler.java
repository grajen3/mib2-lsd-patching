/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerLogger;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.ClientEventsFeatureHandler$1;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.SpeechClientIdentifiersUtil;
import de.vw.mib.asl.internal.speechengine.features.client.context.ContextEventsContextFeature;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class ClientEventsFeatureHandler
implements DialogManagerStateListener {
    protected DialogManagerLogger logger = new DialogManagerLogger("[ClientEventsFeatureHandler] ");
    private HmiEventPublisher hmiEventPublisher;
    private IntObjectMap idleEvents;
    private IntObjectMap promptStartedEvents;
    private IntObjectMap promptSpokenEvents;
    private IntObjectMap helpModeActivatedEvents;
    private IntObjectMap helpModeDeactivatedEvents;
    private FeatureHandler clientEventsFeatureHandler = new ClientEventsFeatureHandler$1(this);

    public ClientEventsFeatureHandler(DialogManagerInternal dialogManagerInternal, HmiEventPublisher hmiEventPublisher) {
        this.hmiEventPublisher = hmiEventPublisher;
        this.idleEvents = new IntObjectOptHashMap();
        this.promptStartedEvents = new IntObjectOptHashMap();
        this.promptSpokenEvents = new IntObjectOptHashMap();
        this.helpModeActivatedEvents = new IntObjectOptHashMap();
        this.helpModeDeactivatedEvents = new IntObjectOptHashMap();
        dialogManagerInternal.registerFeatureHandler(201, this.clientEventsFeatureHandler);
        dialogManagerInternal.registerDialogManagerStateListener(this);
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        if (n2 == 3) {
            this.onHelpModeChanged(true);
        } else if (n == 3) {
            this.onHelpModeChanged(false);
        }
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
    }

    void handleContextEventsFeature(int n, ContextEventsContextFeature contextEventsContextFeature) {
        if (contextEventsContextFeature.isContextIdleEventValid()) {
            this.idleEvents.put(n, contextEventsContextFeature.getContextIdleEvent());
        }
        if (contextEventsContextFeature.isPromptStartedEventValid()) {
            this.promptStartedEvents.put(n, contextEventsContextFeature.getPromptStartedEvent());
        }
        if (contextEventsContextFeature.isPromptsSpokenEventValid()) {
            this.promptSpokenEvents.put(n, contextEventsContextFeature.getPromptsSpokenEvent());
        }
        if (contextEventsContextFeature.isHelpModeActivatedEventValid()) {
            this.helpModeActivatedEvents.put(n, contextEventsContextFeature.getHelpModeActivatedEvent());
        }
        if (contextEventsContextFeature.isHelpModeDeactivatedEventValid()) {
            this.helpModeDeactivatedEvents.put(n, contextEventsContextFeature.getHelpModeDeactivatedEvent());
        }
    }

    public void fireIdleEvent(int n) {
        Object object;
        Object object2 = this.idleEvents.get(n);
        if (object2 == null) {
            StringBuffer stringBuffer = new StringBuffer("Triggered fireIdleEvent(");
            stringBuffer.append(SpeechClientIdentifiersUtil.toString(n));
            stringBuffer.append("), but no event was specified for the given client.");
            this.logger.error(stringBuffer.toString());
            return;
        }
        if (this.logger.isTraceEnabled()) {
            object = new StringBuffer("Triggered fireIdleEvent(");
            ((StringBuffer)object).append(SpeechClientIdentifiersUtil.toString(n));
            ((StringBuffer)object).append(").");
            this.logger.trace(((StringBuffer)object).toString());
        }
        object = (Event)object2;
        this.hmiEventPublisher.publishHmiEvent(n, object.getEventId());
    }

    public void firePromptStartedEvent(int n) {
        Object object;
        Object object2 = this.promptStartedEvents.get(n);
        if (object2 == null) {
            if (this.logger.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("Triggered firePromptStartedEvent(");
                stringBuffer.append(SpeechClientIdentifiersUtil.toString(n));
                stringBuffer.append("), but no event was specified for the given client.");
                this.logger.warn(stringBuffer.toString());
            }
            return;
        }
        if (this.logger.isTraceEnabled()) {
            object = new StringBuffer("Triggered firePromptStartedEvent(");
            ((StringBuffer)object).append(SpeechClientIdentifiersUtil.toString(n));
            ((StringBuffer)object).append(").");
            this.logger.trace(((StringBuffer)object).toString());
        }
        object = (Event)object2;
        this.hmiEventPublisher.publishHmiEvent(n, object.getEventId());
    }

    public void firePromptSpokenEvent(int n) {
        Object object;
        Object object2 = this.promptSpokenEvents.get(n);
        if (object2 == null) {
            if (this.logger.isTraceEnabled()) {
                StringBuffer stringBuffer = new StringBuffer("Triggered firePromptSpokenEvent(");
                stringBuffer.append(SpeechClientIdentifiersUtil.toString(n));
                stringBuffer.append("), but no event was specified for the given client.");
                this.logger.warn(stringBuffer.toString());
            }
            return;
        }
        if (this.logger.isTraceEnabled()) {
            object = new StringBuffer("Triggered firePromptSpokenEvent(");
            ((StringBuffer)object).append(SpeechClientIdentifiersUtil.toString(n));
            ((StringBuffer)object).append(").");
            this.logger.trace(((StringBuffer)object).toString());
        }
        object = (Event)object2;
        this.hmiEventPublisher.publishHmiEvent(n, object.getEventId());
    }

    protected void onHelpModeChanged(boolean bl) {
        IntObjectMap intObjectMap = bl ? this.helpModeActivatedEvents : this.helpModeDeactivatedEvents;
        IntIterator intIterator = intObjectMap.keyIterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            Event event = (Event)intObjectMap.get(n);
            this.hmiEventPublisher.publishHmiEvent(n, event.getEventId());
        }
    }
}


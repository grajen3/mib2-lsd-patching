/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.system.content.StageContentRequestProcessor;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.processor.stage.AbstractStageContentRequestAdapter;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class ContentRequestTarget
implements Target {
    private final GenericEvents genericEvents;
    private StageContentRequestProcessor stageContentRequestProcessor;

    public ContentRequestTarget(SystemServices systemServices) {
        Preconditions.checkArgumentNotNull(systemServices, "The given SystemServices instance must not be null.");
        this.genericEvents = systemServices.getGenericEvents();
        this.stageContentRequestProcessor = systemServices.getStageContentRequestProcessor();
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return -274066176;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 1075841838: {
                String string = eventGeneric.getString(0);
                this.stageContentRequestProcessor.process(new AbstractStageContentRequestAdapter(string));
                break;
            }
        }
    }

    @Override
    public void setTargetId(int n) {
    }

    private void processPowerOn() {
        this.genericEvents.getServiceRegister().addObserver(772481088, this.getTargetId());
    }
}


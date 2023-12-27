/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.selectiontilel;

import de.vw.mib.asl.api.homescreen.ASLHomeScreenFactory;
import de.vw.mib.asl.internal.selectiontilel.SelectionTileLStartupTarget$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class SelectionTileLStartupTarget
implements Target {
    private final GenericEvents genericEvents;

    public SelectionTileLStartupTarget(GenericEvents genericEvents, String string) {
        this.genericEvents = genericEvents;
        this.genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, string);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return 1944853248;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
        }
    }

    @Override
    public void setTargetId(int n) {
    }

    private void processPowerOn() {
        ASLHomeScreenFactory.getHomeScreenApi().getTileSelectionAppService().registerTileSelectionApp(new SelectionTileLStartupTarget$1(this));
    }
}


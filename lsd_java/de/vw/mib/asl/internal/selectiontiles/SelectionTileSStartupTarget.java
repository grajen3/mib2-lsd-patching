/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.selectiontiles;

import de.vw.mib.asl.api.homescreen.ASLHomeScreenFactory;
import de.vw.mib.asl.internal.selectiontiles.SelectionTileSStartupTarget$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class SelectionTileSStartupTarget
implements Target {
    private final GenericEvents genericEvents;

    public SelectionTileSStartupTarget(GenericEvents genericEvents, String string) {
        this.genericEvents = genericEvents;
        this.genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, string);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return 1131879168;
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
        ASLHomeScreenFactory.getHomeScreenApi().getTileSelectionAppService().registerTileSelectionApp(new SelectionTileSStartupTarget$1(this));
    }
}


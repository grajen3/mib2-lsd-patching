/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile.api.impl;

import de.vw.mib.asl.api.navmaptile.ASLNavMapTileFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.navmaptile.api.impl.ASLNavMapTileAPIImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class NavMapTilePreStartupTarget
extends AbstractASLTarget {
    private static final int EV_DO_DELAYED_STARTUP;
    private static final int EV_DO_DELAYED_STARTUP_ON;

    public NavMapTilePreStartupTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.startTimer(75956480, (long)0, false);
                break;
            }
            case 100100: {
                ((ASLNavMapTileAPIImpl)ASLNavMapTileFactory.getNavMapTileApi()).createTargets();
                this.startTimer(92733696, (long)0, false);
                break;
            }
            case 100101: {
                ((ASLNavMapTileAPIImpl)ASLNavMapTileFactory.getNavMapTileApi()).powerOnTargets();
                this.getEventDispatcher().unregisterTarget(this.getTargetId());
                break;
            }
        }
    }
}


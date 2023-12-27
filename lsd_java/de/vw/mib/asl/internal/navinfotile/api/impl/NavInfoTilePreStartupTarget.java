/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.api.impl;

import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.navinfotile.api.impl.ASLNavInfoTileAPIImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class NavInfoTilePreStartupTarget
extends AbstractASLTarget {
    public NavInfoTilePreStartupTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                ((ASLNavInfoTileAPIImpl)ASLNavInfoTileFactory.getNavInfoTileApi()).createTargets();
                ((ASLNavInfoTileAPIImpl)ASLNavInfoTileFactory.getNavInfoTileApi()).powerOnTargets();
                break;
            }
        }
    }
}


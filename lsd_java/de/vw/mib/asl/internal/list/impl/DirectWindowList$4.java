/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$ScrollFallbackMechanism;
import de.vw.mib.log4mib.LogMessage;

final class DirectWindowList$4
implements DirectWindowList$ScrollFallbackMechanism {
    DirectWindowList$4() {
    }

    @Override
    public String getName() {
        return "ANCHOR_SWITCH";
    }

    @Override
    public void fallback(DirectWindowList directWindowList, LogMessage logMessage) {
        DirectWindowList.scrollFallbackAnchorSwitch(directWindowList, logMessage);
    }
}


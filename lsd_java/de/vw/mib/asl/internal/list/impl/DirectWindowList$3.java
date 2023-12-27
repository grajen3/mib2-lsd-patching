/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.DirectWindowList$ScrollFallbackMechanism;
import de.vw.mib.log4mib.LogMessage;

final class DirectWindowList$3
implements DirectWindowList$ScrollFallbackMechanism {
    DirectWindowList$3() {
    }

    @Override
    public String getName() {
        return "EDGE_DETECT";
    }

    @Override
    public void fallback(DirectWindowList directWindowList, LogMessage logMessage) {
        DirectWindowList.scrollFallbackEdgeDetect(directWindowList, logMessage);
    }
}


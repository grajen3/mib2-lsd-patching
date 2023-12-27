/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.ListenerTools;

final class LscAdapter$ListenerId {
    final int type;
    final int aslTargetId;

    LscAdapter$ListenerId(int n) {
        this.type = ListenerTools.extractListenerType(n);
        this.aslTargetId = ListenerTools.extractAslTargetId(n);
    }

    public String toString() {
        return new StringBuffer().append("listenerType=").append(this.type).append(", aslTargetId=").append(this.aslTargetId).toString();
    }
}


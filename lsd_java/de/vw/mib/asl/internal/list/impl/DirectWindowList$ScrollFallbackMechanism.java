/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.log4mib.LogMessage;

interface DirectWindowList$ScrollFallbackMechanism {
    default public String getName() {
    }

    default public void fallback(DirectWindowList directWindowList, LogMessage logMessage) {
    }
}


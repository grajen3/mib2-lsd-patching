/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.LogMessage;

public interface Loggable {
    default public void toString(LogMessage logMessage) {
    }
}


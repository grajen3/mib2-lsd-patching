/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.log4mib.internal.EmptyLoggerFactory$EmptyLogger;

public class EmptyLoggerFactory
implements LoggerFactory {
    @Override
    public Logger getLogger(int n) {
        return new EmptyLoggerFactory$EmptyLogger();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.Activator$ServiceListenerImpl;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

class Activator$ServiceListenerImpl$1
extends AbstractClassifiedLogger {
    private final /* synthetic */ Logger val$logger;
    private final /* synthetic */ Activator$ServiceListenerImpl this$0;

    Activator$ServiceListenerImpl$1(Activator$ServiceListenerImpl activator$ServiceListenerImpl, int n, String string, Logger logger) {
        this.this$0 = activator$ServiceListenerImpl;
        this.val$logger = logger;
        super(n, string);
    }

    @Override
    protected Logger getLogger() {
        return this.val$logger;
    }
}


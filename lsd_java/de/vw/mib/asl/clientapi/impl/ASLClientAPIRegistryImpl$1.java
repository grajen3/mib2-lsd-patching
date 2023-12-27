/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.ASLClientAPIRegistryImpl;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

class ASLClientAPIRegistryImpl$1
extends AbstractClassifiedLogger {
    private final /* synthetic */ Logger val$logger;
    private final /* synthetic */ ASLClientAPIRegistryImpl this$0;

    ASLClientAPIRegistryImpl$1(ASLClientAPIRegistryImpl aSLClientAPIRegistryImpl, int n, String string, Logger logger) {
        this.this$0 = aSLClientAPIRegistryImpl;
        this.val$logger = logger;
        super(n, string);
    }

    @Override
    protected Logger getLogger() {
        return this.val$logger;
    }
}


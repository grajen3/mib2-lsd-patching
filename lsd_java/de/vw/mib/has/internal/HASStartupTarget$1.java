/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.has.internal.HASStartupTarget;
import de.vw.mib.log4mib.Logger;

class HASStartupTarget$1
extends AbstractClassifiedLogger {
    private final /* synthetic */ Logger val$logger;
    private final /* synthetic */ HASStartupTarget this$0;

    HASStartupTarget$1(HASStartupTarget hASStartupTarget, int n, String string, Logger logger) {
        this.this$0 = hASStartupTarget;
        this.val$logger = logger;
        super(n, string);
    }

    @Override
    protected Logger getLogger() {
        return this.val$logger;
    }
}


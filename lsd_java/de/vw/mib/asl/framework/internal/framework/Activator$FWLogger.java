/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

class Activator$FWLogger
extends AbstractClassifiedLogger {
    Activator$FWLogger(int n, String string) {
        super(n, string);
    }

    @Override
    protected Logger getLogger() {
        return ServiceManager.loggerFW;
    }
}


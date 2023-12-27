/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.Services;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

class ASLListLogImpl
extends AbstractClassifiedLogger {
    private final Services services;

    ASLListLogImpl(Services services) {
        super(2, "[ASLList] ");
        this.services = services;
    }

    @Override
    protected Logger getLogger() {
        return this.services.getASLFWLogger();
    }
}


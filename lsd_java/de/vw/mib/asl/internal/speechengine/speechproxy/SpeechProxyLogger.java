/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.speechproxy;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

public class SpeechProxyLogger
extends AbstractClassifiedLogger {
    private final Logger logger;

    public SpeechProxyLogger(Logger logger) {
        super(16, "[SpeechProxy] ");
        this.logger = logger;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}


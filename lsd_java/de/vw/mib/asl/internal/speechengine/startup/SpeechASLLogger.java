/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

public class SpeechASLLogger
extends AbstractClassifiedLogger {
    private final Logger logger;

    protected SpeechASLLogger(int n, String string, Logger logger) {
        super(n, string);
        this.logger = logger;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}


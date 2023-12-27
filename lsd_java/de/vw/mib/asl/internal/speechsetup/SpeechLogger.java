/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

public class SpeechLogger
extends AbstractClassifiedLogger {
    private final Logger logger;

    public SpeechLogger(Logger logger, int n, int n2, String string) {
        super(n2, string);
        this.logger = logger;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}


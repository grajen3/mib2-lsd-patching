/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.utils;

import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.Logger;

public class SpeechPhoneClassifiedLogger
extends AbstractClassifiedLogger {
    public static final int LOGGER_CLASSIFIER;
    private final Logger logger;

    public SpeechPhoneClassifiedLogger(Logger logger, int n) {
        super(n, null);
        this.logger = logger;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}


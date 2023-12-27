/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.utils;

import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralServiceManager;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class SpeechGeneralLogger
extends AbstractClassifiedLogger {
    private final Logger logger = SpeechGeneralServiceManager.getLogger();

    public SpeechGeneralLogger(String string, int n) {
        super(n, new StringBuffer().append("[[SG]]").append(string).toString());
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }

    @Override
    public LogMessage trace() {
        return super.trace();
    }
}


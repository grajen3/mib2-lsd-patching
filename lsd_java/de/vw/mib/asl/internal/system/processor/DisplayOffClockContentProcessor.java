/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.system.contentprocessor.AbstractContentProcessor;
import de.vw.mib.asl.internal.system.SystemServices;

public class DisplayOffClockContentProcessor
extends AbstractContentProcessor {
    public DisplayOffClockContentProcessor(SystemServices systemServices) {
        super(systemServices.getAsl1Logger(), "ScreenAreaDisplayOffClock");
    }

    @Override
    public void requestContent(String string) {
        if (this.isTraceEnabled()) {
            this.logger.trace(2048, new StringBuffer().append("Requested content id: ").append(string).toString());
        }
        this.updateContent(string);
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }
}


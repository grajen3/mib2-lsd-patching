/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.frontend;

import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.util.IThreadEntityCreator;

public class FrontendThreadEntityCreator
implements IThreadEntityCreator {
    private final TraceFrontend frontend;

    public FrontendThreadEntityCreator(TraceFrontend traceFrontend) {
        this.frontend = traceFrontend;
    }

    @Override
    public int createThreadEntity(String string) {
        TraceEntityURIWithLevel traceEntityURIWithLevel = this.frontend.createThread(string, (short)7);
        if (traceEntityURIWithLevel == null) {
            return -1;
        }
        return traceEntityURIWithLevel.getId();
    }
}


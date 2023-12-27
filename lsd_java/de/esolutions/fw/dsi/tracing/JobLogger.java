/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tracing;

import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.tracing.TraceChannel;

public class JobLogger
implements IJobLogger {
    private static final TraceChannel tracer = Channels.SERVICEWORKER;

    @Override
    public void log(int n, String string, Object object) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object);
    }

    @Override
    public void log(int n, String string, Object object, int n2) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, (Object)String.valueOf(n2));
    }

    @Override
    public void log(int n, String string, Object object, int n2, int n3) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, (Object)String.valueOf(n2), (Object)String.valueOf(n3));
    }

    @Override
    public void log(int n, String string, Object object, Object object2) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, object2);
    }

    @Override
    public void log(int n, String string, Object object, Object object2, int n2) {
        tracer.log(this.jobLogerLevel2TraceLevel(n), string, object, object2, (Object)String.valueOf(n2));
    }

    @Override
    public void logException(Exception exception) {
        tracer.log((short)4, new StringBuffer().append("Caught exception: ").append(exception.toString()).toString());
    }

    private final short jobLogerLevel2TraceLevel(int n) {
        if (n == 1000) {
            return 5;
        }
        if (n == 10000) {
            return 4;
        }
        if (n == -1601830656) {
            return 3;
        }
        if (n == 1078071040) {
            return 2;
        }
        if (n == -2137614336) {
            return 1;
        }
        if (n == 14808325) {
            return 0;
        }
        return 2;
    }
}


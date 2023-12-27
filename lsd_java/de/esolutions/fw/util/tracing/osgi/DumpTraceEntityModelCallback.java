/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.osgi;

import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.TraceClient;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import java.io.File;
import java.io.IOException;

public class DumpTraceEntityModelCallback
implements ITraceCallback {
    private final String basePath;

    public DumpTraceEntityModelCallback(String string) {
        this.basePath = string;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        TraceFrontend traceFrontend;
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null && (traceFrontend = traceClient.getFrontend()) != null) {
            String string = SystemConfig.getInstance().getMyProcName();
            String string2 = new StringBuffer().append(this.basePath).append(File.separator).append(string).append(".sem").toString();
            try {
                traceFrontend.writeSemFile(string2, string);
                System.out.println(new StringBuffer().append("--> Wrote sem file ").append(string2).toString());
            }
            catch (IOException iOException) {
                System.out.println(new StringBuffer().append("--> Error writing sem file ").append(string2).append(": ").append(iOException.getMessage()).toString());
            }
        }
    }
}


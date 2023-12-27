/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.comm;

import de.esolutions.fw.comm.core.IMethod;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.dsi.tracing.Channels;

class DSIServiceWorker$ServiceJob
implements Runnable {
    private IMethod method;

    public String toString() {
        return new StringBuffer().append("ServiceJob [method=").append(this.method.toString()).append("]").toString();
    }

    DSIServiceWorker$ServiceJob(IMethod iMethod) {
        this.method = iMethod;
    }

    @Override
    public void run() {
        try {
            this.method.invoke();
        }
        catch (MethodException methodException) {
            Channels.SERVICEWORKER.log((short)4, "Error during service method invocation: service=%1, method=%2, rootCause=%3", this.method.getService(), (Object)this.method.toString(), (Object)methodException);
        }
    }
}


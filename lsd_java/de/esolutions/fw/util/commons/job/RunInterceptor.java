/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;

public class RunInterceptor
extends BaseInterceptor
implements IInterceptor {
    @Override
    public void execute(Job job) {
        ((Runnable)job.getPayload()).run();
    }
}


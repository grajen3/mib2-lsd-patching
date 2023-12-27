/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public interface IDispatcherManager {
    default public DispatcherBase createDispatcher(String string, IJobLogger iJobLogger) {
    }

    default public DispatcherBase createDispatcher(String string, IJobLogger iJobLogger, JobQueue jobQueue) {
    }

    default public DispatcherBase createDispatcher(String string, IJobLogger iJobLogger, JobQueue jobQueue, IInterceptor iInterceptor, Job job) {
    }

    default public void destroyDispatcher(String string) {
    }

    default public ITimeSource getTimeSource() {
    }
}


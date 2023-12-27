/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;

public interface IBlockedJobHandler {
    default public void blocked(Job job, long l) {
    }

    default public void unblocked(Job job) {
    }

    default public void lengthWarning(int n, int n2) {
    }

    default public void lengthExceeded(int n, int n2) {
    }
}


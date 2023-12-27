/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;

final class JobQueue$NullJob
extends Job {
    JobQueue$NullJob() {
        super(new Object());
        super.cancel();
    }
}


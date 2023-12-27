/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.BundleInfo;
import edu.emory.mathcs.backport.java.util.concurrent.CountDownLatch;
import org.osgi.framework.Bundle;

final class ParallelBundleStartInfo {
    final int id;
    final Bundle[] bundles;
    final int threadPrio;
    private final CountDownLatch latch;
    final BundleInfo forkMarker;
    final BundleInfo joinMarker;

    ParallelBundleStartInfo(int n, Bundle[] bundleArray, int n2) {
        this.id = n;
        this.bundles = bundleArray;
        this.threadPrio = n2;
        this.latch = new CountDownLatch(1);
        this.forkMarker = new BundleInfo(n, new StringBuffer().append("Fork-").append(n).toString(), null);
        this.joinMarker = new BundleInfo(n, new StringBuffer().append("Join-").append(n).toString(), null);
    }

    void countDown() {
        this.latch.countDown();
    }

    boolean isFinished() {
        return this.latch.getCount() == 0L;
    }

    void await() {
        this.latch.await();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.internal.MIBOsgiImpl;
import de.vw.mib.osgi.internal.ParallelBundleStartInfo;
import org.osgi.framework.BundleException;

class MIBOsgiImpl$1
implements Runnable {
    private final /* synthetic */ ParallelBundleStartInfo val$info;
    private final /* synthetic */ int val$id;
    private final /* synthetic */ MIBOsgiImpl this$0;

    MIBOsgiImpl$1(MIBOsgiImpl mIBOsgiImpl, ParallelBundleStartInfo parallelBundleStartInfo, int n) {
        this.this$0 = mIBOsgiImpl;
        this.val$info = parallelBundleStartInfo;
        this.val$id = n;
    }

    @Override
    public void run() {
        try {
            this.this$0.performBundleStarts(this.val$info.bundles, new StringBuffer().append("Starting parallel starting bundles (").append(this.val$id).append(") ...").toString());
            this.val$info.countDown();
            MIBOsgi.logger.info(2, new StringBuffer().append("Parallel starting bundles (").append(this.val$id).append(") started!").toString());
        }
        catch (BundleException bundleException) {
            MIBOsgi.logger.error(2, "Error while starting parallel bundles!", bundleException.getNestedException());
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.restart;

import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$1;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$CallRestartMethod;

class DomainRestartObservation$1$2
implements DomainRestartObservation$CallRestartMethod {
    private final /* synthetic */ int val$domainStatus;
    private final /* synthetic */ DomainRestartObservation$1 this$1;

    DomainRestartObservation$1$2(DomainRestartObservation$1 domainRestartObservation$1, int n) {
        this.this$1 = domainRestartObservation$1;
        this.val$domainStatus = n;
    }

    @Override
    public void run(int n) {
        DomainRestartObservation$1.access$000(this.this$1).handleRestartNav(this.val$domainStatus, n);
    }
}


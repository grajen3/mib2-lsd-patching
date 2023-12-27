/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.restart;

import de.vw.mib.asl.framework.internal.startupv7r.restart.DSIStartupAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$1$1;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$1$2;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$1$3;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$1$4;
import de.vw.mib.asl.framework.internal.startupv7r.restart.DomainRestartObservation$CallRestartMethod;

class DomainRestartObservation$1
extends DSIStartupAdapter {
    private final /* synthetic */ DomainRestartObservation this$0;

    DomainRestartObservation$1(DomainRestartObservation domainRestartObservation) {
        this.this$0 = domainRestartObservation;
    }

    @Override
    public void updateDomainStatusSDS(int n, int n2) {
        this.handleRestart(n, 10, new DomainRestartObservation$1$1(this, n));
    }

    @Override
    public void updateDomainStatusNav(int n, int n2) {
        this.handleRestart(n, 6, new DomainRestartObservation$1$2(this, n));
    }

    @Override
    public void updateDomainStatusGEMMI(int n, int n2) {
        this.handleRestart(n, 17, new DomainRestartObservation$1$3(this, n));
    }

    @Override
    public void updateDomainStatusExLAP(int n, int n2) {
        this.handleRestart(n, 32, new DomainRestartObservation$1$4(this, n));
    }

    private void handleRestart(int n, int n2, DomainRestartObservation$CallRestartMethod domainRestartObservation$CallRestartMethod) {
        if (this.this$0.domainsWereFullyOperationalOnce.contains(n2)) {
            this.this$0.info(new StringBuffer().append("Domain ").append(n2).append(" is handled for restart.").toString());
            int n3 = this.this$0.domainStatesModel.getRequestedState(n2);
            domainRestartObservation$CallRestartMethod.run(n3);
        } else if ((n & 8) != 0) {
            this.this$0.info(new StringBuffer().append("Domain ").append(n2).append(" is stored to be operable.").toString());
            this.this$0.domainsWereFullyOperationalOnce.add(n2);
        }
    }

    static /* synthetic */ DomainRestartObservation access$000(DomainRestartObservation$1 domainRestartObservation$1) {
        return domainRestartObservation$1.this$0;
    }
}


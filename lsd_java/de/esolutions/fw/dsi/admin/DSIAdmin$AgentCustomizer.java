/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.admin.DSIAdmin$1;
import de.esolutions.fw.dsi.admin.DSIAdmin$AgentCustomizer$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DSIAdmin$AgentCustomizer
implements ServiceTrackerCustomizer {
    private final /* synthetic */ DSIAdmin this$0;

    private DSIAdmin$AgentCustomizer(DSIAdmin dSIAdmin) {
        this.this$0 = dSIAdmin;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = DSIAdmin.access$000(this.this$0).getService(serviceReference);
        if (object instanceof Agent) {
            DSIAdmin.access$102(this.this$0, (Agent)object);
            DSIAdmin.access$200(this.this$0).log((short)1, "COMM Agent service available.");
            DSIAdmin.access$300(this.this$0, DSIAdmin.access$000(this.this$0));
            new DSIAdmin$AgentCustomizer$1(this, "DSIAdmin:EarlyStartup").start();
        } else {
            DSIAdmin.access$000(this.this$0).ungetService(serviceReference);
        }
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof Agent) {
            DSIAdmin.access$200(this.this$0).log((short)1, "COMM Agent unregistered.");
            DSIAdmin.access$102(this.this$0, null);
            this.this$0.stop(DSIAdmin.access$000(this.this$0));
        }
    }

    static /* synthetic */ DSIAdmin access$400(DSIAdmin$AgentCustomizer dSIAdmin$AgentCustomizer) {
        return dSIAdmin$AgentCustomizer.this$0;
    }

    /* synthetic */ DSIAdmin$AgentCustomizer(DSIAdmin dSIAdmin, DSIAdmin$1 dSIAdmin$1) {
        this(dSIAdmin);
    }
}


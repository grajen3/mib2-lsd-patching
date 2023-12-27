/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.admin.DSIAdmin$AgentCustomizer;

class DSIAdmin$AgentCustomizer$1
extends Thread {
    private final /* synthetic */ DSIAdmin$AgentCustomizer this$1;

    DSIAdmin$AgentCustomizer$1(DSIAdmin$AgentCustomizer dSIAdmin$AgentCustomizer, String string) {
        this.this$1 = dSIAdmin$AgentCustomizer;
        super(string);
    }

    @Override
    public void run() {
        DSIAdmin.access$500(DSIAdmin$AgentCustomizer.access$400(this.this$1));
    }
}


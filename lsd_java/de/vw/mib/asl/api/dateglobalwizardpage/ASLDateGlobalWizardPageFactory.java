/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.dateglobalwizardpage;

import de.vw.mib.asl.api.dateglobalwizardpage.ASLDateGlobalWizardPageAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLDateGlobalWizardPageFactory
extends ASLFactoryBase {
    private static ASLDateGlobalWizardPageAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$dateglobalwizardpage$ASLDateGlobalWizardPageFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLDateGlobalWizardPageAPI getDateGlobalWizardPageApi() {
        Class clazz = class$de$vw$mib$asl$api$dateglobalwizardpage$ASLDateGlobalWizardPageFactory == null ? (class$de$vw$mib$asl$api$dateglobalwizardpage$ASLDateGlobalWizardPageFactory = ASLDateGlobalWizardPageFactory.class$("de.vw.mib.asl.api.dateglobalwizardpage.ASLDateGlobalWizardPageFactory")) : class$de$vw$mib$asl$api$dateglobalwizardpage$ASLDateGlobalWizardPageFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                // empty if block
            }
            return apiInstance;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.globalsetupwizard;

import de.vw.mib.asl.api.globalsetupwizard.ASLGlobalSetupWizardAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLGlobalSetupWizardFactory
extends ASLFactoryBase {
    private static ASLGlobalSetupWizardAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLGlobalSetupWizardAPI getGlobalSetupWizardApi() {
        Class clazz = class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardFactory == null ? (class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardFactory = ASLGlobalSetupWizardFactory.class$("de.vw.mib.asl.api.globalsetupwizard.ASLGlobalSetupWizardFactory")) : class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLGlobalSetupWizardAPI)ASLGlobalSetupWizardFactory.createServiceInstance(class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardAPI == null ? (class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardAPI = ASLGlobalSetupWizardFactory.class$("de.vw.mib.asl.api.globalsetupwizard.ASLGlobalSetupWizardAPI")) : class$de$vw$mib$asl$api$globalsetupwizard$ASLGlobalSetupWizardAPI, "de.vw.mib.asl.internal.globalsetupwizard.api.impl.ASLGlobalSetupWizardAPIImpl");
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


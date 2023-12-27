/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.ASLListManagerImpl;
import de.vw.mib.asl.framework.internal.framework.Activator;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.threads.MIBInvoker;
import generated.de.vw.mib.asl.internal.StartUpUtil;
import java.util.Dictionary;
import org.osgi.framework.BundleContext;

class Activator$ASLWrapperInitializer
implements Runnable {
    private final BundleContext context;
    private final MIBInvoker invoker;
    private final ClassifiedLogger clogger;
    private ASLDeviceRegistry deviceRegistry;
    private ServiceRegister serviceRegister;
    private boolean done;

    Activator$ASLWrapperInitializer(BundleContext bundleContext, MIBInvoker mIBInvoker, ClassifiedLogger classifiedLogger) {
        this.context = bundleContext;
        this.invoker = mIBInvoker;
        this.clogger = classifiedLogger;
    }

    void setDeviceRegistry(ASLDeviceRegistry aSLDeviceRegistry) {
        this.deviceRegistry = aSLDeviceRegistry;
        this.checkConditions();
    }

    void setServiceRegister(ServiceRegister serviceRegister) {
        this.serviceRegister = serviceRegister;
        this.checkConditions();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkConditions() {
        boolean bl;
        Activator$ASLWrapperInitializer activator$ASLWrapperInitializer = this;
        synchronized (activator$ASLWrapperInitializer) {
            bl = !this.done && null != this.deviceRegistry && null != this.serviceRegister;
            this.done |= bl;
        }
        if (bl) {
            this.invoker.invoke(this);
        }
    }

    @Override
    public void run() {
        StartUpUtil.init(this.deviceRegistry, this.serviceRegister, this.clogger);
        ASLListManagerImpl aSLListManagerImpl = new ASLListManagerImpl(this.deviceRegistry);
        this.context.registerService(new String[]{(Activator.class$de$vw$mib$asl$internal$list$ASLListManager == null ? (Activator.class$de$vw$mib$asl$internal$list$ASLListManager = Activator.class$("de.vw.mib.asl.internal.list.ASLListManager")) : Activator.class$de$vw$mib$asl$internal$list$ASLListManager).getName(), (Activator.class$de$vw$mib$list$DynamicListManager == null ? (Activator.class$de$vw$mib$list$DynamicListManager = Activator.class$("de.vw.mib.list.DynamicListManager")) : Activator.class$de$vw$mib$list$DynamicListManager).getName()}, (Object)aSLListManagerImpl, (Dictionary)null);
    }
}


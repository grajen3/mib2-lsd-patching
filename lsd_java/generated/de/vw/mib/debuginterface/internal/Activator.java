/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.debuginterface.internal;

import de.vw.mib.debuginterface.datapool.DebugDataPoolValues;
import generated.de.vw.mib.global.debuginterface.datapool.DebugDataPoolValuesImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    private BundleContext bundleContext;
    private DebugDataPoolValues debugDataPoolValues;
    static /* synthetic */ Class class$de$vw$mib$debuginterface$datapool$DebugDataPoolValues;

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.startSetup();
        this.bundleContext.registerService((class$de$vw$mib$debuginterface$datapool$DebugDataPoolValues == null ? (class$de$vw$mib$debuginterface$datapool$DebugDataPoolValues = Activator.class$("de.vw.mib.debuginterface.datapool.DebugDataPoolValues")) : class$de$vw$mib$debuginterface$datapool$DebugDataPoolValues).getName(), (Object)this.debugDataPoolValues, null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void startSetup() {
        this.debugDataPoolValues = new DebugDataPoolValuesImpl();
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


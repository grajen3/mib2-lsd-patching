/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.internal;

import de.vw.mib.debug.service.probes.app.cio.CioProbeFactory;
import de.vw.mib.debug.service.probes.app.lifecycle.LifecycleProbeFactory;
import de.vw.mib.debug.service.probes.app.modelapi.ModelApiProbeFactory;
import de.vw.mib.debug.service.probes.asllist.ASLListProbeFactory;
import de.vw.mib.debug.service.probes.datapool.DatapoolProbeFactory;
import de.vw.mib.debug.service.probes.dsimethodcall.DsiMethodCallProbeFactory;
import de.vw.mib.debug.service.probes.events.EventDispatcherProbeFactory;
import de.vw.mib.debug.service.probes.featureflags.FeatureFlagProbeFactory;
import de.vw.mib.debug.service.probes.genericevents.GenericEventProbeFactory;
import de.vw.mib.debug.service.probes.hsm.HsmProbeFactory;
import de.vw.mib.debug.service.probes.logging.LogManagerProbeFactory;
import de.vw.mib.debug.service.probes.queues.QueuesProbeFactory;
import de.vw.mib.debug.service.probes.speech.SpeechProbeFactory;
import de.vw.mib.debug.service.probes.statemachine.StatemachineProbeFactory;
import de.vw.mib.debug.service.probes.timer.TimerProbeFactory;
import de.vw.mib.debug.service.probes.viewmanager.ViewManagerProbeFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$debugmanager$probes$DebugProbeFactory;

    @Override
    public void start(BundleContext bundleContext) {
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new GenericEventProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new EventDispatcherProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new FeatureFlagProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new ASLListProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new DatapoolProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new LogManagerProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new StatemachineProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new DsiMethodCallProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new ViewManagerProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new QueuesProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new TimerProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new HsmProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new SpeechProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new CioProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new LifecycleProbeFactory(), null);
        bundleContext.registerService((class$de$vw$mib$debugmanager$probes$DebugProbeFactory == null ? (class$de$vw$mib$debugmanager$probes$DebugProbeFactory = Activator.class$("de.vw.mib.debugmanager.probes.DebugProbeFactory")) : class$de$vw$mib$debugmanager$probes$DebugProbeFactory).getName(), (Object)new ModelApiProbeFactory(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
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


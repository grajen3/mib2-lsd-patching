/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sound.internal;

import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.sound.asl.ASLSoundWaveplayer;
import de.vw.mib.sound.internal.ServiceManager;
import de.vw.mib.sound.internal.SoundWaveplayerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    private BundleContext context;
    static /* synthetic */ Class class$de$vw$mib$sound$SoundWaveplayer;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$sound$asl$ASLSoundWaveplayer;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (serviceEvent.getType() != 1) {
            return;
        }
        Object object = this.context.getService(serviceEvent.getServiceReference());
        if (object instanceof ASLSoundWaveplayer) {
            this.context.registerService((class$de$vw$mib$sound$SoundWaveplayer == null ? (class$de$vw$mib$sound$SoundWaveplayer = Activator.class$("de.vw.mib.sound.SoundWaveplayer")) : class$de$vw$mib$sound$SoundWaveplayer).getName(), (Object)new SoundWaveplayerImpl((ASLSoundWaveplayer)object), null);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("(|");
        stringBuffer.append("(").append("objectClass").append("=").append((class$de$vw$mib$sound$asl$ASLSoundWaveplayer == null ? (class$de$vw$mib$sound$asl$ASLSoundWaveplayer = Activator.class$("de.vw.mib.sound.asl.ASLSoundWaveplayer")) : class$de$vw$mib$sound$asl$ASLSoundWaveplayer).getName()).append(")");
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        this.context.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
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


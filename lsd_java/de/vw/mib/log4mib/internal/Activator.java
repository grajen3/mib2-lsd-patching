/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.log4mib.backend.MessageWriter;
import de.vw.mib.log4mib.backend.TimestampProvider;
import de.vw.mib.log4mib.internal.CarTimeProvider;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.util.StringBuilder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator
implements BundleActivator,
ServiceListener {
    private BundleContext context;
    private MainLogger logger;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$BinaryMessageFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManagerDiag;
    static /* synthetic */ Class class$de$vw$mib$asl$ASLTimeAndDateServiceTarget;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$MessageWriter;
    static /* synthetic */ Class class$de$vw$mib$log4mib$backend$TimestampProvider;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            String[] stringArray;
            Object object;
            block2: {
                object = this.context.getService(serviceEvent.getServiceReference());
                stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                if (serviceEvent.getType() != 1) break block2;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object);
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.handleServiceUnregistering(stringArray[i3], object);
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        this.logger = MainLogger.initLogger();
        this.context.registerService(new String[]{(class$de$vw$mib$log4mib$backend$BinaryMessageFactory == null ? (class$de$vw$mib$log4mib$backend$BinaryMessageFactory = Activator.class$("de.vw.mib.log4mib.backend.BinaryMessageFactory")) : class$de$vw$mib$log4mib$backend$BinaryMessageFactory).getName(), (class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName(), (class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName(), (class$de$vw$mib$log4mib$LogManagerDiag == null ? (class$de$vw$mib$log4mib$LogManagerDiag = Activator.class$("de.vw.mib.log4mib.LogManagerDiag")) : class$de$vw$mib$log4mib$LogManagerDiag).getName()}, (Object)this.logger, null);
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$asl$ASLTimeAndDateServiceTarget == null ? (class$de$vw$mib$asl$ASLTimeAndDateServiceTarget = Activator.class$("de.vw.mib.asl.ASLTimeAndDateServiceTarget")) : class$de$vw$mib$asl$ASLTimeAndDateServiceTarget).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$log4mib$backend$MessageWriter == null ? (class$de$vw$mib$log4mib$backend$MessageWriter = Activator.class$("de.vw.mib.log4mib.backend.MessageWriter")) : class$de$vw$mib$log4mib$backend$MessageWriter).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$log4mib$backend$TimestampProvider == null ? (class$de$vw$mib$log4mib$backend$TimestampProvider = Activator.class$("de.vw.mib.log4mib.backend.TimestampProvider")) : class$de$vw$mib$log4mib$backend$TimestampProvider).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        this.context.addServiceListener(this, string);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void handleServiceRegistered(String string, Object object) {
        if ((class$de$vw$mib$asl$ASLTimeAndDateServiceTarget == null ? (class$de$vw$mib$asl$ASLTimeAndDateServiceTarget = Activator.class$("de.vw.mib.asl.ASLTimeAndDateServiceTarget")) : class$de$vw$mib$asl$ASLTimeAndDateServiceTarget).getName().equals(string)) {
            CarTimeProvider carTimeProvider = new CarTimeProvider((ASLTimeAndDateServiceTarget)object);
            this.logger.addHeartbeatInformationProvider("car.time", carTimeProvider);
            this.logger.addHeartbeatInformationProvider("time", carTimeProvider);
        } else if ((class$de$vw$mib$log4mib$backend$MessageWriter == null ? (class$de$vw$mib$log4mib$backend$MessageWriter = Activator.class$("de.vw.mib.log4mib.backend.MessageWriter")) : class$de$vw$mib$log4mib$backend$MessageWriter).getName().equals(string)) {
            this.logger.registerBackendMessageWriter((MessageWriter)object);
        } else if ((class$de$vw$mib$log4mib$backend$TimestampProvider == null ? (class$de$vw$mib$log4mib$backend$TimestampProvider = Activator.class$("de.vw.mib.log4mib.backend.TimestampProvider")) : class$de$vw$mib$log4mib$backend$TimestampProvider).getName().equals(string)) {
            this.logger.registerBackendTimestampProvider((TimestampProvider)object);
        }
    }

    private void handleServiceUnregistering(String string, Object object) {
        if ((class$de$vw$mib$log4mib$backend$MessageWriter == null ? (class$de$vw$mib$log4mib$backend$MessageWriter = Activator.class$("de.vw.mib.log4mib.backend.MessageWriter")) : class$de$vw$mib$log4mib$backend$MessageWriter).getName().equals(string)) {
            this.logger.unregisterLogWriter();
        } else if ((class$de$vw$mib$log4mib$backend$TimestampProvider == null ? (class$de$vw$mib$log4mib$backend$TimestampProvider = Activator.class$("de.vw.mib.log4mib.backend.TimestampProvider")) : class$de$vw$mib$log4mib$backend$TimestampProvider).getName().equals(string)) {
            this.logger.registerBackendTimestampProvider(TimestampProvider.DEFAULT);
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


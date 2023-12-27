/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.internal;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.debuginterface.codec.DebugInterfaceSettingsCodec;
import de.vw.mib.debuginterface.codec.DebugInterfaceSettingsCodecListener;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.target.TestInterfaceTargetFactory;
import de.vw.mib.debuginterface.target.hmidump.HmiDumpTarget;
import de.vw.mib.debuginterface.target.informationcollector.InformationCollectorTarget;
import de.vw.mib.debuginterface.target.screenshot.ScreenShotTarget;
import de.vw.mib.debugmanager.tester.TesterTargetService;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.log4mib.Logger;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public class TesterTargetFactoryImpl
implements UnifiedLoggingCallbackListener,
DebugInterfaceSettingsCodecListener,
TesterTargetService {
    public static final int SET_NOTIFICATION_TARGET_NO_WRAPPER;
    public static final int SET_NOTIFICATION_TARGET_WRAPPER;
    protected static Logger logger;
    private final BundleContext context;
    private final TestInterfaceTargetFactory testInterfaceTargetFactory;
    private boolean testInterfaceAvailable = false;
    private final DebugInterfaceSettingsCodec codec = new DebugInterfaceSettingsCodec();
    private final IntSet registeredTargets = new IntOptHashSet();
    private final ByteArrayReader reader = new ByteArrayReader();
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener;

    public TesterTargetFactoryImpl(BundleContext bundleContext) {
        this.context = bundleContext;
        this.testInterfaceTargetFactory = this.loadTestInterfaceTargetFactory();
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("message.type", new Short(100));
        bundleContext.registerService((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = TesterTargetFactoryImpl.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName(), (Object)this, (Dictionary)hashtable);
    }

    private TestInterfaceTargetFactory loadTestInterfaceTargetFactory() {
        try {
            Class clazz = Class.forName("de.vw.mib.debuginterface.target.TestInterfaceTargetFactoryImpl");
            this.testInterfaceAvailable = true;
            return (TestInterfaceTargetFactory)clazz.newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
            logger.warn(1, "[DebugInterface] - Couldn't load Testinterface functions: Class not found!");
        }
        catch (IllegalAccessException illegalAccessException) {
            logger.warn(1, "[DebugInterface] - Couldn't load Testinterface functions: No Access to field!");
        }
        catch (InstantiationException instantiationException) {
            logger.warn(1, "[DebugInterface] - Couldn't load Testinterface functions: Not possible to instantiate!");
        }
        return null;
    }

    @Override
    public void createAndRegisterDebugTarget(int n) {
        if (this.registeredTargets.contains(n)) {
            return;
        }
        logger.normal(1).append("starting debug target: ").append(n).log();
        boolean bl = false;
        switch (n) {
            case 5: {
                new InformationCollectorTarget(this.testInterfaceAvailable);
                bl = true;
                break;
            }
            case 15: {
                new HmiDumpTarget();
                bl = true;
                break;
            }
            case 14: {
                new ScreenShotTarget();
                bl = true;
                break;
            }
            default: {
                if (this.testInterfaceTargetFactory == null) break;
                bl = this.testInterfaceTargetFactory.createAndRegisterDebugTarget(n, this.context);
            }
        }
        if (bl) {
            this.registeredTargets.add(n);
        }
    }

    @Override
    public void onBinaryMessageReceived(short s, byte[] byArray, int n, int n2) {
        try {
            this.reader.reset(byArray, n);
            this.codec.decode(this.reader, (DebugInterfaceSettingsCodecListener)this);
        }
        catch (IOException iOException) {
            logger.error(1).append("[DebugTargetFactory]Error reading message ").append(iOException).log();
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

    static {
        logger = ServiceManager.loggerFactory.getLogger(64);
    }
}


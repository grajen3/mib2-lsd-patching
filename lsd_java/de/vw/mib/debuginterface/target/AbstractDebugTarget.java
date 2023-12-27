/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.Logger;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractDebugTarget
implements UnifiedLoggingCallbackListener {
    protected static final int SUBCLASSIFIER;
    public final Logger logger = ServiceManager.loggerFactory.getLogger(64);
    protected final BinaryLogger binaryLogger = ServiceManager.binaryLogger;
    protected final BundleContext context = ServiceManager.context;
    private final ByteArrayReader reader = new ByteArrayReader();
    private ServiceRegistration serviceRegistration;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener;

    public AbstractDebugTarget(short s) {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("message.type", new Short(s));
        this.serviceRegistration = this.context.registerService((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = AbstractDebugTarget.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName(), (Object)this, (Dictionary)hashtable);
    }

    public void close() {
        this.serviceRegistration.unregister();
    }

    protected ByteArrayReader buildReader(byte[] byArray, int n) {
        this.reader.reset(byArray, n);
        return this.reader;
    }

    public BinaryMessage getBinaryMessage(short s) {
        return this.binaryLogger.getBinaryMessage(s);
    }

    @Override
    public void onBinaryMessageReceived(short s, byte[] byArray, int n, int n2) {
        this.messageDecoded(s, this.buildReader(byArray, n));
    }

    protected abstract void messageDecoded(short s, ByteArrayReader byteArrayReader) {
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


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.frontend;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.core.ITraceCoreErrorHandler;
import de.esolutions.fw.util.tracing.core.TraceCore;
import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendErrorHandler;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.TraceMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class TraceFrontend
implements ITraceCoreErrorHandler {
    private TraceConfig config;
    private boolean isEnabled;
    private TraceCore core;
    private Writer emergencyWriter;
    private int startCount;
    private ITraceFrontendErrorHandler errorHandler;
    private static int initCounter;
    private static TraceConfig theConfig;
    private static TraceFrontend theFrontend;
    private static Object lock;
    private static final String chn;

    public static TraceConfig getDefaultConfig(String string, String string2, boolean bl) {
        TraceConfig traceConfig = new TraceConfig(string, string2);
        if (bl) {
            TraceMe.msg(TraceMe.INFO, "reading config file for %1:%2", string, string2);
            if (!traceConfig.readConfig()) {
                TraceMe.msg(TraceMe.WARN, "Warning: invalid tracing config: %1", traceConfig.getFailString());
            }
        }
        return traceConfig;
    }

    public static void init(String string, String string2, boolean bl) {
        TraceFrontend.init(TraceFrontend.getDefaultConfig(string, string2, bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void init(TraceConfig traceConfig) {
        Object object = lock;
        synchronized (object) {
            if (initCounter == 0 && (theConfig = traceConfig).isEnabled()) {
                theFrontend = new TraceFrontend(theConfig);
            }
            ++initCounter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void exit() {
        Object object = lock;
        synchronized (object) {
            if (--initCounter == 0) {
                if (theFrontend != null) {
                    theFrontend.shutdown();
                    theFrontend = null;
                }
                theConfig = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TraceFrontend getTraceFrontend() {
        Object object = lock;
        synchronized (object) {
            return theFrontend;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TraceConfig getTraceConfig() {
        Object object = lock;
        synchronized (object) {
            return theConfig;
        }
    }

    public TraceFrontend(TraceConfig traceConfig) {
        String string;
        this.config = traceConfig;
        this.isEnabled = traceConfig.isEnabled();
        if (this.isEnabled) {
            this.core = new TraceCore(this, traceConfig);
            this.core.setErrorHandler(this);
        }
        if ((string = traceConfig.getEmergencyLogFile()) != null) {
            try {
                this.emergencyWriter = new OutputStreamWriter(new FileOutputStream(string, true), "UTF-8");
            }
            catch (IOException iOException) {
                TraceMe.msg(TraceMe.ERROR, "Emergency Log File %1 failed with: %2", string, iOException);
            }
        }
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void registerListener(ITraceFrontendListener iTraceFrontendListener) {
        if (this.isEnabled) {
            this.core.registerListener(iTraceFrontendListener);
        }
    }

    public void unregisterListener(ITraceFrontendListener iTraceFrontendListener) {
        if (this.isEnabled) {
            this.core.unregisterListener(iTraceFrontendListener);
        }
    }

    public void registerMessageDecoder(short s, ITraceMessageDecoder iTraceMessageDecoder, ConfigValue configValue) {
        if (this.isEnabled) {
            this.core.registerMessageDecoder(s, iTraceMessageDecoder, configValue);
        }
    }

    public void unregisterMessageDecoder(short s) {
        if (this.isEnabled) {
            this.core.unregisterMessageDecoder(s);
        }
    }

    public synchronized boolean start() {
        if (!this.isEnabled) {
            return false;
        }
        if (this.startCount == 0) {
            this.core.start();
        }
        ++this.startCount;
        return true;
    }

    public synchronized boolean stop() {
        if (!this.isEnabled) {
            return false;
        }
        --this.startCount;
        if (this.startCount == 0) {
            this.core.stop();
            this.shutdown();
        }
        return true;
    }

    private void shutdown() {
        if (this.emergencyWriter != null) {
            try {
                this.emergencyWriter.close();
            }
            catch (IOException iOException) {
                TraceMe.msg(TraceMe.ERROR, "TraceFrontend", "Closing emergency Log File failed: %1", iOException);
            }
            this.emergencyWriter = null;
            TraceMe.msg(TraceMe.INFO, "TraceFrontend", "Emergency Log File closed");
        }
    }

    public synchronized boolean isRunning() {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.isRunning();
    }

    public TraceEntityURIWithLevel createChannel(String string, short s) {
        return this.createEntity((short)3, string, s, null);
    }

    public TraceEntityURIWithLevel createChannel(String string, short s, TraceEntityURI traceEntityURI) {
        return this.createEntity((short)3, string, s, traceEntityURI);
    }

    public TraceEntityURIWithLevel createChannelPath(String string, short s) {
        String[] stringArray = StringUtils.splitString(string, '.');
        if (stringArray == null) {
            return null;
        }
        TraceEntityURIWithLevel traceEntityURIWithLevel = null;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            TraceEntityURIWithLevel traceEntityURIWithLevel2 = this.createChannel(stringArray[i2], s, traceEntityURIWithLevel);
            if (traceEntityURIWithLevel2 == null) {
                return null;
            }
            traceEntityURIWithLevel = traceEntityURIWithLevel2;
        }
        return traceEntityURIWithLevel;
    }

    public boolean enableChannel(int n) {
        return this.enableEntity(new TraceEntityURI(3, n));
    }

    public boolean disableChannel(int n) {
        return this.disableEntity(new TraceEntityURI(3, n));
    }

    public boolean isChannelEnabled(int n) {
        return this.isEntityEnabled(new TraceEntityURI(3, n));
    }

    public TraceEntityURIWithLevel createThread(String string, short s) {
        return this.createEntity((short)2, string, s, null);
    }

    public boolean enableThread(int n) {
        return this.enableEntity(new TraceEntityURI(2, n));
    }

    public boolean disableThread(int n) {
        return this.disableEntity(new TraceEntityURI(2, n));
    }

    public boolean isThreadEnabled(int n) {
        return this.isEntityEnabled(new TraceEntityURI(2, n));
    }

    public TraceEntityURIWithLevel createEntity(short s, String string, short s2, TraceEntityURI traceEntityURI) {
        if (!this.isEnabled) {
            return null;
        }
        if (!this.checkFilterLevel(s2, string, traceEntityURI)) {
            s2 = 0;
        }
        return this.core.createEntity(s, string, s2, traceEntityURI, null);
    }

    public TraceEntityURIWithLevel createEntity(short s, String string, short s2, TraceEntityURI traceEntityURI, Object object) {
        if (!this.isEnabled) {
            return null;
        }
        if (!this.checkFilterLevel(s2, string, traceEntityURI)) {
            s2 = 0;
        }
        return this.core.createEntity(s, string, s2, traceEntityURI, object);
    }

    public int registerTimeZone(int n, String string) {
        if (!this.isEnabled) {
            return -1;
        }
        return this.core.registerTimeZone(n, string);
    }

    public boolean updateTimeZone(int n, long l) {
        if (!this.isEnabled) {
            return false;
        }
        long l2 = System.currentTimeMillis();
        return this.core.updateTimeZone(n, l, l2);
    }

    public boolean updateTimeZone(int n, long l, long l2) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.updateTimeZone(n, l, l2);
    }

    public TraceEntityURIWithLevel getRootEntity(short s) {
        if (!this.isEnabled) {
            return null;
        }
        return this.core.getRootEntity(s);
    }

    public TraceEntityURIWithLevel createRootEntity(short s, String string, short s2) {
        TraceEntityURIWithLevel traceEntityURIWithLevel = null;
        switch (s) {
            case 1: {
                traceEntityURIWithLevel = this.core.getRootEntityNoCreate((short)0);
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                traceEntityURIWithLevel = this.core.getRootEntityNoCreate((short)1);
            }
        }
        return this.createEntity(s, string, s2, traceEntityURIWithLevel);
    }

    public TraceEntityURI getParentEntity(TraceEntityURI traceEntityURI) {
        if (!this.isEnabled) {
            return null;
        }
        return this.core.getParentEntity(traceEntityURI);
    }

    public boolean enableEntity(TraceEntityURI traceEntityURI) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.enableEntity(traceEntityURI);
    }

    public boolean disableEntity(TraceEntityURI traceEntityURI) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.disableEntity(traceEntityURI);
    }

    public boolean isEntityEnabled(TraceEntityURI traceEntityURI) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.isEntityEnabled(traceEntityURI);
    }

    public boolean changeFilterLevel(TraceEntityURI traceEntityURI, short s) {
        if (!this.isEnabled) {
            return false;
        }
        if (!this.checkFilterLevel(s, Integer.toString(traceEntityURI.getId()), null)) {
            return false;
        }
        return this.core.changeFilterLevel(traceEntityURI, s);
    }

    public boolean log(ITraceMessage iTraceMessage) {
        if (!this.isEnabled) {
            return false;
        }
        if (!TraceLevels.isValidLogLevel(iTraceMessage.getLevel())) {
            TraceMe.msg(TraceMe.ERROR, "frontend", "logged with invalid level=%1. msg=%2", new Short(iTraceMessage.getLevel()), iTraceMessage);
            return false;
        }
        return this.core.log(iTraceMessage);
    }

    public boolean reportLostMessages(int n) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.reportLostMessages(n);
    }

    public boolean log(int n, int n2, short s, short s2, String string) {
        long l = System.currentTimeMillis();
        return this.log(new TraceMessage(l, n, n2, s, s2, 1, string));
    }

    public boolean log(int n, int n2, short s, short s2, short s3, byte[] byArray) {
        long l = System.currentTimeMillis();
        return this.log(new TraceMessage(l, n, n2, s, s2, s3, byArray));
    }

    public int createCallback(String string) {
        TraceEntityURIWithLevel traceEntityURIWithLevel = this.createEntity((short)4, string, (short)7, null);
        if (traceEntityURIWithLevel == null) {
            return -1;
        }
        return traceEntityURIWithLevel.getId();
    }

    public boolean disableCallback(int n) {
        return this.disableEntity(new TraceEntityURI(4, n));
    }

    public boolean enableCallback(int n) {
        return this.enableEntity(new TraceEntityURI(4, n));
    }

    public boolean isCallbackEnabled(int n) {
        return this.isEntityEnabled(new TraceEntityURI(4, n));
    }

    public boolean registerBackend(ITraceBackend iTraceBackend, String string) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.registerBackend(iTraceBackend, null, string);
    }

    public boolean unregisterBackend(ITraceBackend iTraceBackend) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.unregisterBackend(iTraceBackend);
    }

    public TraceConfig getConfig() {
        return this.config;
    }

    public synchronized void emergencyLog(String string) {
        if (this.emergencyWriter != null) {
            try {
                this.emergencyWriter.write(new StringBuffer().append(string).append("\n").toString());
                this.emergencyWriter.flush();
            }
            catch (IOException iOException) {
                TraceMe.msg(TraceMe.ERROR, "TraceFrontend", "emergencyWriter failed with: %1", iOException);
                this.emergencyWriter = null;
                System.err.println(string);
                System.err.flush();
            }
        } else {
            System.err.println(string);
            System.err.flush();
        }
    }

    public void emergencyBreak() {
        if (this.core != null) {
            this.core.emergencyBreak();
        }
    }

    public void setAttachment(TraceEntityURI traceEntityURI, Object object) {
        if (!this.isEnabled) {
            return;
        }
        this.core.setAttachment(traceEntityURI, object);
    }

    public Object getAttachment(TraceEntityURI traceEntityURI) {
        if (!this.isEnabled) {
            return null;
        }
        return this.core.getAttachment(traceEntityURI);
    }

    public boolean flushMessages(boolean bl, long l) {
        if (!this.isEnabled) {
            return false;
        }
        return this.core.flushMessages(bl, l);
    }

    public Object getComponent(String string) {
        return this.core.getComponent(string);
    }

    public void setComponent(String string, Object object) {
        this.core.setComponent(string, object);
    }

    public void writeSemFile(String string, String string2) {
        this.core.writeSemFile(string, string2);
    }

    private boolean checkFilterLevel(short s, String string, TraceEntityURI traceEntityURI) {
        if (!TraceLevels.isValidFilterLevel(s)) {
            String string2 = null;
            if (traceEntityURI != null) {
                string2 = Integer.toString(traceEntityURI.getId());
            }
            TraceMe.msg(TraceMe.ERROR, "frontend", "used invalid filter level=%1/%2 name=%3 parent=#%4", new Short(s), TraceLevels.getName(s), string, string2);
            return false;
        }
        return true;
    }

    @Override
    public void errorShutdown(TraceCore traceCore, Throwable throwable) {
        this.isEnabled = false;
        if (this.errorHandler != null) {
            this.errorHandler.errorShutdown(this, throwable);
        }
    }

    public void injectError(Throwable throwable) {
        if (this.core != null) {
            this.core.injectError(throwable);
        }
    }

    public void setErrorHandler(ITraceFrontendErrorHandler iTraceFrontendErrorHandler) {
        this.errorHandler = iTraceFrontendErrorHandler;
    }

    static {
        lock = new Object();
    }
}


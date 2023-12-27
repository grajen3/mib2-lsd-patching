/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.perf.service.intern;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.debugmanager.performance.PerformanceTracingService;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.MIBOsgiMonitor;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.perf.service.PerfServiceData;
import de.vw.mib.perf.service.intern.PerfServiceMIBHMI$1;
import de.vw.mib.timer.spi.TimerSPI;
import java.util.Timer;
import java.util.TimerTask;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class PerfServiceMIBHMI
implements BundleActivatorExtension,
ServiceListener,
PerfService,
MIBOsgiMonitor {
    public static final byte TYPE_INTERNAL;
    public static final byte TYPE_MESSAGE;
    public static final byte TYPE_DSI;
    public static final byte TYPE_DOMAIN;
    public static final byte TYPE_ASL;
    public static final byte TYPE_BUNDLES;
    public static final byte TYPE_DC;
    public static final byte TYPE_RVCSTATE;
    public static final byte TYPE_VIEWHANDLER;
    public static final byte TYPE_STARTUP;
    public static final byte TYPE_PROFILE;
    public static final byte TYPE_PERSISTENCE;
    public static final byte TYPE_DIAGNOSIS;
    public static final byte TYPE_WORKUNIT;
    public static final byte TYPE_EVENT;
    public static final byte TYPE_APPUILIFE;
    public static final int VALUE_TRUE;
    public static final int VALUE_FALSE;
    public static final int DEFAULT_DATA_SEND_TIMEOUT;
    public static final int MINIMUM_DATA_SEND_TIMEOUT;
    private static final int STORAGE_INITIAL_SIZE;
    private static final int STORAGE_INCREASE_SIZE;
    private byte[] m_aTypes = new byte[2048];
    private int[] m_aValue2 = new int[2048];
    private int[] m_aValue3 = new int[2048];
    private long[] m_aValue1 = new long[2048];
    private String[] m_aNames = new String[2048];
    private long[] m_aTimestamps = new long[2048];
    private int m_iIndex = 0;
    private boolean m_bPreloaded = false;
    Timer m_oTimer = null;
    private BundleContext m_oBundleContext = null;
    private PerformanceTracingService m_oPerformanceTracingService = null;
    private boolean m_bSendToConsole = false;
    private boolean m_bSendToOsLogger = false;
    private int m_iTimeoutForData = 120;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$performance$PerformanceTracingService;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$timer$spi$TimerSPI;

    @Override
    public void start(BundleContext bundleContext) {
        this.m_oBundleContext = bundleContext;
        if (!this.m_bPreloaded) {
            this.preload(bundleContext);
        }
        this.bundleStateChanged(8, this.m_oBundleContext.getBundle());
        this.m_oTimer = new Timer();
        this.m_oTimer.schedule((TimerTask)new PerfServiceMIBHMI$1(this), this.m_iTimeoutForData * 1000);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    @Override
    public void preload(BundleContext bundleContext) {
        this.readConfiguration();
        this.m_bPreloaded = true;
        if (bundleContext != null) {
            MIBOsgi.getInstance().registerMIBOsgiMonitor(this);
            String string = new StringBuffer().append("(objectClass=").append((class$de$vw$mib$debugmanager$performance$PerformanceTracingService == null ? (class$de$vw$mib$debugmanager$performance$PerformanceTracingService = PerfServiceMIBHMI.class$("de.vw.mib.debugmanager.performance.PerformanceTracingService")) : class$de$vw$mib$debugmanager$performance$PerformanceTracingService).getName()).append(")").toString();
            bundleContext.addServiceListener(this, string);
            ServiceReference serviceReference = bundleContext.getServiceReference(string);
            if (serviceReference != null) {
                this.serviceChanged(new ServiceEvent(1, serviceReference));
            }
            bundleContext.registerService((class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = PerfServiceMIBHMI.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService).getName(), (Object)this, null);
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
        if (serviceEvent.getType() == 1) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!(class$de$vw$mib$debugmanager$performance$PerformanceTracingService == null ? PerfServiceMIBHMI.class$("de.vw.mib.debugmanager.performance.PerformanceTracingService") : class$de$vw$mib$debugmanager$performance$PerformanceTracingService).getName().equals(stringArray[i2])) continue;
                this.m_oPerformanceTracingService = (PerformanceTracingService)this.m_oBundleContext.getService(serviceEvent.getServiceReference());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void add(byte by, long l, int n, int n2, String string, long l2) {
        PerfServiceMIBHMI perfServiceMIBHMI = this;
        synchronized (perfServiceMIBHMI) {
            if (this.m_aTimestamps != null) {
                if (this.m_iIndex >= this.m_aTimestamps.length) {
                    byte[] byArray = this.m_aTypes;
                    long[] lArray = this.m_aValue1;
                    int[] nArray = this.m_aValue2;
                    int[] nArray2 = this.m_aValue3;
                    String[] stringArray = this.m_aNames;
                    long[] lArray2 = this.m_aTimestamps;
                    int n3 = this.m_aTimestamps.length + 1024;
                    this.m_aTypes = new byte[n3];
                    this.m_aValue1 = new long[n3];
                    this.m_aValue2 = new int[n3];
                    this.m_aValue3 = new int[n3];
                    this.m_aNames = new String[n3];
                    this.m_aTimestamps = new long[n3];
                    System.arraycopy((Object)byArray, 0, (Object)this.m_aTypes, 0, byArray.length);
                    System.arraycopy((Object)lArray, 0, (Object)this.m_aValue1, 0, lArray.length);
                    System.arraycopy((Object)nArray, 0, (Object)this.m_aValue2, 0, nArray.length);
                    System.arraycopy((Object)nArray2, 0, (Object)this.m_aValue3, 0, nArray2.length);
                    System.arraycopy((Object)stringArray, 0, (Object)this.m_aNames, 0, stringArray.length);
                    System.arraycopy((Object)lArray2, 0, (Object)this.m_aTimestamps, 0, lArray2.length);
                }
                this.m_aTypes[this.m_iIndex] = by;
                this.m_aValue1[this.m_iIndex] = l;
                this.m_aValue2[this.m_iIndex] = n;
                this.m_aValue3[this.m_iIndex] = n2;
                this.m_aNames[this.m_iIndex] = string;
                this.m_aTimestamps[this.m_iIndex] = l2;
                ++this.m_iIndex;
            }
        }
        if (this.m_bSendToOsLogger && this.m_oPerformanceTracingService != null) {
            this.m_oPerformanceTracingService.OSLogEvent((int)by, new StringBuffer().append("<Data Value=\"").append(by).append(",").append(n).append(",").append(n2).append(",").append(string != null ? string : new StringBuffer().append("").append(l).toString()).append(",").append(l2).append("\" />").toString());
        }
    }

    @Override
    public boolean isPerfServiceDataSupported() {
        return false;
    }

    @Override
    public PerfServiceData getPerfServiceData(PerfServiceData perfServiceData) {
        return null;
    }

    @Override
    public boolean isPerformanceLogMsgSupported() {
        return true;
    }

    @Override
    public void performanceLogMsg(String string) {
        this.add((byte)0, 0L, 0, 0, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogMsgByID(int n) {
        this.add((byte)1, n, 0, 0, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogDSI(String string, int n) {
        this.add((byte)2, 0L, n, 0, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogDomain(int n, int n2, int n3) {
        this.add((byte)3, n, n2, n3, null, System.currentTimeMillis());
    }

    @Override
    public void bundleStateChanged(int n, Bundle bundle) {
        if (n == 8) {
            this.add((byte)5, bundle.getBundleId(), 3, 0, null, System.currentTimeMillis());
        } else if (n == 32) {
            this.add((byte)5, bundle.getBundleId(), 4, 0, null, System.currentTimeMillis());
        }
    }

    @Override
    public void performanceLogASLTarget(int n, int n2) {
        this.add((byte)4, n, n2, 0, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogContextSwitch(int[] nArray) {
        long l = System.currentTimeMillis();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.add((byte)6, nArray[i2], 0, 0, null, l);
        }
    }

    @Override
    public void performanceLogRvcStateUpdate(boolean bl) {
        this.add((byte)7, bl ? 1L : 0L, 0, 0, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogViewHandler(String string, int n) {
        this.add((byte)8, 0L, n, -1, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogViewHandler(String string, int n, int n2) {
        this.add((byte)8, 0L, n2, n, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogStartup(int n, int n2, int n3) {
        this.add((byte)9, n, n3, n2, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogProfileChange(int n, byte by) {
        this.add((byte)10, 0L, n, by, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogProfileComponentChange(int n, String string, boolean bl) {
        this.add((byte)10, 1L, n, bl ? 1 : 0, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogPersistence(int n, int n2) {
        this.add((byte)11, n, n2, 0, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogDiagnosis(int n, int n2) {
        this.add((byte)12, n, n2, 0, null, System.currentTimeMillis());
    }

    @Override
    public void performanceLogWorkunit(String string, int n) {
        this.add((byte)13, 0L, n, 0, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogEvents(int n, int n2, String string) {
        this.add((byte)14, 0L, n, n2, string, System.currentTimeMillis());
    }

    @Override
    public void performanceLogAppUiLife(int n, String string, String string2, int n2) {
        this.add((byte)15, 0L, n, n2, new StringBuffer().append(string).append("$$").append(string2).toString(), System.currentTimeMillis());
    }

    private Logger getLogger() {
        LoggerFactory loggerFactory = null;
        ServiceReference serviceReference = this.m_oBundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = PerfServiceMIBHMI.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        loggerFactory = serviceReference != null ? (LoggerFactory)this.m_oBundleContext.getService(serviceReference) : MainLogger.getLoggerFactory();
        return loggerFactory == null ? null : loggerFactory.getLogger(4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void writePerformanceDataIntoLog() {
        long l = this.getOffsetForRuntimeTime();
        Logger logger = this.getLogger();
        if (logger != null) {
            PerfServiceMIBHMI perfServiceMIBHMI = this;
            synchronized (perfServiceMIBHMI) {
                this.writeToLogger(logger, "\n\n\t<Dataset>\n");
                for (int i2 = 0; i2 < this.m_iIndex; ++i2) {
                    this.writeToLogger(logger, new StringBuffer().append("\t<Data Value=\"").append(this.m_aTypes[i2]).append(",").append(this.m_aValue2[i2]).append(",").append(this.m_aValue3[i2]).append(",").append(this.m_aNames[i2] != null ? this.m_aNames[i2] : new StringBuffer().append("").append(this.m_aValue1[i2]).toString()).append(",").append(this.m_aTimestamps[i2] - l).append("\" />").toString());
                }
                this.writeToLogger(logger, "\t</Dataset>\n");
                this.m_aTypes = null;
                this.m_aValue1 = null;
                this.m_aValue2 = null;
                this.m_aValue3 = null;
                this.m_aNames = null;
                this.m_aTimestamps = null;
                this.m_iIndex = -1;
            }
        }
    }

    private void writeToLogger(Logger logger, String string) {
        if (this.m_bSendToConsole) {
            logger.info(1).append(string).log();
        } else {
            logger.normal(1).append(string).log();
        }
    }

    private long getOffsetForRuntimeTime() {
        TimerSPI timerSPI = (TimerSPI)this.m_oBundleContext.getService(this.m_oBundleContext.getServiceReference((class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = PerfServiceMIBHMI.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI).getName()));
        long l = System.currentTimeMillis();
        if (timerSPI != null) {
            l -= 0 * timerSPI.getSystemTime() / timerSPI.getSystemTimeFrequency();
        }
        return l;
    }

    private boolean getBooleanFromProperty(String string) {
        boolean bl = Boolean.getBoolean(string);
        if (!bl) {
            Integer n = Integer.getInteger(string);
            bl = n != null && n == 1;
        }
        return bl;
    }

    private void readConfiguration() {
        Integer n = Integer.getInteger("de.vw.mib.perf.service.PerfServiceMIBHMI.timeout");
        this.m_iTimeoutForData = n != null ? Math.max(n, 30) : 120;
        this.m_bSendToConsole = this.getBooleanFromProperty("de.vw.mib.perf.service.PerfServiceMIBHMI");
        if (!this.m_bSendToConsole) {
            this.m_bSendToConsole = this.getBooleanFromProperty("de.vw.mib.perf.service.PerfServiceMIBHMI.console");
        }
        this.m_bSendToOsLogger = Boolean.getBoolean("de.vw.mib.lps.enableKernelLogs");
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


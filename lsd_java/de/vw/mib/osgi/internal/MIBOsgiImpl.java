/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.extstartup.spi.ExtendedStartupSPI;
import de.vw.mib.extstartup.spi.StartupResumeListener;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.log4mib.internal.MainLogger;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.MIBOsgiMonitor;
import de.vw.mib.osgi.SubRegistry;
import de.vw.mib.osgi.internal.BundleInfo;
import de.vw.mib.osgi.internal.BundleRegistry;
import de.vw.mib.osgi.internal.MIBOsgiImpl$1;
import de.vw.mib.osgi.internal.MIBOsgiImpl$2;
import de.vw.mib.osgi.internal.MIBOsgiImpl$BundleStartWatchdog;
import de.vw.mib.osgi.internal.ParallelBundleStartInfo;
import de.vw.mib.osgi.internal.ServiceRegistry;
import java.util.Properties;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public final class MIBOsgiImpl
extends MIBOsgi
implements StartupResumeListener {
    public static final String PARALLEL_BUNDLE_START_THREAD_NAME;
    private static final int GC_LOOPS;
    private static final int WAIT_FOR_GC;
    private static MIBOsgiImpl INSTANCE;
    BundleRegistry bundleRegistry;
    private final MIBOsgiImpl$BundleStartWatchdog bundleStartWatchdog;
    private ExtendedStartupSPI extendedStartupSPI;

    public static MIBOsgi getInstance() {
        return INSTANCE;
    }

    public static MIBOsgi resetInstance() {
        BundleRegistry.resetInstance();
        ServiceRegistry.resetInstance();
        INSTANCE = new MIBOsgiImpl();
        return INSTANCE;
    }

    private MIBOsgiImpl() {
        LoggerFactory loggerFactory = MainLogger.getLoggerFactory();
        if (loggerFactory == null) {
            MainLogger.initLogger();
            loggerFactory = MainLogger.getLoggerFactory();
        }
        MIBOsgi.logger = loggerFactory.getLogger(16384);
        this.registerMIBOsgiMonitor(null);
        this.bundleStartWatchdog = new MIBOsgiImpl$BundleStartWatchdog();
        this.bundleStartWatchdog.setPriority(10);
        this.bundleStartWatchdog.setName("BundleStartWatchdog");
        this.bundleStartWatchdog.start();
    }

    @Override
    public void addSubRegistry(SubRegistry subRegistry) {
        ServiceRegistry.getInstance().addSubRegistry(subRegistry);
    }

    @Override
    public int getBundleState(int n) {
        BundleInfo bundleInfo = this.bundleRegistry.getBundle(n);
        if (bundleInfo == null) {
            return 1;
        }
        return bundleInfo.getState();
    }

    @Override
    public Bundle[] getLateloadBundles() {
        logger.error(2).append("This method is deprecated and will be removed soon!").attachThrowable(new UnsupportedOperationException()).log();
        return this.bundleRegistry.getLateloadBundles();
    }

    @Override
    public Bundle[] getManagedBundles() {
        logger.error(2).append("This method is deprecated and will be removed soon!").attachThrowable(new UnsupportedOperationException()).log();
        return this.bundleRegistry.getManagedBundles();
    }

    @Override
    public Bundle[] getParallelBundles() {
        logger.error(2).append("This method is deprecated and will be removed soon!").attachThrowable(new UnsupportedOperationException()).log();
        return null;
    }

    @Override
    public int getParallelBundleStartId() {
        logger.error(2).append("This method is deprecated and will be removed soon!").attachThrowable(new UnsupportedOperationException()).log();
        return -1;
    }

    @Override
    public void init(ExtendedStartupSPI extendedStartupSPI, Properties properties) {
        this.init(extendedStartupSPI, properties, "TARGET");
    }

    @Override
    public void init(ExtendedStartupSPI extendedStartupSPI, Properties properties, String string) {
        this.init(extendedStartupSPI, properties, string, "");
    }

    @Override
    public void init(ExtendedStartupSPI extendedStartupSPI, Properties properties, String string, String string2) {
        this.extendedStartupSPI = extendedStartupSPI;
        this.bundleRegistry = BundleRegistry.getInstance();
        this.bundleRegistry.initBundleRegistry(properties, string, string2);
    }

    @Override
    public void registerMIBOsgiMonitor(MIBOsgiMonitor mIBOsgiMonitor) {
        this.setMIBOsgiMonitor(mIBOsgiMonitor);
    }

    @Override
    public void resumeHMI() {
        logger.info(2, "resume HMI ...");
        try {
            this.performBundleStarts(this.bundleRegistry.getAutostartBundles(), "Starting autostart bundles ...");
        }
        catch (BundleException bundleException) {
            logger.error(2, "Error while starting autostart bundles!", bundleException.getNestedException());
        }
    }

    @Override
    public void startBundle(int n) {
        BundleInfo bundleInfo = this.bundleRegistry.getBundle(n);
        if (bundleInfo == null) {
            throw new BundleException(new StringBuffer().append("unknown bundle id ").append(n).toString());
        }
        if ((bundleInfo.getState() & 0x28) == 0) {
            this.startBundle(bundleInfo);
        }
    }

    @Override
    public void startBundles() {
        logger.error(2).append("This method is deprecated and will be removed soon!").attachThrowable(new UnsupportedOperationException()).log();
        this.startAutostartBundles();
    }

    @Override
    public void startAutostartBundles() {
        if (this.extendedStartupSPI == null) {
            this.performBundleStarts(this.bundleRegistry.getAutostartBundles(), "Starting autostart bundles ...");
            return;
        }
        if (this.extendedStartupSPI.isSnapshotBoot()) {
            this.extendedStartupSPI.addBootResumeListener(this);
            try {
                this.performBundlePreloads();
                this.prepareSnapshot();
                this.extendedStartupSPI.readyToMakeSnaphot();
            }
            catch (Exception exception) {
                logger.fatal(2, "error while creating boot snapshot!", exception);
                this.extendedStartupSPI.setSnapshotCorrupted();
            }
        } else {
            this.performBundlePreloads();
            this.performBundleStarts(this.bundleRegistry.getAutostartBundles(), "Starting autostart bundles ...");
        }
    }

    @Override
    public void startManagedBundles() {
        this.performBundleStarts(this.bundleRegistry.getManagedBundles(), "Starting managed bundles ...");
    }

    @Override
    public void startLateloadBundles() {
        this.performBundleStarts(this.bundleRegistry.getLateloadBundles(), "Starting lateload bundles ...");
        this.bundleStartWatchdog.stopWatchdog();
    }

    void forkBundlesStart(int n) {
        ParallelBundleStartInfo parallelBundleStartInfo = this.bundleRegistry.getParallelBundleStartInfo(n);
        if (parallelBundleStartInfo == null) {
            return;
        }
        Thread thread = new Thread(new MIBOsgiImpl$1(this, parallelBundleStartInfo, n));
        thread.setName(new StringBuffer().append("PARALLEL_BUNDLE_START_THREAD-").append(n).toString());
        thread.setPriority(parallelBundleStartInfo.threadPrio);
        thread.start();
    }

    @Override
    public void startSPIBundles() {
        this.performBundleStarts(this.bundleRegistry.getSPIBundles(), "Starting SPI bundles ...");
    }

    @Override
    public void stopBundle(int n) {
        BundleInfo bundleInfo = this.bundleRegistry.getBundle(n);
        if (bundleInfo == null) {
            throw new BundleException(new StringBuffer().append("unknown bundle id ").append(n).toString());
        }
        this.stopBundle(bundleInfo);
    }

    @Override
    public void stopBundles() {
    }

    void performBundleStarts(Bundle[] bundleArray, String string) {
        logger.info(2, string);
        for (int i2 = 0; i2 < bundleArray.length; ++i2) {
            this.startBundle(bundleArray[i2]);
        }
    }

    private void performBundlePreloads() {
        BundleInfo[] bundleInfoArray = this.bundleRegistry.getPreloadBundles();
        logger.info(2, "Preloading bundles ...");
        for (int i2 = 0; i2 < bundleInfoArray.length; ++i2) {
            this.preloadBundle(bundleInfoArray[i2]);
        }
    }

    private void preloadBundle(BundleInfo bundleInfo) {
        logger.normal(2).append("Preloading bundle ").append(bundleInfo.getLocation()).append(" ...").log();
        try {
            bundleInfo.preload();
        }
        catch (BundleException bundleException) {
            logger.error(2).append("Unable to preload bundle ").append(bundleInfo.getLocation()).attachThrowable(bundleException.getNestedException()).log();
            throw bundleException;
        }
    }

    private void prepareSnapshot() {
        for (int i2 = 0; i2 < 5; ++i2) {
            System.gc();
            try {
                Thread.sleep(0);
                continue;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    private void setMIBOsgiMonitor(MIBOsgiMonitor mIBOsgiMonitor) {
        MIBOsgi.monitor = mIBOsgiMonitor != null ? mIBOsgiMonitor : new MIBOsgiImpl$2(this);
    }

    private void startBundle(Bundle bundle) {
        if (this.bundleRegistry.isForkMarkerBundle(bundle)) {
            int n = (int)bundle.getBundleId();
            this.forkBundlesStart(n);
            return;
        }
        if (this.bundleRegistry.isJoinMarkerBundle(bundle)) {
            int n = (int)bundle.getBundleId();
            this.joinBundleStart(n);
            return;
        }
        logger.normal(2).append("Starting bundle ").append(bundle.getLocation()).append(" ...").log();
        try {
            this.bundleStartWatchdog.bundleStart(bundle);
            bundle.start();
        }
        catch (BundleException bundleException) {
            logger.error(2).append("Unable to start bundle ").append(bundle.getLocation()).attachThrowable(bundleException.getNestedException()).log();
            throw bundleException;
        }
        finally {
            this.bundleStartWatchdog.bundleStartDone(bundle);
        }
    }

    private void joinBundleStart(int n) {
        ParallelBundleStartInfo parallelBundleStartInfo = this.bundleRegistry.getParallelBundleStartInfo(n);
        if (parallelBundleStartInfo == null) {
            return;
        }
        if (parallelBundleStartInfo.isFinished()) {
            logger.info(2, new StringBuffer().append("Resume because parallel starting bundles (").append(n).append(") already started!").toString());
            return;
        }
        try {
            logger.info(2, new StringBuffer().append("Wait for parallel starting bundles (").append(n).append(") ...").toString());
            parallelBundleStartInfo.await();
            logger.info(2, new StringBuffer().append("Resume after parallel starting bundles (").append(n).append(")!").toString());
        }
        catch (InterruptedException interruptedException) {
            logger.error(2).append("Error while waiting for parallel bundle start join!").attachThrowable(interruptedException).log();
        }
    }

    private void stopBundle(Bundle bundle) {
        logger.normal(2, new StringBuffer().append("Stopping bundle ").append(bundle.getLocation()).toString());
        try {
            bundle.stop();
        }
        catch (BundleException bundleException) {
            logger.error(2).append("Error while stopping bundle ").append(bundle.getBundleId()).attachThrowable(bundleException.getNestedException()).log();
            throw bundleException;
        }
    }

    static {
        INSTANCE = new MIBOsgiImpl();
    }
}


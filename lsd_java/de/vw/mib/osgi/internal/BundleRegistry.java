/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.osgi.internal.BundleInfo;
import de.vw.mib.osgi.internal.ParallelBundleStartInfo;
import java.util.Properties;
import java.util.StringTokenizer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;

final class BundleRegistry {
    private static final int INITIAL_STRINGBUFFER_SIZE;
    private static BundleRegistry INSTANCE;
    private static final String KEY_BUNDLE_ACTIVATOR;
    private static final String KEY_BUNDLE_NAME;
    private static final String KEY_BUNDLE_STARTUP_AUTOSTART;
    private static final String KEY_BUNDLE_STARTUP_LATELOAD;
    private static final String KEY_BUNDLE_STARTUP_MANAGED;
    private static final String KEY_BUNDLE_STARTUP_PARALLEL;
    private static final String KEY_BUNDLE_STARTUP_PRELOAD;
    private static final String KEY_BUNDLE_STARTUP_SPI;
    private static final String KEY_PARALLEL_FORK_MARKER;
    private static final String KEY_PARALLEL_JOIN_MARKER;
    private static final String KEY_PARALLEL_THREAD_PRIO;
    private static final String KEY_SEPARATOR;
    private static final String KEY_WILDCARD;
    private static final int MAX_NUM_BUNDLES;
    private static final int MAX_PARALLEL_BUNDLE_STARTS;
    private BundleInfo[] allBundles;
    private BundleInfo[] autostartBundles;
    private CowArray bundleListeners = new CowArray();
    private Bundle[] lateloadBundles;
    private BundleInfo[] managedBundles;
    private final IntObjectMap parallelBundleStartInfos = new IntObjectOptHashMap();
    private BundleInfo[] preloadBundles;
    private BundleInfo[] spiBundles;

    static BundleRegistry getInstance() {
        return INSTANCE;
    }

    static BundleRegistry resetInstance() {
        INSTANCE = new BundleRegistry();
        return INSTANCE;
    }

    private BundleRegistry() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2048);
        for (int i2 = 0; i2 < this.allBundles.length; ++i2) {
            stringBuffer.append(this.allBundles[i2] != null ? this.allBundles[i2].toString() : "null");
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    private BundleInfo[] createAllBundles(Properties properties) {
        BundleInfo[] bundleInfoArray = new BundleInfo[150];
        for (int i2 = 0; i2 < 150; ++i2) {
            String string = properties.getProperty(new StringBuffer().append("Bundle.Name.").append(i2).toString());
            if (string == null) continue;
            bundleInfoArray[i2] = new BundleInfo(i2, string, this.getActivatorClassName(properties, new StringBuffer().append("Bundle.Activator.").append(i2).toString()));
        }
        return bundleInfoArray;
    }

    private String getActivatorClassName(Properties properties, String string) {
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            throw new BundleException(new StringBuffer().append("There is no activator '").append(string).append("' specified!").toString());
        }
        return string2;
    }

    private BundleInfo[] getBundlesByIdsString(String string) {
        if (string == null) {
            return new BundleInfo[0];
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        BundleInfo[] bundleInfoArray = new BundleInfo[stringTokenizer.countTokens()];
        for (int i2 = 0; i2 < bundleInfoArray.length; ++i2) {
            String string2 = stringTokenizer.nextToken();
            if (string2.startsWith("FORK_")) {
                bundleInfoArray[i2] = this.getForkMarker(string2);
            } else if (string2.startsWith("JOIN_")) {
                bundleInfoArray[i2] = this.getJoinMarker(string2);
            } else {
                int n = Integer.parseInt(string2);
                bundleInfoArray[i2] = this.getBundle(n);
            }
            if (bundleInfoArray[i2] != null) continue;
            throw new BundleException(new StringBuffer().append("unknown bundle id ").append(string2).toString());
        }
        return bundleInfoArray;
    }

    private BundleInfo getForkMarker(String string) {
        int n = Integer.parseInt(string.substring("FORK_".length()));
        ParallelBundleStartInfo parallelBundleStartInfo = (ParallelBundleStartInfo)this.parallelBundleStartInfos.get(n);
        return parallelBundleStartInfo == null ? null : parallelBundleStartInfo.forkMarker;
    }

    private BundleInfo getJoinMarker(String string) {
        int n = Integer.parseInt(string.substring("JOIN_".length()));
        ParallelBundleStartInfo parallelBundleStartInfo = (ParallelBundleStartInfo)this.parallelBundleStartInfos.get(n);
        return parallelBundleStartInfo == null ? null : parallelBundleStartInfo.joinMarker;
    }

    private String getBundlesIdString(Properties properties, String string, String string2, String string3) {
        String string4 = new StringBuffer().append(string).append(".").append(string2).append(".").append(string3).toString();
        if (properties.containsKey(string4)) {
            return properties.getProperty(string4);
        }
        string4 = new StringBuffer().append(string).append(".").append(string2).toString();
        if (properties.containsKey(string4)) {
            return properties.getProperty(string4);
        }
        string4 = new StringBuffer().append(string).append(".").append("*").append(".").append(string3).toString();
        if (properties.containsKey(string4)) {
            return properties.getProperty(string4);
        }
        string4 = string;
        if (properties.containsKey(string4)) {
            return properties.getProperty(string4);
        }
        return null;
    }

    private void readParallelBundles(Properties properties) {
        String string = "Bundle.Startup.Parallel.";
        for (int i2 = 0; i2 < 5; ++i2) {
            String string2 = new StringBuffer().append(string).append(i2).toString();
            if (!properties.containsKey(string2)) continue;
            String string3 = properties.getProperty(string2);
            Bundle[] bundleArray = this.getBundlesByIdsString(string3);
            int n = 5;
            if (properties.contains(string2 = new StringBuffer().append(string2).append(".").append("prio").toString())) {
                n = Integer.parseInt(properties.getProperty(string2));
            }
            ParallelBundleStartInfo parallelBundleStartInfo = new ParallelBundleStartInfo(i2, bundleArray, n);
            this.parallelBundleStartInfos.put(i2, parallelBundleStartInfo);
        }
    }

    void addBundleListener(BundleListener bundleListener) {
        this.bundleListeners.addIfNotAlreadyIn(bundleListener);
    }

    void removeBundleListener(BundleListener bundleListener) {
        this.bundleListeners.remove(bundleListener);
    }

    void notifyBundleListeners(BundleEvent bundleEvent) {
        Object[] objectArray = this.bundleListeners.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            BundleListener bundleListener = (BundleListener)objectArray[i2];
            bundleListener.bundleChanged(bundleEvent);
        }
    }

    Bundle[] getAutostartBundles() {
        return this.autostartBundles;
    }

    BundleInfo getBundle(int n) {
        if (n < 150) {
            return this.allBundles[n];
        }
        return null;
    }

    Bundle[] getBundles() {
        return this.allBundles;
    }

    Bundle[] getLateloadBundles() {
        return this.lateloadBundles;
    }

    Bundle[] getManagedBundles() {
        return this.managedBundles;
    }

    Bundle[] getParallelBundles(int n) {
        if (!this.parallelBundleStartInfos.containsKey(n)) {
            return new Bundle[0];
        }
        ParallelBundleStartInfo parallelBundleStartInfo = (ParallelBundleStartInfo)this.parallelBundleStartInfos.get(n);
        return parallelBundleStartInfo.bundles;
    }

    ParallelBundleStartInfo getParallelBundleStartInfo(int n) {
        return (ParallelBundleStartInfo)this.parallelBundleStartInfos.get(n);
    }

    BundleInfo[] getPreloadBundles() {
        return this.preloadBundles;
    }

    BundleInfo[] getSPIBundles() {
        return this.spiBundles;
    }

    void initBundleRegistry(Properties properties, String string, String string2) {
        this.allBundles = this.createAllBundles(properties);
        this.spiBundles = this.getBundlesByIdsString(this.getBundlesIdString(properties, "Bundle.Startup.SPIPreload", string, string2));
        this.preloadBundles = this.getBundlesByIdsString(this.getBundlesIdString(properties, "Bundle.Startup.Preload", string, string2));
        this.readParallelBundles(properties);
        this.autostartBundles = this.getBundlesByIdsString(this.getBundlesIdString(properties, "Bundle.Startup.Autostart", string, string2));
        this.managedBundles = this.getBundlesByIdsString(this.getBundlesIdString(properties, "Bundle.Startup.Managed", string, string2));
        this.lateloadBundles = this.getBundlesByIdsString(this.getBundlesIdString(properties, "Bundle.Startup.Lateload", string, string2));
    }

    boolean isForkMarkerBundle(Bundle bundle) {
        int n = (int)bundle.getBundleId();
        ParallelBundleStartInfo parallelBundleStartInfo = (ParallelBundleStartInfo)this.parallelBundleStartInfos.get(n);
        return parallelBundleStartInfo != null && parallelBundleStartInfo.forkMarker == bundle;
    }

    boolean isJoinMarkerBundle(Bundle bundle) {
        int n = (int)bundle.getBundleId();
        ParallelBundleStartInfo parallelBundleStartInfo = (ParallelBundleStartInfo)this.parallelBundleStartInfos.get(n);
        return parallelBundleStartInfo != null && parallelBundleStartInfo.joinMarker == bundle;
    }

    static {
        INSTANCE = new BundleRegistry();
    }
}


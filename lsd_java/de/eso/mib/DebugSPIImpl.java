/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.microdoc.j9.Tools;
import de.eso.mib.PerformanceIndicator;
import de.eso.mib.SPI;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.miniser.BEMiniIntDeserializer;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;
import de.vw.mib.debug.spi.DebugListener;
import de.vw.mib.debug.spi.DebugSPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.zip.CRC32;

public class DebugSPIImpl
implements DebugSPI,
ITraceCallback {
    public TraceChannel tcp_channel = new TraceChannel("vw.tcp");
    public TraceChannel file_channel = new TraceChannel("vw.file");
    public TraceChannel serial_channel = new TraceChannel("vw.serial");
    private TraceChannel[] chns = new TraceChannel[]{this.tcp_channel, this.file_channel, this.serial_channel};
    private TraceClient client;
    private ArrayList listeners;
    private int cb_id;
    private int num_channels = this.chns.length;
    private boolean[] enable = new boolean[this.num_channels];
    private boolean debugMLP = false;
    private TreeMap performanceIndicators;
    private File sysLoadDataFile = null;
    private Object performanceSync = new Object();
    private static final String ch;
    private static final String SYSLOAD_DATA_NAME;

    public void init() {
        this.listeners = new ArrayList();
        String string = System.getProperty("de.eso.mib.debug.mlpPath");
        if (string == null) {
            string = "/dev/eso/mlplog";
        }
        if (System.getProperty("de.eso.mib.debug.mlpDebug") != null) {
            this.debugMLP = true;
        }
        this.initNative(string);
        this.performanceIndicators = new TreeMap();
        this.initPerformanceIndicators();
        this.sysLoadDataFile = this.getSysLoadDataFile();
    }

    public void exit() {
        this.performanceIndicators = null;
        this.exitNative();
        TraceClient.exit();
        this.listeners = null;
    }

    private native void initNative(String string) {
    }

    private native void exitNative() {
    }

    @Override
    public void writeLogEntry(short s, byte[] byArray, int n) {
        if (this.client != null) {
            byte[] byArray2 = new byte[n];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n);
            for (int i2 = 0; i2 < this.num_channels; ++i2) {
                if (!this.enable[i2]) continue;
                this.client.logMessage(this.chns[i2], (short)2, (short)0, (short)22103, byArray2);
            }
        }
    }

    @Override
    public void writeLogEntry(short s, byte[] byArray) {
        if (this.client != null) {
            for (int i2 = 0; i2 < this.num_channels; ++i2) {
                if (!this.enable[i2]) continue;
                this.client.logMessage(this.chns[i2], (short)2, (short)0, (short)22103, byArray);
            }
        }
    }

    @Override
    public native void writeBinaryMessages(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
    }

    @Override
    public native void writeTextLogMessages(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
    }

    private void initPerformanceIndicators() {
        this.performanceIndicators.put("CPU1", new PerformanceIndicator(1, 1L, false));
        this.performanceIndicators.put("CPU2", new PerformanceIndicator(1, 1L, false));
        this.performanceIndicators.put("CPU3", new PerformanceIndicator(1, 1L, false));
        this.performanceIndicators.put("CPU4", new PerformanceIndicator(1, 1L, false));
        this.performanceIndicators.put("MEM", new PerformanceIndicator(2, 1L, false));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getPerformanceIndicatorCount() {
        Object object = this.performanceSync;
        synchronized (object) {
            int n = 0;
            Iterator iterator = this.performanceIndicators.values().iterator();
            while (iterator.hasNext()) {
                PerformanceIndicator performanceIndicator = (PerformanceIndicator)iterator.next();
                if (!performanceIndicator.getEnabled()) continue;
                ++n;
            }
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getPerformanceIndicatorDescription(String[] stringArray, int[] nArray, long[] lArray) {
        Object object = this.performanceSync;
        synchronized (object) {
            int n = 0;
            Iterator iterator = this.performanceIndicators.entrySet().iterator();
            while (iterator.hasNext() && n < stringArray.length) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                PerformanceIndicator performanceIndicator = (PerformanceIndicator)map$Entry.getValue();
                if (!performanceIndicator.getEnabled()) continue;
                stringArray[n] = (String)map$Entry.getKey();
                nArray[n] = performanceIndicator.getType();
                lArray[n] = performanceIndicator.getDenominator();
                ++n;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getPerformanceIndicatorValues(long[] lArray) {
        Object object = this.performanceSync;
        synchronized (object) {
            this.updatePerformanceIndicatorValues();
            int n = 0;
            Iterator iterator = this.performanceIndicators.values().iterator();
            while (iterator.hasNext() && n < lArray.length) {
                PerformanceIndicator performanceIndicator = (PerformanceIndicator)iterator.next();
                if (!performanceIndicator.getEnabled()) continue;
                lArray[n] = performanceIndicator.getValue();
                ++n;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updatePerformanceIndicatorValues() {
        long l = -1L;
        int[] nArray = null;
        if (this.sysLoadDataFile != null) {
            FileInputStream fileInputStream = null;
            try {
                String string;
                int n;
                byte[] byArray = new byte[128];
                fileInputStream = new FileInputStream(this.sysLoadDataFile);
                int n2 = fileInputStream.read(byArray);
                if (n2 >= 5 && (n = (string = new String(byArray, 0, n2, "ASCII")).indexOf("|")) > 0) {
                    l = Integer.parseInt(string.substring(n + 1).trim());
                    String string2 = string.substring(0, n).trim();
                    if (string2.indexOf("CPU") >= 0) {
                        StringTokenizer stringTokenizer = new StringTokenizer(string2, " ");
                        nArray = new int[stringTokenizer.countTokens()];
                        for (int i2 = 0; i2 < nArray.length; ++i2) {
                            nArray[i2] = -1;
                            try {
                                int n3;
                                String string3 = stringTokenizer.nextToken();
                                if (string3 == null || (n3 = string3.indexOf(58)) <= 0) continue;
                                nArray[i2] = Integer.parseInt(string3.substring(n3 + 1));
                                continue;
                            }
                            catch (NumberFormatException numberFormatException) {
                                nArray[i2] = -1;
                            }
                        }
                    }
                }
            }
            catch (IOException iOException) {
                nArray = null;
                l = -1L;
            }
            catch (NumberFormatException numberFormatException) {
                nArray = null;
                l = -1L;
            }
            finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        }
        this.updatePerformanceIndicatorValue("MEM", l);
        if (nArray != null) {
            this.updatePerformanceIndicatorValue("CPU1", (long)nArray[0]);
            this.updatePerformanceIndicatorValue("CPU2", (long)nArray[1]);
            this.updatePerformanceIndicatorValue("CPU3", (long)nArray[2]);
            this.updatePerformanceIndicatorValue("CPU4", (long)nArray[3]);
        } else {
            this.updatePerformanceIndicatorValue("CPU1", -1L);
            this.updatePerformanceIndicatorValue("CPU2", -1L);
            this.updatePerformanceIndicatorValue("CPU3", -1L);
            this.updatePerformanceIndicatorValue("CPU4", -1L);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void performanceIndicatorChange(int n) {
        Object[] objectArray = this.performanceSync;
        synchronized (this.performanceSync) {
            this.disablePerformanceIndicator("MEM");
            this.disablePerformanceIndicator("CPU1");
            this.disablePerformanceIndicator("CPU2");
            this.disablePerformanceIndicator("CPU3");
            this.disablePerformanceIndicator("CPU4");
            switch (n) {
                default: {
                    break;
                }
                case 1: {
                    this.enablePerformanceIndicator("MEM");
                    break;
                }
                case 2: {
                    this.enablePerformanceIndicator("CPU1");
                    this.enablePerformanceIndicator("CPU2");
                    this.enablePerformanceIndicator("CPU3");
                    this.enablePerformanceIndicator("CPU4");
                    break;
                }
                case 3: {
                    this.enablePerformanceIndicator("MEM");
                    this.enablePerformanceIndicator("CPU1");
                    this.enablePerformanceIndicator("CPU2");
                    this.enablePerformanceIndicator("CPU3");
                    this.enablePerformanceIndicator("CPU4");
                }
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            objectArray = new DebugListener[this.listeners.size()];
            ArrayList arrayList = this.listeners;
            synchronized (arrayList) {
                this.listeners.toArray(objectArray);
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray[i2].performanceIndicatorsChange();
            }
            return;
        }
    }

    private void updatePerformanceIndicatorValue(String string, long l) {
        PerformanceIndicator performanceIndicator = (PerformanceIndicator)this.performanceIndicators.get(string);
        if (performanceIndicator != null) {
            performanceIndicator.setValue(l);
        }
    }

    private void enablePerformanceIndicator(String string) {
        PerformanceIndicator performanceIndicator = (PerformanceIndicator)this.performanceIndicators.get(string);
        if (performanceIndicator != null) {
            performanceIndicator.setEnabled(true);
        }
    }

    private void disablePerformanceIndicator(String string) {
        PerformanceIndicator performanceIndicator = (PerformanceIndicator)this.performanceIndicators.get(string);
        if (performanceIndicator != null) {
            performanceIndicator.setEnabled(false);
        }
    }

    private File getSysLoadDataFile() {
        File file = new File("/dev/cpumeter/mmx_cpu");
        if (file.exists() && file.canRead()) {
            return file;
        }
        return null;
    }

    private int mapLogSinkToIndex(int n) {
        switch (n) {
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 1: {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public void activateLogSink(int n) {
        this.enable[this.mapLogSinkToIndex((int)n)] = true;
    }

    @Override
    public void deactivateLogSink(int n) {
        this.enable[this.mapLogSinkToIndex((int)n)] = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addDebugListener(DebugListener debugListener) {
        boolean bl = false;
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            bl = this.listeners.isEmpty();
            this.listeners.add(debugListener);
        }
        if (bl && this.client != null) {
            this.cb_id = this.client.registerCallback("vw_callback", this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeDebugListener(DebugListener debugListener) {
        boolean bl = false;
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.remove(debugListener);
            bl = this.listeners.isEmpty();
        }
        if (bl && this.client != null) {
            this.client.unregisterCallback(this.cb_id);
        }
    }

    @Override
    public void OSLogEvent(int n, byte[] byArray, int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2);
        byteBuffer.put(byArray, 0, n2);
        byteBuffer.rewind();
        SPI.os_log_event_buf(n, byteBuffer, n2);
    }

    @Override
    public void OSLogEvent(int n, String string) {
        SPI.os_log_event_str(n, string);
    }

    @Override
    public void OSLogEvent(int n, byte[] byArray) {
        this.OSLogEvent(n, byArray, byArray.length);
    }

    @Override
    public void J9MAUserEvent(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        if (n == this.cb_id) {
            Object[] objectArray = new DebugListener[this.listeners.size()];
            ArrayList arrayList = this.listeners;
            synchronized (arrayList) {
                this.listeners.toArray(objectArray);
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray[i2].updateLogConfig(byArray);
            }
        }
    }

    private void reportMLPError(String string) {
        System.out.println(new StringBuffer().append("DebugSPI: invalid MLP packet received: ").append(string).toString());
    }

    private void decodeIncomingMLP(byte[] byArray) {
        BEMiniIntDeserializer bEMiniIntDeserializer = new BEMiniIntDeserializer();
        int n = byArray.length;
        if (n < 21) {
            this.reportMLPError(new StringBuffer().append("too short: ").append(n).toString());
            return;
        }
        if (byArray[0] != 77 || byArray[1] != 76 || byArray[2] != 80) {
            this.reportMLPError("signature");
            return;
        }
        int n2 = bEMiniIntDeserializer.retrieveInt(byArray, 3);
        CRC32 cRC32 = new CRC32();
        cRC32.update(byArray, 7, n - 7);
        int n3 = (int)cRC32.getValue();
        if (n2 != n3) {
            this.reportMLPError("crc mismatch");
            return;
        }
        long l = bEMiniIntDeserializer.retrieveLong(byArray, 7);
        byte by = byArray[15];
        int n4 = bEMiniIntDeserializer.retrieveInt(byArray, 17);
        if (n4 + 21 != n) {
            this.reportMLPError(new StringBuffer().append("size mismatch: dataSize=").append(n4).append(" payloadSize=").append(n).toString());
            return;
        }
        if (this.debugMLP) {
            System.out.println(new StringBuffer().append("DebugSPI: incoming MLP OK! ts=").append(l).append(" format=").append(by).append(" len=").append(byArray.length).toString());
        }
        if (by == 1) {
            this.dispatchVWBinaryMessage(l, byArray, 21, n4);
        } else if (by == 5) {
            this.dispatchConfigMessage(l, byArray, 21, n4);
        } else {
            this.reportMLPError(new StringBuffer().append("unsupported protocol format: ").append(by).toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dispatchVWBinaryMessage(long l, byte[] byArray, int n, int n2) {
        Object[] objectArray;
        byte[] byArray2 = new byte[n2];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        if (this.debugMLP) {
            System.out.println(new StringBuffer().append("MLP vw binary message: size=").append(byArray2.length).append(" ts=").append(l).toString());
            objectArray = StringUtils.toHexTextLines(byArray2, 16);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                System.out.println((String)objectArray[i2]);
            }
        }
        if (this.listeners.isEmpty()) {
            this.reportMLPError("no listener for vw bin msg");
            return;
        }
        objectArray = new DebugListener[this.listeners.size()];
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.toArray(objectArray);
        }
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            objectArray[i3].readBinaryMessage(l, byArray2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dispatchConfigMessage(long l, byte[] byArray, int n, int n2) {
        int n3;
        if (this.debugMLP) {
            System.out.println(new StringBuffer().append("MLP config message: size=").append(n2).append(" ts").append(l).toString());
        }
        if (n2 < 8) {
            this.reportMLPError(new StringBuffer().append("config message too short: size=").append(n2).toString());
            return;
        }
        BEMiniIntDeserializer bEMiniIntDeserializer = new BEMiniIntDeserializer();
        int n4 = n;
        short s = bEMiniIntDeserializer.retrieveShort(byArray, n4);
        n4 += 2;
        int n5 = bEMiniIntDeserializer.retrieveShort(byArray);
        n4 += 2;
        int n6 = n5 * 4 + 4;
        if (n6 != n2) {
            this.reportMLPError(new StringBuffer().append("config message size mismatch: got=").append(n2).append(" want=").append(n6).toString());
            return;
        }
        if (n5 == 0) {
            this.reportMLPError("config message is empty?");
            return;
        }
        int[] nArray = new int[n5];
        int[] nArray2 = new int[n5];
        for (n3 = 0; n3 < n5; ++n3) {
            short s2 = bEMiniIntDeserializer.retrieveShort(byArray, n4);
            int n7 = byArray[n4 += 2];
            n4 += 2;
            nArray[n3] = s2;
            nArray2[n3] = n7;
        }
        if (this.debugMLP) {
            System.out.println(new StringBuffer().append("MLP config message: ts=").append(l).append(" domain=").append(s).append(" num=").append(n5).toString());
            for (n3 = 0; n3 < n5; ++n3) {
                System.out.println(new StringBuffer().append("MLP cfg: channel=").append(nArray[n3]).append(" -> level=").append(nArray2[n3]).toString());
            }
        }
        if (this.listeners.isEmpty()) {
            this.reportMLPError("no listener for config msg");
            return;
        }
        Object[] objectArray = new DebugListener[this.listeners.size()];
        ArrayList arrayList = this.listeners;
        synchronized (arrayList) {
            this.listeners.toArray(objectArray);
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            objectArray[i2].logLevelChange(s, nArray, nArray2);
        }
    }

    @Override
    public void dumpAllThreadStacks() {
        Tools.dumpThreadsInfo();
    }

    static {
        System.loadLibrary("debugspi");
    }
}


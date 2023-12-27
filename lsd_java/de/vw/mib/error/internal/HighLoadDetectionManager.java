/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.error.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

final class HighLoadDetectionManager
implements Runnable {
    private static HighLoadDetectionManager s_oHLDManager = null;
    private static Logger s_oLogger = ServiceManager.loggerFactory.getLogger(32);
    private boolean m_bEnabled = false;
    private int m_iPort;
    private int m_iRepeatCount;
    private int m_iWaitTime;
    private int m_iPriority;
    private int m_iSuspendPriority;
    private int m_iStartupWaittime;
    private String m_sHighLoadString;
    private Thread[] threads = new Thread[256];
    private int[] threadPrios = new int[256];
    private int threadCount = 0;

    static void create() {
        if (s_oHLDManager == null) {
            s_oHLDManager = new HighLoadDetectionManager();
        }
    }

    private HighLoadDetectionManager() {
        this.readConfiguration();
        if (this.m_bEnabled) {
            Thread thread = new Thread(this);
            thread.setPriority(this.m_iPriority);
            thread.setName("HighLoadListenerThread");
            thread.start();
        }
    }

    private void readConfiguration() {
        String string = System.getProperty("de.vw.mib.HighLoadDetectionManager", "");
        this.m_bEnabled = false;
        this.m_iPort = 1000;
        this.m_iRepeatCount = 5;
        this.m_iWaitTime = 5000;
        this.m_iPriority = 10;
        this.m_iSuspendPriority = 1;
        this.m_iStartupWaittime = 2000;
        this.m_sHighLoadString = "highload";
        if (string.length() > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
            for (int i2 = 0; stringTokenizer.hasMoreTokens() && i2 < 8; ++i2) {
                try {
                    if (i2 == 0) {
                        this.m_bEnabled = Integer.parseInt(stringTokenizer.nextToken()) == 1;
                        continue;
                    }
                    if (i2 == 1) {
                        this.m_iPort = Integer.parseInt(stringTokenizer.nextToken());
                        continue;
                    }
                    if (i2 == 2) {
                        this.m_iRepeatCount = Integer.parseInt(stringTokenizer.nextToken());
                        continue;
                    }
                    if (i2 == 3) {
                        this.m_iWaitTime = Integer.parseInt(stringTokenizer.nextToken());
                        continue;
                    }
                    if (i2 == 4) {
                        this.m_iPriority = Integer.parseInt(stringTokenizer.nextToken());
                        continue;
                    }
                    if (i2 == 5) {
                        this.m_iSuspendPriority = Integer.parseInt(stringTokenizer.nextToken());
                        continue;
                    }
                    if (i2 == 6) {
                        this.m_iStartupWaittime = Integer.parseInt(stringTokenizer.nextToken());
                        continue;
                    }
                    if (i2 != 7) continue;
                    this.m_sHighLoadString = stringTokenizer.nextToken();
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            try {
                Thread.sleep(this.m_iStartupWaittime);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            DatagramSocket datagramSocket = new DatagramSocket(this.m_iPort);
            byte[] byArray = new byte[128];
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
                datagramSocket.receive(datagramPacket);
                String string = new String(datagramPacket.getData());
                if (!string.startsWith(this.m_sHighLoadString)) continue;
                this.highLoadDetected(string);
            }
        }
        catch (Exception exception) {
            s_oLogger.error(128, "Error while receiving udp datagram for high load detection", exception);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void highLoadDetected(String string) {
        s_oLogger.fatal(128).append("Highload detection begin").log();
        s_oLogger.fatal(128).append("Highload detected on thread: ").append(string).log();
        try {
            for (int i2 = 0; i2 < this.m_iRepeatCount; ++i2) {
                this.setAllThreadsPriority(this.m_iSuspendPriority);
                try {
                    Thread.sleep(0);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                this.dump();
                try {
                    Thread.sleep(0);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
                this.recoverAllThreadsPriority();
                try {
                    Thread.sleep(this.m_iWaitTime);
                    continue;
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
            }
        }
        catch (Throwable throwable) {
        }
        finally {
            this.recoverAllThreadsPriority();
        }
        s_oLogger.fatal(128).append("Highload detection end").log();
    }

    private void setAllThreadsPriority(int n) {
        this.threadCount = Thread.enumerate(this.threads);
        for (int i2 = 0; i2 < this.threadCount; ++i2) {
            if (this.threads[i2] == Thread.currentThread()) continue;
            this.threadPrios[i2] = this.threads[i2].getPriority();
            this.threads[i2].setPriority(n);
        }
    }

    private void recoverAllThreadsPriority() {
        for (int i2 = 0; i2 < this.threadCount; ++i2) {
            if (this.threads[i2] == Thread.currentThread() || this.threads[i2] == null || !this.threads[i2].isAlive()) continue;
            this.threads[i2].setPriority(this.threadPrios[i2]);
        }
    }

    private void dump() {
        s_oLogger.info(128, "thread dump triggered");
        if (ServiceManager.debugSpi == null) {
            s_oLogger.warn(128, "Couldn't create thread dump! No method available!");
        } else {
            ServiceManager.debugSpi.dumpAllThreadStacks();
        }
    }
}


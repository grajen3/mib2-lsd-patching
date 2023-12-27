/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.debug.connection.spi.DebugSPI_Connection;
import de.vw.mib.debug.connection.spi.DebugSPI_ConnectionEventHandler;
import de.vw.mib.debug.spi.DebugListener;
import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debug.spi.internal.sinks.DebugSPI_Sink;
import de.vw.mib.debug.spi.internal.sinks.DebugSPI_TcpSink;
import java.io.IOException;
import java.lang.reflect.Method;

public class DebugSPI_Service
implements DebugSPI_ConnectionEventHandler,
DebugSPI {
    private static final String CLASSNAME = System.getProperty("ThreadManager.threadDumpClass", "com.microdoc.j9.Tools");
    private static final String METHODNAME = System.getProperty("ThreadManager.threadDumpMethod", "dumpThreadsInfo");
    public static final int MESSAGE_CACHE_SIZE;
    private final CowArray debugListeners = new CowArray();
    private DebugSPI_Sink tcpSink;
    private final Method threadDumpMethod;
    boolean[] registeredSinks = new boolean[]{false, false, false};

    public DebugSPI_Service() {
        this.threadDumpMethod = this.findThreadDumpMethod();
        this.tcpSink = new DebugSPI_TcpSink(this);
    }

    @Override
    public void activateLogSink(int n) {
    }

    @Override
    public void deactivateLogSink(int n) {
    }

    @Override
    public void addDebugListener(DebugListener debugListener) {
        for (int i2 = 0; i2 < this.registeredSinks.length; ++i2) {
            debugListener.logSinkStateChange(i2 + 1, this.registeredSinks[i2]);
        }
        this.debugListeners.addIfNotAlreadyIn(debugListener);
    }

    @Override
    public void dumpAllThreadStacks() {
        if (this.threadDumpMethod == null) {
            System.err.println("[DebugSPI] - Couldn't create thread dump! No method available!");
            return;
        }
        try {
            this.threadDumpMethod.invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            System.err.println("[DebugSPI] - Couldn't create thread dump!");
            exception.printStackTrace();
        }
    }

    public void handleConnectionLoss(DebugSPI_Connection debugSPI_Connection) {
    }

    @Override
    public void handleException(Throwable throwable) {
    }

    @Override
    public void J9MAUserEvent(int n) {
    }

    @Override
    public void OSLogEvent(int n, byte[] byArray) {
    }

    @Override
    public void OSLogEvent(int n, byte[] byArray, int n2) {
    }

    @Override
    public void OSLogEvent(int n, String string) {
    }

    @Override
    public void removeDebugListener(DebugListener debugListener) {
        this.debugListeners.remove(debugListener);
    }

    @Override
    public void writeLogEntry(short s, byte[] byArray) {
        this.writeLogEntry(s, byArray, byArray.length);
    }

    @Override
    public void writeLogEntry(short s, byte[] byArray, int n) {
        if (this.tcpSink != null) {
            try {
                this.tcpSink.write(4, s, byArray, n);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private Method findThreadDumpMethod() {
        Class clazz = null;
        try {
            clazz = Class.forName(CLASSNAME);
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.err.println("[DebugSPI] - Couldn't find J9 class for creating thread dumps!");
            return null;
        }
        Method method = null;
        try {
            method = clazz.getMethod(METHODNAME, new Class[0]);
        }
        catch (Exception exception) {
            System.err.println("[DebugSPI] - Couldn't find J9 method for creating thread dumps");
            exception.printStackTrace();
        }
        return method;
    }

    @Override
    public void consume(byte[] byArray) {
        Object[] objectArray = this.debugListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugListener)objectArray[i2]).updateLogConfig(byArray);
        }
    }

    @Override
    public void consume(long l, byte[] byArray) {
        Object[] objectArray = this.debugListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugListener)objectArray[i2]).readBinaryMessage(l, byArray);
        }
    }

    @Override
    public void writeBinaryMessages(long[] lArray, byte[][] byArray, int[] nArray, int[] nArray2, int n, int n2) {
        if (this.tcpSink != null) {
            try {
                this.tcpSink.writeBinaryLogMessages(lArray, byArray, nArray, nArray2, n, n2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public void writeTextLogMessages(long[] lArray, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4, byte[][] byArray, int[] nArray5, int n, int n2) {
        if (this.tcpSink != null) {
            try {
                this.tcpSink.writeTextLogMessages(lArray, nArray, nArray2, nArray3, nArray4, byArray, nArray5, n, n2);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public int getPerformanceIndicatorCount() {
        return 0;
    }

    @Override
    public void getPerformanceIndicatorDescription(String[] stringArray, int[] nArray, long[] lArray) {
    }

    @Override
    public void getPerformanceIndicatorValues(long[] lArray) {
    }

    @Override
    public void logSinkStateChanged(int n, boolean bl) {
        this.registeredSinks[n - 1] = bl;
        Object[] objectArray = this.debugListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((DebugListener)objectArray[i2]).logSinkStateChange(n, bl);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

import com.microdoc.j9.ThreadInfo;
import com.microdoc.j9.Tools$1;
import com.microdoc.j9.Tools$1$DDInfo;
import com.microdoc.j9.Tools$2;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Hashtable;

public class Tools {
    public static void init() {
        long l;
        int n = Integer.getInteger("dumpPriority", 5);
        Integer n2 = Integer.getInteger("dumpThreadOnPort");
        if (n2 != null) {
            new Tools$1(n, n2).start();
        }
        if (0L != (l = Tools.getIntervalSetting("dumpThreads"))) {
            long l2 = Tools.getIntervalSetting("dumpThreadDelay");
            new Tools$2(l, l2, n).start();
        }
    }

    private static void runThreadDumpLoop(long l, long l2, int n) {
        int n2 = 0;
        try {
            Thread.sleep(l2);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        while (true) {
            ThreadInfo[] threadInfoArray = Tools.getThreadsInfo();
            Tools.outputInfo(threadInfoArray, System.out);
            if (n > 0 && ++n2 >= n) {
                Tools.searchForDeadlocks(threadInfoArray, System.out);
                n2 = 0;
            }
            try {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedException) {
            }
        }
    }

    private static void searchForDeadlocks(ThreadInfo[] threadInfoArray, PrintStream printStream) {
        try {
            Tools$1$DDInfo tools$1$DDInfo;
            ThreadInfo threadInfo;
            if (threadInfoArray == null) {
                return;
            }
            Hashtable hashtable = new Hashtable(threadInfoArray.length * 2);
            int n = 0;
            while (n < threadInfoArray.length) {
                ThreadInfo threadInfo2 = threadInfoArray[n];
                hashtable.put(threadInfo2.getThread(), new Tools$1$DDInfo(threadInfo2));
                ++n;
            }
            n = 0;
            int n2 = 0;
            while (n2 < threadInfoArray.length) {
                threadInfo = threadInfoArray[n2];
                tools$1$DDInfo = (Tools$1$DDInfo)hashtable.get(threadInfo.getThread());
                if (tools$1$DDInfo.fVisited < 0) {
                    tools$1$DDInfo.fVisited = n2;
                    if (tools$1$DDInfo.isBlocked()) {
                        Tools$1$DDInfo tools$1$DDInfo2;
                        Thread thread = tools$1$DDInfo.fThreadInfo.getMonitorOwner();
                        while (thread != null) {
                            tools$1$DDInfo2 = (Tools$1$DDInfo)hashtable.get(thread);
                            if (tools$1$DDInfo2 == null) {
                                if (thread == Thread.currentThread()) break;
                                System.out.println("JVM WARNING: monitor owner thread not listed");
                                System.out.println(new StringBuffer("             ").append(thread).toString());
                                break;
                            }
                            if (tools$1$DDInfo2.fDeadlocked || tools$1$DDInfo2.fVisited == n2) {
                                tools$1$DDInfo.fDeadlocked = true;
                                break;
                            }
                            if (!tools$1$DDInfo2.isBlocked()) {
                                tools$1$DDInfo2.fVisited = n2;
                                break;
                            }
                            if (tools$1$DDInfo2.fVisited >= 0 && tools$1$DDInfo2.fVisited < n2) break;
                            tools$1$DDInfo2.fVisited = n2;
                            thread = tools$1$DDInfo2.fThreadInfo.getMonitorOwner();
                        }
                        if (tools$1$DDInfo.fDeadlocked) {
                            ++n;
                            tools$1$DDInfo2 = (Tools$1$DDInfo)hashtable.get(tools$1$DDInfo.fThreadInfo.getMonitorOwner());
                            while (!tools$1$DDInfo2.fDeadlocked) {
                                tools$1$DDInfo2.fDeadlocked = true;
                                ++n;
                                tools$1$DDInfo2 = (Tools$1$DDInfo)hashtable.get(tools$1$DDInfo2.fThreadInfo.getMonitorOwner());
                            }
                        }
                    }
                }
                ++n2;
            }
            if (n > 0) {
                System.out.println(new StringBuffer("Found ").append(n).append(" deadlocked threads!!!").toString());
                n2 = 0;
                while (n2 < threadInfoArray.length) {
                    threadInfo = threadInfoArray[n2];
                    tools$1$DDInfo = (Tools$1$DDInfo)hashtable.get(threadInfo.getThread());
                    if (tools$1$DDInfo.fDeadlocked) {
                        System.out.println(threadInfo.toString());
                    }
                    ++n2;
                }
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static long getIntervalSetting(String string) {
        Integer n = Integer.getInteger(string);
        if (n != null) {
            return n.longValue() * 0;
        }
        Long l = Long.getLong(new StringBuffer(String.valueOf(string)).append("Ms").toString());
        if (l != null) {
            return l;
        }
        return 0L;
    }

    private static void runServerSocket(int n) {
        try {
            ServerSocket serverSocket = new ServerSocket(n);
            while (true) {
                Socket socket = serverSocket.accept();
                Tools.dumpThreadsInfo();
                socket.close();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }

    private static void outputInfo(ThreadInfo[] threadInfoArray, PrintStream printStream) {
        try {
            if (threadInfoArray == null) {
                System.out.println("No thread information received");
                return;
            }
            printStream.println(new StringBuffer("Thread informations for ").append(threadInfoArray.length).append(" threads (").append(new Date()).append(")").toString());
            int n = 0;
            while (n < threadInfoArray.length) {
                if (threadInfoArray[n] != null) {
                    printStream.println(threadInfoArray[n].toString());
                }
                ++n;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static native ThreadInfo[] getThreadsInfo() {
    }

    public static void dumpThreadsInfo(boolean bl, boolean bl2) {
        ThreadInfo[] threadInfoArray = Tools.getThreadsInfo();
        if (bl) {
            Tools.outputInfo(threadInfoArray, System.out);
        }
        if (bl2) {
            Tools.searchForDeadlocks(threadInfoArray, System.out);
        }
    }

    public static void dumpThreadsInfo() {
        Tools.dumpThreadsInfo(true, true);
    }

    static /* synthetic */ void access$0(int n) {
        Tools.runServerSocket(n);
    }

    static /* synthetic */ void access$1(long l, long l2, int n) {
        Tools.runThreadDumpLoop(l, l2, n);
    }
}


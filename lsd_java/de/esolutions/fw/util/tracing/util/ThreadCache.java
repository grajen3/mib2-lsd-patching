/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.util.IThreadEntityCreator;
import de.esolutions.fw.util.tracing.util.ThreadCache$Info;
import java.util.WeakHashMap;

public class ThreadCache {
    private WeakHashMap mapThreadToInfo = new WeakHashMap();
    private Thread lastThread;
    private ThreadCache$Info lastInfo;
    private IThreadEntityCreator creator;

    public ThreadCache(IThreadEntityCreator iThreadEntityCreator) {
        this.creator = iThreadEntityCreator;
    }

    public synchronized ThreadCache$Info getThreadInfo(Thread thread) {
        ThreadCache$Info threadCache$Info;
        String string = thread.getName();
        if (string == null || string.length() == 0) {
            string = "noname";
        }
        if ((threadCache$Info = this.lastThread == thread ? this.lastInfo : (ThreadCache$Info)this.mapThreadToInfo.get(thread)) == null) {
            String[] stringArray = this.splitThreadName(string);
            threadCache$Info = this.createInfo(stringArray[0]);
            this.mapThreadToInfo.put(thread, threadCache$Info);
            threadCache$Info.msgPrefix = stringArray[1];
            threadCache$Info.threadName = string;
        } else if (!string.equals(threadCache$Info.threadName)) {
            threadCache$Info.threadName = string;
            String[] stringArray = this.splitThreadName(string);
            threadCache$Info.msgPrefix = stringArray[0].equals(threadCache$Info.entityName) ? stringArray[1] : new StringBuffer().append(" ~").append(string).append("~").toString();
        }
        this.lastThread = thread;
        this.lastInfo = threadCache$Info;
        return threadCache$Info;
    }

    private String[] splitThreadName(String string) {
        String[] stringArray = new String[2];
        int n = string.indexOf(93);
        int n2 = string.length();
        if (n > 0 && n < n2 - 1) {
            stringArray[0] = string.substring(0, n + 1);
            stringArray[1] = new StringBuffer().append(" ~").append(string.substring(n + 1)).append("~").toString();
        } else {
            stringArray[0] = string;
        }
        return stringArray;
    }

    private ThreadCache$Info createInfo(String string) {
        int n = this.creator.createThreadEntity(string);
        TraceMe.msg(TraceMe.INFO, "Thread", "create %1 -> tid=%2", string, new Integer(n));
        return new ThreadCache$Info(n, string);
    }
}


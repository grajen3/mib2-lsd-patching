/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

import com.microdoc.j9.StackFrameInfo;

public class ThreadInfo {
    Thread fThread = null;
    public static final int RUNNING;
    public static final int BLOCKED;
    public static final int WAITING;
    public static final int TIMED_WAITING;
    public static final int SLEEPING;
    int fStatus;
    int fOSId;
    Object fMonitorObject = null;
    Thread fMonitorOwner = null;
    StackFrameInfo[] fStackFrames;

    String describeThread(Thread thread) {
        if (thread == null) {
            return "";
        }
        return new StringBuffer(String.valueOf(thread.getName())).append(", ").append(thread.getPriority()).toString();
    }

    String describeObject(Object object) {
        String string;
        if (object == null) {
            return "<null>";
        }
        try {
            string = object.toString();
        }
        catch (Throwable throwable) {
            string = "";
        }
        return new StringBuffer("\"").append(string).append("\" (").append(object.getClass().getName()).append(")").toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ThreadInfo: ").append(this.describeThread(this.fThread));
        stringBuffer.append(", 0x").append(Integer.toHexString(this.fOSId));
        stringBuffer.append("\nStatus: ").append(this.getStatusAsString());
        if (this.fMonitorObject != null) {
            stringBuffer.append(" on Monitor ").append(this.describeObject(this.fMonitorObject));
        }
        if (this.fMonitorOwner != null) {
            stringBuffer.append(" owned by ").append(this.describeThread(this.fMonitorOwner));
        }
        if (this.fStackFrames != null) {
            int n = 0;
            while (n < this.fStackFrames.length) {
                if (this.fStackFrames[n] != null) {
                    stringBuffer.append("\n\t").append(this.fStackFrames[n].fClassName).append(".").append(this.fStackFrames[n].fMethodName).append(this.fStackFrames[n].fMethodSignature);
                }
                ++n;
            }
        }
        return stringBuffer.toString();
    }

    public Object getMonitorObject() {
        return this.fMonitorObject;
    }

    public void setMonitorObject(Object object) {
        this.fMonitorObject = object;
    }

    public Thread getMonitorOwner() {
        return this.fMonitorOwner;
    }

    public void setMonitorOwner(Thread thread) {
        this.fMonitorOwner = thread;
    }

    public Thread getThread() {
        return this.fThread;
    }

    public void setThread(Thread thread) {
        this.fThread = thread;
    }

    public int getStatus() {
        return this.fStatus;
    }

    public String getStatusAsString() {
        switch (this.fStatus) {
            case 0: {
                return "running";
            }
            case 1: {
                return "blocked";
            }
            case 2: {
                return "waiting";
            }
            case 3: {
                return "waiting (timed)";
            }
            case 4: {
                return "sleeping";
            }
        }
        return "";
    }

    public void setStatus(int n) {
        this.fStatus = n;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.os;

import de.esolutions.fw.util.commons.os.OSFinder;
import java.lang.reflect.Method;

public final class Slayer {
    private Method killMethod;
    private Method getpidMethod;
    private Object osInstance;
    private final Object[] killArgs;

    public Slayer(int n) {
        this.findMethods();
        long l = this.getpid();
        if (l == -1L) {
            l = 0L;
        }
        this.killArgs = new Object[]{new Long(l), new Integer(n)};
    }

    public Slayer() {
        this(16);
    }

    private void findMethods() {
        try {
            OSFinder oSFinder = OSFinder.getInstance();
            this.osInstance = oSFinder.getOSInstance();
            if (this.osInstance == null) {
                return;
            }
            Class[] classArray = new Class[]{Long.TYPE, Integer.TYPE};
            this.killMethod = oSFinder.getOSClass().getDeclaredMethod("kill", classArray);
            Class[] classArray2 = new Class[]{};
            this.getpidMethod = oSFinder.getOSClass().getDeclaredMethod("getpid", classArray2);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public boolean haveKillMethod() {
        return this.killMethod != null;
    }

    public boolean haveGetPidMethod() {
        return this.getpidMethod != null;
    }

    public long getpid() {
        if (this.getpidMethod == null) {
            return -1L;
        }
        try {
            Object object = this.getpidMethod.invoke(this.osInstance, null);
            long l = (Long)object;
            return l;
        }
        catch (Exception exception) {
            return -1L;
        }
    }

    public final boolean suicide() {
        System.out.print("-----> J9 committing suicide <----- ");
        if (this.killMethod != null) {
            System.out.println(" with OS.kill()");
            System.out.flush();
            try {
                while (true) {
                    this.killMethod.invoke(this.osInstance, this.killArgs);
                    Thread.sleep(0);
                }
            }
            catch (Exception exception) {
                System.out.println(" -> FAILED!");
                exception.printStackTrace();
                return false;
            }
        }
        System.out.println(" -> ABORTED: no java_util_os (jar+jni) found!");
        return false;
    }

    public final boolean silentSuicide() {
        if (this.killMethod != null) {
            try {
                while (true) {
                    this.killMethod.invoke(this.osInstance, this.killArgs);
                    Thread.sleep(0);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        return false;
    }
}


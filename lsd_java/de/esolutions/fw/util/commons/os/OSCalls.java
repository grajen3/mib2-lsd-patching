/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.os;

import de.esolutions.fw.util.commons.os.OSFinder;
import java.lang.reflect.Method;

public class OSCalls {
    private Object osInstance;
    private Method sumMethod;

    public OSCalls() {
        try {
            OSFinder oSFinder = OSFinder.getInstance();
            this.osInstance = oSFinder.getOSInstance();
            if (this.osInstance == null) {
                return;
            }
            Class[] classArray = new Class[]{Long.TYPE};
            this.sumMethod = oSFinder.getOSClass().getDeclaredMethod("sum", classArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public boolean hasSum() {
        return this.sumMethod != null;
    }

    public long sum(long l) {
        if (this.sumMethod != null) {
            try {
                Object[] objectArray = new Object[]{new Long(l)};
                Object object = this.sumMethod.invoke(this.osInstance, objectArray);
                long l2 = (Long)object;
                return l2;
            }
            catch (Exception exception) {
                return -1L;
            }
        }
        return -1L;
    }
}


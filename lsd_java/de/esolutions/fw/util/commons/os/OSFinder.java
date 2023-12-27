/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.os;

import java.lang.reflect.Method;

public final class OSFinder {
    public static final String OSClassName;
    private Class osClass;
    private Object osInstance;
    private static OSFinder instance;

    public static synchronized OSFinder getInstance() {
        if (instance == null) {
            instance = new OSFinder();
        }
        return instance;
    }

    private OSFinder() {
        try {
            this.osClass = Class.forName("de.esolutions.fw.util.os.OS");
            Class[] classArray = new Class[]{};
            Method method = this.osClass.getDeclaredMethod("getInstance", classArray);
            this.osInstance = method.invoke(null, null);
        }
        catch (Exception exception) {
            this.osInstance = null;
            this.osClass = null;
        }
    }

    public final Object getOSInstance() {
        return this.osInstance;
    }

    public final Class getOSClass() {
        return this.osClass;
    }
}


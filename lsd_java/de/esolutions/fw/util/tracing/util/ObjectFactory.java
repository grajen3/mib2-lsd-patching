/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static final String chn;
    private Map map = new HashMap();

    public void register(String string, Class clazz) {
        TraceMe.msg(TraceMe.DEBUG, "Registry", "registry: register name=%1 class=%2", string, clazz.getName());
        this.map.put(string, clazz);
    }

    public void unregister(String string) {
        TraceMe.msg(TraceMe.DEBUG, "Registry", "unregister name=%1", string);
        this.map.remove(string);
    }

    public Object create(String string) {
        Object object = this.map.get(string);
        if (object == null) {
            TraceMe.msg(TraceMe.WARN, "Registry", "no name=%1 found!", string);
            return null;
        }
        Class clazz = (Class)object;
        try {
            return clazz.newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            TraceMe.msg(TraceMe.ERROR, "Registry", "name=%1 class=%2: %3", string, clazz.getName(), illegalAccessException);
            return null;
        }
        catch (InstantiationException instantiationException) {
            TraceMe.msg(TraceMe.ERROR, "Registry", "name=%1 class=%2: %3", string, clazz.getName(), instantiationException);
            return null;
        }
    }
}


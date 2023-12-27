/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.adpaterfactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.dsi.ifc.base.IAdapterManager;
import org.dsi.ifc.base.IFactory;

public final class DsiAdapterFactoryManager
implements IAdapterManager {
    private static final DsiAdapterFactoryManager INSTANCE = new DsiAdapterFactoryManager();
    private HashMap factories = new HashMap(5);

    public static DsiAdapterFactoryManager getDefault() {
        return INSTANCE;
    }

    private DsiAdapterFactoryManager() {
    }

    @Override
    public synchronized void registerFactories(IFactory iFactory) {
        Class[] classArray = iFactory.getFactoryList();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            String string = classArray[i2].getName();
            Object object = this.factories.get(string);
            if (object != null && !iFactory.shouldOverride((IFactory)object)) continue;
            this.factories.put(string, iFactory);
        }
    }

    @Override
    public synchronized void unregisterFactories(IFactory iFactory) {
        Class[] classArray = iFactory.getFactoryList();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            String string = classArray[i2].getName();
            Object object = this.factories.get(string);
            if (object != iFactory) continue;
            this.factories.remove(string);
        }
    }

    public synchronized void unregisterAllFactories() {
        this.factories.clear();
    }

    @Override
    public synchronized Object getFactory(Class clazz) {
        IFactory iFactory = (IFactory)this.factories.get(clazz.getName());
        Object object = null;
        if (iFactory != null) {
            object = iFactory.getFactory(clazz);
        }
        return object;
    }

    public String getVersionInfo(Object object) {
        String string;
        if (object == null) {
            string = null;
        } else {
            try {
                Field field = object.getClass().getDeclaredField("VERSION");
                field.setAccessible(true);
                Object object2 = field.get(object);
                string = new StringBuffer().append(object.getClass().getName()).append("@@").append(String.valueOf(object2)).toString();
            }
            catch (Throwable throwable) {
                string = null;
            }
        }
        return string;
    }
}


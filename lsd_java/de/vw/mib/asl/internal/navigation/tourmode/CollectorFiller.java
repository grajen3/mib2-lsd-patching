/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.tourmode;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class CollectorFiller {
    static /* synthetic */ Class class$java$lang$String;

    public static void checkCollectorForSimpleNull(Object object) {
        if (object != null) {
            Field[] fieldArray = object.getClass().getFields();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                try {
                    if (fieldArray[i2].getType() != (class$java$lang$String == null ? CollectorFiller.class$("java.lang.String") : class$java$lang$String) || fieldArray[i2].get(object) != null) continue;
                    fieldArray[i2].set(object, "");
                    continue;
                }
                catch (Exception exception) {
                    ServiceManager.logger.error(16384, exception.toString());
                }
            }
        }
    }

    public static Object genericClone(Object object) {
        if (object == null) {
            return null;
        }
        if (object.getClass().isArray()) {
            if (object.getClass().getComponentType().isPrimitive()) {
                Object object2 = Array.newInstance(object.getClass().getComponentType(), Array.getLength(object));
                System.arraycopy(object, 0, object2, 0, Array.getLength(object));
                return object2;
            }
            Object[] objectArray = (Object[])object;
            Object[] objectArray2 = (Object[])objectArray.clone();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray2[i2] = CollectorFiller.genericClone(objectArray[i2]);
            }
            return objectArray2;
        }
        if (object.getClass().getName().startsWith("org.dsi")) {
            Class clazz = object.getClass();
            Object object3 = clazz.newInstance();
            Field[] fieldArray = clazz.getFields();
            for (int i3 = 0; i3 < fieldArray.length; ++i3) {
                fieldArray[i3].set(object3, CollectorFiller.genericClone(fieldArray[i3].get(object)));
            }
            return object3;
        }
        return object;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


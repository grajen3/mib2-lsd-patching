/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.reflection;

import de.vw.mib.reflection.LightReflectionClassData;
import de.vw.mib.reflection.impl.ca.ConstructorAccessibleGenerator;
import de.vw.mib.reflection.impl.ma.MethodAccessibleGenerator;
import de.vw.mib.reflection.impl.mca.MultipleConstructorAccessibleGenerator;
import de.vw.mib.reflection.impl.mma.MultipleMethodAccessibleGenerator;
import de.vw.mib.reflection.impl.proxy.ProxyGenerator;
import java.lang.reflect.Method;

public final class LightReflection {
    public static LightReflectionClassData createMethodAccessibleClass(String string, String string2, Method[] methodArray) {
        return MethodAccessibleGenerator.create(string, string2, methodArray);
    }

    public static LightReflectionClassData createMultipleMethodAccessibleClass(String string, String[] stringArray, Method[] methodArray) {
        return MultipleMethodAccessibleGenerator.create(string, stringArray, methodArray);
    }

    public static LightReflectionClassData createConstructorAccessibleClass(String string, String string2) {
        return ConstructorAccessibleGenerator.create(string, string2);
    }

    public static LightReflectionClassData createMultipleConstructorAccessibleClass(String string, String[] stringArray) {
        return MultipleConstructorAccessibleGenerator.create(string, stringArray);
    }

    public static LightReflectionClassData createProxyClass(String string, String[] stringArray) {
        return ProxyGenerator.create(string, stringArray);
    }
}


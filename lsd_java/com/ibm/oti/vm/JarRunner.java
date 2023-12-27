/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import java.lang.reflect.Method;
import java.util.jar.Attributes;
import java.util.jar.Attributes$Name;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarRunner {
    public static void main(String[] stringArray) {
        Manifest manifest = JarRunner.getManifest(stringArray[0]);
        if (manifest == null) {
            System.err.println(Msg.getString("K0222", stringArray[0]));
            return;
        }
        String string = JarRunner.mainClassName(manifest);
        if (string == null) {
            System.err.println(Msg.getString("K01c6", stringArray[0]));
            return;
        }
        Class clazz = Class.forName(string, true, ClassLoader.getSystemClassLoader());
        Class[] classArray = new Class[]{super.getClass()};
        Method method = clazz.getMethod("main", classArray);
        Object[] objectArray = new Object[1];
        String[] stringArray2 = new String[stringArray.length - 1];
        System.arraycopy((Object)stringArray, 1, (Object)stringArray2, 0, stringArray.length - 1);
        objectArray[0] = stringArray2;
        method.invoke(null, objectArray);
    }

    private static String mainClassName(Manifest manifest) {
        Attributes attributes = manifest.getMainAttributes();
        String string = attributes.getValue(Attributes$Name.MAIN_CLASS);
        if (string != null) {
            string = string.replace('/', '.');
        }
        return string;
    }

    private static Manifest getManifest(String string) {
        JarFile jarFile = new JarFile(string);
        return jarFile.getManifest();
    }
}


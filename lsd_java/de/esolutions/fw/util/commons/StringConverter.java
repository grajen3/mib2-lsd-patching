/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import java.lang.reflect.Method;

public class StringConverter {
    private static final int SYS_UNKNOWN;
    private static final int SYS_J9;
    private final String encoding;
    private Object sysConv;
    private Method sysConvGetBytesMethod;
    private Method sysConvGetCharsMethod;
    private int sysType;
    private static final String j9VMClassName;
    private static final String j9CharConvClassName;
    public static final StringConverter UTF8;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class array$C;
    static /* synthetic */ Class array$B;

    public StringConverter(String string) {
        this.encoding = string;
        try {
            Class clazz = Class.forName("com.ibm.oti.vm.VM");
            Method method = clazz.getDeclaredMethod("useNatives", new Class[0]);
            method.invoke(null, new Object[0]);
            Class clazz2 = Class.forName("com.ibm.oti.io.CharacterConverter");
            Class[] classArray = new Class[]{class$java$lang$String == null ? (class$java$lang$String = StringConverter.class$("java.lang.String")) : class$java$lang$String};
            Method method2 = clazz2.getDeclaredMethod("getConverter", classArray);
            Object[] objectArray = new Object[]{string};
            Object object = method2.invoke(null, objectArray);
            Method method3 = clazz2.getDeclaredMethod("getModeless", new Class[0]);
            this.sysConv = method3.invoke(object, new Object[0]);
            Class[] classArray2 = new Class[]{array$C == null ? (array$C = StringConverter.class$("[C")) : array$C, Integer.TYPE, Integer.TYPE};
            this.sysConvGetBytesMethod = clazz2.getDeclaredMethod("convert", classArray2);
            Class[] classArray3 = new Class[]{array$B == null ? (array$B = StringConverter.class$("[B")) : array$B, Integer.TYPE, Integer.TYPE};
            this.sysConvGetCharsMethod = clazz2.getDeclaredMethod("convert", classArray3);
            this.sysType = 1;
        }
        catch (Exception exception) {
            this.sysConv = null;
            this.sysConvGetBytesMethod = null;
            this.sysType = 0;
        }
    }

    public String getString(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (this.sysConv == null) {
            return new String(byArray, this.encoding);
        }
        try {
            if (this.sysType == 1) {
                Object[] objectArray = new Object[]{byArray, new Integer(0), new Integer(byArray.length)};
                char[] cArray = (char[])this.sysConvGetCharsMethod.invoke(this.sysConv, objectArray);
                return new String(cArray);
            }
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public byte[] getBytes(String string) {
        if (string == null) {
            return null;
        }
        if (this.sysConv == null) {
            return string.getBytes(this.encoding);
        }
        try {
            if (this.sysType == 1) {
                char[] cArray = string.toCharArray();
                Object[] objectArray = new Object[]{cArray, new Integer(0), new Integer(cArray.length)};
                return (byte[])this.sysConvGetBytesMethod.invoke(this.sysConv, objectArray);
            }
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        UTF8 = new StringConverter("UTF-8");
    }
}


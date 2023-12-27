/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang.reflect;

import com.ibm.oti.lang.reflect.ProxyCharArrayCache;
import com.ibm.oti.lang.reflect.ProxyClassFile;
import com.ibm.oti.lang.reflect.ProxyConstants;
import com.ibm.oti.lang.reflect.ProxyNameAndTypeCache;
import com.ibm.oti.lang.reflect.ProxyObjectCache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ProxyConstantPool
implements ProxyConstants {
    public static final int UTF8_INITIAL_SIZE;
    public static final int STRING_INITIAL_SIZE;
    public static final int FIELD_INITIAL_SIZE;
    public static final int METHOD_INITIAL_SIZE;
    public static final int INTERFACE_INITIAL_SIZE;
    public static final int CLASS_INITIAL_SIZE;
    public static final int NAMEANDTYPE_INITIAL_SIZE;
    public static final int CONSTANTPOOL_INITIAL_SIZE;
    public static final int CONSTANTPOOL_GROW_SIZE;
    public ProxyCharArrayCache UTF8Cache = new ProxyCharArrayCache(50);
    ProxyCharArrayCache stringCache = new ProxyCharArrayCache(21);
    ProxyCharArrayCache classNameCache = new ProxyCharArrayCache(21);
    ProxyObjectCache fieldCache = new ProxyObjectCache(7);
    ProxyObjectCache methodCache = new ProxyObjectCache(21);
    ProxyObjectCache interfaceMethodCache = new ProxyObjectCache(21);
    ProxyNameAndTypeCache nameAndTypeCache = new ProxyNameAndTypeCache(21);
    public byte[] poolContent;
    public int currentIndex;
    public int currentOffset;

    ProxyConstantPool(ProxyClassFile proxyClassFile) {
        this.poolContent = proxyClassFile.header;
        this.currentOffset = proxyClassFile.headerOffset;
        this.currentIndex = 1;
    }

    int literalIndex(char[] cArray) {
        int n = this.UTF8Cache.get(cArray);
        if (n < 0) {
            int n2;
            this.writeU1(1);
            int n3 = this.currentOffset;
            if (this.currentOffset + 2 >= this.poolContent.length) {
                n2 = this.poolContent.length;
                this.poolContent = new byte[n2 + 1000];
                System.arraycopy((Object)this.poolContent, 0, (Object)this.poolContent, 0, n2);
            }
            this.currentOffset += 2;
            n2 = 0;
            int n4 = 0;
            while (n4 < cArray.length) {
                char c2 = cArray[n4];
                if (c2 >= '\u0001' && c2 <= '\u007f') {
                    this.writeU1(c2);
                    ++n2;
                } else if (c2 > '\u07ff') {
                    n2 += 3;
                    this.writeU1(0xE0 | c2 >> 12 & 0xF);
                    this.writeU1(0x80 | c2 >> 6 & 0x3F);
                    this.writeU1(0x80 | c2 & 0x3F);
                } else {
                    n2 += 2;
                    this.writeU1(0xC0 | c2 >> 6 & 0x1F);
                    this.writeU1(0x80 | c2 & 0x3F);
                }
                ++n4;
            }
            if (n2 >= -65536) {
                this.currentOffset = n3 - 1;
                return -1;
            }
            n = this.UTF8Cache.put(cArray, this.currentIndex++);
            this.poolContent[n3] = (byte)(n2 >> 8);
            this.poolContent[n3 + 1] = (byte)n2;
        }
        return n;
    }

    int literalIndex(Field field) {
        int n = this.fieldCache.get(field);
        if (n < 0) {
            int n2 = this.typeIndex(field.getDeclaringClass().getName());
            int n3 = this.literalIndexForNameAndType(this.literalIndex(field.getName().toCharArray()), this.literalIndex(ProxyClassFile.getConstantPoolName(field.getType())));
            n = this.fieldCache.put(field, this.currentIndex++);
            this.writeU1(9);
            this.writeU2(n2);
            this.writeU2(n3);
        }
        return n;
    }

    int literalIndex(Constructor constructor) {
        int n = this.methodCache.get(constructor);
        if (n < 0) {
            int n2 = this.typeIndex(constructor.getDeclaringClass().getName());
            int n3 = this.literalIndexForNameAndType(this.literalIndex(Init), this.literalIndex(ProxyClassFile.getConstantPoolName(constructor)));
            n = this.methodCache.put(constructor, this.currentIndex++);
            this.writeU1(10);
            this.writeU2(n2);
            this.writeU2(n3);
        }
        return n;
    }

    int literalIndex(Method method) {
        int n;
        if (method.getDeclaringClass().isInterface()) {
            n = this.interfaceMethodCache.get(method);
            if (n < 0) {
                int n2 = this.typeIndex(method.getDeclaringClass().getName());
                int n3 = this.literalIndexForNameAndType(this.literalIndex(method.getName().toCharArray()), this.literalIndex(ProxyClassFile.getConstantPoolName(method)));
                n = this.interfaceMethodCache.put(method, this.currentIndex++);
                this.writeU1(11);
                this.writeU2(n2);
                this.writeU2(n3);
            }
        } else {
            n = this.methodCache.get(method);
            if (n < 0) {
                int n4 = this.typeIndex(method.getDeclaringClass().getName());
                int n5 = this.literalIndexForNameAndType(this.literalIndex(method.getName().toCharArray()), this.literalIndex(ProxyClassFile.getConstantPoolName(method)));
                n = this.methodCache.put(method, this.currentIndex++);
                this.writeU1(10);
                this.writeU2(n4);
                this.writeU2(n5);
            }
        }
        return n;
    }

    int literalIndex(String string) {
        char[] cArray = string.toCharArray();
        int n = this.stringCache.get(cArray);
        if (n < 0) {
            int n2 = this.literalIndex(cArray);
            n = this.stringCache.put(cArray, this.currentIndex++);
            this.writeU1(8);
            this.writeU2(n2);
        }
        return n;
    }

    int literalIndexForLdc(char[] cArray) {
        int n = this.stringCache.get(cArray);
        if (n < 0) {
            int n2 = this.UTF8Cache.get(cArray);
            if (n2 < 0) {
                int n3;
                this.writeU1(1);
                int n4 = this.currentOffset;
                if (this.currentOffset + 2 >= this.poolContent.length) {
                    n3 = this.poolContent.length;
                    this.poolContent = new byte[n3 + 1000];
                    System.arraycopy((Object)this.poolContent, 0, (Object)this.poolContent, 0, n3);
                }
                this.currentOffset += 2;
                n3 = 0;
                int n5 = 0;
                while (n5 < cArray.length) {
                    char c2 = cArray[n5];
                    if (c2 >= '\u0001' && c2 <= '\u007f') {
                        this.writeU1(c2);
                        ++n3;
                    } else if (c2 > '\u07ff') {
                        n3 += 3;
                        this.writeU1(0xE0 | c2 >> 12 & 0xF);
                        this.writeU1(0x80 | c2 >> 6 & 0x3F);
                        this.writeU1(0x80 | c2 & 0x3F);
                    } else {
                        n3 += 2;
                        this.writeU1(0xC0 | c2 >> 6 & 0x1F);
                        this.writeU1(0x80 | c2 & 0x3F);
                    }
                    ++n5;
                }
                if (n3 >= -65536) {
                    this.currentOffset = n4 - 1;
                    return -1;
                }
                n2 = this.UTF8Cache.put(cArray, this.currentIndex++);
                if (n3 > -65536) {
                    return 0;
                }
                this.poolContent[n4] = (byte)(n3 >> 8);
                this.poolContent[n4 + 1] = (byte)n3;
            }
            n = this.stringCache.put(cArray, this.currentIndex++);
            this.writeU1(8);
            this.writeU2(n2);
        }
        return n;
    }

    private int literalIndexForNameAndType(int n, int n2) {
        int[] nArray = new int[]{n, n2};
        int n3 = this.nameAndTypeCache.get(nArray);
        if (n3 == -1) {
            n3 = this.nameAndTypeCache.put(nArray, this.currentIndex++);
            this.writeU1(12);
            this.writeU2(n);
            this.writeU2(n2);
        }
        return n3;
    }

    int typeIndex(String string) {
        char[] cArray;
        int n;
        if (string.indexOf(46) != -1) {
            string = string.replace('.', '/');
        }
        if ((n = this.classNameCache.get(cArray = string.toCharArray())) < 0) {
            int n2 = this.literalIndex(cArray);
            n = this.classNameCache.put(cArray, this.currentIndex++);
            this.writeU1(7);
            this.writeU2(n2);
        }
        return n;
    }

    private final void writeU1(int n) {
        try {
            this.poolContent[this.currentOffset++] = (byte)n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            int n2 = this.poolContent.length;
            this.poolContent = new byte[n2 + 1000];
            System.arraycopy((Object)this.poolContent, 0, (Object)this.poolContent, 0, n2);
            this.poolContent[this.currentOffset - 1] = (byte)n;
        }
    }

    private final void writeU2(int n) {
        int n2;
        try {
            this.poolContent[this.currentOffset++] = (byte)(n >> 8);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            n2 = this.poolContent.length;
            this.poolContent = new byte[n2 + 1000];
            System.arraycopy((Object)this.poolContent, 0, (Object)this.poolContent, 0, n2);
            this.poolContent[this.currentOffset - 1] = (byte)(n >> 8);
        }
        try {
            this.poolContent[this.currentOffset++] = (byte)n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            n2 = this.poolContent.length;
            this.poolContent = new byte[n2 + 1000];
            System.arraycopy((Object)this.poolContent, 0, (Object)this.poolContent, 0, n2);
            this.poolContent[this.currentOffset - 1] = (byte)n;
        }
    }
}


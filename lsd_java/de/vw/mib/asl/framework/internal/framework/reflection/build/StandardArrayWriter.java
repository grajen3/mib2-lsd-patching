/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import de.vw.mib.asl.framework.internal.framework.reflection.build.ArrayWriter;
import java.lang.reflect.Array;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;

public class StandardArrayWriter
implements ArrayWriter {
    static /* synthetic */ Class class$java$lang$String;

    @Override
    public void pushArray(GeneratorAdapter generatorAdapter, Class clazz, Object object) {
        if (null == object) {
            this.pushNullArray(generatorAdapter, clazz);
        } else {
            Class clazz2 = object.getClass();
            if (clazz2.isArray()) {
                int n = Array.getLength(object);
                if (0 == n) {
                    this.pushEmptyArray(generatorAdapter, clazz2, object);
                } else {
                    this.pushNonEmptyArray(generatorAdapter, clazz2, object, n);
                }
            } else {
                throw new IllegalArgumentException(new StringBuffer().append("not an array type: ").append(clazz2).toString());
            }
        }
    }

    @Override
    public void pushNullArray(GeneratorAdapter generatorAdapter, Class clazz) {
        generatorAdapter.push((Type)null);
    }

    @Override
    public void pushEmptyArray(GeneratorAdapter generatorAdapter, Class clazz, Object object) {
        this.pushNonEmptyArray(generatorAdapter, clazz, object, 0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void pushNonEmptyArray(GeneratorAdapter generatorAdapter, Class clazz, Object object, int n) {
        Class clazz2 = clazz.getComponentType();
        if (clazz2.isPrimitive()) {
            if (clazz2 == Boolean.TYPE) {
                this.push(generatorAdapter, (boolean[])object);
                return;
            } else if (clazz2 == Byte.TYPE) {
                this.push(generatorAdapter, (byte[])object);
                return;
            } else if (clazz2 == Short.TYPE) {
                this.push(generatorAdapter, (short[])object);
                return;
            } else if (clazz2 == Character.TYPE) {
                this.push(generatorAdapter, (char[])object);
                return;
            } else if (clazz2 == Integer.TYPE) {
                this.push(generatorAdapter, (int[])object);
                return;
            } else if (clazz2 == Long.TYPE) {
                this.push(generatorAdapter, (long[])object);
                return;
            } else if (clazz2 == Float.TYPE) {
                this.push(generatorAdapter, (float[])object);
                return;
            } else {
                if (clazz2 != Double.TYPE) throw new IllegalArgumentException(new StringBuffer().append("unknown primitive type: ").append(clazz2).toString());
                this.push(generatorAdapter, (double[])object);
            }
            return;
        } else if (clazz2 == (class$java$lang$String == null ? (class$java$lang$String = StandardArrayWriter.class$("java.lang.String")) : class$java$lang$String)) {
            this.push(generatorAdapter, (String[])object);
            return;
        } else {
            if (!clazz2.isArray()) throw new IllegalArgumentException(new StringBuffer().append("not an array type: ").append(clazz2).toString());
            Type type = Type.getType((Class)clazz2);
            generatorAdapter.push(n);
            generatorAdapter.newArray(type);
            for (int i2 = 0; i2 < n; ++i2) {
                generatorAdapter.dup();
                generatorAdapter.push(i2);
                this.pushArray(generatorAdapter, clazz2, Array.get(object, i2));
                generatorAdapter.arrayStore(type);
            }
        }
    }

    private void push(GeneratorAdapter generatorAdapter, boolean[] blArray) {
        generatorAdapter.push(blArray.length);
        generatorAdapter.newArray(Type.BOOLEAN_TYPE);
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push(blArray[i2]);
            generatorAdapter.arrayStore(Type.BOOLEAN_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, byte[] byArray) {
        generatorAdapter.push(byArray.length);
        generatorAdapter.newArray(Type.BYTE_TYPE);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push((int)byArray[i2]);
            generatorAdapter.arrayStore(Type.BYTE_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, char[] cArray) {
        generatorAdapter.push(cArray.length);
        generatorAdapter.newArray(Type.CHAR_TYPE);
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push((int)cArray[i2]);
            generatorAdapter.arrayStore(Type.CHAR_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, short[] sArray) {
        generatorAdapter.push(sArray.length);
        generatorAdapter.newArray(Type.SHORT_TYPE);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push((int)sArray[i2]);
            generatorAdapter.arrayStore(Type.SHORT_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, int[] nArray) {
        generatorAdapter.push(nArray.length);
        generatorAdapter.newArray(Type.INT_TYPE);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push(nArray[i2]);
            generatorAdapter.arrayStore(Type.INT_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, long[] lArray) {
        generatorAdapter.push(lArray.length);
        generatorAdapter.newArray(Type.LONG_TYPE);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push(lArray[i2]);
            generatorAdapter.arrayStore(Type.LONG_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, float[] fArray) {
        generatorAdapter.push(fArray.length);
        generatorAdapter.newArray(Type.FLOAT_TYPE);
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push(fArray[i2]);
            generatorAdapter.arrayStore(Type.FLOAT_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, double[] dArray) {
        generatorAdapter.push(dArray.length);
        generatorAdapter.newArray(Type.DOUBLE_TYPE);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push(dArray[i2]);
            generatorAdapter.arrayStore(Type.DOUBLE_TYPE);
        }
    }

    private void push(GeneratorAdapter generatorAdapter, String[] stringArray) {
        Type type = Type.getType((Class)(class$java$lang$String == null ? (class$java$lang$String = StandardArrayWriter.class$("java.lang.String")) : class$java$lang$String));
        generatorAdapter.push(stringArray.length);
        generatorAdapter.newArray(type);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            generatorAdapter.dup();
            generatorAdapter.push(i2);
            generatorAdapter.push(stringArray[i2]);
            generatorAdapter.arrayStore(type);
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
}


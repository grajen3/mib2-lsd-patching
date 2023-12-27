/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.commons;

public class ArrayUtils {
    public static Object[] toObjects(Object object) {
        Object[] objectArray;
        block8: {
            block13: {
                block12: {
                    block11: {
                        block10: {
                            block9: {
                                block7: {
                                    objectArray = null;
                                    if (!(object instanceof byte[])) break block7;
                                    byte[] byArray = (byte[])object;
                                    objectArray = new Object[byArray.length];
                                    for (int i2 = 0; i2 < objectArray.length; ++i2) {
                                        objectArray[i2] = new Byte(byArray[i2]);
                                    }
                                    break block8;
                                }
                                if (!(object instanceof boolean[])) break block9;
                                boolean[] blArray = (boolean[])object;
                                objectArray = new Object[blArray.length];
                                for (int i3 = 0; i3 < objectArray.length; ++i3) {
                                    objectArray[i3] = new Boolean(blArray[i3]);
                                }
                                break block8;
                            }
                            if (!(object instanceof short[])) break block10;
                            short[] sArray = (short[])object;
                            objectArray = new Object[sArray.length];
                            for (int i4 = 0; i4 < objectArray.length; ++i4) {
                                objectArray[i4] = new Short(sArray[i4]);
                            }
                            break block8;
                        }
                        if (!(object instanceof int[])) break block11;
                        int[] nArray = (int[])object;
                        objectArray = new Object[nArray.length];
                        for (int i5 = 0; i5 < objectArray.length; ++i5) {
                            objectArray[i5] = new Integer(nArray[i5]);
                        }
                        break block8;
                    }
                    if (!(object instanceof long[])) break block12;
                    long[] lArray = (long[])object;
                    objectArray = new Object[lArray.length];
                    for (int i6 = 0; i6 < objectArray.length; ++i6) {
                        objectArray[i6] = new Long(lArray[i6]);
                    }
                    break block8;
                }
                if (!(object instanceof double[])) break block13;
                double[] dArray = (double[])object;
                objectArray = new Object[dArray.length];
                for (int i7 = 0; i7 < objectArray.length; ++i7) {
                    objectArray[i7] = new Double(dArray[i7]);
                }
                break block8;
            }
            if (!(object instanceof float[])) break block8;
            float[] fArray = (float[])object;
            objectArray = new Object[fArray.length];
            for (int i8 = 0; i8 < objectArray.length; ++i8) {
                objectArray[i8] = new Float(fArray[i8]);
            }
        }
        return objectArray;
    }
}


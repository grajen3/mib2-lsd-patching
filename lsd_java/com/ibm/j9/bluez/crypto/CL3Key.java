/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.bluez.crypto;

import com.ibm.j9.bluez.crypto.BigInteger;
import com.ibm.j9.bluez.crypto.CL3;

public class CL3Key {
    protected int type;
    protected Object obj;

    protected CL3Key(Object object, int n) {
        this.obj = object;
        this.type = n;
    }

    public void dispose() {
        block8: {
            block11: {
                block10: {
                    block9: {
                        block7: {
                            if (this.obj == null) {
                                return;
                            }
                            if (!(this.obj instanceof byte[])) break block7;
                            byte[] byArray = (byte[])this.obj;
                            int n = byArray.length - 1;
                            while (n >= 0) {
                                byArray[n] = 0;
                                --n;
                            }
                            break block8;
                        }
                        if (!(this.obj instanceof int[])) break block9;
                        int[] nArray = (int[])this.obj;
                        int n = nArray.length - 1;
                        while (n >= 0) {
                            nArray[n] = 0;
                            --n;
                        }
                        break block8;
                    }
                    if (!(this.obj instanceof long[])) break block10;
                    long[] lArray = (long[])this.obj;
                    int n = lArray.length - 1;
                    while (n >= 0) {
                        lArray[n] = 0L;
                        --n;
                    }
                    break block8;
                }
                if (!(this.obj instanceof BigInteger[])) break block11;
                BigInteger[] bigIntegerArray = (BigInteger[])this.obj;
                BigInteger bigInteger = BigInteger.valueOf(0);
                int n = bigIntegerArray.length - 1;
                while (n >= 0) {
                    bigIntegerArray[n] = bigInteger;
                    --n;
                }
                break block8;
            }
            if (!(this.obj instanceof Object[])) break block8;
            Object[] objectArray = (Object[])this.obj;
            int n = 0;
            while (n < objectArray.length) {
                if (objectArray[n] instanceof CL3) {
                    CL3.dispose((CL3)objectArray[n]);
                }
                ++n;
            }
        }
    }
}


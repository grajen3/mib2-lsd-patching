/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.ArrayHelper;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.BitHelper;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.util.NoSuchElementException;

public abstract class AccessImpl
implements Access {
    private static final int TYPE_BOOLEAN;
    private static final int TYPE_INTEGER;
    private static final int TYPE_BYTEARRAY;
    private static final int ENTRY_RANGE;
    private static final int ENTRY_ARRAY;
    protected final byte[] mData;
    protected Engine mEngine;
    protected int[] mConfiguration;

    public AccessImpl(byte[] byArray, int[] nArray, int n, long l) {
        if (byArray != null) {
            if (ArrayHelper.contains(nArray, byArray.length)) {
                this.mData = byArray;
            } else {
                ServiceManager.logger.error(16384).append("DIAGNOSTIC data ns/key ").append(n).append("/").append(l).append(" invalid length: ").append(byArray.length).log();
                this.mData = new byte[0];
            }
        } else {
            ServiceManager.logger.error(16384).append("DIAGNOSTIC ns/key ").append(n).append("/").append(l).append(" data == null").log();
            this.mData = new byte[0];
        }
        this.mEngine = null;
    }

    @Override
    public boolean contains(int n) {
        int n2 = this.mEngine.getInt();
        return this.mEngine.getInt(n2, n) >= 0;
    }

    @Override
    public boolean getBoolean(int n) {
        int n2 = this.mEngine.getInt();
        if ((n2 = this.mEngine.getInt(n2, n)) >= 0) {
            int n3;
            int n4;
            if ((n4 = this.mConfiguration[n2++]) != 10037) {
                this.wrongType(n);
            }
            if ((n3 = this.mConfiguration[n2++]) == 1) {
                int n5;
                int n6 = this.mConfiguration[n2++];
                int n7 = this.mConfiguration[n2++];
                if (0 <= n6 && n6 < this.mData.length) {
                    return BitHelper.testBit(this.mData[n6], n7);
                }
                return (n5 = this.mConfiguration[n2++]) != 0;
            }
            throw new RuntimeException(new StringBuffer().append("Wrong length for boolean: ").append(n3).toString());
        }
        ServiceManager.logger.error(16384).append("DIAGNOSTIC getBoolean called with unknown id: ").append(n).log();
        throw new NoSuchElementException(Integer.toString(n));
    }

    @Override
    public int getValue(int n) {
        int n2 = this.mEngine.getInt();
        if ((n2 = this.mEngine.getInt(n2, n)) >= 0) {
            int n3;
            int n4;
            int n5;
            int n6;
            int n7 = 0;
            if ((n6 = this.mConfiguration[n2++]) != 20051) {
                this.wrongType(n);
            }
            int n8 = this.mConfiguration[n2++];
            int n9 = this.mConfiguration[n2++];
            int n10 = this.mConfiguration[n2++];
            int n11 = this.mConfiguration[n2++];
            if (n8 <= 8) {
                if (0 <= n9 && n9 < this.mData.length) {
                    for (n5 = n10; n5 < n10 + n8; ++n5) {
                        if (!BitHelper.testBit(this.mData[n9], n5)) continue;
                        n7 = BitHelper.setBit(n7, n5 - n10);
                    }
                } else {
                    n7 = n11;
                }
            } else if ((n8 & 7) == 0 && n10 == 0) {
                n5 = n8 >> 3;
                n4 = n9 + n5;
                if (0 <= n9 && n4 < this.mData.length) {
                    for (n3 = n9; n3 < n4; ++n3) {
                        n7 <<= 8;
                        n7 |= this.mData[n3] & 0xFF;
                    }
                } else {
                    n7 = n11;
                }
            } else {
                throw new RuntimeException(new StringBuffer().append("Wrong config for value: ").append(n8).append(" - ").append(n10).toString());
            }
            n2 = this.mConfiguration[n2];
            if (n2 < 0) {
                return n7;
            }
            n5 = this.mConfiguration[n2++];
            for (n4 = 0; n4 < n5; ++n4) {
                int n12;
                int n13;
                int n14;
                n3 = this.mConfiguration[n2++];
                if ((n14 = this.mConfiguration[n3++]) == 1091) {
                    n13 = this.mConfiguration[n3++];
                    n12 = this.mConfiguration[n3++];
                    if (n13 > n7 || n7 > n12) continue;
                    return n7;
                }
                if (n14 == 2029) {
                    n13 = this.mConfiguration[n3++];
                    for (n12 = 0; n12 < n13; ++n12) {
                        int n15;
                        if (n7 != (n15 = this.mConfiguration[n3++])) continue;
                        return n7;
                    }
                    continue;
                }
                throw new RuntimeException("unknown container type");
            }
            return n11;
        }
        ServiceManager.logger.error(16384).append("DIAGNOSTIC getValue called with unknown id: ").append(n).log();
        throw new NoSuchElementException(Integer.toString(n));
    }

    @Override
    public byte[] getByteArray(int n) {
        int n2 = this.mEngine.getInt();
        if ((n2 = this.mEngine.getInt(n2, n)) >= 0) {
            int n3;
            if ((n3 = this.mConfiguration[n2++]) != 30029) {
                throw new UnsupportedOperationException(new StringBuffer().append("Can't get a byte array from: ").append(n).toString());
            }
            int n4 = this.mConfiguration[n2++];
            int n5 = this.mConfiguration[n2++];
            int n6 = this.mConfiguration[n2++];
            if ((n4 & 7) == 0 && n6 == 0) {
                int n7 = n4 >> 3;
                int n8 = n5 + n7;
                if (0 <= n5 && n8 <= this.mData.length) {
                    byte[] byArray = new byte[n7];
                    for (int i2 = n5; i2 < n8; ++i2) {
                        byArray[i2 - n5] = this.mData[i2];
                    }
                    return byArray;
                }
                if ((n2 = this.mConfiguration[n2]) < 0) {
                    return new byte[0];
                }
                byte[] byArray = new byte[n7];
                int n9 = 0;
                int n10 = this.mConfiguration[n2++];
                for (int i3 = 0; i3 < n7; ++i3) {
                    byArray[i3] = (byte)(n10 & 0xFF);
                    if (++n9 >= 4) {
                        n9 = 0;
                        n10 = this.mConfiguration[n2++];
                        continue;
                    }
                    n10 >>= 8;
                }
                return byArray;
            }
            throw new RuntimeException(new StringBuffer().append("Wrong config for byte array: ").append(n4).append(" - ").append(n6).toString());
        }
        ServiceManager.logger.error(16384).append("DIAGNOSTIC getValue called with unknown id: ").append(n).log();
        throw new NoSuchElementException(Integer.toString(n));
    }

    @Override
    public byte[] getRawData() {
        return this.mData;
    }

    protected static void deprecated() {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        ServiceManager.logger.error(16384).append("deprecated diagnosis method (").append(stackTraceElementArray[1].getMethodName()).append(") called from ").append(stackTraceElementArray[2].getMethodName()).append(" (").append(stackTraceElementArray[2].getFileName()).append(":").append(stackTraceElementArray[2].getLineNumber()).append(")").log();
    }

    private void wrongType(int n) {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        ServiceManager.logger.error(16384).append("diagnosis coding value (").append(n).append(") accessed by wrong getter (").append(stackTraceElementArray[1].getMethodName()).append(") from ").append(stackTraceElementArray[2].getMethodName()).append(" (").append(stackTraceElementArray[2].getFileName()).append(":").append(stackTraceElementArray[2].getLineNumber()).append(")").log();
    }
}


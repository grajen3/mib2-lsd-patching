/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.personalization.DSIPersonalization;

public final class LR22bcdba25
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2126176143: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1996743737: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1846490619: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1498642978: {
                if (bl) {
                    if (n2 != -2059728075) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1317034624: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1295961878: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 25;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 26;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 27;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1141196584: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -986328085: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 28;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 29;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 30;
                    break;
                }
                n3 = 28;
                break;
            }
            case -902587515: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -663863249: {
                if (bl) {
                    if (n2 != -1495293689) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -500195396: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -68284892: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 212041584: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 229166067: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 399580303: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 514842559: {
                if (bl) {
                    if (n2 != 15757373) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 583281990: {
                if (bl) {
                    if (n2 != 1507281920) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 0x37333774: {
                if (bl) {
                    if (n2 != 934977799) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1080383726: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1197737757: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1279960634: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1412236101: {
                if (bl) {
                    if (n2 != -1521674749) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1570216261: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 2023648310: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 2101112184: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 31;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 32;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 33;
                    break;
                }
                n3 = 31;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 34;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 35;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 36;
                    break;
                }
                n3 = 34;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case 1038018639: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 2081251247: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIPersistence)object).readInt(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 1: {
                ((DSIPersistence)object).writeInt(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIPersistence)object).writeBuffer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (byte[])objectArray[2]);
                return null;
            }
            case 3: {
                ((DSIPersistence)object).subscribe(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (long[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 4: {
                ((DSIPersistence)object).unsubscribe(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (long[])objectArray[2]);
                return null;
            }
            case 5: {
                ((DSIPersistence)object).readArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 6: {
                ((DSIPersistence)object).readString(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 7: {
                ((DSIPersistence)object).readIntTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIPersistence)object).readBuffer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 9: {
                ((DSIPersistence)object).readBufferTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIPersistence)object).writeString(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String)objectArray[2]);
                return null;
            }
            case 11: {
                ((DSIPersistence)object).readStringTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIPersistence)object).writeArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (int[])objectArray[2]);
                return null;
            }
            case 13: {
                ((DSIPersistence)object).readArrayTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIPersistence)object).writeStringArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String[])objectArray[2]);
                return null;
            }
            case 15: {
                ((DSIPersistence)object).readStringArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 16: {
                ((DSIPersistence)object).readStringArrayTimeout(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                ((DSIPersistence)object).enterEngineeringSession(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIPersistence)object).exitEngineeringSession(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIPersistence)object).getVisibleSystemLanguages();
                return null;
            }
            case 20: {
                ((DSIPersistence)object).flushSQLDatabase();
                return null;
            }
            case 21: {
                ((DSIPersistence)object).setSQLDatabaseMedium(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSIPersistence)object).beginTransaction(((Number)objectArray[0]).intValue());
                return null;
            }
            case 23: {
                ((DSIPersistence)object).endTransaction(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIPersistence)object).unsubscribeAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIPersistence)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIPersistence)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIPersistence)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIPersistence)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIPersistence)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIPersistence)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSIPersonalization)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIPersonalization)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIPersonalization)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSIPersonalization)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSIPersonalization)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 36: {
                ((DSIPersonalization)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
                case 1: {
                    return this.f1(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.persistence.DSIPersistenceListener;
import org.dsi.ifc.personalization.DSIPersonalizationListener;

public final class LR21b91841d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -932243735: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -903659569: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 627101265: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1996743737: {
                if (bl) {
                    if (n2 != 743714674) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1846490619: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1498642978: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1295961878: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1141196584: {
                if (bl) {
                    if (n2 != 1308149060) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -986328085: {
                if (bl) {
                    if (n2 != -556612284) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -871692486: {
                if (bl) {
                    if (n2 != 743714674) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -791722172: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -663863249: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -643537055: {
                if (bl) {
                    if (n2 != 1174474573) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -500195396: {
                if (bl) {
                    if (n2 != 1281768000) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 28309131: {
                if (bl) {
                    if (n2 != 1308149060) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 583281990: {
                if (bl) {
                    if (n2 != 61137418) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 908610712: {
                if (bl) {
                    if (n2 != -556612284) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 0x37333774: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1080383726: {
                if (bl) {
                    if (n2 != 1174474573) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1279960634: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1394743401: {
                if (bl) {
                    if (n2 != 1281768000) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1412236101: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1570216261: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 2101112184: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case -419910013: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1300731683: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIPersonalizationListener)object).copyProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIPersonalizationListener)object).resetProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIPersonalizationListener)object).resetAllProfiles();
                return null;
            }
            case 3: {
                ((DSIPersonalizationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIPersistenceListener)object).readInt(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 5: {
                ((DSIPersistenceListener)object).writeInt(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIPersistenceListener)object).writeBuffer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIPersistenceListener)object).unsubscribe(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (long[])objectArray[2], (int[])objectArray[3]);
                return null;
            }
            case 8: {
                ((DSIPersistenceListener)object).readArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (int[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 9: {
                ((DSIPersistenceListener)object).readString(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((DSIPersistenceListener)object).readBuffer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (byte[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 11: {
                ((DSIPersistenceListener)object).writeString(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIPersistenceListener)object).writeArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIPersistenceListener)object).writeStringArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIPersistenceListener)object).readStringArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 15: {
                ((DSIPersistenceListener)object).getVisibleSystemLanguages((String)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIPersistenceListener)object).flushSQLDatabase(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIPersistenceListener)object).beginTransaction(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIPersistenceListener)object).endTransaction(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIPersistenceListener)object).updateActiveSQLDatabaseMedium(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIPersistenceListener)object).valueChangedInt(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 21: {
                ((DSIPersistenceListener)object).valueChangedString(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 22: {
                ((DSIPersistenceListener)object).valueChangedArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (int[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 23: {
                ((DSIPersistenceListener)object).valueChangedStringArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (String[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 24: {
                ((DSIPersistenceListener)object).valueChangedBuffer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (byte[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 25: {
                ((DSIPersistenceListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}


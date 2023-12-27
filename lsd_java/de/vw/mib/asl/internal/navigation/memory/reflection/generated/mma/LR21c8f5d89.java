/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.reflection.generated.mma;

import de.vw.mib.asl.internal.navigation.memory.search.StateMSAddSpellerChar;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSDeleteSpellerChar;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSInit;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSLastDestMemMode;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSMain;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.organizer.DataSet;

public final class LR21c8f5d89
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 889816265: {
                if (bl) {
                    if (n2 != -550871682) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1347938500: {
                if (bl) {
                    if (n2 != 1436671998) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1747869026: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 889816265: {
                if (bl) {
                    if (n2 != -550871682) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1347938500: {
                if (bl) {
                    if (n2 != 1436671998) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1747869026: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -530099032: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 889816265: {
                if (bl) {
                    if (n2 != -550871682) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1347938500: {
                if (bl) {
                    if (n2 != 1436671998) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1747869026: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 889816265: {
                if (bl) {
                    if (n2 != -550871682) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1347938500: {
                if (bl) {
                    if (n2 != 1436671998) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 889816265: {
                if (bl) {
                    if (n2 != -550871682) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 916038131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1347938500: {
                if (bl) {
                    if (n2 != 1436671998) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1747869026: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -1734965954: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1734859289: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case -1429626180: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case -580012456: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1802349436: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return ((StateMSAddSpellerChar)object).dsiAdbListStopSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 1: {
                return ((StateMSAddSpellerChar)object).dsiAdbListSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue(), (String)objectArray[4], (String)objectArray[5]);
            }
            case 2: {
                return ((StateMSAddSpellerChar)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
            }
            case 3: {
                return ((StateMSAddSpellerChar)object).dsiAdbListGetSpellerViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue());
            }
            case 4: {
                return ((StateMSDeleteSpellerChar)object).dsiAdbListStopSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 5: {
                return ((StateMSDeleteSpellerChar)object).dsiAdbListSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue(), (String)objectArray[4], (String)objectArray[5]);
            }
            case 6: {
                return ((StateMSDeleteSpellerChar)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
            }
            case 7: {
                return ((StateMSDeleteSpellerChar)object).dsiAdbListGetSpellerViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue());
            }
            case 8: {
                return ((StateMSInit)object).dsiAdbSetupUpdateAdbState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 9: {
                return ((StateMSInit)object).dsiAdbListStopSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 10: {
                return ((StateMSInit)object).dsiAdbListSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue(), (String)objectArray[4], (String)objectArray[5]);
            }
            case 11: {
                return ((StateMSInit)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
            }
            case 12: {
                return ((StateMSInit)object).dsiAdbListGetSpellerViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue());
            }
            case 13: {
                return ((StateMSLastDestMemMode)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
            }
            case 14: {
                return ((StateMSLastDestMemMode)object).dsiAdbListSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue(), (String)objectArray[4], (String)objectArray[5]);
            }
            case 15: {
                return ((StateMSLastDestMemMode)object).dsiAdbListGetSpellerViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue());
            }
            case 16: {
                return ((StateMSMain)object).dsiAdbListStopSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 17: {
                return ((StateMSMain)object).dsiAdbListInvalidData(((Number)objectArray[0]).intValue());
            }
            case 18: {
                return ((StateMSMain)object).dsiAdbListSpellerResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue(), (String)objectArray[4], (String)objectArray[5]);
            }
            case 19: {
                return ((StateMSMain)object).dsiAdbListGetSpellerViewWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataSet[])objectArray[2], ((Number)objectArray[3]).intValue());
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


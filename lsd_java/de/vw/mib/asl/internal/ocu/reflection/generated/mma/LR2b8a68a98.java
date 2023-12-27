/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.reflection.generated.mma;

import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.states.Initializing;
import de.vw.mib.asl.internal.ocu.common.states.VersionCheckState;
import de.vw.mib.asl.internal.ocu.common.states.WaitForFsgOperationState;
import de.vw.mib.asl.internal.ocu.common.states.WaitForLcuStartState;
import de.vw.mib.asl.internal.ocu.common.states.WaitForMiddlewareState;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR2b8a68a98
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2086321212: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1307748055: {
                if (bl) {
                    if (n2 != -1007383187) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1273258099: {
                if (bl) {
                    if (n2 != -687897344) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -251754282: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -238664506: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1003355883: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1095693572: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1150147384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1270073469: {
                if (bl) {
                    if (n2 != 235232405) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1279210286: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2086321212: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1307748055: {
                if (bl) {
                    if (n2 != -1007383187) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1273258099: {
                if (bl) {
                    if (n2 != -687897344) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -251754282: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -238664506: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1003355883: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1095693572: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1150147384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1270073469: {
                if (bl) {
                    if (n2 != 235232405) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1279210286: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1638047518: {
                if (bl) {
                    if (n2 != -1216294061) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2086321212: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1307748055: {
                if (bl) {
                    if (n2 != -1007383187) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1273258099: {
                if (bl) {
                    if (n2 != -687897344) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -251754282: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -238664506: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1003355883: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1095693572: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 1150147384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 1270073469: {
                if (bl) {
                    if (n2 != 235232405) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1279210286: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2086321212: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1273258099: {
                if (bl) {
                    if (n2 != -687897344) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -251754282: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -238664506: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1003355883: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1095693572: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1150147384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case 1279210286: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2086321212: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -1273258099: {
                if (bl) {
                    if (n2 != -687897344) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -251754282: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -238664506: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 346441700: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 1003355883: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 1095693572: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1150147384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1279210286: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
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
            case -1340083431: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 540033451: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 1214936909: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1240010795: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1314514192: {
                n2 = this.a2(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((Initializing)object).stateEntry();
                return null;
            }
            case 1: {
                ((Initializing)object).stateStart();
                return null;
            }
            case 2: {
                ((Initializing)object).stateExit();
                return null;
            }
            case 3: {
                ((Initializing)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((Initializing)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((Initializing)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 6: {
                ((Initializing)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((Initializing)object).bapValueChanged((BAPValueObserverable)objectArray[0], (BAPEntity)objectArray[1], (BAPEntity)objectArray[2], objectArray[3]);
                return null;
            }
            case 8: {
                ((Initializing)object).bapValueError((BAPValueObserverable)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 9: {
                ((Initializing)object).initialize();
                return null;
            }
            case 10: {
                ((Initializing)object).request(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 11: {
                ((Initializing)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 12: {
                ((Initializing)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((Initializing)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((Initializing)object).requestVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((Initializing)object).requestByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (byte[])objectArray[2]);
                return null;
            }
            case 16: {
                ((Initializing)object).requestError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((Initializing)object).getBAPState();
                return null;
            }
            case 18: {
                ((Initializing)object).setHMIState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((VersionCheckState)object).stateEntry();
                return null;
            }
            case 20: {
                ((VersionCheckState)object).stateStart();
                return null;
            }
            case 21: {
                ((VersionCheckState)object).stateExit();
                return null;
            }
            case 22: {
                ((VersionCheckState)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((VersionCheckState)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((VersionCheckState)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((VersionCheckState)object).bapValueChanged((BAPValueObserverable)objectArray[0], (BAPEntity)objectArray[1], (BAPEntity)objectArray[2], objectArray[3]);
                return null;
            }
            case 26: {
                ((VersionCheckState)object).bapValueError((BAPValueObserverable)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 27: {
                ((VersionCheckState)object).timerFired((Timer)objectArray[0]);
                return null;
            }
            case 28: {
                ((VersionCheckState)object).initialize();
                return null;
            }
            case 29: {
                ((VersionCheckState)object).request(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 30: {
                ((VersionCheckState)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 31: {
                ((VersionCheckState)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((VersionCheckState)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((VersionCheckState)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 34: {
                ((VersionCheckState)object).requestVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((VersionCheckState)object).requestByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (byte[])objectArray[2]);
                return null;
            }
            case 36: {
                ((VersionCheckState)object).requestError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((VersionCheckState)object).getBAPState();
                return null;
            }
            case 38: {
                ((VersionCheckState)object).setHMIState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 39: {
                ((WaitForFsgOperationState)object).stateEntry();
                return null;
            }
            case 40: {
                ((WaitForFsgOperationState)object).stateStart();
                return null;
            }
            case 41: {
                ((WaitForFsgOperationState)object).stateExit();
                return null;
            }
            case 42: {
                ((WaitForFsgOperationState)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((WaitForFsgOperationState)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 44: {
                ((WaitForFsgOperationState)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 45: {
                ((WaitForFsgOperationState)object).bapValueChanged((BAPValueObserverable)objectArray[0], (BAPEntity)objectArray[1], (BAPEntity)objectArray[2], objectArray[3]);
                return null;
            }
            case 46: {
                ((WaitForFsgOperationState)object).bapValueError((BAPValueObserverable)objectArray[0], ((Number)objectArray[1]).intValue(), objectArray[2]);
                return null;
            }
            case 47: {
                ((WaitForFsgOperationState)object).initialize();
                return null;
            }
            case 48: {
                ((WaitForFsgOperationState)object).request(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 49: {
                ((WaitForFsgOperationState)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 50: {
                ((WaitForFsgOperationState)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 51: {
                ((WaitForFsgOperationState)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 52: {
                ((WaitForFsgOperationState)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 53: {
                ((WaitForFsgOperationState)object).requestVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((WaitForFsgOperationState)object).requestByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (byte[])objectArray[2]);
                return null;
            }
            case 55: {
                ((WaitForFsgOperationState)object).requestError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((WaitForFsgOperationState)object).getBAPState();
                return null;
            }
            case 57: {
                ((WaitForFsgOperationState)object).setHMIState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 58: {
                ((WaitForLcuStartState)object).initialize();
                return null;
            }
            case 59: {
                ((WaitForLcuStartState)object).request(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 60: {
                ((WaitForLcuStartState)object).stateEntry();
                return null;
            }
            case 61: {
                ((WaitForLcuStartState)object).stateStart();
                return null;
            }
            case 62: {
                ((WaitForLcuStartState)object).stateExit();
                return null;
            }
            case 63: {
                ((WaitForLcuStartState)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((WaitForLcuStartState)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 65: {
                ((WaitForLcuStartState)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 66: {
                ((WaitForLcuStartState)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 67: {
                ((WaitForLcuStartState)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 68: {
                ((WaitForLcuStartState)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 69: {
                ((WaitForLcuStartState)object).requestVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((WaitForLcuStartState)object).requestByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (byte[])objectArray[2]);
                return null;
            }
            case 71: {
                ((WaitForLcuStartState)object).requestError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((WaitForLcuStartState)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((WaitForLcuStartState)object).getBAPState();
                return null;
            }
            case 74: {
                ((WaitForLcuStartState)object).setHMIState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 75: {
                ((WaitForMiddlewareState)object).request(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 76: {
                ((WaitForMiddlewareState)object).stateEntry();
                return null;
            }
            case 77: {
                ((WaitForMiddlewareState)object).stateStart();
                return null;
            }
            case 78: {
                ((WaitForMiddlewareState)object).stateExit();
                return null;
            }
            case 79: {
                ((WaitForMiddlewareState)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((WaitForMiddlewareState)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 81: {
                ((WaitForMiddlewareState)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 82: {
                ((WaitForMiddlewareState)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 83: {
                ((WaitForMiddlewareState)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 84: {
                ((WaitForMiddlewareState)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 85: {
                ((WaitForMiddlewareState)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 86: {
                ((WaitForMiddlewareState)object).requestVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((WaitForMiddlewareState)object).requestByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (byte[])objectArray[2]);
                return null;
            }
            case 88: {
                ((WaitForMiddlewareState)object).requestError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((WaitForMiddlewareState)object).initialize();
                return null;
            }
            case 90: {
                ((WaitForMiddlewareState)object).getBAPState();
                return null;
            }
            case 91: {
                ((WaitForMiddlewareState)object).setHMIState(((Number)objectArray[0]).intValue());
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}


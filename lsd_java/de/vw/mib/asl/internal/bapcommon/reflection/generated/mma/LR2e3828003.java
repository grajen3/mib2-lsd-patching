/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.bapcommon.reflection.generated.mma;

import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget;
import de.vw.mib.event.SystemEvent;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public final class LR2e3828003
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2044156407: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1949860573: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1730540603: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1561955110: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1302253218: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1249549802: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1205986570: {
                if (bl) {
                    if (n2 != 1160087040) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -881416589: {
                if (bl) {
                    if (n2 != 1679997669) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -504056290: {
                if (bl) {
                    if (n2 != -350933450) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -387560858: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -220168187: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -110075665: {
                if (bl) {
                    if (n2 != 2034582771) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 333470093: {
                if (bl) {
                    if (n2 != -2010296500) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 427178298: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 667458648: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 871091717: {
                if (bl) {
                    if (n2 != 565526649) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1516973686: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
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
            case -477986813: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((BAPDispatcherTarget)object).initialize((GenericEvents)objectArray[0], (EventFactory)objectArray[1]);
                return null;
            }
            case 1: {
                ((BAPDispatcherTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((BAPDispatcherTarget)object).registerLogicalControlUnits((ArrayList)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 3: {
                ((BAPDispatcherTarget)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((BAPDispatcherTarget)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((BAPDispatcherTarget)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 6: {
                ((BAPDispatcherTarget)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 7: {
                ((BAPDispatcherTarget)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((BAPDispatcherTarget)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((BAPDispatcherTarget)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((BAPDispatcherTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                return ((BAPDispatcherTarget)object).getServiceProvider();
            }
            case 12: {
                ((BAPDispatcherTarget)object).processStageOutputValue(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((BAPDispatcherTarget)object).processStageOutputValueWithThreadChange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((BAPDispatcherTarget)object).processDatapoolChange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((BAPDispatcherTarget)object).processDatapoolChangeWithThreadChange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((BAPDispatcherTarget)object).informThatAllBapDatapoolValuesAreValid(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((BAPDispatcherTarget)object).informHmiLanguageChange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((BAPDispatcherTarget)object).informPersistenceAvailability();
                return null;
            }
            case 19: {
                ((BAPDispatcherTarget)object).registerForPersistenceAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((BAPDispatcherTarget)object).transmitData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), objectArray[3]);
                return null;
            }
            case 21: {
                ((BAPDispatcherTarget)object).uninitialize(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                return RuntimeUtil.valueOf(((BAPDispatcherTarget)object).consumeEvent((SystemEvent)objectArray[0]));
            }
            case 23: {
                ((BAPDispatcherTarget)object).observeHMIEvents(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (int[])objectArray[2]);
                return null;
            }
            case 24: {
                return ((BAPDispatcherTarget)object).createTimer((TimerNotifier)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).longValue());
            }
            case 25: {
                return ((BAPDispatcherTarget)object).getLogicalControlUnit(((Number)objectArray[0]).intValue());
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


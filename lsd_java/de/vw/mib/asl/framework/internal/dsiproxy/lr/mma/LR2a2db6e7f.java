/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;
import org.dsi.ifc.modelapi.DSIModelAPI;
import org.dsi.ifc.modelapi.ListRowData;
import org.dsi.ifc.modelapi.NBestResultEntry;

public final class LR2a2db6e7f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2057306567: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -2017456400: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -2004202581: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1981759805: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1694719012: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1669184101: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1561500323: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1491441527: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1339650588: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1224958119: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1162471198: {
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
            case -1021120488: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -969752939: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 37;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 38;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 39;
                    break;
                }
                n3 = 37;
                break;
            }
            case -636711364: {
                if (bl) {
                    if (n2 != -1612125681) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -451456028: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -142779967: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -100992196: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 341885836: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 491122624: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 591925085: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 602263304: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 660803195: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 683657549: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 983198117: {
                if (bl) {
                    if (n2 != 305244040) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1028311690: {
                if (bl) {
                    if (n2 != 284847587) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1166429869: {
                if (bl) {
                    if (n2 != -745719908) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1177050460: {
                if (bl) {
                    if (n2 != -1529287658) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1417435045: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1695482529: {
                if (bl) {
                    if (n2 != -1621617783) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1820004675: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1848359131: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1903568226: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1940803682: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 2068061847: {
                if (bl) {
                    if (n2 != 1516286462) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 2097692019: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
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
                        n3 = 45;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 46;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 47;
                    break;
                }
                n3 = 45;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 48;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 49;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 50;
                    break;
                }
                n3 = 48;
                break;
            }
            case -553805504: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -14601000: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 342199185: {
                if (bl) {
                    if (n2 != 539566029) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 824439964: {
                if (bl) {
                    if (n2 != -54730077) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1052985407: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
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
            case -1915877361: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 605308617: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIModelAPI)object).popupRemoved(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIModelAPI)object).hmiState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIModelAPI)object).keyTyped(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIModelAPI)object).increment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIModelAPI)object).decrement(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIModelAPI)object).textChanged(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 6: {
                ((DSIModelAPI)object).itemSelected(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 7: {
                ((DSIModelAPI)object).itemFocused(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 8: {
                ((DSIModelAPI)object).itemDrag(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).longValue());
                return null;
            }
            case 9: {
                ((DSIModelAPI)object).itemSelectedColumn(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIModelAPI)object).fillListBufferAtStart(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIModelAPI)object).fillListBufferAtEnd(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIModelAPI)object).textChangedFreeTextSpeller(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], (String)objectArray[3], (String)objectArray[4]);
                return null;
            }
            case 13: {
                ((DSIModelAPI)object).screenHidden(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIModelAPI)object).screenVisible(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIModelAPI)object).touchPadMovement(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIModelAPI)object).validateCharacters(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIModelAPI)object).touchScreenPressed(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIModelAPI)object).touchScreenLongPressed(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIModelAPI)object).touchScreenMoved(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 20: {
                ((DSIModelAPI)object).touchScreenReleased(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSIModelAPI)object).touchScreenZoom(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 22: {
                ((DSIModelAPI)object).inputModeChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIModelAPI)object).sdsSessionEnded();
                return null;
            }
            case 24: {
                ((DSIModelAPI)object).sdsSessionStarted();
                return null;
            }
            case 25: {
                ((DSIModelAPI)object).sdsRuleFired(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIModelAPI)object).sdsRuleFiredNBest(((Number)objectArray[0]).intValue(), (NBestResultEntry)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIModelAPI)object).sdsRuleFiredOneShot(((Number)objectArray[0]).intValue(), (NBestResultEntry[])objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIModelAPI)object).sdsPromptFinished();
                return null;
            }
            case 29: {
                ((DSIModelAPI)object).listDataChanged(((Number)objectArray[0]).intValue(), (ListRowData[])objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIModelAPI)object).setPOIViewPortData(((Number)objectArray[0]).intValue(), (ListRowData[])objectArray[1], ((Number)objectArray[2]).intValue(), (double[])objectArray[3]);
                return null;
            }
            case 31: {
                ((DSIModelAPI)object).addSpellerStroke(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIModelAPI)object).getValidHanziCharsWindow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((DSIModelAPI)object).responseStateMachineControl();
                return null;
            }
            case 34: {
                ((DSIModelAPI)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSIModelAPI)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 36: {
                ((DSIModelAPI)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIModelAPI)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSIModelAPI)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSIModelAPI)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSIMobilityHorizon)object).setConsumptionInfo((ConsumptionInfo[])objectArray[0]);
                return null;
            }
            case 41: {
                ((DSIMobilityHorizon)object).setLocations((MobilityHorizonLocation[])objectArray[0]);
                return null;
            }
            case 42: {
                ((DSIMobilityHorizon)object).setConsideredLocationTypes((int[])objectArray[0]);
                return null;
            }
            case 43: {
                ((DSIMobilityHorizon)object).setDriveTrainMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIMobilityHorizon)object).requestLocationRangeLevel(((Number)objectArray[0]).intValue());
                return null;
            }
            case 45: {
                ((DSIMobilityHorizon)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 46: {
                ((DSIMobilityHorizon)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 47: {
                ((DSIMobilityHorizon)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSIMobilityHorizon)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSIMobilityHorizon)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 50: {
                ((DSIMobilityHorizon)object).clearNotification((DSIListener)objectArray[0]);
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


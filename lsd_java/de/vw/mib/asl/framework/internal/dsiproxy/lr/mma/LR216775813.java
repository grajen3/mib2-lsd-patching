/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.DSITmcOnRouteListener;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tollcollect.DSITollCollectListener;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public final class LR216775813
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1700627950: {
                if (bl) {
                    if (n2 != -1666704538) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1651758405: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1357970021: {
                if (bl) {
                    if (n2 != -1559756288) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1239271876: {
                if (bl) {
                    if (n2 != -1017431296) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1122686092: {
                if (bl) {
                    if (n2 != -1559756288) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -241864631: {
                if (bl) {
                    if (n2 != 2010712203) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -183116981: {
                if (bl) {
                    if (n2 != 2010712203) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 921978831: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 999542703: {
                if (bl) {
                    if (n2 != 896829670) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1017054851: {
                if (bl) {
                    if (n2 != 551617679) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1572871675: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 2026046057: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2063673072: {
                if (bl) {
                    if (n2 != -262260825) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -2020227891: {
                if (bl) {
                    if (n2 != 1096472403) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -93796777: {
                if (bl) {
                    if (n2 != -1025628275) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 746336944: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 936414340: {
                if (bl) {
                    if (n2 != 2029214372) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 949387021: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1157973040: {
                if (bl) {
                    if (n2 != 1831678472) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1996149338: {
                if (bl) {
                    if (n2 != 239822588) break;
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
            case -1427975933: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1672422681: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITmcOnRouteListener)object).updateTmcMessagesAhead((TmcMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSITmcOnRouteListener)object).updateUrgentMessages((TmcMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITmcOnRouteListener)object).tmcMessage((TmcMessage)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSITmcOnRouteListener)object).updateTmcMessagesAheadCalculationHorizon(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSITmcOnRouteListener)object).setTmcWarningModeResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSITmcOnRouteListener)object).updateCurrentlyBlockedTMCMessages((long[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSITmcOnRouteListener)object).blockTMCMessagesResult((long[])objectArray[0], (long[])objectArray[1]);
                return null;
            }
            case 7: {
                ((DSITmcOnRouteListener)object).unblockTMCMessagesResult((long[])objectArray[0], (long[])objectArray[1]);
                return null;
            }
            case 8: {
                ((DSITmcOnRouteListener)object).unblockAllTMCMessagesResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSITmcOnRouteListener)object).updateNaviCoreAvailableToChangeTMCBlockings(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSITmcOnRouteListener)object).indicateTrafficEventNoticeMap((TmcMessage)objectArray[0], (NavRectangle)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSITmcOnRouteListener)object).updateSpeedAndFlowAhead((SpeedAndFlowSegment[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSITmcOnRouteListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSITollCollectListener)object).setLanguageResponse((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSITollCollectListener)object).updateCardState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSITollCollectListener)object).updateCardError((TCCardError)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSITollCollectListener)object).updateCardDateInformation((TCCardDateInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSITollCollectListener)object).updateHardwareInformation((TCHardwareInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSITollCollectListener)object).updateCurrentTollPayment((NavPriceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSITollCollectListener)object).requestPaymentHistoryListResult((TCPaymentInfo[])objectArray[0]);
                return null;
            }
            case 20: {
                ((DSITollCollectListener)object).requestPaymentHistoryDetailsResult(((Number)objectArray[0]).intValue(), (TCPaymentInfoDetails)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSITollCollectListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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


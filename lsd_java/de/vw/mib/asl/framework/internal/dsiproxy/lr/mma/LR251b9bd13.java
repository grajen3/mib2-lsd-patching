/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.startup.DSIStartupListener;
import org.dsi.ifc.swap.ConfigInfo;
import org.dsi.ifc.swap.DSISWaPListener;
import org.dsi.ifc.swap.SFscDetails;
import org.dsi.ifc.swap.SFscHistory;
import org.dsi.ifc.swap.SFscImportStatus;
import org.dsi.ifc.swap.SFscStatus;

public final class LR251b9bd13
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2049526498: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -2015318297: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1871153572: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1819506612: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1815747490: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1815418463: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1811666100: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1808901030: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1806030364: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1801950224: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1713987986: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1243429212: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1062689517: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1056638838: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1056628263: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1056624392: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1056624348: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -934829837: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -535753562: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -453868599: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -327392109: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -312609421: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -154389002: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -153559581: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -69681604: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 25787845: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 317430622: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 592068365: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 679157763: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 687884306: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 915905465: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 946850157: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1604106498: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1604375862: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1604381216: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1671897047: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1769205867: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1994602043: {
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
            case -2073705376: {
                if (bl) {
                    if (n2 != 377723601) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1414478618: {
                if (bl) {
                    if (n2 != -14666978) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1381433595: {
                if (bl) {
                    if (n2 != -1432102577) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1195649762: {
                if (bl) {
                    if (n2 != -1724086207) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1148422958: {
                if (bl) {
                    if (n2 != -1724086207) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -889152623: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -377407714: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -317485799: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -288495471: {
                if (bl) {
                    if (n2 != -1557157188) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 345387547: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 351986678: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 422372901: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 492757365: {
                if (bl) {
                    if (n2 != -371136565) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 566684069: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 1437295349: {
                if (bl) {
                    if (n2 != 151566222) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1506460799: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1963795155: {
                if (bl) {
                    if (n2 != 1360239352) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 2101565935: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 2124819895: {
                if (bl) {
                    if (n2 != 602714922) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
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
            case -300668701: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -70896511: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIStartupListener)object).startDomain(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIStartupListener)object).updateDomainStatusRoot(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIStartupListener)object).updateDomainStatusTuner(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIStartupListener)object).updateDomainStatusMedia(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIStartupListener)object).updateDomainStatusAddressbook(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIStartupListener)object).updateDomainStatusPhone(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIStartupListener)object).updateDomainStatusNav(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIStartupListener)object).updateDomainStatusInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIStartupListener)object).updateDomainStatusCar(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIStartupListener)object).updateDomainStatusAudio(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIStartupListener)object).updateDomainStatusSDS(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIStartupListener)object).updateDomainStatusSWDL(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIStartupListener)object).updateDomainStatusEarlyApps(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIStartupListener)object).updateDomainStatusPostStartup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIStartupListener)object).updateDomainStatusCommunication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIStartupListener)object).updateDomainStatusIpServices(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIStartupListener)object).updateDomainStatusGEMMI(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIStartupListener)object).updateDomainStatusBapkombi(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIStartupListener)object).updateDomainStatusBluetooth(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIStartupListener)object).updateDomainStatusBrowser(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIStartupListener)object).updateDomainStatusExplorer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIStartupListener)object).updateDomainStatusCalendar(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIStartupListener)object).updateDomainStatusPictureStore(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIStartupListener)object).updateDomainStatusStreetView(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIStartupListener)object).updateDomainStatusMobilityHorizon(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIStartupListener)object).updateDomainStatusExBoxM(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIStartupListener)object).updateDomainStatusMirrorLink(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIStartupListener)object).updateDomainStatusSFA(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIStartupListener)object).updateDomainStatusSearch(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIStartupListener)object).updateDomainStatusDiagnosis(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIStartupListener)object).updateDomainStatusAsiaLanguageSupport(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIStartupListener)object).updateDomainStatusExLAP(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIStartupListener)object).updateDomainStatusTVTuner(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSIStartupListener)object).updateDomainStatusMediaOnline(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSIStartupListener)object).updateDomainStatusMediaRouter(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIStartupListener)object).updateDomainStatusRadioDataServer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSIStartupListener)object).updateDomainStatusSmartphoneIntegration(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSIStartupListener)object).updateDomainStatusWirelessCharger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIStartupListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 39: {
                ((DSISWaPListener)object).getPublicKey((short[])objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 40: {
                ((DSISWaPListener)object).getHistory((SFscHistory)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSISWaPListener)object).importFSCs(((Number)objectArray[0]).intValue(), (SFscImportStatus)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSISWaPListener)object).encryptFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSISWaPListener)object).checkSignature((Boolean)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 44: {
                ((DSISWaPListener)object).checkSingleFsc(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSISWaPListener)object).decryptFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSISWaPListener)object).exportCCD(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSISWaPListener)object).getHistoryList((SFscHistory[])objectArray[0]);
                return null;
            }
            case 48: {
                ((DSISWaPListener)object).updateSoftwareEnabling((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSISWaPListener)object).updateIllegalFSCs((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSISWaPListener)object).updateAreFSCsSigned((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSISWaPListener)object).updateLimitedLifetime((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSISWaPListener)object).updateConfigCheck((ConfigInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSISWaPListener)object).updateConfigPrepare((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSISWaPListener)object).updateConfigFinalize((ConfigInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSISWaPListener)object).updateFscList((SFscStatus[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSISWaPListener)object).getFscDetail((SFscDetails)objectArray[0]);
                return null;
            }
            case 57: {
                ((DSISWaPListener)object).importFSCsList(((Number)objectArray[0]).intValue(), (SFscImportStatus[])objectArray[1]);
                return null;
            }
            case 58: {
                ((DSISWaPListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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


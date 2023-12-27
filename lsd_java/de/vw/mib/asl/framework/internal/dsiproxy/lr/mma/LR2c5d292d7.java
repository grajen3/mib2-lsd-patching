/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public final class LR2c5d292d7
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1955411721: {
                if (bl) {
                    if (n2 != 371672439) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1485243971: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 341407623: {
                if (bl) {
                    if (n2 != -1788336694) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1067507717: {
                if (bl) {
                    if (n2 != -557795602) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2116536790: {
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
            case -1805375723: {
                if (bl) {
                    if (n2 != 157363125) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1717626132: {
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
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1430100884: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1264686979: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1190354646: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -715942645: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -295984300: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -8234246: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 78376899: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 129433667: {
                if (bl) {
                    if (n2 != 1775039192) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 318518408: {
                if (bl) {
                    if (n2 != -1335562314) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1006253938: {
                if (bl) {
                    if (n2 != 650376921) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1220168752: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1274757618: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1579354662: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1610385979: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1638686872: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1963775000: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1979196347: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1993000990: {
                if (bl) {
                    if (n2 != -1433648127) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 2055246440: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
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
            case -1898271817: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 141004977: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIDataConnectionListener)object).updateRoamingState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIDataConnectionListener)object).updateStateDataConnection((DataConnectionStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIDataConnectionListener)object).updateConnectionStateInformation((ConnectionStateInformationStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIDataConnectionListener)object).updateErrorState((ApplicationErrorStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIDataConnectionListener)object).forceDisconnectResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIDataConnectionListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIWLANListener)object).updateRole(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIWLANListener)object).updateRFActive(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIWLANListener)object).updateNodeList((Node[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIWLANListener)object).updateProfile((Profile)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIWLANListener)object).updateWlanEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIWLANListener)object).updateStartupState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIWLANListener)object).updateTrustedNetworks((String[])objectArray[0], (String[])objectArray[1], (int[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 13: {
                ((DSIWLANListener)object).updateDiscoveredNetwork((DiscoveredNetwork)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIWLANListener)object).updateConnectedNetwork((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 15: {
                ((DSIWLANListener)object).responseFactoryReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIWLANListener)object).responseSetRole(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIWLANListener)object).responseSetRFActive(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIWLANListener)object).responseSetProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIWLANListener)object).responseNetworkSearch(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIWLANListener)object).responseAbortSearch(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIWLANListener)object).responseConnectNetwork((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 22: {
                ((DSIWLANListener)object).responseDisconnectNetwork((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((DSIWLANListener)object).responseDeleteTrustedNetwork((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((DSIWLANListener)object).responseActivateWps(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIWLANListener)object).updateWPSRunning(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIWLANListener)object).updateWPSStoppedAndConnecting((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 27: {
                ((DSIWLANListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.reflection.generated.mma;

import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapParentState;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapStateActive;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapStateNotActive;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public final class LR2adf78408
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2138113217: {
                if (bl) {
                    if (n2 != -798997638) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1560251870: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1309221021: {
                if (bl) {
                    if (n2 != -721724903) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -425677767: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 784351054: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1186744010: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1543889018: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1988585600: {
                if (bl) {
                    if (n2 != 1497062907) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1488161510: {
                if (bl) {
                    if (n2 != -1848896417) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 773487453: {
                if (bl) {
                    if (n2 != 1540874370) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1928989099: {
                if (bl) {
                    if (n2 != -1427738526) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1988585600: {
                if (bl) {
                    if (n2 != 1497062907) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1488161510: {
                if (bl) {
                    if (n2 != -1848896417) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 773487453: {
                if (bl) {
                    if (n2 != 1540874370) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1928989099: {
                if (bl) {
                    if (n2 != -1427738526) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
            case -111280215: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 231990969: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1096751424: {
                n2 = this.a2(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuUpdatePrefecture((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuUpdateProbeDataSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuUpdateFrequency(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuUpdateReceptionDate((DateTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuUpdateReceivableStations((TunerData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuSetLanguageResponse((Boolean)objectArray[0]);
                return null;
            }
            case 6: {
                ((TrafficMiniMapParentState)object).dsiAsiaTrafficInfoMenuAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((TrafficMiniMapStateActive)object).dsiAsiaTrafficInfoMenuUpdateActiveInterrupts((Interrupt[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((TrafficMiniMapStateActive)object).dsiAsiaTrafficInfoMenuUpdateTrafficType((TrafficInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((TrafficMiniMapStateActive)object).dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(((Number)objectArray[0]).intValue(), (ResourceInformation)objectArray[1]);
                return null;
            }
            case 10: {
                ((TrafficMiniMapStateActive)object).dsiAsiaTrafficInfoMenuRequestTrafficInformationDetailsResponse(((Number)objectArray[0]).intValue(), (TrafficInformationDetails[])objectArray[1]);
                return null;
            }
            case 11: {
                ((TrafficMiniMapStateNotActive)object).dsiAsiaTrafficInfoMenuUpdateActiveInterrupts((Interrupt[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((TrafficMiniMapStateNotActive)object).dsiAsiaTrafficInfoMenuUpdateTrafficType((TrafficInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((TrafficMiniMapStateNotActive)object).dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(((Number)objectArray[0]).intValue(), (ResourceInformation)objectArray[1]);
                return null;
            }
            case 14: {
                ((TrafficMiniMapStateNotActive)object).dsiAsiaTrafficInfoMenuRequestTrafficInformationDetailsResponse(((Number)objectArray[0]).intValue(), (TrafficInformationDetails[])objectArray[1]);
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.global.DateTime;

public final class LR2b5619a40
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2061968180: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
            case -1185815333: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1091417310: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -326912503: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 281221090: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 723666299: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1124634453: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1286327029: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1653082089: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -1792892204: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1749628087: {
                if (bl) {
                    if (n2 != -721724903) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -1618004134: {
                if (bl) {
                    if (n2 != 1497062907) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1614546419: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -529975436: {
                if (bl) {
                    if (n2 != -1848896417) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -444297447: {
                if (bl) {
                    if (n2 != -798997638) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 118756613: {
                if (bl) {
                    if (n2 != -1427738526) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 746336944: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1135493384: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1519397059: {
                if (bl) {
                    if (n2 != 1540874370) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1538046483: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
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
            case -1006823133: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1640823462: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAudioManagementListener)object).errorConnection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSIAudioManagementListener)object).fadedIn(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIAudioManagementListener)object).pauseConnection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIAudioManagementListener)object).updateActiveConnection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIAudioManagementListener)object).updateActiveEntertainmentConnection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIAudioManagementListener)object).startConnection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIAudioManagementListener)object).stopConnection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIAudioManagementListener)object).updateAMAvailable(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIAudioManagementListener)object).responseVolumelock(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 9: {
                ((DSIAudioManagementListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateActiveInterrupts((Interrupt[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateTrafficType((TrafficInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIAsiaTrafficInfoMenuListener)object).updatePrefecture((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateProbeDataSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateFrequency(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateReceptionStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateReceptionDate((DateTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIAsiaTrafficInfoMenuListener)object).requestResourceInformationResponse(((Number)objectArray[0]).intValue(), (ResourceInformation)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIAsiaTrafficInfoMenuListener)object).requestTrafficInformationDetailsResponse(((Number)objectArray[0]).intValue(), (TrafficInformationDetails[])objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIAsiaTrafficInfoMenuListener)object).updateReceivableStations((TunerData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIAsiaTrafficInfoMenuListener)object).setLanguageResponse((Boolean)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIAsiaTrafficInfoMenuListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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


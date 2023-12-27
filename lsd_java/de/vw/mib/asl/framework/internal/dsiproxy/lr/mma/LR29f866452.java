/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.DSIIconExtractorListener;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorderListener;

public final class LR29f866452
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2033633656: {
                if (bl) {
                    if (n2 != -748995840) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
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
            case -2061331411: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1931304851: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1409738139: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1306899453: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1087488700: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1072985001: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -850787404: {
                if (bl) {
                    if (n2 != 461999728) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -761467371: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -539429781: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -448927240: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -67007770: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 11144634: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 25448117: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 158279157: {
                if (bl) {
                    if (n2 != 461999728) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 914477695: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1077632163: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1698568951: {
                if (bl) {
                    if (n2 != 461999728) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 2102754590: {
                if (bl) {
                    if (n2 != -1202513960) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
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
            case -390627597: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1127614020: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIInfotainmentRecorderListener)object).updateEnabledTriggers((boolean[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIInfotainmentRecorderListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIIconExtractorListener)object).resourceIdForTMCEventIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIIconExtractorListener)object).resourceIdForPOIIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIIconExtractorListener)object).renderingInformationForRoadIcon((ResourceLocator)objectArray[0], (TextRenderingInfo)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIIconExtractorListener)object).resourceIdForTargetIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIIconExtractorListener)object).resourceIdForRoadClassIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIIconExtractorListener)object).resourceIdForTrafficRegulationIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIIconExtractorListener)object).renderingInformationForExitIcon((ResourceLocator)objectArray[0], (TextRenderingInfo)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIIconExtractorListener)object).resourceIdForAdditionalIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIIconExtractorListener)object).resourceIdForCountryIcon((ResourceLocator)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIIconExtractorListener)object).renderingInformationForExitIconWithVariant((ResourceLocator)objectArray[0], (TextRenderingInfo)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIIconExtractorListener)object).iconResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIIconExtractorListener)object).resourceIdForTrafficRegulationIconWithSubIndex((ResourceLocator)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIIconExtractorListener)object).setBrandIconStyleResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIIconExtractorListener)object).resourceIdForTrafficSourceIconResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIIconExtractorListener)object).resourceIdForAreaWarningIconResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIIconExtractorListener)object).resourceIdForAdditionalTurnListIconResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIIconExtractorListener)object).resourceIdForComposedPOIIconResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIIconExtractorListener)object).resourceIdForPOIIconFromRawDataResult((ResourceLocator)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIIconExtractorListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.DSITPEGServicesListener;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;
import org.dsi.ifc.trafficregulation.DSITrafficRegulationListener;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public final class LR23178c94d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -980572367: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -338175681: {
                if (bl) {
                    if (n2 != -207367584) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 200833415: {
                if (bl) {
                    if (n2 != -200198824) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 969046731: {
                if (bl) {
                    if (n2 != -200198824) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1630851086: {
                if (bl) {
                    if (n2 != -1243969024) break;
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
            case -1948039296: {
                if (bl) {
                    if (n2 != 912445903) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1533803121: {
                if (bl) {
                    if (n2 != -1717055975) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1364350206: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1213847904: {
                if (bl) {
                    if (n2 != -218740935) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1107519724: {
                if (bl) {
                    if (n2 != -2012328694) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -967184091: {
                if (bl) {
                    if (n2 != 718986701) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 96962087: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 118756613: {
                if (bl) {
                    if (n2 != 313129090) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 746336944: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1803263601: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1860998491: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2043300350: {
                if (bl) {
                    if (n2 != 1558953715) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case 109431683: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1760677779: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSITrafficRegulationListener)object).updateCountrySpeedInformation((RoadClassSpeedInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSITrafficRegulationListener)object).updateCurrentTrafficSign((TrafficSignInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSITrafficRegulationListener)object).updateTrafficSignOnRoute((TrafficSignInformationOnRoute[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSITrafficRegulationListener)object).requestRoadClassSpeedInfoForCountryResult((RoadClassSpeedInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSITrafficRegulationListener)object).updateTrailerStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSITrafficRegulationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSITPEGServicesListener)object).requestResourceInformationResponse(((Number)objectArray[0]).intValue(), (ResourceInformation)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSITPEGServicesListener)object).setLanguageResponse((Boolean)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSITPEGServicesListener)object).updateTPEGContentAvailability((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSITPEGServicesListener)object).updateSimpleMapsBookmarks((SimpleMapData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSITPEGServicesListener)object).requestLocationDetailsResponse((NavLocation)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSITPEGServicesListener)object).requestFuelPriceInformationResponse((FuelPriceInformation[])objectArray[0]);
                return null;
            }
            case 12: {
                ((DSITPEGServicesListener)object).requestNewsInformationResponse((NewsCategory)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSITPEGServicesListener)object).requestSimpleMapListResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (SimpleMapData[])objectArray[2]);
                return null;
            }
            case 14: {
                ((DSITPEGServicesListener)object).addSimpleMapBookmarkResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSITPEGServicesListener)object).deleteSimpleMapBookmarkResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSITPEGServicesListener)object).deleteAllSimpleMapBookmarksResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSITPEGServicesListener)object).requestWeatherInfoResult((WeatherInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSITPEGServicesListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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


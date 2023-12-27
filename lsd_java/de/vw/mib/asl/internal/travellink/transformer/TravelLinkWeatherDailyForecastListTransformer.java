/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkWeatherDailyForecastListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkWeatherDailyForecastListTransformer
extends AbstractTravelLinkWeatherDailyForecastListTransformer {
    final int fixFormatterOffset;

    public TravelLinkWeatherDailyForecastListTransformer() {
        this.fixFormatterOffset = 10;
    }

    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 2: {
                int n2 = GenericPropertyUtility.getInt(-1978006016, 0, genericPropertyContainer);
                return n2;
            }
            case 5: {
                int n3 = GenericPropertyUtility.getInt(-2095446528, 0, genericPropertyContainer);
                if (n3 >= 0 && n3 <= 59) {
                    return n3;
                }
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Weather condition not in range. Expected values are from 0 to 59. But the received value is ").append(n3).log();
                }
                return 0;
            }
            case 8: {
                return GenericPropertyUtility.getInt(-2137614336, 0, genericPropertyContainer);
            }
            case 9: {
                return GenericPropertyUtility.getInt(-2104059904, 0, genericPropertyContainer);
            }
            case 10: {
                return GenericPropertyUtility.getInt(-2120837120, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 13: {
                int n2 = GenericPropertyUtility.getInt(-2045114880, 0, genericPropertyContainer);
                String string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n2, true);
                return string;
            }
            case 14: {
                int n3 = GenericPropertyUtility.getInt(-2028337664, 0, genericPropertyContainer);
                String string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n3, true);
                return string;
            }
            case 15: {
                int n4 = GenericPropertyUtility.getInt(-1978006016, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPrecipitationProbability(n4, true);
            }
        }
        throw new IllegalArgumentException();
    }
}


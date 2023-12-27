/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkWeatherHourlyForecastListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkWeatherHourlyForecastListTransformer
extends AbstractTravelLinkWeatherHourlyForecastListTransformer {
    final int fixFormatterOffset;

    public TravelLinkWeatherHourlyForecastListTransformer() {
        this.fixFormatterOffset = 10;
    }

    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return GenericPropertyUtility.getInt(-1978006016, 0, genericPropertyContainer);
            }
            case 5: {
                int n2 = GenericPropertyUtility.getInt(-2095446528, 0, genericPropertyContainer);
                if (n2 >= 0 && n2 <= 59) {
                    return n2;
                }
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Weather condition not in range. Expected values are from 0 to 59. But the received value is ").append(n2).log();
                }
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 7: {
                int n2 = GenericPropertyUtility.getInt(-2011560448, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n2, true);
            }
            case 8: {
                int n3 = GenericPropertyUtility.getInt(-1978006016, 0, genericPropertyContainer);
                return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPrecipitationProbability(n3, true);
            }
        }
        throw new IllegalArgumentException();
    }
}


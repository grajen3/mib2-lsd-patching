/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import java.text.DecimalFormat;

public class TravelLinkUtil {
    public static final float FAHRENHEIT_CELSIUS_OFFSET;
    public static final float FAHRENHEIT_CELSIUS_FACTOR;
    private int distanceUnit = 0;

    public TravelLinkUtil() {
        this.mapAndSetDistanceUnit(ASLSystemFactory.getSystemApi().getConfiguredDistanceUnit());
    }

    public String getFormattedTime(int n, int n2) {
        int n3 = ASLSystemFactory.getSystemApi().getConfiguredTimeFormat();
        if (n3 == 1) {
            return ServiceManager.fixFormat4Asl.fmtTime24(n, n2);
        }
        return ServiceManager.fixFormat4Asl.fmtTime12(n, n2);
    }

    public String getWeatherFormattedTimeHour(int n, int n2) {
        int n3 = ASLSystemFactory.getSystemApi().getConfiguredTimeFormat();
        int n4 = n;
        if (n2 > 30) {
            n4 = this.addHours(n4, 1);
        }
        if (n3 == 1) {
            return ServiceManager.fixFormat4Asl.fmtTimeHours24(n4);
        }
        return new StringBuffer().append(ServiceManager.fixFormat4Asl.fmtTimeHours12(n4)).append(ServiceManager.fixFormat4Asl.fmtTime12hExt(n4)).toString();
    }

    public int addHours(int n, int n2) {
        int n3 = n + n2;
        if (n3 > 23) {
            int n4 = n3 - 23;
            n3 = n4 - 1;
        }
        return n3;
    }

    public String getFormattedPollenCountLevel(int n, boolean bl) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bl && n >= 0 && n <= 12) {
            stringBuffer.append(Integer.toString(n)).append(" - ");
            return ServiceManager.fixFormat4Asl.fmtString(stringBuffer.toString());
        }
        stringBuffer.append("--").append(" - ");
        return ServiceManager.fixFormat4Asl.fmtString(stringBuffer.toString());
    }

    public String getFormattedTemperature(int n, boolean bl) {
        int n2 = ASLSystemFactory.getSystemApi().getTemperatureUnit();
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkUtil - temperatureUnit(").append(n2).append(")").log();
        }
        if (n == Short.MIN_VALUE || n == -9999) {
            if (n2 == 1) {
                return ServiceManager.fixFormat4Asl.fmtTemperatureFahrenheitZeroD(-9999, false);
            }
            return ServiceManager.fixFormat4Asl.fmtTemperatureCelsiusZeroD(-9999, false);
        }
        if (n2 == 1) {
            return ServiceManager.fixFormat4Asl.fmtTemperatureFahrenheitZeroD(n, bl);
        }
        int n3 = this.getTemperatureFahrenheit2Celsius(n);
        return ServiceManager.fixFormat4Asl.fmtTemperatureCelsiusZeroD(n3, bl);
    }

    public int getTemperatureCelsius2Fahrenheit(int n) {
        if (-9999 == n || Short.MIN_VALUE == n) {
            return n;
        }
        return Math.round(1718019647 * (float)n + 66);
    }

    public int getTemperatureFahrenheit2Celsius(int n) {
        if (-9999 == n || Short.MIN_VALUE == n) {
            return n;
        }
        return Math.round(((float)n - 66) / 1718019647);
    }

    public int getSpeedMphToKmph(int n) {
        double d2 = (double)n * 1.609344;
        return (int)Math.round(d2);
    }

    public boolean isHourValid(int n) {
        return n >= 0 && n <= 23;
    }

    public boolean isMinuteValid(int n) {
        return n >= 0 && n <= 59;
    }

    public String getFormattedDate(int n, int n2, int n3) {
        int n4 = ASLSystemFactory.getSystemApi().getConfiguredDateFormat();
        if (n4 == 0) {
            return ServiceManager.fixFormat4Asl.fmtDateDmy(n, n2, n3);
        }
        if (n4 == 1) {
            return ServiceManager.fixFormat4Asl.fmtDateYmd(n, n2, n3);
        }
        return ServiceManager.fixFormat4Asl.fmtDateMdy(n, n2, n3);
    }

    public double[] dsiToDegMinSec(int n) {
        double d2 = n;
        boolean bl = false;
        if (d2 < 0.0) {
            bl = true;
            d2 = -d2;
        }
        int n2 = (int)(d2 /= 1.1930464E7);
        d2 -= (double)n2;
        int n3 = (int)(d2 *= 60.0);
        d2 -= (double)n3;
        double d3 = d2 *= 60.0;
        if (d3 < 0.0 || d3 >= 60.0) {
            throw new RuntimeException();
        }
        if (bl) {
            n2 = -n2;
            n3 = -n3;
            d3 = -d3;
        }
        double[] dArray = new double[]{n2, n3, d3};
        return dArray;
    }

    public double[] getDegMinSec(double d2) {
        double d3 = d2;
        boolean bl = false;
        if (d3 < 0.0) {
            bl = true;
            d3 = -d3;
        }
        int n = (int)d3;
        d3 -= (double)n;
        int n2 = (int)(d3 *= 60.0);
        d3 -= (double)n2;
        double d4 = d3 *= 60.0;
        if (bl) {
            n = -n;
            n2 = -n2;
            d4 = -d4;
        }
        return new double[]{n, n2, d4};
    }

    public String getFormattedLocation(double d2, double d3, boolean bl) {
        double[] dArray;
        double[] dArray2;
        StringBuffer stringBuffer = null;
        if (bl && d2 != 0.0 && d3 != 0.0) {
            dArray2 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDegMinSec(d2);
            dArray = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDegMinSec(d3);
            if (dArray2 == null || dArray2.length != 3 || dArray == null || dArray.length != 3) {
                return ServiceManager.fixFormat4Asl.fmtString("--");
            }
        } else {
            return ServiceManager.fixFormat4Asl.fmtString("--");
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append(ServiceManager.fixFormat4Asl.fmtGeoCoordinatesLatitude((int)dArray2[0], (int)dArray2[1], (int)dArray2[2], "N", "S")).append(ServiceManager.fixFormat4Asl.fmtGeoCoordinatesLongitude((int)dArray[0], (int)dArray[1], (int)dArray[2], "E", "W"));
        return stringBuffer.toString();
    }

    public String generateFormattedAddressNamingRuleA(String string, String string2, String string3, String string4, String string5, String string6) {
        String string7 = "";
        if (string2.length() > 0) {
            string7 = string3.length() > 0 ? new StringBuffer().append(string3).append(" ").append(string2).toString() : string2;
        }
        if (string.length() > 0 || string5.length() > 0) {
            if (string7.length() > 0) {
                string7 = new StringBuffer().append(string7).append("\n").toString();
            }
            if (string.length() > 0 && string5.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string).append(", ").append(string5).toString();
            } else if (string.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string).toString();
            } else if (string5.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string5).toString();
            }
        }
        if (string6.length() > 0) {
            if (string7.length() > 0) {
                string7 = new StringBuffer().append(string7).append("\n").toString();
            }
            string7 = new StringBuffer().append(string7).append(string6).toString();
        }
        if (string4.length() > 0) {
            if (string7.length() > 0) {
                string7 = new StringBuffer().append(string7).append("\n").toString();
            }
            string7 = new StringBuffer().append(string7).append(string4).toString();
        }
        return string7;
    }

    public int checkDirection(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkUtil - checkDirection(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 359) {
            return n;
        }
        return 0;
    }

    public String getFormattedSpeedUnit() {
        return ServiceManager.fixFormat4Asl.fmtString("mph");
    }

    public String getFormattedSpeed(int n, boolean bl) {
        if (bl && -9999 != n && 255 != n) {
            return ServiceManager.fixFormat4Asl.fmtInteger(n);
        }
        return "--";
    }

    public String getFormattedStromSpeed(float f2, boolean bl) {
        if (bl && 3939526 != f2 && 32579 != f2) {
            return Float.toString(f2);
        }
        return "--";
    }

    public String getFormattedPrecipitationProbability(int n, boolean bl) {
        if (bl && -9999 != n && 255 != n) {
            return new StringBuffer().append(ServiceManager.fixFormat4Asl.fmtInteger(n)).append("%").toString();
        }
        return "--%";
    }

    public String getFormattedPressure(int n, boolean bl) {
        if (bl && -9999 != n) {
            return new StringBuffer().append(ServiceManager.fixFormat4Asl.fmtInteger(n)).append("mbar").toString();
        }
        return "--mbar";
    }

    public String getFormattedMaximumSustainedWind(float f2, boolean bl) {
        if (bl && 3939526 != f2) {
            return new StringBuffer().append(Float.toString(f2)).append("kn").toString();
        }
        return "--kn";
    }

    public String getFormattedPrecipitationRange(float f2, float f3, boolean bl) {
        if (bl && -163636026 != f2 && -163636026 != f3 && 32579 != f3 && 32579 != f2) {
            return new StringBuffer().append(f3).append("\"").append(" ").append("-").append(" ").append(f2).append("\"").toString();
        }
        return "--\" - --\"";
    }

    public String formatGeoPosition(double d2, double d3) {
        DecimalFormat decimalFormat = new DecimalFormat("#.######");
        String string = decimalFormat.format(d2);
        String string2 = decimalFormat.format(d3);
        string = string.replace(',', '.');
        string2 = string2.replace(',', '.');
        return new StringBuffer().append(string).append(";").append(string2).toString();
    }

    public String getFormattedUvIndex(int n, int n2, boolean bl) {
        String string = "";
        string = !bl || -9999 == n || 255 == n && n2 != 11 || -9999 == n2 || 255 == n2 ? "(-- - --)" : (n2 == 11 && n == 255 ? new StringBuffer().append("(").append(ServiceManager.fixFormat4Asl.fmtInteger(n2)).append("+").append(")").toString() : new StringBuffer().append("(").append(ServiceManager.fixFormat4Asl.fmtInteger(n2)).append(" ").append("-").append(" ").append(ServiceManager.fixFormat4Asl.fmtInteger(n)).append(")").toString());
        return string;
    }

    public String getFormattedHumidity(int n, int n2, boolean bl) {
        String string = "";
        string = !bl || -9999 == n || 255 == n || -9999 == n2 || 255 == n2 ? "--% - --%" : new StringBuffer().append(ServiceManager.fixFormat4Asl.fmtInteger(n2)).append("%").append(" ").append("-").append(" ").append(ServiceManager.fixFormat4Asl.fmtInteger(n)).append("%").toString();
        return string;
    }

    public void setDistanceUnit(EventGeneric eventGeneric) {
        try {
            this.mapAndSetDistanceUnit(eventGeneric.getInt(0));
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void mapAndSetDistanceUnit(int n) {
        switch (n) {
            case 0: {
                this.distanceUnit = 0;
                break;
            }
            default: {
                this.distanceUnit = 1;
            }
        }
    }

    public String getDistanceValueAndUnit(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkUtil - DistanceUnit(").append(this.distanceUnit).append(")").log();
            }
            if (this.distanceUnit == 0) {
                return ServiceManager.fixFormat4Asl.fmtDistance2Kilometers(n);
            }
            return ServiceManager.fixFormat4Asl.fmtDistance2Miles(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    public String getFormattedNamingRuleF(String string, String string2) {
        try {
            if (null == string) {
                string = "";
            }
            if (null == string2) {
                string2 = "";
            }
            string = string.trim();
            string2 = string2.trim();
            if (string.length() > 0 && string2.length() > 0) {
                return new StringBuffer().append(string).append(" ").append("(").append(string2).append(")").toString();
            }
            if (string.length() > 0) {
                return string;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return "";
    }

    public String getFormattedNamingRuleE(String string, String string2) {
        try {
            if (null == string) {
                string = "";
            }
            if (null == string2) {
                string2 = "";
            }
            string = string.trim();
            string2 = string2.trim();
            if (string.length() > 0 && string2.length() > 0) {
                return new StringBuffer().append(string).append(",").append(" ").append(string2).toString();
            }
            if (string.length() > 0) {
                return string;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return "";
    }

    public String getNavigationFormattedAddressNamingRule14(String string, String string2, String string3, String string4, String string5, String string6) {
        String string7 = "";
        if (string2.length() > 0 || string3.length() > 0) {
            if (string2.length() > 0 && string3.length() > 0) {
                string7 = new StringBuffer().append(string3).append(" ").append(string2).toString();
            } else if (string2.length() > 0) {
                string7 = string2;
            } else if (string3.length() > 0) {
                string7 = string3;
            }
        }
        if (string.length() > 0) {
            if (string7.length() > 0) {
                string7 = new StringBuffer().append(string7).append("\n").toString();
            }
            if (string.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string).toString();
            }
        }
        if (string5.length() > 0 || string6.length() > 0 || string4.length() > 0) {
            if (string7.length() > 0) {
                string7 = new StringBuffer().append(string7).append("\n").toString();
            }
            if (string5.length() > 0 && string6.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string5).append(", ").append(string6).toString();
            } else if (string5.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string5).toString();
            } else if (string6.length() > 0) {
                string7 = new StringBuffer().append(string7).append(string6).toString();
            }
            if (string4.length() > 0 && string7.length() > 0) {
                string7 = new StringBuffer().append(string7).append(" (").append(string4).append(")").toString();
            }
        }
        return string7;
    }
}


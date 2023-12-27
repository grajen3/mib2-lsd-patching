/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.graphics.image.ExifInfo;

public final class PictureViewerExifGpsData {
    public static final int GPS_LATITUDE_REF_NORTH;
    public static final int GPS_LATITUDE_REF_SOUTH;
    public static final int GPS_LONGITUDE_REF_EAST;
    public static final int GPS_LONGITUDE_REF_WEST;
    public static final int GPS_ALTITUDE_REF_SEALEVEL;
    public static final int GPS_ALTITUDE_REF_ABSOLUTE;
    private Short[] _gpsVersionId = new Short[4];
    private int _gpsLatitudeRef = 0;
    private double[] _gpsLatitude = new double[3];
    private int _gpsLongitudeRef = 0;
    private double[] _gpsLongitude = new double[3];
    private int _gpsAltitudeRef = 0;
    private double _gpsAltitude = 0.0;
    private int _gpsDestLatitudeRef = 0;
    private double[] _gpsDestLatitude = new double[3];
    private int _gpsDestLongitudeRef = 0;
    private double[] _gpsDestLongitude = new double[3];
    private String _imageDescription = "";
    private boolean containsGpsData = false;
    private final String _classname = super.getClass().getName();

    public PictureViewerExifGpsData(ExifInfo exifInfo) {
        if (exifInfo != null) {
            Short[] shortArray = (Short[])exifInfo.getExifValue(0);
            if (shortArray != null) {
                this.setGpsVersionId(shortArray);
            }
            this.containsGpsData = true;
            boolean bl = false;
            try {
                this.setGPSLatitude((Double[])exifInfo.getExifValue(2));
                this.setGPSLongitude((Double[])exifInfo.getExifValue(4));
            }
            catch (Exception exception) {
                bl = true;
            }
            if (bl) {
                String string = (String)exifInfo.getExifValue(1);
                if (string != null) {
                    if (string.equalsIgnoreCase("N")) {
                        this.setGPSLatitudeRef(0);
                    } else if (string.equalsIgnoreCase("S")) {
                        this.setGPSLatitudeRef(1);
                    }
                } else {
                    this.containsGpsData = false;
                }
                if (this.containsGpsData) {
                    Object object;
                    Object[] objectArray = (Object[])exifInfo.getExifValue(2);
                    if (objectArray != null) {
                        object = new Long[objectArray.length][2];
                        for (int i2 = 0; i2 < objectArray.length; ++i2) {
                            object[i2] = (Long[])objectArray[i2];
                        }
                        this.setGPSLatitude((Long[][])object);
                    } else {
                        this.containsGpsData = false;
                    }
                    object = (String)exifInfo.getExifValue(3);
                    if (object != null) {
                        if (((String)object).equalsIgnoreCase("E")) {
                            this.setGPSLongitudeRef(0);
                        } else if (((String)object).equalsIgnoreCase("W")) {
                            this.setGPSLongitudeRef(1);
                        }
                    } else {
                        this.containsGpsData = false;
                    }
                    objectArray = (Object[])exifInfo.getExifValue(4);
                    if (objectArray != null) {
                        Long[][] longArray = new Long[objectArray.length][2];
                        for (int i3 = 0; i3 < objectArray.length; ++i3) {
                            longArray[i3] = (Long[])objectArray[i3];
                        }
                        this.setGPSLongitude(longArray);
                    } else {
                        this.containsGpsData = false;
                    }
                    Number number = (Number)exifInfo.getExifValue(5);
                    if (number != null) {
                        this.setGPSAltitudeRef(number.intValue());
                    }
                }
            }
        } else {
            this.containsGpsData = false;
        }
    }

    public boolean containsGpsData() {
        return this.containsGpsData;
    }

    public Short[] getGpsVersionId() {
        return this._gpsVersionId;
    }

    private void setGpsVersionId(Short[] shortArray) {
        if (shortArray != null) {
            this._gpsVersionId = shortArray;
        } else if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append(this._classname).append(".setGpsVersionId(): gpsVersionId = null").log();
        }
    }

    void setGPSLatitudeRef(int n) {
        if (n != 0 && n != 1) {
            this.containsGpsData = false;
            throw new IllegalArgumentException("Unknown latitude ref value.");
        }
        this._gpsLatitudeRef = n;
    }

    public int getGPSLatitudeRef() {
        return this._gpsLatitudeRef;
    }

    void setGPSLatitude(Double[] doubleArray) {
        if (doubleArray.length == 3) {
            for (int i2 = 0; i2 < 3; ++i2) {
                this._gpsLatitude[i2] = doubleArray[i2];
            }
        } else {
            this.containsGpsData = false;
            throw new IllegalArgumentException("Latitude must always have 3 values.");
        }
    }

    void setGPSLatitude(Long[][] longArray) {
        if (longArray.length == 3) {
            for (int i2 = 0; i2 < 3; ++i2) {
                if (longArray[i2] != null) {
                    this._gpsLatitude[i2] = longArray[i2][0].doubleValue() / longArray[i2][1].doubleValue();
                    continue;
                }
                if (!ServiceManager.logger2.isTraceEnabled(128)) continue;
                ServiceManager.logger2.trace(128).append(this._classname).append(".setGPSLatitude(): rationals array element is null (empty EXIF data delivered from DSI)").log();
            }
        } else {
            this.containsGpsData = false;
            throw new IllegalArgumentException("Latitude must always have 3 values.");
        }
    }

    public double[] getGPSLatitude() {
        return this._gpsLatitude;
    }

    void setGPSLongitudeRef(int n) {
        if (0 != n && 1 != n) {
            this.containsGpsData = false;
            throw new IllegalArgumentException("Unknown latitude ref value.");
        }
        this._gpsLongitudeRef = n;
    }

    public int getGPSLongitudeRef() {
        return this._gpsLongitudeRef;
    }

    void setGPSLongitude(Double[] doubleArray) {
        if (doubleArray.length == 3) {
            for (int i2 = 0; i2 < 3; ++i2) {
                this._gpsLongitude[i2] = doubleArray[i2];
            }
        } else {
            this.containsGpsData = false;
            throw new IllegalArgumentException("Longitude must always have 3 values.");
        }
    }

    void setGPSLongitude(Long[][] longArray) {
        if (longArray.length == 3) {
            for (int i2 = 0; i2 < 3; ++i2) {
                if (longArray[i2] != null) {
                    this._gpsLongitude[i2] = longArray[i2][0].doubleValue() / longArray[i2][1].doubleValue();
                    continue;
                }
                if (!ServiceManager.logger2.isTraceEnabled(128)) continue;
                ServiceManager.logger2.trace(128).append(this._classname).append(".setGPSLongitude(): rationals array element is null (empty EXIF data delivered from DSI)").log();
            }
        } else {
            this.containsGpsData = false;
            throw new IllegalArgumentException("Longitude must always have 3 values.");
        }
    }

    public double[] getGPSLongitude() {
        return this._gpsLongitude;
    }

    void setGPSAltitudeRef(int n) {
        if (0 != n && 1 != n) {
            throw new IllegalArgumentException("Unknown altitude ref value.");
        }
        this._gpsAltitudeRef = n;
    }

    public int getGPSAltitudeRef() {
        return this._gpsAltitudeRef;
    }

    void setGPSAltitude(Long[] longArray) {
        if (longArray.length != 2) {
            throw new IllegalArgumentException("Altitude must always have 2 long values.");
        }
        this._gpsAltitude = longArray[0] / longArray[1];
    }

    public double getGPSAltitude() {
        return this._gpsAltitude;
    }

    void setDestGPSLatitudeRef(int n) {
        if (0 != n && 1 != n) {
            throw new IllegalArgumentException("Unknown latitude ref value.");
        }
        this._gpsDestLatitudeRef = n;
    }

    public int getDestGPSLatitudeRef() {
        return this._gpsDestLatitudeRef;
    }

    void setGPSDestLatitude(long[][] lArray) {
        if (lArray.length == 3) {
            for (int i2 = 0; i2 < 3; ++i2) {
                this._gpsDestLatitude[i2] = lArray[i2][0] / lArray[i2][1];
            }
        } else {
            throw new IllegalArgumentException("Latitude must always have 3 values.");
        }
    }

    public double[] getDestGPSLatitude() {
        return this._gpsDestLatitude;
    }

    void setGPSDestLongitudeRef(int n) {
        if (0 != n && 1 != n) {
            throw new IllegalArgumentException("Unknown latitude ref value.");
        }
        this._gpsDestLongitudeRef = n;
    }

    public int getGPSDestLongitudeRef() {
        return this._gpsDestLongitudeRef;
    }

    void setGPSDestLongitude(long[][] lArray) {
        if (lArray.length == 3) {
            for (int i2 = 0; i2 < 3; ++i2) {
                this._gpsDestLongitude[i2] = lArray[i2][0] / lArray[i2][1];
            }
        } else {
            throw new IllegalArgumentException("Longitude must always have 3 values.");
        }
    }

    public double[] getGPSDestLongitude() {
        return this._gpsDestLongitude;
    }

    void setImageDescription(String string) {
        this._imageDescription = string;
    }

    public String getImageDescription() {
        return this._imageDescription;
    }

    public String toString() {
        return new StringBuffer().append("PictureViewerExifGpsData [_gpsAltitude=").append(this._gpsAltitude).append(", _gpsAltitudeRef[Sealevel=0/Absolute=1]=").append(this._gpsAltitudeRef).append(", _gpsLatitude=").append(this._gpsLatitude != null ? this.arrayToString(this._gpsLatitude, this._gpsLatitude.length) : null).append(", _gpsLatitudeRef[North=0/South=1]=").append(this._gpsLatitudeRef).append(", _gpsLongitude=").append(this._gpsLongitude != null ? this.arrayToString(this._gpsLongitude, this._gpsLongitude.length) : null).append(", _gpsLongitudeRef[East=0/West=1]=").append(this._gpsLongitudeRef).append(", gpsVersionId=").append(this._gpsVersionId != null ? this.arrayToString(this._gpsVersionId, this._gpsVersionId.length) : null).append("]").toString();
    }

    private String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (object instanceof double[]) {
                stringBuffer.append(((double[])object)[i2]);
            }
            if (!(object instanceof byte[])) continue;
            stringBuffer.append(((byte[])object)[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}


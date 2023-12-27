/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo.transformer;

public class UGDOCollector {
    public int fsgListPos;
    public String KeyName;
    public float positionLatitude;
    public float PositionLongitude;
    public int learnedState;
    public int hardKey;
    public int softKey;
    public boolean doorNameExist;
    public boolean isGpsSupervision;
    public boolean isKeyFob;
    public boolean isBiDirectionalCommunication;
    public int nameState;
    public static final boolean UGDO_SPECIAL_FEATURE_DEFAULT;
    public static final int UGDO_GPS_LOCATION_DEFAULT;
    public static final int UGDO_FSG_LIST_POSITION_DEFAULT;
    public static final int UGDO_KEY_NUMBER_DEFAULT;

    public UGDOCollector(int n, String string, float f2, float f3, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n5) {
        this.fsgListPos = n;
        this.KeyName = string;
        this.positionLatitude = f2;
        this.PositionLongitude = f3;
        this.learnedState = n2;
        this.hardKey = n3;
        this.softKey = n4;
        this.doorNameExist = bl;
        this.isGpsSupervision = bl2;
        this.isKeyFob = bl3;
        this.isBiDirectionalCommunication = bl4;
        this.nameState = n5;
    }

    public UGDOCollector() {
        this.fsgListPos = 0;
        this.KeyName = "free";
        this.positionLatitude = 0.0f;
        this.PositionLongitude = 0.0f;
        this.learnedState = 0;
        this.hardKey = 0;
        this.softKey = 0;
        this.doorNameExist = false;
        this.isGpsSupervision = false;
        this.isKeyFob = false;
        this.isBiDirectionalCommunication = false;
        this.nameState = 0;
    }
}


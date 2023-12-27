/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.internal.carlife.common.CarLifeHelper;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;

public class CarLifeResourceOwner {
    public static final int RESOURCEOWNER_HMI;
    public static final int RESOURCEOWNER_CARLIFE;
    public static final int RESOURCEOWNER_UNKNOWN;
    public static final int APPLICATIONOWNER_HMI;
    public static final int APPLICATIONOWNER_CARLIFE;
    public static final int APPLICATIONOWNER_UNKNOWN;
    private int screenOwner;
    private int audioMediaOwner;
    private int audioMicrophoneOwner;
    private int audioTTSOwner;
    private int navigationOwner;
    private int speechOwner;

    public CarLifeResourceOwner() {
        this.screenOwner = 0;
        this.audioMediaOwner = 0;
        this.audioMicrophoneOwner = 0;
        this.audioTTSOwner = 0;
        this.navigationOwner = 0;
        this.speechOwner = 0;
    }

    public CarLifeResourceOwner(int n, int n2, int n3, int n4, int n5, int n6) {
        this.screenOwner = n;
        this.audioMediaOwner = n2;
        this.audioMicrophoneOwner = n3;
        this.audioTTSOwner = n4;
        this.navigationOwner = n5;
        this.speechOwner = n6;
    }

    public CarLifeResourceOwner(CarLifeResourceOwner carLifeResourceOwner) {
        this.screenOwner = carLifeResourceOwner.screenOwner;
        this.audioMediaOwner = carLifeResourceOwner.audioMediaOwner;
        this.audioMicrophoneOwner = carLifeResourceOwner.audioMicrophoneOwner;
        this.audioTTSOwner = carLifeResourceOwner.audioTTSOwner;
        this.navigationOwner = carLifeResourceOwner.navigationOwner;
        this.speechOwner = carLifeResourceOwner.speechOwner;
    }

    public void handleConnectionToDeviceLost() {
        if (2 == this.screenOwner) {
            this.screenOwner = 0;
        }
        if (2 == this.audioMediaOwner) {
            this.audioMediaOwner = 0;
        }
        if (2 == this.audioMicrophoneOwner) {
            this.audioMicrophoneOwner = 0;
        }
        if (2 == this.audioTTSOwner) {
            this.audioTTSOwner = 0;
        }
        if (2 == this.navigationOwner) {
            this.navigationOwner = 0;
        }
        if (2 == this.speechOwner) {
            this.speechOwner = 0;
        }
    }

    public int getScreenOwner() {
        return this.screenOwner;
    }

    public void setScreenOwner(int n) {
        this.screenOwner = n;
    }

    public int getAudioMediaOwner() {
        return this.audioMediaOwner;
    }

    public void setAudioMediaOwner(int n) {
        this.audioMediaOwner = n;
    }

    public int getAudioMicrophoneOwner() {
        return this.audioMicrophoneOwner;
    }

    public void setAudioMicrophoneOwner(int n) {
        this.audioMicrophoneOwner = n;
    }

    public int getAudioTTSOwner() {
        return this.audioTTSOwner;
    }

    public void setAudioTTSOwner(int n) {
        this.audioTTSOwner = n;
    }

    public int getNavigationOwner() {
        return this.navigationOwner;
    }

    public void setNavigationOwner(int n) {
        this.navigationOwner = n;
    }

    public int getSpeechOwner() {
        return this.speechOwner;
    }

    public void setSpeechOwner(int n) {
        this.speechOwner = n;
    }

    public void update(Resource[] resourceArray, AppState[] appStateArray) {
        this.setScreenOwner(CarLifeHelper.getOwner(resourceArray, 1));
        this.setAudioMediaOwner(CarLifeHelper.getOwner(resourceArray, 3));
        this.setAudioMicrophoneOwner(CarLifeHelper.getOwner(resourceArray, 2));
        this.setAudioTTSOwner(CarLifeHelper.getOwner(resourceArray, 4));
        this.setNavigationOwner(CarLifeHelper.getOwner(appStateArray, 1));
        this.setSpeechOwner(CarLifeHelper.getOwner(appStateArray, 2));
    }

    public boolean equals(Object object) {
        if (object != null && object instanceof CarLifeResourceOwner) {
            CarLifeResourceOwner carLifeResourceOwner = (CarLifeResourceOwner)object;
            if (this.screenOwner == carLifeResourceOwner.screenOwner && this.audioMediaOwner == carLifeResourceOwner.audioMediaOwner && this.audioMicrophoneOwner == carLifeResourceOwner.audioMicrophoneOwner && this.audioTTSOwner == carLifeResourceOwner.audioTTSOwner && this.navigationOwner == carLifeResourceOwner.navigationOwner && this.speechOwner == carLifeResourceOwner.speechOwner) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.screenOwner + this.audioMediaOwner * 2 + this.audioMicrophoneOwner * 4 + this.audioTTSOwner * 8 + this.navigationOwner * 16 + this.speechOwner * 32;
    }
}


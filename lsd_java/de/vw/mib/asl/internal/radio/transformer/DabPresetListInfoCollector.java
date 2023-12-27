/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import org.dsi.ifc.global.ResourceLocator;

public class DabPresetListInfoCollector {
    public boolean mIsServiceStored = false;
    public String mPresetName = "";
    public int mAutoStoreState = 0;
    public ResourceLocator mResource = null;
    public String mPresetId = "";
    public int mAttributes = 0;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mIsServiceStored[");
        stringBuffer.append(this.mIsServiceStored);
        stringBuffer.append("] ");
        stringBuffer.append("mPresetName[");
        stringBuffer.append(this.mPresetName);
        stringBuffer.append("] ");
        stringBuffer.append("mImageState[");
        stringBuffer.append("] ");
        stringBuffer.append("mResource[");
        stringBuffer.append("] ");
        stringBuffer.append("mPresetId[");
        stringBuffer.append(this.mPresetId);
        stringBuffer.append("] ");
        stringBuffer.append("mAttributed[");
        stringBuffer.append(Integer.toBinaryString(this.mAttributes));
        stringBuffer.append("] ");
        stringBuffer.append("mPresetId[");
        switch (this.mAutoStoreState) {
            case 0: {
                stringBuffer.append("DAB_PRESET_LIST_INFO__DAB_PRESET_LIST_INFO__STORED_LOGO_STATE__C0_NOTHING");
                break;
            }
            case 1: {
                stringBuffer.append("DAB_PRESET_LIST_INFO__DAB_PRESET_LIST_INFO__STORED_LOGO_STATE__C1_AUTO");
                break;
            }
            case 2: {
                stringBuffer.append("DAB_PRESET_LIST_INFO__DAB_PRESET_LIST_INFO__STORED_LOGO_STATE__C2_MANUAL");
                break;
            }
            default: {
                stringBuffer.append("Unknown State");
            }
        }
        stringBuffer.append("] ");
        return stringBuffer.toString();
    }
}


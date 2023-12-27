/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phonetiles.presets.transformer;

import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.presets.transformer.PhonePresetCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.presets.ASLPhonePresetsPropertyManager;
import generated.de.vw.mib.asl.internal.phonetiles.presets.transformer.AbstractPhoneTileSPresetsPresetsTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneTileSPresetsPresetsTransformer
extends AbstractPhoneTileSPresetsPresetsTransformer
implements ItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        PhonePresetCollector phonePresetCollector = (PhonePresetCollector)object;
        boolean bl = this.isEmpty(phonePresetCollector);
        switch (n) {
            case 0: {
                return bl ? -1 : PhoneUtil.convertPhoneTypeDSI2ASLCombined(phonePresetCollector.adbEntry.phoneData[phonePresetCollector.phoneDataIdx].numberType);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhonePresetCollector phonePresetCollector = (PhonePresetCollector)object;
        String string = ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber;
        boolean bl = this.isEmpty(phonePresetCollector);
        switch (n) {
            case 2: {
                return phonePresetCollector.sosButtonPreset ? "SOS" : (bl ? "" : phonePresetCollector.adbEntry.combinedName);
            }
            case 3: {
                return bl ? (phonePresetCollector.sosButtonPreset ? string : "") : phonePresetCollector.adbEntry.phoneData[phonePresetCollector.phoneDataIdx].number;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhonePresetCollector phonePresetCollector = (PhonePresetCollector)object;
        boolean bl = this.isEmpty(phonePresetCollector);
        switch (n) {
            case 5: {
                return phonePresetCollector.sosButtonPreset;
            }
            case 6: {
                return bl && !phonePresetCollector.sosButtonPreset;
            }
            case 7: {
                return phonePresetCollector.adbEntry.getPersonalData() == null || phonePresetCollector.adbEntry.getPersonalData().getContactPicture() == null || phonePresetCollector.adbEntry.getPersonalData().getContactPicture().isIntResource() && phonePresetCollector.adbEntry.getPersonalData().getContactPicture().id == -1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        PhonePresetCollector phonePresetCollector = (PhonePresetCollector)object;
        switch (n) {
            case 1: {
                return phonePresetCollector == null ? 0L : phonePresetCollector.adbEntry.entryId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private boolean isEmpty(PhonePresetCollector phonePresetCollector) {
        return phonePresetCollector == null || phonePresetCollector.phoneDataIdx == -1;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        PhonePresetCollector phonePresetCollector = (PhonePresetCollector)object;
        boolean bl = this.isEmpty(phonePresetCollector);
        switch (n) {
            case 4: {
                return bl ? ASLPhonePresetsPropertyManager.PRESETS__PICTURE__DEFAULT_VALUE : phonePresetCollector.adbEntry.personalData.contactPicture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}


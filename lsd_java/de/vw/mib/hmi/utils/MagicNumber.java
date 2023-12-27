/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

public final class MagicNumber {
    public static final MagicNumber HMI_SEED = new MagicNumber("****", "HMI seed");
    public static final MagicNumber PUBLICIDS_RES = new MagicNumber("PbID", "Public IDs");
    public static final MagicNumber MODELAPI_RES = new MagicNumber("MoAp", "ModelApi signatures");
    public static final MagicNumber MODELDATAPOOL_RES = new MagicNumber("MDPL", "Model data pool data");
    public static final MagicNumber STATEMACHINES_RES = new MagicNumber("SM  ", "Statemachine description data");
    public static final MagicNumber POPUPINFO_RES = new MagicNumber("PopI", "Popup information data");
    public static final MagicNumber WIDGETFACTORY_RES = new MagicNumber("WFDA", "Widget construction data for factory");
    public static final MagicNumber DEBUGEVENTS_INFO = new MagicNumber("D-EV", "Events debug information");
    public static final MagicNumber DEBUGPROPERTIES_INFO = new MagicNumber("D-DP", "Properties debug information");
    public static final MagicNumber STATEMACHINES_INFO = new MagicNumber("D-SM", "Statemachines debug information");
    public static final MagicNumber I18N = new MagicNumber("I18n", "Skinned i18n language text data");
    public static final MagicNumber I18N_DELTA = new MagicNumber("I18d", "Skinned i18n language delta text data");
    public static final MagicNumber IMAGES_RES = new MagicNumber("\u0000\u0000\u0000\u0000", "Skinned images: resource data");
    public static final MagicNumber IMAGES_SKIN0_RES = new MagicNumber("Skr0", "Skinned images: Skin 0 resource data");
    public static final MagicNumber IMAGES_SKINX_RES = new MagicNumber("SkrX", "Skinned images: Skin X resource data");
    public static final MagicNumber IMAGES_SKIN0_SEED = new MagicNumber("Skn0", "Skinned images: Skin 0 seed");
    public static final MagicNumber IMAGES_SKINX_SEED = new MagicNumber("SknX", "Skinned images: Skin X seed");
    public static final MagicNumber IMAGES_MIF_ESO = new MagicNumber("MifE", "MIF data for ESO");
    public static final MagicNumber IMAGES_MIF_PASE = new MagicNumber("MifP", "MIF data for PASE");
    public static final MagicNumber IMAGES_MAPPING_TABLE = new MagicNumber("MapI", "Mapping Info");
    public static final MagicNumber V2VANIMS_RES = new MagicNumber("v2vA", "View-2-view animation data");
    public static final MagicNumber SKINANIM_RES = new MagicNumber("SknA", "Skin animation data");
    public static final MagicNumber DATADRIVEN_RES = new MagicNumber("Dd  ", "Datadriven res file");
    public static final MagicNumber DIAGNOSE_EVENTS = new MagicNumber("EV-D", "Diagnose data: events");
    public static final MagicNumber DIAGNOSE_PROPERTIES = new MagicNumber("PR-D", "Diagnose data: properties");
    private final String fourLetters;
    private final int intValue;
    private final String description;

    private MagicNumber(String string, String string2) {
        this.description = string2;
        this.fourLetters = string;
        int n = 0;
        n |= string.charAt(0);
        n |= string.charAt(1) << 8;
        n |= string.charAt(2) << 16;
        this.intValue = n |= string.charAt(3) << 24;
    }

    public String getFourLetters() {
        return this.fourLetters;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public String getDescription() {
        return this.description;
    }
}


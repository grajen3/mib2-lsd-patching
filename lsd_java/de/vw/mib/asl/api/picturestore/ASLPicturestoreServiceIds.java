/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.picturestore;

public interface ASLPicturestoreServiceIds {
    public static final int SET_CONTEXT_CONFIG;
    public static final int SET_CONTEXT_CONFIG_P0_CONTEXTID_INTEGER;
    public static final int SET_CONTEXT_CONFIG_P1_NUMSLOTS_INTEGER;
    public static final int SET_CONTEXT_CONFIG_P2_SCALEWIDTH_INTEGER;
    public static final int SET_CONTEXT_CONFIG_P3_SCALEHEIGHT_INTEGER;
    public static final int IMPORT_PICTURE;
    public static final int IMPORT_PICTURE_P0_CONTEXTID_INTEGER;
    public static final int IMPORT_PICTURE_P1_VOLATILEPICTUREPATH_RESOURCELOCATOR;
    public static final int IMPORT_PICTURE_P2_USER_DATA_OBJECT;
    public static final int IMPORT_PICTURE_RESULT_P0_CONTEXTID_INTEGER;
    public static final int IMPORT_PICTURE_RESULT_P1_VOLATILEPICTUREPATH_RESOURCELOCATOR;
    public static final int IMPORT_PICTURE_RESULT_P2_USER_DATA_OBJECT;
    public static final int IMPORT_PICTURE_RESULT_P3_PERSISTENTPICTUREPATH_RESOURCELOCATOR;
    public static final int IMPORT_PICTURE_RESULT_P4_SUCCESS_BOOLEAN;
    public static final int DELETE_ALL_PICTURES;
    public static final int DELETE_ALL_PICTURES_P0_CONTEXTID_INTEGER;
    public static final int DELETE_ALL_PICTURES_P1_FORCE_BOOLEAN;
    public static final int DELETE_PICTURES;
    public static final int DELETE_PICTURES_P0_PICTURES_RESOURCELOCATOR_ARRAY;
    public static final int DELETE_PICTURES_P1_FORCE_BOOLEAN;
    public static final int DELETE_PICTURES_RESULT_P0_DELETEDPICTURES_RESOURCELOCATOR_ARRAY;
    public static final int PICTURESTORE_STATUS;
    public static final int PICTURESTORE_STATUS_P0_READY_BOOLEAN;
}


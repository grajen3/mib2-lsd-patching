/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

import org.dsi.ifc.base.DSIBase;

public interface DSISWaP
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_SOFTWAREENABLING;
    public static final int ATTR_ILLEGALFSCS;
    public static final int ATTR_AREFSCSSIGNED;
    public static final int ATTR_LIMITEDLIFETIME;
    public static final int ATTR_CONFIGCHECK;
    public static final int ATTR_CONFIGPREPARE;
    public static final int ATTR_CONFIGFINALIZE;
    public static final int ATTR_FSCLIST;
    public static final int CRYPTERR_NOT_INITIALIZED;
    public static final int CRYPTERR_OK;
    public static final int CRYPTERR_READ_ERROR;
    public static final int CRYPTERR_WRITE_ERROR;
    public static final int CRYPTERR_CRYPTO_ERROR;
    public static final int CRYPTERR_ALGORITHM_UNKNOWN;
    public static final int CRYPTERR_WRONG_KEY_SIZE;
    public static final int CRYPTERR_OUT_OF_MEMORY;
    public static final int FSC_NOT_INITIALIZED;
    public static final int FSC_OK;
    public static final int FSC_INVALID_SIZE;
    public static final int FSC_INVALID_FORMAT;
    public static final int FSC_INVALID_CONTENT;
    public static final int FSC_INVALID_SIGNATURE;
    public static final int FSC_OTP_SWID_MISMATCH;
    public static final int FSC_VIN_MISMATCH;
    public static final int FSCSTATE_STATE_NOT_INITIALIZED;
    public static final int FSCSTATE_LEGAL;
    public static final int FSCSTATE_ILLEGAL;
    public static final int FSCSTATE_SUPPORTED;
    public static final int FSCSTATE_TEMP;
    public static final int FSCSTATE_PERM;
    public static final int MEDIUM_NOT_INITIALIZED;
    public static final int MEDIUM_NFS;
    public static final int MEDIUM_INTERNAL_DRIVE;
    public static final int MEDIUM_USB_FS;
    public static final int MEDIUM_SD_1;
    public static final int MEDIUM_SD_2;
    public static final int MEDIUM_CIFS;
    public static final int MEDIUM_OTA;
    public static final int MEDIUM_FS;
    public static final int RT_ENCRYPTFILE;
    public static final int RT_CHECKSIGNATURE;
    public static final int RT_GETPUBLICKEY;
    public static final int RT_CHECKSINGLEFSC;
    public static final int RT_DECRYPTFILE;
    public static final int RT_GETFSCDETAILS;
    public static final int RT_TRIGGERSOFTWAREENABLING;
    public static final int RT_GETHISTORY;
    public static final int RT_EXPORTCCD;
    public static final int RT_IMPORTFSCS;
    public static final int RP_ENCRYPTFILE;
    public static final int RP_CHECKSIGNATURE;
    public static final int RP_GETPUBLICKEY;
    public static final int RP_CHECKSINGLEFSC;
    public static final int RP_DECRYPTFILE;
    public static final int RP_GETFSCDETAIL;
    public static final int RP_IMPORTFSCS;
    public static final int RP_EXPORTCCD;
    public static final int RP_GETHISTORY;
    public static final int RP_IMPORTFSCSLIST;
    public static final int RP_GETHISTORYLIST;

    default public void encryptFile(String string, String string2, byte[] byArray) {
    }

    default public void checkSignature(String string, short[] sArray, int n, long l) {
    }

    default public void getPublicKey() {
    }

    default public void checkSingleFsc(int n) {
    }

    default public void decryptFile(String string, String string2, byte[] byArray) {
    }

    default public void getFscDetails(int n, int n2, int n3) {
    }

    default public void triggerSoftwareEnabling() {
    }

    default public void importFSCs(int n) {
    }

    default public void exportCCD(int n) {
    }

    default public void getHistory() {
    }
}


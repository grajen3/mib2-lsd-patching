/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.dsi.ifc.networking.Profile;

public final class ASLWLANData {
    private static boolean wLANActivatedViaDiagnosis;
    private static boolean systemInTransportOrProductionMode;
    private static boolean sContactOn;
    private static boolean wLANActivated;
    private static boolean simOrSurfstickInserted;
    private static Profile myProfile;
    private static Profile pendingProfile;
    static /* synthetic */ Class array$Ljava$lang$String;

    private ASLWLANData() {
    }

    public static void clear() {
        myProfile = new Profile();
        pendingProfile = new Profile();
        ASLWLANData.setWLANActivated(false);
        ASLWLANData.setWLANSSID("");
        ASLWLANData.setWLANconcealed(true);
    }

    public static Profile getProfile() {
        return myProfile;
    }

    static void setProfile(Profile profile) {
        myProfile = profile;
    }

    public static Profile getPendingProfile() {
        return pendingProfile;
    }

    static void setPending2Profile() {
        String[] stringArray = null;
        if (!Util.isNullOrEmpty(myProfile.getKeys())) {
            stringArray = (String[])Arrays.copyOf(myProfile.getKeys(), myProfile.getKeys().length, array$Ljava$lang$String == null ? (array$Ljava$lang$String = ASLWLANData.class$("[Ljava.lang.String;")) : array$Ljava$lang$String);
        }
        pendingProfile = new Profile(ASLWLANData.myProfile.identifier, ASLWLANData.myProfile.name, stringArray, ASLWLANData.myProfile.keyNumber, ASLWLANData.myProfile.sSIDBroadcast, ASLWLANData.myProfile.sSID, ASLWLANData.myProfile.cryptoModel, ASLWLANData.myProfile.authenticationModel, ASLWLANData.myProfile.active, ASLWLANData.myProfile.channel);
    }

    static void setWLANconcealed(boolean bl) {
        ASLWLANData.myProfile.sSIDBroadcast = !bl;
    }

    static boolean getWLANConcealed() {
        return !ASLWLANData.getProfile().isSSIDBroadcast();
    }

    static int getWLANSecurityLevel2() {
        int n = 1;
        switch (ASLWLANData.myProfile.cryptoModel) {
            case 4: 
            case 5: 
            case 8: {
                break;
            }
            case 6: 
            case 7: 
            case 9: {
                n = 0;
                break;
            }
            case 1: {
                break;
            }
            case 10: {
                n = 1;
                break;
            }
            default: {
                ServiceManager.logger2.error(1).append("Unsupported encryption mode!").append(ASLWLANData.myProfile.cryptoModel).log();
            }
        }
        return n;
    }

    static int getWLANClientSecurityLevel(int n) {
        int n2 = 0;
        switch (n) {
            case 4: 
            case 5: 
            case 8: {
                break;
            }
            case 6: 
            case 7: 
            case 9: {
                n2 = 0;
                break;
            }
            case 1: {
                break;
            }
            case 10: {
                n2 = 1;
                break;
            }
            default: {
                ServiceManager.logger2.error(1).append("Unsupported encryption mode!").append(n).log();
            }
        }
        return n2;
    }

    static int getDpWLANSecurityLevel2CryptoModel(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 7;
                break;
            }
            case 1: {
                n2 = 10;
                break;
            }
        }
        return n2;
    }

    static int getDpWLANClientSecurityLevel2CryptoModel(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 7;
                break;
            }
            case 1: {
                n2 = 10;
                break;
            }
        }
        return n2;
    }

    public static boolean iswLANActivatedViaDiagnosis() {
        return wLANActivatedViaDiagnosis;
    }

    public static void setwLANActivatedViaDiagnosis(boolean bl) {
        wLANActivatedViaDiagnosis = bl;
    }

    public static boolean isSystemInTransportOrProductionMode() {
        return systemInTransportOrProductionMode;
    }

    public static void setSystemInTransportOrProductionMode(boolean bl) {
        systemInTransportOrProductionMode = bl;
    }

    public static void setSContactOn(boolean bl) {
        sContactOn = bl;
    }

    public static boolean isSContactOn() {
        return sContactOn;
    }

    public static void setWLANActivated(boolean bl) {
        wLANActivated = bl;
    }

    public static boolean isWLANActivated() {
        return wLANActivated;
    }

    static void setWLANSSID(String string) {
        ASLWLANData.myProfile.sSID = string;
    }

    static String getWLANSSID() {
        return myProfile.getSSID();
    }

    static void setCryptoModel(int n) {
        ASLWLANData.myProfile.cryptoModel = n;
    }

    static int getCryptoModel() {
        return ASLWLANData.myProfile.cryptoModel;
    }

    static void setKeys(String[] stringArray) {
        ASLWLANData.myProfile.keys = stringArray;
    }

    static String getActiveKey() {
        if (!Util.isNullOrEmpty(myProfile.getKeys()) && myProfile.getKeys().length > myProfile.getKeyNumber()) {
            return myProfile.getKeys()[myProfile.getKeyNumber()];
        }
        return "";
    }

    public static boolean isSimOrSurfstickInserted() {
        return simOrSurfstickInserted;
    }

    public static void setSimOrSurfstickInserted(boolean bl) {
        simOrSurfstickInserted = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        ASLWLANData.clear();
    }
}


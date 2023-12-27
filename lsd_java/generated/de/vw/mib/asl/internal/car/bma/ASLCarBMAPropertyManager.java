/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.bma;

public interface ASLCarBMAPropertyManager {
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_STATE;
    public static final boolean PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_STATE__DEFAULT_VALUE;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__DEFAULT_VALUE;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C0_NORMAL;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C1_ERROR;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C2_IGNITION;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C3_SPEED;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C4_ENGINE;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C5_TRAILER;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C6_SOC_1;
    public static final int PROFILE_AVAILABILITY__PROFILE_AVAILABILITY_REASON__C7_SOC_2;
    public static final int PROFILES;
    public static final boolean[] PROFILES__DEFAULT_VALUE;
    public static final int PROFILE_ACTIVE;
    public static final int PROFILE_ACTIVE__DEFAULT_VALUE;
    public static final int PROFILE_ACTIVE__C0_NONE;
    public static final int PROFILE_ACTIVE__C1_EMODE;
    public static final int PROFILE_ACTIVE__C2_HYBRIDAUTO;
    public static final int PROFILE_ACTIVE__C3_HYBRIDHOLD;
    public static final int PROFILE_ACTIVE__C4_HYBRIDCHARGE;
    public static final int PROFILE_ACTIVE__C5_HYBRIDSPORT;

    static {
        PROFILES__DEFAULT_VALUE = new boolean[]{false, false, false, false};
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

public final class OnlinePoiDataPool {
    private static final OnlinePoiDataPool INSTANCE = new OnlinePoiDataPool();
    public static final int SEARCH_TYPE_ONLINE_SEARCH;
    public static final int SEARCH_TYPE_DYNAMIC_SEARCH;
    public static final int SEARCH_TYPE_VOICE_SEARCH;
    private boolean onlineProviderLogoAvailable = false;
    private boolean dynamicEChargingProviderLogoAvailable = false;
    private boolean dynamicEChargingFastProviderLogoAvailable = false;
    private boolean dynamicEChargingNormalProviderLogoAvailable = false;
    private boolean dynamicGasProviderLogoAvailable = false;
    private boolean dynamicNaturalGasProviderLogoAvailable = false;
    private boolean dynamicParkingProviderLogoAvailable = false;
    private int searchType;

    private OnlinePoiDataPool() {
    }

    public static OnlinePoiDataPool getInstance() {
        return INSTANCE;
    }

    boolean isDynamicProviderLogoAvailable(int n) {
        switch (n) {
            case 4: {
                return this.dynamicEChargingProviderLogoAvailable;
            }
            case 6: {
                return this.dynamicEChargingFastProviderLogoAvailable;
            }
            case 5: {
                return this.dynamicEChargingNormalProviderLogoAvailable;
            }
            case 1: {
                return this.dynamicGasProviderLogoAvailable;
            }
            case 3: {
                return this.dynamicNaturalGasProviderLogoAvailable;
            }
            case 2: {
                return this.dynamicParkingProviderLogoAvailable;
            }
        }
        return false;
    }

    void setDynamicProviderLogoAvailable(boolean bl, int n) {
        switch (n) {
            case 4: {
                this.dynamicEChargingProviderLogoAvailable = bl;
                break;
            }
            case 6: {
                this.dynamicEChargingFastProviderLogoAvailable = bl;
                break;
            }
            case 5: {
                this.dynamicEChargingNormalProviderLogoAvailable = bl;
                break;
            }
            case 1: {
                this.dynamicGasProviderLogoAvailable = bl;
                break;
            }
            case 3: {
                this.dynamicNaturalGasProviderLogoAvailable = bl;
                break;
            }
            case 2: {
                this.dynamicParkingProviderLogoAvailable = bl;
                break;
            }
        }
    }

    boolean isOnlineProviderLogoAvailable() {
        return this.onlineProviderLogoAvailable;
    }

    void setOnlineProviderLogoAvailable(boolean bl) {
        this.onlineProviderLogoAvailable = bl;
    }

    void setSearchType(int n) {
        this.searchType = n;
    }

    int getSearchType() {
        return this.searchType;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

public class MapFavoriteDescriptor {
    private long flagId;
    private long managedFlagId;
    private String name;
    private long organizerId;
    private int[] position;
    private String country;
    private String city;
    private String street;

    public static boolean isPositionValid(int[] nArray) {
        return nArray != null && nArray.length == 2 && (nArray[0] != 0 || nArray[1] != 0);
    }

    MapFavoriteDescriptor(int[] nArray, String string, long l, long l2, String string2, String string3, String string4) {
        this.position = nArray;
        this.name = string;
        this.organizerId = l;
        this.flagId = l2;
        this.managedFlagId = 0L;
        this.country = string2;
        this.city = string3;
        this.street = string4;
    }

    public long getFlagId() {
        return this.flagId;
    }

    public int getLatitude() {
        return this.position[0];
    }

    public int getLongitude() {
        return this.position[1];
    }

    public long getManagedFlagId() {
        return this.managedFlagId;
    }

    public String getName() {
        return this.name;
    }

    public long getOrganizerId() {
        return this.organizerId;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setManagedFlagId(long l) {
        this.managedFlagId = l;
    }
}


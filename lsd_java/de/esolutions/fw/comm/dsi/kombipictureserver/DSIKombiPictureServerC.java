/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver;

import org.dsi.ifc.global.ResourceLocator;

public interface DSIKombiPictureServerC {
    default public void setKombiHmiReady() {
    }

    default public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void responseActiveCallPictureInstance(int n, int n2, int n3, ResourceLocator resourceLocator) {
    }

    default public void responseDynamicIcon(int n, int n2, boolean bl, ResourceLocator resourceLocator) {
    }

    default public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
    }

    default public void responseInternalAddressID(long l, int n, int n2) {
    }

    default public void responsePictureServerAbilities(int n) {
    }

    default public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}


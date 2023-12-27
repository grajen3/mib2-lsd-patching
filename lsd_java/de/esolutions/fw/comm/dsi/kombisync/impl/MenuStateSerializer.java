/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MenuState;

public class MenuStateSerializer {
    public static void putOptionalMenuState(ISerializer iSerializer, MenuState menuState) {
        boolean bl = menuState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = menuState.getFas();
            iSerializer.putInt32(n);
            int n2 = menuState.getLoading();
            iSerializer.putInt32(n2);
            int n3 = menuState.getFavorite();
            iSerializer.putInt32(n3);
            int n4 = menuState.getCarViewer();
            iSerializer.putInt32(n4);
            int n5 = menuState.getService();
            iSerializer.putInt32(n5);
            int n6 = menuState.getAuxHeater();
            iSerializer.putInt32(n6);
            int n7 = menuState.getAirCondition();
            iSerializer.putInt32(n7);
            int n8 = menuState.getVehicleSettings();
            iSerializer.putInt32(n8);
            int n9 = menuState.getOffice();
            iSerializer.putInt32(n9);
            int n10 = menuState.getRace();
            iSerializer.putInt32(n10);
            int n11 = menuState.getSystemsettings();
            iSerializer.putInt32(n11);
            int n12 = menuState.getTone();
            iSerializer.putInt32(n12);
            int n13 = menuState.getConnect();
            iSerializer.putInt32(n13);
            int n14 = menuState.getProfile();
            iSerializer.putInt32(n14);
            int n15 = menuState.getDriveSelect();
            iSerializer.putInt32(n15);
            int n16 = menuState.getBordbook();
            iSerializer.putInt32(n16);
            int n17 = menuState.getConnectivityManager();
            iSerializer.putInt32(n17);
            int n18 = menuState.getEtc();
            iSerializer.putInt32(n18);
            int n19 = menuState.getReserve2();
            iSerializer.putInt32(n19);
            int n20 = menuState.getReserve3();
            iSerializer.putInt32(n20);
            int n21 = menuState.getBCall();
            iSerializer.putInt32(n21);
            int n22 = menuState.getCCall();
            iSerializer.putInt32(n22);
            int n23 = menuState.getVics();
            iSerializer.putInt32(n23);
            int n24 = menuState.getTpeg();
            iSerializer.putInt32(n24);
        }
    }

    public static void putOptionalMenuStateVarArray(ISerializer iSerializer, MenuState[] menuStateArray) {
        boolean bl = menuStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(menuStateArray.length);
            for (int i2 = 0; i2 < menuStateArray.length; ++i2) {
                MenuStateSerializer.putOptionalMenuState(iSerializer, menuStateArray[i2]);
            }
        }
    }

    public static MenuState getOptionalMenuState(IDeserializer iDeserializer) {
        MenuState menuState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            int n20;
            int n21;
            int n22;
            int n23;
            int n24;
            menuState = new MenuState();
            menuState.fas = n24 = iDeserializer.getInt32();
            menuState.loading = n23 = iDeserializer.getInt32();
            menuState.favorite = n22 = iDeserializer.getInt32();
            menuState.carViewer = n21 = iDeserializer.getInt32();
            menuState.service = n20 = iDeserializer.getInt32();
            menuState.auxHeater = n19 = iDeserializer.getInt32();
            menuState.airCondition = n18 = iDeserializer.getInt32();
            menuState.vehicleSettings = n17 = iDeserializer.getInt32();
            menuState.office = n16 = iDeserializer.getInt32();
            menuState.race = n15 = iDeserializer.getInt32();
            menuState.systemsettings = n14 = iDeserializer.getInt32();
            menuState.tone = n13 = iDeserializer.getInt32();
            menuState.connect = n12 = iDeserializer.getInt32();
            menuState.profile = n11 = iDeserializer.getInt32();
            menuState.driveSelect = n10 = iDeserializer.getInt32();
            menuState.bordbook = n9 = iDeserializer.getInt32();
            menuState.connectivityManager = n8 = iDeserializer.getInt32();
            menuState.etc = n7 = iDeserializer.getInt32();
            menuState.reserve2 = n6 = iDeserializer.getInt32();
            menuState.reserve3 = n5 = iDeserializer.getInt32();
            menuState.bCall = n4 = iDeserializer.getInt32();
            menuState.cCall = n3 = iDeserializer.getInt32();
            menuState.vics = n2 = iDeserializer.getInt32();
            menuState.tpeg = n = iDeserializer.getInt32();
        }
        return menuState;
    }

    public static MenuState[] getOptionalMenuStateVarArray(IDeserializer iDeserializer) {
        MenuState[] menuStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            menuStateArray = new MenuState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                menuStateArray[i2] = MenuStateSerializer.getOptionalMenuState(iDeserializer);
            }
        }
        return menuStateArray;
    }
}


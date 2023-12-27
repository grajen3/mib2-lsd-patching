/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

public class DeviceInfo {
    public String os;
    public String board;
    public String bootloader;
    public String brand;
    public String cpuAbi;
    public String cpuAbi2;
    public String device;
    public String display;
    public String fingerprint;
    public String hardware;
    public String host;
    public String cid;
    public String manufacturer;
    public String model;
    public String product;
    public String serial;
    public String codename;
    public String incremental;
    public String release;
    public String sdk;
    public String sdkInt;
    public String token;

    public DeviceInfo() {
        this.os = "";
        this.board = "";
        this.bootloader = "";
        this.brand = "";
        this.cpuAbi = "";
        this.cpuAbi2 = "";
        this.device = "";
        this.display = "";
        this.fingerprint = "";
        this.hardware = "";
        this.host = "";
        this.cid = "";
        this.manufacturer = "";
        this.model = "";
        this.product = "";
        this.serial = "";
        this.codename = "";
        this.incremental = "";
        this.release = "";
        this.sdk = "";
        this.sdkInt = "";
        this.token = "";
    }

    public DeviceInfo(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15, String string16, String string17, String string18, String string19, String string20, String string21, String string22) {
        this.os = string;
        this.board = string2;
        this.bootloader = string3;
        this.brand = string4;
        this.cpuAbi = string5;
        this.cpuAbi2 = string6;
        this.device = string7;
        this.display = string8;
        this.fingerprint = string9;
        this.hardware = string10;
        this.host = string11;
        this.cid = string12;
        this.manufacturer = string13;
        this.model = string14;
        this.product = string15;
        this.serial = string16;
        this.codename = string17;
        this.incremental = string18;
        this.release = string19;
        this.sdk = string20;
        this.sdkInt = string21;
        this.token = string22;
    }

    public String getOs() {
        return this.os;
    }

    public String getBoard() {
        return this.board;
    }

    public String getBootloader() {
        return this.bootloader;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCpuAbi() {
        return this.cpuAbi;
    }

    public String getCpuAbi2() {
        return this.cpuAbi2;
    }

    public String getDevice() {
        return this.device;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getHost() {
        return this.host;
    }

    public String getCid() {
        return this.cid;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getProduct() {
        return this.product;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getCodename() {
        return this.codename;
    }

    public String getIncremental() {
        return this.incremental;
    }

    public String getRelease() {
        return this.release;
    }

    public String getSdk() {
        return this.sdk;
    }

    public String getSdkInt() {
        return this.sdkInt;
    }

    public String getToken() {
        return this.token;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1650);
        stringBuffer.append("DeviceInfo");
        stringBuffer.append('(');
        stringBuffer.append("os");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.os);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("board");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.board);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("bootloader");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.bootloader);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("brand");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.brand);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("cpuAbi");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.cpuAbi);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("cpuAbi2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.cpuAbi2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("device");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.device);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("display");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.display);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fingerprint");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fingerprint);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hardware");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.hardware);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("host");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.host);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("cid");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.cid);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("manufacturer");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.manufacturer);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("model");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.model);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("product");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.product);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("serial");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serial);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("codename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.codename);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("incremental");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.incremental);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("release");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.release);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sdk");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sdk);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("sdkInt");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sdkInt);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("token");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.token);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}


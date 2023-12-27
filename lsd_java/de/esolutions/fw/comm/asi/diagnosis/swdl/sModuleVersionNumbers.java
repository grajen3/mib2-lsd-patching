/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.swdl;

public class sModuleVersionNumbers {
    public long msg_id;
    public long bluetooth_parrot_stack;
    public long phone_module;
    public long languages_voices;
    public long codec_media_driver;
    public long gracenote_database;
    public long radio_tv_station_list;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public long getBluetooth_parrot_stack() {
        return this.bluetooth_parrot_stack;
    }

    public void setBluetooth_parrot_stack(long l) {
        this.bluetooth_parrot_stack = l;
    }

    public long getPhone_module() {
        return this.phone_module;
    }

    public void setPhone_module(long l) {
        this.phone_module = l;
    }

    public long getLanguages_voices() {
        return this.languages_voices;
    }

    public void setLanguages_voices(long l) {
        this.languages_voices = l;
    }

    public long getCodec_media_driver() {
        return this.codec_media_driver;
    }

    public void setCodec_media_driver(long l) {
        this.codec_media_driver = l;
    }

    public long getGracenote_database() {
        return this.gracenote_database;
    }

    public void setGracenote_database(long l) {
        this.gracenote_database = l;
    }

    public long getRadio_tv_station_list() {
        return this.radio_tv_station_list;
    }

    public void setRadio_tv_station_list(long l) {
        this.radio_tv_station_list = l;
    }

    public sModuleVersionNumbers() {
    }

    public sModuleVersionNumbers(long l, long l2, long l3, long l4, long l5, long l6, long l7) {
        this.msg_id = l;
        this.bluetooth_parrot_stack = l2;
        this.phone_module = l3;
        this.languages_voices = l4;
        this.codec_media_driver = l5;
        this.gracenote_database = l6;
        this.radio_tv_station_list = l7;
    }

    public String toString() {
        return new StringBuffer("sModuleVersionNumbers{").append("msg_id=").append(this.msg_id).append(", bluetooth_parrot_stack=").append(this.bluetooth_parrot_stack).append(", phone_module=").append(this.phone_module).append(", languages_voices=").append(this.languages_voices).append(", codec_media_driver=").append(this.codec_media_driver).append(", gracenote_database=").append(this.gracenote_database).append(", radio_tv_station_list=").append(this.radio_tv_station_list).append("}").toString();
    }
}


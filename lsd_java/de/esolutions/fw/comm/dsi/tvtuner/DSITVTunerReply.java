/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner;

import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public interface DSITVTunerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateTunerState(int n, int n2) {
    }

    default public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
    }

    default public void updateSelectedService(ProgramInfo programInfo, int n) {
    }

    default public void updateSelectedSource(int n, int n2) {
    }

    default public void updateTVNormArea(int n, int n2) {
    }

    default public void updateAudioChannel(int n, int n2) {
    }

    default public void updateMuteState(int n, int n2) {
    }

    default public void updateInfoTextState(String string, int n) {
    }

    default public void updateTerminalMode(int n, int n2, int n3) {
    }

    default public void updateServiceLinking(boolean bl, int n) {
    }

    default public void updateTVNormList(int[] nArray, int n) {
    }

    default public void updateTVNormAreaSubList(int[] nArray, int n) {
    }

    default public void updateAVNorm(int n, int n2) {
    }

    default public void updateEWSInfoList(EWSInfo[] eWSInfoArray, int n) {
    }

    default public void selectService(int n) {
    }

    default public void selectNextService(int n) {
    }

    default public void abortSeek(int n) {
    }

    default public void switchSource(int n) {
    }

    default public void updateSubtitle(boolean bl, int n) {
    }

    default public void updateLogoList(LogoInfo[] logoInfoArray, int n) {
    }

    default public void updateCASInfo(boolean bl, String string, int n) {
    }

    default public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3, int n) {
    }

    default public void updateMessageService(int n, int n2) {
    }

    default public void updateStartUpMUConfig(StartUpConfig startUpConfig, int n) {
    }

    default public void updateTMTVKeyPanel(short s, short s2, int n) {
    }

    default public void updateBrowserListSort(int n, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}


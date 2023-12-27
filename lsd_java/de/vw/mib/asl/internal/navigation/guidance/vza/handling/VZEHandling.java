/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling;

import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceVZAVZEIcons;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.transformer.VZAIconsCollector;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import de.vw.mib.dynamicresourcedata.DynamicResourceData;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.cardriverassistance.TSDSignFct;

public class VZEHandling {
    private HsmTargetVZA target;
    private VZAIconsCollector[] signs = new VZAIconsCollector[3];
    private DynamicResourceData mapVZE = null;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA;

    public VZEHandling(HsmTargetVZA hsmTargetVZA) {
        this.target = hsmTargetVZA;
        for (int i2 = 0; i2 < this.signs.length; ++i2) {
            this.signs[i2] = new VZAIconsCollector();
        }
        this.mapVZE = this.createVZEDynamicResourceData();
    }

    public void updateTSDSign1(TSDSignFct tSDSignFct) {
        this.target.traceState("updateTSDSign1 -- Country Dependent VZEVZA");
        this.setSign(tSDSignFct, 0);
        this.updateModel();
    }

    public void updateTSDSign2(TSDSignFct tSDSignFct) {
        this.target.traceState("updateTSDSign2 -- Country Dependent VZEVZA");
        this.setSign(tSDSignFct, 1);
        this.updateModel();
    }

    public void updateTSDSign3(TSDSignFct tSDSignFct) {
        this.target.traceState("updateTSDSign3 -- Country Dependent VZEVZA");
        this.setSign(tSDSignFct, 2);
        this.updateModel();
    }

    private DynamicResourceData createVZEDynamicResourceData() {
        DynamicResourceDataDescription dynamicResourceDataDescription = ServiceManager.configManagerDiag.getVzeMappingDescription();
        dynamicResourceDataDescription.input("TrafficSignID_AddSign").input("TrafficSignID_MainSign").input("MainSign_DynamicValue");
        dynamicResourceDataDescription.output("MainSign", -1).output("MainSign_StackBG_DisplayMode", -1).output("MainSign_StackBG_InteractiveMode", -1).output("MainSign_Dynamic", -1).output("AddSign", -1);
        DynamicResourceData dynamicResourceData = dynamicResourceDataDescription.create();
        return dynamicResourceData;
    }

    private String[] getImagePaths(int n, int n2, int n3) {
        this.target.traceState("getImagePaths");
        int[] nArray = this.mapVZE.map(new int[]{n, n2, n3});
        String[] stringArray = new String[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringArray[i2] = this.mapVZE.mapImagePath(nArray[i2]);
        }
        this.traceImagePaths(stringArray);
        return stringArray;
    }

    private void updateModel() {
        int n;
        this.target.traceState("updateModel()");
        ArrayList arrayList = new ArrayList();
        if (this.signs != null) {
            for (n = 0; n < this.signs.length; ++n) {
                if (!this.signs[n].isMainIconActive) continue;
                arrayList.add(this.signs[n]);
            }
        }
        this.target.traceState(new StringBuffer("Begin size check: ").append(arrayList.size()).toString());
        if (arrayList.size() < 3) {
            n = 3 - arrayList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                arrayList.add(new VZAIconsCollector());
            }
        }
        this.target.traceState(new StringBuffer("End size check: ").append(arrayList.size()).toString());
        ListManager.getGenericASLList(-2131750912).updateList(arrayList.toArray());
        this.updateInternalAPI(arrayList.toArray());
    }

    private void setSign(TSDSignFct tSDSignFct, int n) {
        this.target.traceState("setSign()");
        String[] stringArray = this.getImagePaths(tSDSignFct.getAddSign(), tSDSignFct.getSign(), tSDSignFct.getSignDynamicValue());
        if (this.signs[n] == null) {
            this.target.traceState("No existing sign available -> create new one");
            this.signs[n] = new VZAIconsCollector();
        }
        this.signs[n].mainIcons = stringArray[0];
        this.signs[n].bgDisplayMode = stringArray[1];
        this.signs[n].bgInteractiveMode = stringArray[2];
        this.signs[n].speedIcons = stringArray[3];
        this.signs[n].additionalIcons = stringArray[4];
        this.signs[n].isMainIconActive = !this.signs[n].mainIcons.equals("");
        this.signs[n].isAdditionalIconActive = !this.signs[n].additionalIcons.equals("");
        this.signs[n].isSpeedIconActive = !this.signs[n].speedIcons.equals("");
        this.signs[n].speedLimitKmh = this.roundSpeedValue(tSDSignFct.getSignDynamicValue());
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append((class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA == null ? (class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA = VZEHandling.class$("de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA")) : class$de$vw$mib$asl$internal$navigation$guidance$vza$HsmTargetVZA).getName());
            logMessage.append("VZE sign ");
            logMessage.append(n);
            logMessage.append(": ");
            logMessage.append(this.signs[n].toString());
            logMessage.log();
        }
    }

    private int roundSpeedValue(int n) {
        if (n < 100) {
            return 5 * (n / 5);
        }
        if (n < 170) {
            return 10 * (n / 10);
        }
        if (n < 200) {
            return 160;
        }
        if (n < 250) {
            return 200;
        }
        return 250;
    }

    private void traceImagePaths(String[] stringArray) {
        this.target.traceState("traceImagePaths");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.target.traceState(new StringBuffer().append(stringArray[i2]).append(" ").toString());
        }
    }

    private void updateInternalAPI(Object[] objectArray) {
        ASLGuidanceVZAVZEIcons[] aSLGuidanceVZAVZEIconsArray = new ASLGuidanceVZAVZEIcons[]{new ASLGuidanceVZAVZEIcons(), new ASLGuidanceVZAVZEIcons(), new ASLGuidanceVZAVZEIcons()};
        for (int i2 = 0; i2 < 3; ++i2) {
            aSLGuidanceVZAVZEIconsArray[i2].setAdditionalIcon(((VZAIconsCollector)objectArray[i2]).additionalIcons);
            aSLGuidanceVZAVZEIconsArray[i2].setAdditionalIconActive(((VZAIconsCollector)objectArray[i2]).isAdditionalIconActive);
            aSLGuidanceVZAVZEIconsArray[i2].setMainIcon(((VZAIconsCollector)objectArray[i2]).mainIcons);
            aSLGuidanceVZAVZEIconsArray[i2].setMainIconActive(((VZAIconsCollector)objectArray[i2]).isMainIconActive);
            aSLGuidanceVZAVZEIconsArray[i2].setSpeedIcon(((VZAIconsCollector)objectArray[i2]).speedIcons);
            aSLGuidanceVZAVZEIconsArray[i2].setSpeedIconActive(((VZAIconsCollector)objectArray[i2]).isSpeedIconActive);
        }
        this.target.getGuidanceAPINotifier().sendEvVZAVZEUpdate(aSLGuidanceVZAVZEIconsArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}


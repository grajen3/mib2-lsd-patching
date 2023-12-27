/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerKeyPanelListCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KeyPanelList {
    private Map keyPanelMap = new HashMap();
    private final short delimiter = (short)255;
    private int offset = 2;
    private static final TVTunerKeyPanelListCollector DEFAULT_COLLECTOR = new TVTunerKeyPanelListCollector();

    public KeyPanelList(short[] sArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("KeyPanelList( ").append(Arrays.toString(sArray)).append(" )").toString());
        }
        List list = this.tokenize(sArray, (short)255);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            this.parse((short[])iterator.next());
        }
    }

    private List tokenize(short[] sArray, short s) {
        ArrayList arrayList = new ArrayList();
        int n = 0;
        int n2 = 0;
        while (n2 < sArray.length) {
            if (sArray[n2] != s) {
                ++n2;
                continue;
            }
            arrayList.add(Arrays.copyOfRange(sArray, n, n2));
            n2 = n = n2 + 1;
        }
        return arrayList;
    }

    private void parse(short[] sArray) {
        TVTunerKeyPanelListCollector tVTunerKeyPanelListCollector = new TVTunerKeyPanelListCollector();
        int n = -1;
        for (int i2 = this.offset; i2 < sArray.length; ++i2) {
            switch (sArray[i2]) {
                case 1: {
                    tVTunerKeyPanelListCollector.tvtuner_key_panel_button_yellow = ++n;
                    break;
                }
                case 2: {
                    tVTunerKeyPanelListCollector.tvtuner_key_panel_button_green = ++n;
                    break;
                }
                case 3: {
                    tVTunerKeyPanelListCollector.tvtuner_key_panel_button_red = ++n;
                    break;
                }
                case 4: {
                    tVTunerKeyPanelListCollector.tvtuner_key_panel_button_blue = ++n;
                    break;
                }
            }
            if (n >= 3) break;
        }
        this.keyPanelMap.put(new Short(sArray[0]), tVTunerKeyPanelListCollector);
    }

    public TVTunerKeyPanelListCollector getKeyPanelPositions(int n) {
        TVTunerKeyPanelListCollector tVTunerKeyPanelListCollector = (TVTunerKeyPanelListCollector)this.keyPanelMap.get(new Short((short)n));
        if (tVTunerKeyPanelListCollector != null) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("KeyPanelList#getKeyPanelPositions( ").append(n).append(" ) - result != null, collector = ").append(this.toString(tVTunerKeyPanelListCollector)).toString());
            }
        } else {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("KeyPanelList#getKeyPanelPositions( ").append(n).append(" ) - result == null, returning DEFAULT_COLLECTOR").toString());
            }
            tVTunerKeyPanelListCollector = DEFAULT_COLLECTOR;
        }
        return tVTunerKeyPanelListCollector;
    }

    public String toString(TVTunerKeyPanelListCollector tVTunerKeyPanelListCollector) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("yellow: ").append(tVTunerKeyPanelListCollector.tvtuner_key_panel_button_yellow).append(", ");
        stringBuffer.append("green: ").append(tVTunerKeyPanelListCollector.tvtuner_key_panel_button_green).append(", ");
        stringBuffer.append("red: ").append(tVTunerKeyPanelListCollector.tvtuner_key_panel_button_red).append(", ");
        stringBuffer.append("blue: ").append(tVTunerKeyPanelListCollector.tvtuner_key_panel_button_blue);
        return stringBuffer.toString();
    }
}


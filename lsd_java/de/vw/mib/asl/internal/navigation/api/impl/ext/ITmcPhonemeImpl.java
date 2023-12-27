/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.traffic.ITmcPhoneme;
import org.dsi.ifc.tmc.TmcPhoneme;

public class ITmcPhonemeImpl
implements ITmcPhoneme {
    private String directionOfRoad1;
    private String directionOfRoad2;
    private String endLocation;
    private String phonemeAlphabet;
    private String roadName;
    private String startLocation;

    public ITmcPhonemeImpl(TmcPhoneme tmcPhoneme) {
        if (tmcPhoneme != null) {
            this.setDirectionOfRoad1(tmcPhoneme.getDirectionOfRoad1());
            this.setDirectionOfRoad2(tmcPhoneme.getDirectionOfRoad2());
            this.setEndLocation(tmcPhoneme.getEndLocation());
            this.setPhonemeAlphabet(tmcPhoneme.getPhonemeAlphabet());
            this.setRoadName(tmcPhoneme.getRoadName());
            this.setStartLocation(tmcPhoneme.getStartLocation());
        } else {
            this.setDirectionOfRoad1("");
            this.setDirectionOfRoad2("");
            this.setEndLocation("");
            this.setPhonemeAlphabet("");
            this.setRoadName("");
            this.setStartLocation("");
        }
    }

    @Override
    public String getDirectionOfRoad1() {
        return this.directionOfRoad1;
    }

    private void setDirectionOfRoad1(String string) {
        this.directionOfRoad1 = string;
    }

    @Override
    public String getDirectionOfRoad2() {
        return this.directionOfRoad2;
    }

    private void setDirectionOfRoad2(String string) {
        this.directionOfRoad2 = string;
    }

    @Override
    public String getEndLocation() {
        return this.endLocation;
    }

    private void setEndLocation(String string) {
        this.endLocation = string;
    }

    @Override
    public String getPhonemeAlphabet() {
        return this.phonemeAlphabet;
    }

    private void setPhonemeAlphabet(String string) {
        this.phonemeAlphabet = string;
    }

    @Override
    public String getRoadName() {
        return this.roadName;
    }

    private void setRoadName(String string) {
        this.roadName = string;
    }

    @Override
    public String getStartLocation() {
        return this.startLocation;
    }

    private void setStartLocation(String string) {
        this.startLocation = string;
    }
}


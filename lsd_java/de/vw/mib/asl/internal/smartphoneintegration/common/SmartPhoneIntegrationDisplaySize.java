/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;

public class SmartPhoneIntegrationDisplaySize {
    static int CONST_DISPLAYTYPE_UNKNOWN = 0;
    static int CONST_DISPLAYTYPE_9_2_INCH = 1;
    static int CONST_DISPLAYTYPE_15_INCH = 2;
    static int CONST_DISPLAYTYPE_8_INCH = 3;
    static int CONST_DISPLAYTYPE_6_5_INCH = 4;
    private HsmTarget target;
    private String classname = "SmartPhoneIntegrationDisplaySize.";
    private double[] pixelsize_w = new double[]{0.0, 0.1631, 0.1756, 0.2178, 0.177};
    private double[] pixelsize_h = new double[]{0.0, 0.1631, 0.1756, 0.2178, 0.177};
    private int type = CONST_DISPLAYTYPE_UNKNOWN;

    SmartPhoneIntegrationDisplaySize(HsmTarget hsmTarget) {
        this.target = hsmTarget;
        int n = ASLSystemFactory.getSystemApi().getAbtFeatureService().getAbtType();
        ASLSystemFactory.getSystemApi().getAbtFeatureService();
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this.classname).append("SmartPhoneIntegrationDisplaySize()").log();
        }
        switch (n) {
            case 1: {
                this.type = CONST_DISPLAYTYPE_6_5_INCH;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.ABT_TYPE_ALPINE_6_5").log();
                break;
            }
            case 3: {
                this.type = CONST_DISPLAYTYPE_6_5_INCH;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.ABT_TYPE_CONTI_6_5").log();
                break;
            }
            case 2: {
                this.type = CONST_DISPLAYTYPE_8_INCH;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.ABT_TYPE_ALPINE_8").log();
                break;
            }
            case 5: {
                this.type = CONST_DISPLAYTYPE_8_INCH;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.ABT_TYPE_CONTI_8_GEN2_GP").log();
                break;
            }
            case 6: {
                this.type = CONST_DISPLAYTYPE_9_2_INCH;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.ABT_TYPE_CONTI_9_2_GEN2_GP").log();
                break;
            }
            case 4: {
                this.type = CONST_DISPLAYTYPE_15_INCH;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.ABT_TYPE_CONTI_VW_621").log();
                break;
            }
            default: {
                this.type = CONST_DISPLAYTYPE_UNKNOWN;
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append(this.classname).append("AbtFeatureService.UNKNOWN").log();
            }
        }
    }

    public double getDisplayWidth() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this.classname).append(new StringBuffer().append("getDisplayWidth( ").append(this.type).append("= ").toString()).append(this.pixelsize_w[this.type]).append(")").log();
        }
        return this.pixelsize_w[this.type];
    }

    public double getDisplayHeight() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this.classname).append(new StringBuffer().append("getDisplayHeight( ").append(this.type).append("= ").toString()).append(this.pixelsize_h[this.type]).append(")").log();
        }
        return this.pixelsize_h[this.type];
    }
}


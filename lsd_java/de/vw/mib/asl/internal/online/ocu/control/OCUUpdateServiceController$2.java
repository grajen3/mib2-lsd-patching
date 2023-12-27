/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.internal.online.ocu.OCUUpdateServiceFactory;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceController;
import de.vw.mib.asl.internal.online.ocu.control.OCUUpdateServiceHashCalculation;
import de.vw.mib.util.Util;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

class OCUUpdateServiceController$2
implements Runnable {
    private final /* synthetic */ OCUUpdateServiceController this$0;

    OCUUpdateServiceController$2(OCUUpdateServiceController oCUUpdateServiceController) {
        this.this$0 = oCUUpdateServiceController;
    }

    @Override
    public void run() {
        try {
            if (!Util.isNullOrEmpty(this.this$0.getCurrentService().getChallengeDataWithType(1))) {
                if (!Util.isNullOrEmpty(this.this$0.getCurrentService().getSPinNumeric())) {
                    OCUUpdateServiceHashCalculation.init();
                    String string = OCUUpdateServiceHashCalculation.hashSecurityPin(this.this$0.getCurrentService().getChallengeDataWithType(1), this.this$0.getCurrentService().getSPinNumeric());
                    if (!Util.isNullOrEmpty(this.this$0.getCurrentService().getChallengeDataWithType(0))) {
                        string = OCUUpdateServiceHashCalculation.hashSecurityPinForTransmission(string, this.this$0.getCurrentService().getChallengeDataWithType(0));
                        OCUUpdateServiceFactory.getServiceHandler(OCUUpdateServiceController.access$000(this.this$0)).sendForUpdateServiceAuthentication(string);
                    } else {
                        OCUUpdateServiceController.access$200(this.this$0, OCUUpdateServiceController.access$100(this.this$0));
                        this.this$0.setState(11);
                    }
                } else {
                    OCUUpdateServiceController.access$000(this.this$0).info().append(OCUUpdateServiceController.access$300(this.this$0)).append(".updateSpinHashResult()->SPIN is invalid").log();
                }
            } else {
                OCUUpdateServiceController.access$000(this.this$0).info().append(OCUUpdateServiceController.access$300(this.this$0)).append(".updateSpinHashResult()->user challenge failed").log();
                OCUUpdateServiceController.access$200(this.this$0, OCUUpdateServiceController.access$100(this.this$0));
                this.this$0.setState(11);
            }
        }
        catch (NoSuchProviderException noSuchProviderException) {
            OCUUpdateServiceController.access$000(this.this$0).error(noSuchProviderException);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            OCUUpdateServiceController.access$000(this.this$0).error(noSuchAlgorithmException);
        }
    }
}


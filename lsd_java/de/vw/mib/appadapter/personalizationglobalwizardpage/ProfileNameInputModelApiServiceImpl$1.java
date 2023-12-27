/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.personalizationglobalwizardpage;

import de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiServiceImpl;
import de.vw.mib.asl.api.car.pso.PersonalizationAdapter;

class ProfileNameInputModelApiServiceImpl$1
extends PersonalizationAdapter {
    private final /* synthetic */ ProfileNameInputModelApiServiceImpl this$0;

    ProfileNameInputModelApiServiceImpl$1(ProfileNameInputModelApiServiceImpl profileNameInputModelApiServiceImpl) {
        this.this$0 = profileNameInputModelApiServiceImpl;
    }

    @Override
    public void updateActiveProfile(String string, int n) {
        this.this$0.modelApiCallback._update_getProfileName(string);
        this.this$0.modelApiCallback._update_getProfileType(n);
    }

    @Override
    public void updateActive(boolean bl) {
        this.this$0.evaluateIntent(bl);
    }
}


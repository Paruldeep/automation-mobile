package com.thescore;

import com.thescore.screens.*;

public class ApplicationScreen {

    public static AllowLocationScreen getAllowLocationScreen() {
        return new AllowLocationScreen();
    }

    public static HomeScreen getHomeScreen() {
        return new HomeScreen();
    }

    public static LeaguesScreen getLeaguesScreen() {
        return new LeaguesScreen();
    }

    public static LoginScreen getLoginScreen() {
        return new LoginScreen();
    }

    public static TermsAndConditionScreen getTermsAndConditionScreen() {
        return new TermsAndConditionScreen();
    }

    public static WelcomeScreen getWelcomeScreen() {
        return new WelcomeScreen();
    }

    public static LeagueScreen getLeagueScreen() {
        return new LeagueScreen();
    }

    public static LeadersTabScreen getLeadersTabScreen() {
        return new LeadersTabScreen();
    }
}

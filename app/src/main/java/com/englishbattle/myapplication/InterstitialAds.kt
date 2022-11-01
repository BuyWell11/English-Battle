package com.englishbattle.myapplication

import android.app.Activity
import android.content.Context
import com.yandex.mobile.ads.interstitial.InterstitialAd
import android.os.Bundle
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData

class InterstitialAds : Activity() {
    var mInterstitialAd: InterstitialAd? = null

    // Creating an ad targeting object.
    val adRequest = AdRequest.Builder().build()

    fun loadAndShowAd(context : Context)
    {
        // Creating an InterstitialAd instance.
        mInterstitialAd = InterstitialAd(context)
        mInterstitialAd!!.setAdUnitId(AdUnitId)


        // Registering a listener to track events in the ad.
        mInterstitialAd!!.setInterstitialAdEventListener(object : InterstitialAdEventListener {
            override fun onAdLoaded() {
                mInterstitialAd!!.show()
            }

            override fun onAdFailedToLoad(adRequestError: AdRequestError) {}
            override fun onAdShown() {}
            override fun onAdDismissed() {}
            override fun onAdClicked() {}
            override fun onLeftApplication() {}
            override fun onReturnedToApplication() {}
            override fun onImpression(impressionData: ImpressionData?) {}
        })

        // Loading ads.
        mInterstitialAd!!.loadAd(adRequest)
    }

    companion object {
        const val AdUnitId = "R-M-1973138-3"
    }
}
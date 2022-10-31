package com.englishbattle.myapplication

import android.app.Activity
import com.yandex.mobile.ads.interstitial.InterstitialAd
import android.os.Bundle
import com.englishbattle.myapplication.test
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData

class test : Activity() {
    private var mInterstitialAd: InterstitialAd? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        // Создание экземпляра InterstitialAd.
        super.onCreate(savedInstanceState)
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd!!.setAdUnitId(AdUnitId)

        // Создание объекта таргетирования рекламы.
        val adRequest = AdRequest.Builder().build()

        // Регистрация слушателя для отслеживания событий, происходящих в рекламе.
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

        // Загрузка объявления.
        mInterstitialAd!!.loadAd(adRequest)
    }

    companion object {
        private const val AdUnitId = "YOUR_AdUnitId"
    }
}
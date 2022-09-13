@file:OptIn(ExperimentalCoroutinesApi::class)

package com.yubyf.truetypeparser

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * Fonts in assets folder are referenced from [here](https://github.com/adobe-fonts/source-han-sans/tree/release)
 */
@RunWith(AndroidJUnit4::class)
class TTFFileTest {
    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun testOpenSourceHanSansSCVf() = runTest {
        val ttfFile = TTFFile.open(context.assets.open("SourceHanSansSC-VF.otf"))
        // Weight
        Assert.assertEquals(ttfFile.weightClass, 250)
        // Copyright
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            with(ttfFile) { copyrights[Locale.ENGLISH] }
        )
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            with(ttfFile) { copyrights[Locale.SIMPLIFIED_CHINESE] }
        )
        // Family
        Assert.assertEquals("Source Han Sans SC VF", with(ttfFile) { families[Locale.ENGLISH] })
        Assert.assertEquals("思源黑体 VF", with(ttfFile) { families[Locale.SIMPLIFIED_CHINESE] })
        Assert.assertEquals("思源黑体 VF", with(ttfFile) { families[Locale.TRADITIONAL_CHINESE] })
        Assert.assertEquals("Source Han Sans SC VF", with(ttfFile) { families[Locale.ROOT] })
        // Subfamily
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.ENGLISH] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.SIMPLIFIED_CHINESE] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.TRADITIONAL_CHINESE] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.ROOT] })
        // Full name
        Assert.assertEquals("Source Han Sans SC VF", with(ttfFile) { fullNames[Locale.ENGLISH] })
        Assert.assertEquals("思源黑体 VF", with(ttfFile) { fullNames[Locale.SIMPLIFIED_CHINESE] })
        Assert.assertEquals("思源黑体 VF", with(ttfFile) { fullNames[Locale.TRADITIONAL_CHINESE] })
        Assert.assertEquals("Source Han Sans SC VF", with(ttfFile) { fullNames[Locale.ROOT] })
        // Manufacturer
        Assert.assertEquals("Adobe", with(ttfFile) { manufacturers[Locale.ENGLISH] })
        // Designer
        Assert.assertEquals(
            "Ryoko NISHIZUKA 西塚涼子 (kana, bopomofo & ideographs); Paul D. Hunt (Latin, Greek & Cyrillic); Sandoll Communications 산돌커뮤니케이션, Soo-young JANG 장수영 & Joo-yeon KANG 강주연 (hangul elements, letters & syllables)",
            with(ttfFile) { designers[Locale.ENGLISH] }
        )
        // Vendor URL
        Assert.assertEquals("http://www.adobe.com/type/", ttfFile.vendorURL)
        // Preferred Subfamily
        Assert.assertEquals("ExtraLight", with(ttfFile) { preferSubfamilies[Locale.ENGLISH] })
        Assert.assertEquals("ExtraLight",
            with(ttfFile) { preferSubfamilies[Locale.SIMPLIFIED_CHINESE] })
        Assert.assertEquals("ExtraLight",
            with(ttfFile) { preferSubfamilies[Locale.TRADITIONAL_CHINESE] })
        Assert.assertEquals("ExtraLight", with(ttfFile) { preferSubfamilies[Locale.ROOT] })
    }

    @Test
    fun testOpenSourceHanSansJ() = runTest {
        val ttfFile = TTFFile.open(context.assets.open("SourceHanSansJ-Medium.otf"))
        // Weight
        Assert.assertEquals(ttfFile.weightClass, 500)
        // Copyright
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            with(ttfFile) { copyrights[Locale.ENGLISH] }
        )
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            with(ttfFile) { copyrights[Locale.JAPANESE] }
        )
        // Family
        Assert.assertEquals("Source Han Sans Medium", with(ttfFile) { families[Locale.ENGLISH] })
        Assert.assertEquals("源ノ角ゴシック Medium", with(ttfFile) { families[Locale.JAPANESE] })
        Assert.assertEquals("Source Han Sans Medium", with(ttfFile) { families[Locale.ROOT] })
        // Subfamily
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.ENGLISH] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.JAPANESE] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.ROOT] })
        // Full name
        Assert.assertEquals("Source Han Sans Medium", with(ttfFile) { fullNames[Locale.ENGLISH] })
        Assert.assertEquals("源ノ角ゴシック Medium",
            with(ttfFile) { fullNames[Locale.JAPANESE] })
        Assert.assertEquals("Source Han Sans Medium", with(ttfFile) { fullNames[Locale.ROOT] })
        // Manufacturer
        Assert.assertEquals("Adobe", with(ttfFile) { manufacturers[Locale.ENGLISH] })
        // Designer
        Assert.assertEquals(
            "Ryoko NISHIZUKA 西塚涼子 (kana, bopomofo & ideographs); Paul D. Hunt (Latin, Greek & Cyrillic); Sandoll Communications 산돌커뮤니케이션, Soo-young JANG 장수영 & Joo-yeon KANG 강주연 (hangul elements, letters & syllables)",
            with(ttfFile) { designers[Locale.ENGLISH] }
        )
        // Vendor URL
        Assert.assertEquals("http://www.adobe.com/type/", ttfFile.vendorURL)
        // Preferred Family
        Assert.assertEquals("Source Han Sans", with(ttfFile) { preferFamilies[Locale.ENGLISH] })
        Assert.assertEquals("源ノ角ゴシック",
            with(ttfFile) { preferFamilies[Locale.JAPANESE] })
        Assert.assertEquals("Source Han Sans", with(ttfFile) { preferFamilies[Locale.ROOT] })
        // Preferred Subfamily
        Assert.assertEquals("Medium", with(ttfFile) { preferSubfamilies[Locale.ENGLISH] })
        Assert.assertEquals("Medium", with(ttfFile) { preferSubfamilies[Locale.JAPANESE] })
        Assert.assertEquals("Medium", with(ttfFile) { preferSubfamilies[Locale.ROOT] })
    }

    @Test
    fun testOpenSourceHanSansKRVf() = runTest {
        val ttfFile = TTFFile.open(context.assets.open("SourceHanSansKR-VF.ttf"))
        // Weight
        Assert.assertEquals(ttfFile.weightClass, 250)
        // Copyright
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            with(ttfFile) { copyrights[Locale.ENGLISH] }
        )
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            with(ttfFile) { copyrights[Locale.KOREAN] }
        )
        // Family
        Assert.assertEquals("Source Han Sans KR VF", with(ttfFile) { families[Locale.ENGLISH] })
        Assert.assertEquals("본고딕 KR VF", with(ttfFile) { families[Locale.KOREAN] })
        Assert.assertEquals("Source Han Sans KR VF", with(ttfFile) { families[Locale.ROOT] })
        // Subfamily
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.ENGLISH] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.KOREAN] })
        Assert.assertEquals("Regular", with(ttfFile) { subfamilies[Locale.ROOT] })
        // Full name
        Assert.assertEquals("Source Han Sans KR VF", with(ttfFile) { fullNames[Locale.ENGLISH] })
        Assert.assertEquals("본고딕 KR VF",
            with(ttfFile) { fullNames[Locale.KOREAN] })
        Assert.assertEquals("Source Han Sans KR VF", with(ttfFile) { fullNames[Locale.ROOT] })
        // Manufacturer
        Assert.assertEquals("Adobe", with(ttfFile) { manufacturers[Locale.ENGLISH] })
        // Designer
        Assert.assertEquals(
            "Ryoko NISHIZUKA 西塚涼子 (kana, bopomofo & ideographs); Paul D. Hunt (Latin, Greek & Cyrillic); Sandoll Communications 산돌커뮤니케이션, Soo-young JANG 장수영 & Joo-yeon KANG 강주연 (hangul elements, letters & syllables)",
            with(ttfFile) { designers[Locale.ENGLISH] }
        )
        // Vendor URL
        Assert.assertEquals("http://www.adobe.com/type/", ttfFile.vendorURL)
        // Preferred Subfamily
        Assert.assertEquals("ExtraLight", with(ttfFile) { preferSubfamilies[Locale.ENGLISH] })
        Assert.assertEquals("ExtraLight", with(ttfFile) { preferSubfamilies[Locale.KOREAN] })
        Assert.assertEquals("ExtraLight", with(ttfFile) { preferSubfamilies[Locale.ROOT] })
    }
}
package com.yubyf.truetypeparser

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
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
            ttfFile.getCopyright(Locale.ENGLISH)
        )
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            ttfFile.getCopyright(Locale.SIMPLIFIED_CHINESE)
        )
        // Family
        Assert.assertEquals("Source Han Sans SC VF", ttfFile.getFamily(Locale.ENGLISH))
        Assert.assertEquals("思源黑体 VF", ttfFile.getFamily(Locale.SIMPLIFIED_CHINESE))
        Assert.assertEquals("思源黑体 VF", ttfFile.getFamily(Locale.TRADITIONAL_CHINESE))
        Assert.assertEquals("Source Han Sans SC VF", ttfFile.getFamily(Locale.ROOT))
        // Subfamily
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.ENGLISH))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.SIMPLIFIED_CHINESE))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.TRADITIONAL_CHINESE))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.ROOT))
        // Full name
        Assert.assertEquals("Source Han Sans SC VF", ttfFile.getFullName(Locale.ENGLISH))
        Assert.assertEquals("思源黑体 VF", ttfFile.getFullName(Locale.SIMPLIFIED_CHINESE))
        Assert.assertEquals("思源黑体 VF", ttfFile.getFullName(Locale.TRADITIONAL_CHINESE))
        Assert.assertEquals("Source Han Sans SC VF", ttfFile.getFullName(Locale.ROOT))
        // Manufacturer
        Assert.assertEquals("Adobe", ttfFile.getManufacturer(Locale.ENGLISH))
        // Designer
        Assert.assertEquals(
            "Ryoko NISHIZUKA 西塚涼子 (kana, bopomofo & ideographs); Paul D. Hunt (Latin, Greek & Cyrillic); Sandoll Communications 산돌커뮤니케이션, Soo-young JANG 장수영 & Joo-yeon KANG 강주연 (hangul elements, letters & syllables)",
            ttfFile.getDesigner(Locale.ENGLISH)
        )
        // Vendor URL
        Assert.assertEquals("http://www.adobe.com/type/", ttfFile.vendorURL)
        // Preferred Subfamily
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.ENGLISH))
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.SIMPLIFIED_CHINESE))
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.TRADITIONAL_CHINESE))
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.ROOT))
    }

    @Test
    fun testOpenSourceHanSansJ() = runTest {
        val ttfFile = TTFFile.open(context.assets.open("SourceHanSansJ-Medium.otf"))
        // Weight
        Assert.assertEquals(ttfFile.weightClass, 500)
        // Copyright
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            ttfFile.getCopyright(Locale.ENGLISH)
        )
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            ttfFile.getCopyright(Locale.JAPANESE)
        )
        // Family
        Assert.assertEquals("Source Han Sans Medium", ttfFile.getFamily(Locale.ENGLISH))
        Assert.assertEquals("源ノ角ゴシック Medium", ttfFile.getFamily(Locale.JAPANESE))
        Assert.assertEquals("Source Han Sans Medium", ttfFile.getFamily(Locale.ROOT))
        // Subfamily
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.ENGLISH))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.JAPANESE))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.ROOT))
        // Full name
        Assert.assertEquals("Source Han Sans Medium", ttfFile.getFullName(Locale.ENGLISH))
        Assert.assertEquals("源ノ角ゴシック Medium",
            ttfFile.getFullName(Locale.JAPANESE))
        Assert.assertEquals("Source Han Sans Medium", ttfFile.getFullName(Locale.ROOT))
        // Manufacturer
        Assert.assertEquals("Adobe", ttfFile.getManufacturer(Locale.ENGLISH))
        // Designer
        Assert.assertEquals(
            "Ryoko NISHIZUKA 西塚涼子 (kana, bopomofo & ideographs); Paul D. Hunt (Latin, Greek & Cyrillic); Sandoll Communications 산돌커뮤니케이션, Soo-young JANG 장수영 & Joo-yeon KANG 강주연 (hangul elements, letters & syllables)",
            ttfFile.getDesigner(Locale.ENGLISH)
        )
        // Vendor URL
        Assert.assertEquals("http://www.adobe.com/type/", ttfFile.vendorURL)
        // Preferred Family
        Assert.assertEquals("Source Han Sans", ttfFile.getPreferFamily(Locale.ENGLISH))
        Assert.assertEquals("源ノ角ゴシック",
            ttfFile.getPreferFamily(Locale.JAPANESE))
        Assert.assertEquals("Source Han Sans", ttfFile.getPreferFamily(Locale.ROOT))
        // Preferred Subfamily
        Assert.assertEquals("Medium", ttfFile.getPreferSubfamily(Locale.ENGLISH))
        Assert.assertEquals("Medium", ttfFile.getPreferSubfamily(Locale.JAPANESE))
        Assert.assertEquals("Medium", ttfFile.getPreferSubfamily(Locale.ROOT))
    }

    @Test
    fun testOpenSourceHanSansKRVf() = runTest {
        val ttfFile = TTFFile.open(context.assets.open("SourceHanSansKR-VF.ttf"))
        // Weight
        Assert.assertEquals(ttfFile.weightClass, 250)
        // Copyright
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            ttfFile.getCopyright(Locale.ENGLISH)
        )
        Assert.assertEquals(
            "© 2014-2021 Adobe (http://www.adobe.com/), with Reserved Font Name 'Source'.",
            ttfFile.getCopyright(Locale.KOREAN)
        )
        // Family
        Assert.assertEquals("Source Han Sans KR VF", ttfFile.getFamily(Locale.ENGLISH))
        Assert.assertEquals("본고딕 KR VF", ttfFile.getFamily(Locale.KOREAN))
        Assert.assertEquals("Source Han Sans KR VF", ttfFile.getFamily(Locale.ROOT))
        // Subfamily
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.ENGLISH))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.KOREAN))
        Assert.assertEquals("Regular", ttfFile.getSubfamily(Locale.ROOT))
        // Full name
        Assert.assertEquals("Source Han Sans KR VF", ttfFile.getFullName(Locale.ENGLISH))
        Assert.assertEquals("본고딕 KR VF",
            ttfFile.getFullName(Locale.KOREAN))
        Assert.assertEquals("Source Han Sans KR VF", ttfFile.getFullName(Locale.ROOT))
        // Manufacturer
        Assert.assertEquals("Adobe", ttfFile.getManufacturer(Locale.ENGLISH))
        // Designer
        Assert.assertEquals(
            "Ryoko NISHIZUKA 西塚涼子 (kana, bopomofo & ideographs); Paul D. Hunt (Latin, Greek & Cyrillic); Sandoll Communications 산돌커뮤니케이션, Soo-young JANG 장수영 & Joo-yeon KANG 강주연 (hangul elements, letters & syllables)",
            ttfFile.getDesigner(Locale.ENGLISH)
        )
        // Vendor URL
        Assert.assertEquals("http://www.adobe.com/type/", ttfFile.vendorURL)
        // Preferred Subfamily
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.ENGLISH))
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.KOREAN))
        Assert.assertEquals("ExtraLight", ttfFile.getPreferSubfamily(Locale.ROOT))
    }
}
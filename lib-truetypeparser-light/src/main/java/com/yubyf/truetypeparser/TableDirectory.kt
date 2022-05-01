/*
 * Modified by Yubyf on 2022:
 * Copyright (c) 2022 Yubyf <lpy19920505@gmail.com>
 *
 * Copyright (C) 2016 Jared Rummler <jared.rummler@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
/* $Id: TTFDirTabEntry.java 1357883 2012-07-05 20:29:53Z gadams $ */
package com.yubyf.truetypeparser

import java.io.IOException

/**
 * This class represents an entry to a TrueType font's table directory.
 */
internal data class TableDirectory(
    var tag: String = "",
    var offset: Long = 0,
    var length: Long = 0,
) {
    /**
     * Read table directory.
     *
     * @param reader font file reader
     * @return this table directory
     * @throws IOException upon I/O exception
     */
    @Throws(IOException::class)
    fun read(reader: FontStreamReader): TableDirectory {
        val tagBuf = ByteArray(4)
        reader.readTo(tagBuf)
        tag = runCatching { String(tagBuf, Charsets.ISO_8859_1) }.getOrDefault("")
        // Skip checksum
        reader.skip(4)
        offset = reader.readUInt32()
        length = reader.readUInt32()
        return this
    }
}
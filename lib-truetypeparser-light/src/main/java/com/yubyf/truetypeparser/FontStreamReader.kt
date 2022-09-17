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
package com.yubyf.truetypeparser

import java.io.*
import java.nio.charset.Charset

/**
 * Reads a TrueType font file or a segment of font file and provides file like functions for array access.
 */
internal class FontStreamReader : Closeable {

    /**
     * The size of the file.
     */
    private var size = 0

    /**
     * Current position in file
     */
    private var position = 0

    private lateinit var stream: InputStream

    @Throws(IOException::class)
    constructor(inputStream: InputStream) {
        init(inputStream)
    }

    @Throws(IOException::class)
    constructor(path: String) {
        init(FileInputStream(path))
    }

    /**
     * Initializes class and reads stream. Init does not close stream.
     *
     * @param inputStream InputStream to read from new array with size + inc
     * @throws IOException In case of an I/O problem
     */
    @Throws(IOException::class)
    private fun init(inputStream: InputStream) {
        stream = inputStream
        size = inputStream.available()
        if (stream.markSupported()) {
            stream.mark(-1)
        }
        position = 0
    }

    /**
     * Read 1 byte.
     *
     * @return One byte
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun read(): Byte {
        if (position >= size) {
            throw EOFException("Reached EOF, file size=$size")
        }
        position++
        return stream.read().toByte()
    }

    @Throws(IOException::class)
    fun readTo(bytes: ByteArray): Int {
        if (size - position <= bytes.size) {
            throw EOFException("Reached EOF, file size=$size")
        }
        val result = stream.read(bytes)
        position += bytes.size
        return result
    }

    /**
     * Read 1 signed byte.
     *
     * @return One byte
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readInt8(): Int {
        return read().toInt()
    }

    /**
     * Read 1 unsigned byte.
     *
     * @return One unsigned byte
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readUInt8(): Int {
        return read().let {
            if (it < 0) {
                256 + it
            } else {
                it.toInt()
            }
        }
    }

    /**
     * Read 2 bytes signed.
     *
     * @return One unsigned short
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readInt16(): Int {
        return (readUInt8() shl 8) + readUInt8()
    }

    /**
     * Read 2 bytes unsigned.
     *
     * @return One unsigned short
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readUInt16(): Int {
        return (readUInt8() shl 8) + readUInt8()
    }

    /**
     * Read 4 bytes.
     *
     * @return One signed integer
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readInt32(): Int {
        var ret = readUInt8().toLong()
        ret = (ret shl 8) + readUInt8()
        ret = (ret shl 8) + readUInt8()
        ret = (ret shl 8) + readUInt8()
        return ret.toInt()
    }

    /**
     * Read 4 bytes unsigned.
     *
     * @return One unsigned integer
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readUInt32(): Long {
        var ret = readUInt8().toLong()
        ret = (ret shl 8) + readUInt8()
        ret = (ret shl 8) + readUInt8()
        ret = (ret shl 8) + readUInt8()
        return ret
    }

    /**
     * Read 32 bytes fixed float(16.16).
     *
     * @return One float
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readFixedFloat32(): Float = readUInt32() / 65536f

    /**
     * Read an ISO-8859-1 string of length bytes.
     *
     * @param length The length of the string to read
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readString(length: Int): String {
        if ((length + position) > size) {
            throw EOFException("Reached EOF, file size - $size")
        }
        val buf = ByteArray(length)
        stream.read(buf, 0, length)
        position += length
        val encoding: Charset = if (buf.isNotEmpty() && buf[0] == 0.toByte()) {
            Charsets.UTF_16BE
        } else {
            Charsets.ISO_8859_1
        }
        return String(buf, encoding)
    }

    /**
     * Read an string of length bytes in the specific encoding.
     *
     * @param length    The length of the string to read
     * @param encoding  The string encoding
     * @throws IOException If EOF is reached
     */
    @Throws(IOException::class)
    fun readString(length: Int, encoding: Charset): String {
        if ((length + position) > size) {
            throw EOFException("Reached EOF, file size=$size")
        }
        val buf = ByteArray(length)
        stream.read(buf, 0, length)
        position += length
        return String(buf, encoding)
    }

    /**
     * Set current file position to offset
     *
     * @param offset The new offset to set
     * @throws IOException In case of an I/O problem
     */
    @Throws(IOException::class)
    fun seekAt(offset: Long) {
        if (offset > size || offset < 0) {
            throw EOFException("Reached EOF, file size=$size offset=$offset")
        }
        if (offset > position) {
            position += stream.skip(offset - position).toInt()
        } else if (stream.markSupported()) {
            stream.reset()
            position = stream.skip(offset).toInt()
        }
    }

    /**
     * Skip a given number of bytes.
     *
     * @param add The number of bytes to advance
     * @throws IOException In case of an I/O problem
     */
    @Throws(IOException::class)
    fun skip(add: Long) {
        if ((add + position) > size || add < 0) {
            throw EOFException("Reached EOF, file size=$size offset=$add")
        }
        stream.skip(add)
        position += add.toInt()
    }

    override fun close() {
        stream.close()
    }
}
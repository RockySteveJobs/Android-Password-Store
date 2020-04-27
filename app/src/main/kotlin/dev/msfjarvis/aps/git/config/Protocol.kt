/*
 * Copyright © 2014-2020 The Android Password Store Authors. All Rights Reserved.
 * SPDX-License-Identifier: GPL-3.0-only
 */
package dev.msfjarvis.aps.git.config

enum class Protocol(val pref: String) {
    Ssh("ssh://"),
    Https("https://");

    companion object {
        private val map = values().associateBy(dev.msfjarvis.aps.ng.git.config.Protocol::pref)
        fun fromString(type: String?): dev.msfjarvis.aps.ng.git.config.Protocol {
            return map[type ?: return Ssh]
                ?: throw IllegalArgumentException("$type is not a valid Protocol")
        }
    }
}
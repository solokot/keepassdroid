/*
 * Copyright 2017-2021 Brian Pellin.
 *
 * This file is part of KeePassDroid.
 *
 *  KeePassDroid is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  KeePassDroid is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KeePassDroid.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.keepassdroid.crypto.keyDerivation;

import com.keepassdroid.crypto.NativeLib;

import java.io.IOException;

public class Argon2Native {

    public static byte[] transformKey(byte[] password, byte[] salt, int parallelism,
                                              long memory, long iterations, byte[] secretKey,
                                              byte[] associatedData, long version, int type) throws IOException {
        NativeLib.init();

        return nTransformMasterKey(password, salt, parallelism, memory, iterations, secretKey, associatedData, version, type);
    }

    private static native byte[] nTransformMasterKey(byte[] password, byte[] salt, int parallelism,
                                              long memory, long iterations, byte[] secretKey,
                                              byte[] associatedData, long version, int type) throws IOException;
}

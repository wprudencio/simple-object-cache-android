/*
 * Copyright (C) 2013 Weslei Prudencio
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
 */

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SimpleObjectCache {

    public static void saveObject(Object object, String id,Context context) {
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File(context.getCacheDir(), "") + "/"+id));
            out.writeObject(object);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object loadObject(String id,Context context) throws FileNotFoundException {
        Object object = null;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(new File(new File(context.getCacheDir(), "") + "/"+id)));
            object = in.readObject();
            in.close();
        }catch (IOException | ClassNotFoundException e){
            throw new FileNotFoundException();
        }
        return object;
    }
    
    public static Boolean removeObject(String id,Context context){
    	File file = new File(new File(context.getCacheDir(), "") + "/"+id);
    	return file.delete();
    }
}

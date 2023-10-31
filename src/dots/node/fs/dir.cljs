(ns dots.node.fs.dir
  "A class representing a directory stream.
   
   Created by {@link opendir }, {@link opendirSync }, or `fsPromises.opendir()`.
   
   ```js
   import { opendir } from 'fs/promises';
   
   try {
     const dir = await opendir('./');
     for await (const dirent of dir)
       console.log(dirent.name);
   } catch (err) {
     console.error(err);
   }
   ```
   
   When using the async iterator, the `fs.Dir` object will be automatically
   closed after the iterator exits.")

(defn path
  "The read-only path of this directory as was provided to {@link opendir },{@link opendirSync }, or `fsPromises.opendir()`."
  ^js [dir]
  (.-path ^js dir))

(defn close
  "Asynchronously close the directory's underlying resource handle.
   Subsequent reads will result in errors.
   
   A promise is returned that will be resolved after the resource has been
   closed."
  (^js [dir]
   (.close ^js dir))
  (^js [dir cb]
   (.close ^js dir cb)))

(defn close-sync
  "Synchronously close the directory's underlying resource handle.
   Subsequent reads will result in errors."
  ^js [dir]
  (.closeSync ^js dir))

(defn read
  "Asynchronously read the next directory entry via [`readdir(3)`](http://man7.org/linux/man-pages/man3/readdir.3.html) as an `fs.Dirent`.
   
   A promise is returned that will be resolved with an `fs.Dirent`, or `null`if there are no more directory entries to read.
   
   Directory entries returned by this function are in no particular order as
   provided by the operating system's underlying directory mechanisms.
   Entries added or removed while iterating over the directory might not be
   included in the iteration results."
  (^js [dir]
   (.read ^js dir))
  (^js [dir cb]
   (.read ^js dir cb)))

(defn read-sync
  "Synchronously read the next directory entry as an `fs.Dirent`. See the
   POSIX [`readdir(3)`](http://man7.org/linux/man-pages/man3/readdir.3.html) documentation for more detail.
   
   If there are no more directory entries to read, `null` will be returned.
   
   Directory entries returned by this function are in no particular order as
   provided by the operating system's underlying directory mechanisms.
   Entries added or removed while iterating over the directory might not be
   included in the iteration results."
  ^js [dir]
  (.readSync ^js dir))

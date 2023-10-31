(ns dots.fs.dirent
  "A representation of a directory entry, which can be a file or a subdirectory
   within the directory, as returned by reading from an `fs.Dir`. The
   directory entry is a combination of the file name and file type pairs.
   
   Additionally, when {@link readdir } or {@link readdirSync } is called with
   the `withFileTypes` option set to `true`, the resulting array is filled with `fs.Dirent` objects, rather than strings or `Buffer` s."
  (:refer-clojure :exclude [name]))

(defn file?
  "Returns `true` if the `fs.Dirent` object describes a regular file."
  ^js [dirent]
  (.isFile ^js dirent))

(defn directory?
  "Returns `true` if the `fs.Dirent` object describes a file system
   directory."
  ^js [dirent]
  (.isDirectory ^js dirent))

(defn block-device?
  "Returns `true` if the `fs.Dirent` object describes a block device."
  ^js [dirent]
  (.isBlockDevice ^js dirent))

(defn character-device?
  "Returns `true` if the `fs.Dirent` object describes a character device."
  ^js [dirent]
  (.isCharacterDevice ^js dirent))

(defn symbolic-link?
  "Returns `true` if the `fs.Dirent` object describes a symbolic link."
  ^js [dirent]
  (.isSymbolicLink ^js dirent))

(defn fifo?
  "Returns `true` if the `fs.Dirent` object describes a first-in-first-out
   (FIFO) pipe."
  ^js [dirent]
  (.isFIFO ^js dirent))

(defn socket?
  "Returns `true` if the `fs.Dirent` object describes a socket."
  ^js [dirent]
  (.isSocket ^js dirent))

(defn name
  "The file name that this `fs.Dirent` object refers to. The type of this
   value is determined by the `options.encoding` passed to {@link readdir } or {@link readdirSync }."
  ^js [dirent]
  (.-name ^js dirent))

(defn set-name!
  "The file name that this `fs.Dirent` object refers to. The type of this
   value is determined by the `options.encoding` passed to {@link readdir } or {@link readdirSync }."
  ^js [dirent value]
  (set! (.-name ^js dirent) value))

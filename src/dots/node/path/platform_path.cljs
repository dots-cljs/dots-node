(ns dots.node.path.platform-path
  (:refer-clojure :exclude [resolve]))

(defn normalize
  "Normalize a string path, reducing '..' and '.' parts.
   When multiple slashes are found, they're replaced by a single one; when the path contains a trailing slash, it is preserved. On Windows backslashes are used."
  ^js [platform-path path]
  (.normalize ^js platform-path path))

(defn join
  "Join all arguments together and normalize the resulting path."
  ^js [platform-path & paths]
  (.. ^js platform-path -join (apply ^js platform-path (to-array paths))))

(defn resolve
  "The right-most parameter is considered {to}. Other parameters are considered an array of {from}.
   
   Starting from leftmost {from} parameter, resolves {to} to an absolute path.
   
   If {to} isn't already absolute, {from} arguments are prepended in right to left order,
   until an absolute path is found. If after using all {from} paths still no absolute path is found,
   the current working directory is used as well. The resulting path is normalized,
   and trailing slashes are removed unless the path gets resolved to the root directory."
  ^js [platform-path & paths]
  (.. ^js platform-path -resolve (apply ^js platform-path (to-array paths))))

(defn absolute?
  "Determines whether {path} is an absolute path. An absolute path will always resolve to the same location, regardless of the working directory.
   
   If the given {path} is a zero-length string, `false` will be returned."
  ^js [platform-path path]
  (.isAbsolute ^js platform-path path))

(defn relative
  "Solve the relative path from {from} to {to} based on the current working directory.
   At times we have two absolute paths, and we need to derive the relative path from one to the other. This is actually the reverse transform of path.resolve."
  ^js [platform-path from to]
  (.relative ^js platform-path from to))

(defn dirname
  "Return the directory name of a path. Similar to the Unix dirname command."
  ^js [platform-path path]
  (.dirname ^js platform-path path))

(defn basename
  "Return the last portion of a path. Similar to the Unix basename command.
   Often used to extract the file name from a fully qualified path."
  (^js [platform-path path]
   (.basename ^js platform-path path))
  (^js [platform-path path suffix]
   (.basename ^js platform-path path suffix)))

(defn extname
  "Return the extension of the path, from the last '.' to end of string in the last portion of the path.
   If there is no '.' in the last portion of the path or the first character of it is '.', then it returns an empty string."
  ^js [platform-path path]
  (.extname ^js platform-path path))

(defn sep
  "The platform-specific file separator. '\\\\' or '/'."
  ^js [platform-path]
  (.-sep ^js platform-path))

(defn delimiter
  "The platform-specific file delimiter. ';' or ':'."
  ^js [platform-path]
  (.-delimiter ^js platform-path))

(defn parse
  "Returns an object from a path string - the opposite of format()."
  ^js [platform-path path]
  (.parse ^js platform-path path))

(defn format
  "Returns a path string from an object - the opposite of parse()."
  ^js [platform-path path-object]
  (.format ^js platform-path path-object))

(defn to-namespaced-path
  "On Windows systems only, returns an equivalent namespace-prefixed path for the given path.
   If path is not a string, path will be returned without modifications.
   This method is meaningful only on Windows system.
   On POSIX systems, the method is non-operational and always returns path without modifications."
  ^js [platform-path path]
  (.toNamespacedPath ^js platform-path path))

(defn posix
  "Posix specific pathing.
   Same as parent object on posix."
  ^js [platform-path]
  (.-posix ^js platform-path))

(defn win-32
  "Windows specific pathing.
   Same as parent object on windows"
  ^js [platform-path]
  (.-win32 ^js platform-path))

(ns dots.path.format-input-path-object
  (:refer-clojure :exclude [name]))

(defn root
  "The root of the path such as '/' or 'c:\\'"
  ^js [format-input-path-object]
  (.-root ^js format-input-path-object))

(defn set-root!
  "The root of the path such as '/' or 'c:\\'"
  ^js [format-input-path-object value]
  (set! (.-root ^js format-input-path-object) value))

(defn dir
  "The full directory path such as '/home/user/dir' or 'c:\\path\\dir'"
  ^js [format-input-path-object]
  (.-dir ^js format-input-path-object))

(defn set-dir!
  "The full directory path such as '/home/user/dir' or 'c:\\path\\dir'"
  ^js [format-input-path-object value]
  (set! (.-dir ^js format-input-path-object) value))

(defn base
  "The file name including extension (if any) such as 'index.html'"
  ^js [format-input-path-object]
  (.-base ^js format-input-path-object))

(defn set-base!
  "The file name including extension (if any) such as 'index.html'"
  ^js [format-input-path-object value]
  (set! (.-base ^js format-input-path-object) value))

(defn ext
  "The file extension (if any) such as '.html'"
  ^js [format-input-path-object]
  (.-ext ^js format-input-path-object))

(defn set-ext!
  "The file extension (if any) such as '.html'"
  ^js [format-input-path-object value]
  (set! (.-ext ^js format-input-path-object) value))

(defn name
  "The file name without extension (if any) such as 'index'"
  ^js [format-input-path-object]
  (.-name ^js format-input-path-object))

(defn set-name!
  "The file name without extension (if any) such as 'index'"
  ^js [format-input-path-object value]
  (set! (.-name ^js format-input-path-object) value))

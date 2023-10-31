(ns dots.fs.copy-options)

(defn filter?
  "Function to filter copied files/directories. Return
   `true` to copy the item, `false` to ignore it."
  ^js [copy-options source destination]
  (.filter ^js copy-options source destination))

(defn dereference?
  "Dereference symlinks"
  ^js [copy-options]
  (.-dereference ^js copy-options))

(defn set-dereference!
  "Dereference symlinks"
  ^js [copy-options value]
  (set! (.-dereference ^js copy-options) value))

(defn error-on-exist?
  "When `force` is `false`, and the destination
   exists, throw an error."
  ^js [copy-options]
  (.-errorOnExist ^js copy-options))

(defn set-error-on-exist!
  "When `force` is `false`, and the destination
   exists, throw an error."
  ^js [copy-options value]
  (set! (.-errorOnExist ^js copy-options) value))

(defn force?
  "Overwrite existing file or directory. _The copy
   operation will ignore errors if you set this to false and the destination
   exists. Use the `errorOnExist` option to change this behavior."
  ^js [copy-options]
  (.-force ^js copy-options))

(defn set-force!
  "Overwrite existing file or directory. _The copy
   operation will ignore errors if you set this to false and the destination
   exists. Use the `errorOnExist` option to change this behavior."
  ^js [copy-options value]
  (set! (.-force ^js copy-options) value))

(defn preserve-timestamps?
  "When `true` timestamps from `src` will
   be preserved."
  ^js [copy-options]
  (.-preserveTimestamps ^js copy-options))

(defn set-preserve-timestamps!
  "When `true` timestamps from `src` will
   be preserved."
  ^js [copy-options value]
  (set! (.-preserveTimestamps ^js copy-options) value))

(defn recursive?
  "Copy directories recursively."
  ^js [copy-options]
  (.-recursive ^js copy-options))

(defn set-recursive!
  "Copy directories recursively."
  ^js [copy-options value]
  (set! (.-recursive ^js copy-options) value))

(defn verbatim-symlinks?
  "When true, path resolution for symlinks will be skipped"
  ^js [copy-options]
  (.-verbatimSymlinks ^js copy-options))

(defn set-verbatim-symlinks!
  "When true, path resolution for symlinks will be skipped"
  ^js [copy-options value]
  (set! (.-verbatimSymlinks ^js copy-options) value))

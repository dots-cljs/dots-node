(ns dots.fs.copy-sync-options)

(defn filter?
  "Function to filter copied files/directories. Return
   `true` to copy the item, `false` to ignore it."
  ^js [copy-sync-options source destination]
  (.filter ^js copy-sync-options source destination))

(defn dereference?
  "Dereference symlinks"
  ^js [copy-sync-options]
  (.-dereference ^js copy-sync-options))

(defn set-dereference!
  "Dereference symlinks"
  ^js [copy-sync-options value]
  (set! (.-dereference ^js copy-sync-options) value))

(defn error-on-exist?
  "When `force` is `false`, and the destination
   exists, throw an error."
  ^js [copy-sync-options]
  (.-errorOnExist ^js copy-sync-options))

(defn set-error-on-exist!
  "When `force` is `false`, and the destination
   exists, throw an error."
  ^js [copy-sync-options value]
  (set! (.-errorOnExist ^js copy-sync-options) value))

(defn force?
  "Overwrite existing file or directory. _The copy
   operation will ignore errors if you set this to false and the destination
   exists. Use the `errorOnExist` option to change this behavior."
  ^js [copy-sync-options]
  (.-force ^js copy-sync-options))

(defn set-force!
  "Overwrite existing file or directory. _The copy
   operation will ignore errors if you set this to false and the destination
   exists. Use the `errorOnExist` option to change this behavior."
  ^js [copy-sync-options value]
  (set! (.-force ^js copy-sync-options) value))

(defn preserve-timestamps?
  "When `true` timestamps from `src` will
   be preserved."
  ^js [copy-sync-options]
  (.-preserveTimestamps ^js copy-sync-options))

(defn set-preserve-timestamps!
  "When `true` timestamps from `src` will
   be preserved."
  ^js [copy-sync-options value]
  (set! (.-preserveTimestamps ^js copy-sync-options) value))

(defn recursive?
  "Copy directories recursively."
  ^js [copy-sync-options]
  (.-recursive ^js copy-sync-options))

(defn set-recursive!
  "Copy directories recursively."
  ^js [copy-sync-options value]
  (set! (.-recursive ^js copy-sync-options) value))

(defn verbatim-symlinks?
  "When true, path resolution for symlinks will be skipped"
  ^js [copy-sync-options]
  (.-verbatimSymlinks ^js copy-sync-options))

(defn set-verbatim-symlinks!
  "When true, path resolution for symlinks will be skipped"
  ^js [copy-sync-options value]
  (set! (.-verbatimSymlinks ^js copy-sync-options) value))

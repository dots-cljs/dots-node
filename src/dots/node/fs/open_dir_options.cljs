(ns dots.node.fs.open-dir-options)

(defn encoding
  ^js [open-dir-options]
  (.-encoding ^js open-dir-options))

(defn set-encoding!
  ^js [open-dir-options value]
  (set! (.-encoding ^js open-dir-options) value))

(defn buffer-size
  "Number of directory entries that are buffered
   internally when reading from the directory. Higher values lead to better
   performance but higher memory usage."
  ^js [open-dir-options]
  (.-bufferSize ^js open-dir-options))

(defn set-buffer-size!
  "Number of directory entries that are buffered
   internally when reading from the directory. Higher values lead to better
   performance but higher memory usage."
  ^js [open-dir-options value]
  (set! (.-bufferSize ^js open-dir-options) value))

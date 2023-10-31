(ns dots.fs.read-sync-options)

(defn offset
  ^js [read-sync-options]
  (.-offset ^js read-sync-options))

(defn set-offset!
  ^js [read-sync-options value]
  (set! (.-offset ^js read-sync-options) value))

(defn length
  ^js [read-sync-options]
  (.-length ^js read-sync-options))

(defn set-length!
  ^js [read-sync-options value]
  (set! (.-length ^js read-sync-options) value))

(defn position
  ^js [read-sync-options]
  (.-position ^js read-sync-options))

(defn set-position!
  ^js [read-sync-options value]
  (set! (.-position ^js read-sync-options) value))

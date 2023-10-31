(ns dots.fs.read-async-options)

(defn buffer
  ^js [read-async-options]
  (.-buffer ^js read-async-options))

(defn set-buffer!
  ^js [read-async-options value]
  (set! (.-buffer ^js read-async-options) value))

(defn offset
  ^js [read-async-options]
  (.-offset ^js read-async-options))

(defn set-offset!
  ^js [read-async-options value]
  (set! (.-offset ^js read-async-options) value))

(defn length
  ^js [read-async-options]
  (.-length ^js read-async-options))

(defn set-length!
  ^js [read-async-options value]
  (set! (.-length ^js read-async-options) value))

(defn position
  ^js [read-async-options]
  (.-position ^js read-async-options))

(defn set-position!
  ^js [read-async-options value]
  (set! (.-position ^js read-async-options) value))

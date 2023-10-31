(ns dots.fs.object-encoding-options)

(defn encoding
  ^js [object-encoding-options]
  (.-encoding ^js object-encoding-options))

(defn set-encoding!
  ^js [object-encoding-options value]
  (set! (.-encoding ^js object-encoding-options) value))

(ns dots.fs.big-int-options)

(defn bigint
  ^js [big-int-options]
  (.-bigint ^js big-int-options))

(defn set-bigint!
  ^js [big-int-options value]
  (set! (.-bigint ^js big-int-options) value))

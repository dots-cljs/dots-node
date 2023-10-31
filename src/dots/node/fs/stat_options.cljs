(ns dots.node.fs.stat-options)

(defn bigint?
  ^js [stat-options]
  (.-bigint ^js stat-options))

(defn set-bigint!
  ^js [stat-options value]
  (set! (.-bigint ^js stat-options) value))

(ns dots.fs.stat-sync-options)

(defn throw-if-no-entry?
  ^js [stat-sync-options]
  (.-throwIfNoEntry ^js stat-sync-options))

(defn set-throw-if-no-entry!
  ^js [stat-sync-options value]
  (set! (.-throwIfNoEntry ^js stat-sync-options) value))

(defn bigint?
  ^js [stat-sync-options]
  (.-bigint ^js stat-sync-options))

(defn set-bigint!
  ^js [stat-sync-options value]
  (set! (.-bigint ^js stat-sync-options) value))

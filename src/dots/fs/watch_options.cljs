(ns dots.fs.watch-options)

(defn encoding
  ^js [watch-options]
  (.-encoding ^js watch-options))

(defn set-encoding!
  ^js [watch-options value]
  (set! (.-encoding ^js watch-options) value))

(defn persistent?
  ^js [watch-options]
  (.-persistent ^js watch-options))

(defn set-persistent!
  ^js [watch-options value]
  (set! (.-persistent ^js watch-options) value))

(defn recursive?
  ^js [watch-options]
  (.-recursive ^js watch-options))

(defn set-recursive!
  ^js [watch-options value]
  (set! (.-recursive ^js watch-options) value))

(defn signal
  "When provided the corresponding `AbortController` can be used to cancel an asynchronous action."
  ^js [watch-options]
  (.-signal ^js watch-options))

(defn set-signal!
  "When provided the corresponding `AbortController` can be used to cancel an asynchronous action."
  ^js [watch-options value]
  (set! (.-signal ^js watch-options) value))

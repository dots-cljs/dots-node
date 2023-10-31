(ns dots.fs.rm-dir-options)

(defn max-retries
  "If an `EBUSY`, `EMFILE`, `ENFILE`, `ENOTEMPTY`, or
   `EPERM` error is encountered, Node.js will retry the operation with a linear
   backoff wait of `retryDelay` ms longer on each try. This option represents the
   number of retries. This option is ignored if the `recursive` option is not
   `true`."
  ^js [rm-dir-options]
  (.-maxRetries ^js rm-dir-options))

(defn set-max-retries!
  "If an `EBUSY`, `EMFILE`, `ENFILE`, `ENOTEMPTY`, or
   `EPERM` error is encountered, Node.js will retry the operation with a linear
   backoff wait of `retryDelay` ms longer on each try. This option represents the
   number of retries. This option is ignored if the `recursive` option is not
   `true`."
  ^js [rm-dir-options value]
  (set! (.-maxRetries ^js rm-dir-options) value))

(defn recursive?
  ^js [rm-dir-options]
  (.-recursive ^js rm-dir-options))

(defn set-recursive!
  ^js [rm-dir-options value]
  (set! (.-recursive ^js rm-dir-options) value))

(defn retry-delay
  "The amount of time in milliseconds to wait between retries.
   This option is ignored if the `recursive` option is not `true`."
  ^js [rm-dir-options]
  (.-retryDelay ^js rm-dir-options))

(defn set-retry-delay!
  "The amount of time in milliseconds to wait between retries.
   This option is ignored if the `recursive` option is not `true`."
  ^js [rm-dir-options value]
  (set! (.-retryDelay ^js rm-dir-options) value))

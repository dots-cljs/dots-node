(ns dots.node.fs.rm-options)

(defn force?
  "When `true`, exceptions will be ignored if `path` does not exist."
  ^js [rm-options]
  (.-force ^js rm-options))

(defn set-force!
  "When `true`, exceptions will be ignored if `path` does not exist."
  ^js [rm-options value]
  (set! (.-force ^js rm-options) value))

(defn max-retries
  "If an `EBUSY`, `EMFILE`, `ENFILE`, `ENOTEMPTY`, or
   `EPERM` error is encountered, Node.js will retry the operation with a linear
   backoff wait of `retryDelay` ms longer on each try. This option represents the
   number of retries. This option is ignored if the `recursive` option is not
   `true`."
  ^js [rm-options]
  (.-maxRetries ^js rm-options))

(defn set-max-retries!
  "If an `EBUSY`, `EMFILE`, `ENFILE`, `ENOTEMPTY`, or
   `EPERM` error is encountered, Node.js will retry the operation with a linear
   backoff wait of `retryDelay` ms longer on each try. This option represents the
   number of retries. This option is ignored if the `recursive` option is not
   `true`."
  ^js [rm-options value]
  (set! (.-maxRetries ^js rm-options) value))

(defn recursive?
  "If `true`, perform a recursive directory removal. In
   recursive mode, operations are retried on failure."
  ^js [rm-options]
  (.-recursive ^js rm-options))

(defn set-recursive!
  "If `true`, perform a recursive directory removal. In
   recursive mode, operations are retried on failure."
  ^js [rm-options value]
  (set! (.-recursive ^js rm-options) value))

(defn retry-delay
  "The amount of time in milliseconds to wait between retries.
   This option is ignored if the `recursive` option is not `true`."
  ^js [rm-options]
  (.-retryDelay ^js rm-options))

(defn set-retry-delay!
  "The amount of time in milliseconds to wait between retries.
   This option is ignored if the `recursive` option is not `true`."
  ^js [rm-options value]
  (set! (.-retryDelay ^js rm-options) value))

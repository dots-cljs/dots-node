(ns dots.fs.read-v-result)

(defn bytes-read
  ^js [read-v-result]
  (.-bytesRead ^js read-v-result))

(defn set-bytes-read!
  ^js [read-v-result value]
  (set! (.-bytesRead ^js read-v-result) value))

(defn buffers
  ^js [read-v-result]
  (.-buffers ^js read-v-result))

(defn set-buffers!
  ^js [read-v-result value]
  (set! (.-buffers ^js read-v-result) value))

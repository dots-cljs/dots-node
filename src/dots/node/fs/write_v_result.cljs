(ns dots.node.fs.write-v-result)

(defn bytes-written
  ^js [write-v-result]
  (.-bytesWritten ^js write-v-result))

(defn set-bytes-written!
  ^js [write-v-result value]
  (set! (.-bytesWritten ^js write-v-result) value))

(defn buffers
  ^js [write-v-result]
  (.-buffers ^js write-v-result))

(defn set-buffers!
  ^js [write-v-result value]
  (set! (.-buffers ^js write-v-result) value))

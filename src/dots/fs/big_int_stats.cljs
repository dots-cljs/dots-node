(ns dots.fs.big-int-stats)

(defn atime-ns
  ^js [big-int-stats]
  (.-atimeNs ^js big-int-stats))

(defn set-atime-ns!
  ^js [big-int-stats value]
  (set! (.-atimeNs ^js big-int-stats) value))

(defn mtime-ns
  ^js [big-int-stats]
  (.-mtimeNs ^js big-int-stats))

(defn set-mtime-ns!
  ^js [big-int-stats value]
  (set! (.-mtimeNs ^js big-int-stats) value))

(defn ctime-ns
  ^js [big-int-stats]
  (.-ctimeNs ^js big-int-stats))

(defn set-ctime-ns!
  ^js [big-int-stats value]
  (set! (.-ctimeNs ^js big-int-stats) value))

(defn birthtime-ns
  ^js [big-int-stats]
  (.-birthtimeNs ^js big-int-stats))

(defn set-birthtime-ns!
  ^js [big-int-stats value]
  (set! (.-birthtimeNs ^js big-int-stats) value))

(defn file?
  ^js [big-int-stats]
  (.isFile ^js big-int-stats))

(defn directory?
  ^js [big-int-stats]
  (.isDirectory ^js big-int-stats))

(defn block-device?
  ^js [big-int-stats]
  (.isBlockDevice ^js big-int-stats))

(defn character-device?
  ^js [big-int-stats]
  (.isCharacterDevice ^js big-int-stats))

(defn symbolic-link?
  ^js [big-int-stats]
  (.isSymbolicLink ^js big-int-stats))

(defn fifo?
  ^js [big-int-stats]
  (.isFIFO ^js big-int-stats))

(defn socket?
  ^js [big-int-stats]
  (.isSocket ^js big-int-stats))

(defn dev
  ^js [big-int-stats]
  (.-dev ^js big-int-stats))

(defn set-dev!
  ^js [big-int-stats value]
  (set! (.-dev ^js big-int-stats) value))

(defn ino
  ^js [big-int-stats]
  (.-ino ^js big-int-stats))

(defn set-ino!
  ^js [big-int-stats value]
  (set! (.-ino ^js big-int-stats) value))

(defn mode
  ^js [big-int-stats]
  (.-mode ^js big-int-stats))

(defn set-mode!
  ^js [big-int-stats value]
  (set! (.-mode ^js big-int-stats) value))

(defn nlink
  ^js [big-int-stats]
  (.-nlink ^js big-int-stats))

(defn set-nlink!
  ^js [big-int-stats value]
  (set! (.-nlink ^js big-int-stats) value))

(defn uid
  ^js [big-int-stats]
  (.-uid ^js big-int-stats))

(defn set-uid!
  ^js [big-int-stats value]
  (set! (.-uid ^js big-int-stats) value))

(defn gid
  ^js [big-int-stats]
  (.-gid ^js big-int-stats))

(defn set-gid!
  ^js [big-int-stats value]
  (set! (.-gid ^js big-int-stats) value))

(defn rdev
  ^js [big-int-stats]
  (.-rdev ^js big-int-stats))

(defn set-rdev!
  ^js [big-int-stats value]
  (set! (.-rdev ^js big-int-stats) value))

(defn size
  ^js [big-int-stats]
  (.-size ^js big-int-stats))

(defn set-size!
  ^js [big-int-stats value]
  (set! (.-size ^js big-int-stats) value))

(defn blksize
  ^js [big-int-stats]
  (.-blksize ^js big-int-stats))

(defn set-blksize!
  ^js [big-int-stats value]
  (set! (.-blksize ^js big-int-stats) value))

(defn blocks
  ^js [big-int-stats]
  (.-blocks ^js big-int-stats))

(defn set-blocks!
  ^js [big-int-stats value]
  (set! (.-blocks ^js big-int-stats) value))

(defn atime-ms
  ^js [big-int-stats]
  (.-atimeMs ^js big-int-stats))

(defn set-atime-ms!
  ^js [big-int-stats value]
  (set! (.-atimeMs ^js big-int-stats) value))

(defn mtime-ms
  ^js [big-int-stats]
  (.-mtimeMs ^js big-int-stats))

(defn set-mtime-ms!
  ^js [big-int-stats value]
  (set! (.-mtimeMs ^js big-int-stats) value))

(defn ctime-ms
  ^js [big-int-stats]
  (.-ctimeMs ^js big-int-stats))

(defn set-ctime-ms!
  ^js [big-int-stats value]
  (set! (.-ctimeMs ^js big-int-stats) value))

(defn birthtime-ms
  ^js [big-int-stats]
  (.-birthtimeMs ^js big-int-stats))

(defn set-birthtime-ms!
  ^js [big-int-stats value]
  (set! (.-birthtimeMs ^js big-int-stats) value))

(defn atime
  ^js [big-int-stats]
  (.-atime ^js big-int-stats))

(defn set-atime!
  ^js [big-int-stats value]
  (set! (.-atime ^js big-int-stats) value))

(defn mtime
  ^js [big-int-stats]
  (.-mtime ^js big-int-stats))

(defn set-mtime!
  ^js [big-int-stats value]
  (set! (.-mtime ^js big-int-stats) value))

(defn ctime
  ^js [big-int-stats]
  (.-ctime ^js big-int-stats))

(defn set-ctime!
  ^js [big-int-stats value]
  (set! (.-ctime ^js big-int-stats) value))

(defn birthtime
  ^js [big-int-stats]
  (.-birthtime ^js big-int-stats))

(defn set-birthtime!
  ^js [big-int-stats value]
  (set! (.-birthtime ^js big-int-stats) value))

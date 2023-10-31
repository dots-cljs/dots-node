(ns dots.node.fs.stats-base)

(defn file?
  ^js [stats-base]
  (.isFile ^js stats-base))

(defn directory?
  ^js [stats-base]
  (.isDirectory ^js stats-base))

(defn block-device?
  ^js [stats-base]
  (.isBlockDevice ^js stats-base))

(defn character-device?
  ^js [stats-base]
  (.isCharacterDevice ^js stats-base))

(defn symbolic-link?
  ^js [stats-base]
  (.isSymbolicLink ^js stats-base))

(defn fifo?
  ^js [stats-base]
  (.isFIFO ^js stats-base))

(defn socket?
  ^js [stats-base]
  (.isSocket ^js stats-base))

(defn dev
  ^js [stats-base]
  (.-dev ^js stats-base))

(defn set-dev!
  ^js [stats-base value]
  (set! (.-dev ^js stats-base) value))

(defn ino
  ^js [stats-base]
  (.-ino ^js stats-base))

(defn set-ino!
  ^js [stats-base value]
  (set! (.-ino ^js stats-base) value))

(defn mode
  ^js [stats-base]
  (.-mode ^js stats-base))

(defn set-mode!
  ^js [stats-base value]
  (set! (.-mode ^js stats-base) value))

(defn nlink
  ^js [stats-base]
  (.-nlink ^js stats-base))

(defn set-nlink!
  ^js [stats-base value]
  (set! (.-nlink ^js stats-base) value))

(defn uid
  ^js [stats-base]
  (.-uid ^js stats-base))

(defn set-uid!
  ^js [stats-base value]
  (set! (.-uid ^js stats-base) value))

(defn gid
  ^js [stats-base]
  (.-gid ^js stats-base))

(defn set-gid!
  ^js [stats-base value]
  (set! (.-gid ^js stats-base) value))

(defn rdev
  ^js [stats-base]
  (.-rdev ^js stats-base))

(defn set-rdev!
  ^js [stats-base value]
  (set! (.-rdev ^js stats-base) value))

(defn size
  ^js [stats-base]
  (.-size ^js stats-base))

(defn set-size!
  ^js [stats-base value]
  (set! (.-size ^js stats-base) value))

(defn blksize
  ^js [stats-base]
  (.-blksize ^js stats-base))

(defn set-blksize!
  ^js [stats-base value]
  (set! (.-blksize ^js stats-base) value))

(defn blocks
  ^js [stats-base]
  (.-blocks ^js stats-base))

(defn set-blocks!
  ^js [stats-base value]
  (set! (.-blocks ^js stats-base) value))

(defn atime-ms
  ^js [stats-base]
  (.-atimeMs ^js stats-base))

(defn set-atime-ms!
  ^js [stats-base value]
  (set! (.-atimeMs ^js stats-base) value))

(defn mtime-ms
  ^js [stats-base]
  (.-mtimeMs ^js stats-base))

(defn set-mtime-ms!
  ^js [stats-base value]
  (set! (.-mtimeMs ^js stats-base) value))

(defn ctime-ms
  ^js [stats-base]
  (.-ctimeMs ^js stats-base))

(defn set-ctime-ms!
  ^js [stats-base value]
  (set! (.-ctimeMs ^js stats-base) value))

(defn birthtime-ms
  ^js [stats-base]
  (.-birthtimeMs ^js stats-base))

(defn set-birthtime-ms!
  ^js [stats-base value]
  (set! (.-birthtimeMs ^js stats-base) value))

(defn atime
  ^js [stats-base]
  (.-atime ^js stats-base))

(defn set-atime!
  ^js [stats-base value]
  (set! (.-atime ^js stats-base) value))

(defn mtime
  ^js [stats-base]
  (.-mtime ^js stats-base))

(defn set-mtime!
  ^js [stats-base value]
  (set! (.-mtime ^js stats-base) value))

(defn ctime
  ^js [stats-base]
  (.-ctime ^js stats-base))

(defn set-ctime!
  ^js [stats-base value]
  (set! (.-ctime ^js stats-base) value))

(defn birthtime
  ^js [stats-base]
  (.-birthtime ^js stats-base))

(defn set-birthtime!
  ^js [stats-base value]
  (set! (.-birthtime ^js stats-base) value))

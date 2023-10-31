(ns dots.fs.stats
  "A `fs.Stats` object provides information about a file.
   
   Objects returned from {@link stat }, {@link lstat } and {@link fstat } and
   their synchronous counterparts are of this type.
   If `bigint` in the `options` passed to those methods is true, the numeric values
   will be `bigint` instead of `number`, and the object will contain additional
   nanosecond-precision properties suffixed with `Ns`.
   
   ```console
   Stats {
     dev: 2114,
     ino: 48064969,
     mode: 33188,
     nlink: 1,
     uid: 85,
     gid: 100,
     rdev: 0,
     size: 527,
     blksize: 4096,
     blocks: 8,
     atimeMs: 1318289051000.1,
     mtimeMs: 1318289051000.1,
     ctimeMs: 1318289051000.1,
     birthtimeMs: 1318289051000.1,
     atime: Mon, 10 Oct 2011 23:24:11 GMT,
     mtime: Mon, 10 Oct 2011 23:24:11 GMT,
     ctime: Mon, 10 Oct 2011 23:24:11 GMT,
     birthtime: Mon, 10 Oct 2011 23:24:11 GMT }
   ```
   
   `bigint` version:
   
   ```console
   BigIntStats {
     dev: 2114n,
     ino: 48064969n,
     mode: 33188n,
     nlink: 1n,
     uid: 85n,
     gid: 100n,
     rdev: 0n,
     size: 527n,
     blksize: 4096n,
     blocks: 8n,
     atimeMs: 1318289051000n,
     mtimeMs: 1318289051000n,
     ctimeMs: 1318289051000n,
     birthtimeMs: 1318289051000n,
     atimeNs: 1318289051000000000n,
     mtimeNs: 1318289051000000000n,
     ctimeNs: 1318289051000000000n,
     birthtimeNs: 1318289051000000000n,
     atime: Mon, 10 Oct 2011 23:24:11 GMT,
     mtime: Mon, 10 Oct 2011 23:24:11 GMT,
     ctime: Mon, 10 Oct 2011 23:24:11 GMT,
     birthtime: Mon, 10 Oct 2011 23:24:11 GMT }
   ```")

(defn file?
  ^js [stats]
  (.isFile ^js stats))

(defn directory?
  ^js [stats]
  (.isDirectory ^js stats))

(defn block-device?
  ^js [stats]
  (.isBlockDevice ^js stats))

(defn character-device?
  ^js [stats]
  (.isCharacterDevice ^js stats))

(defn symbolic-link?
  ^js [stats]
  (.isSymbolicLink ^js stats))

(defn fifo?
  ^js [stats]
  (.isFIFO ^js stats))

(defn socket?
  ^js [stats]
  (.isSocket ^js stats))

(defn dev
  ^js [stats]
  (.-dev ^js stats))

(defn set-dev!
  ^js [stats value]
  (set! (.-dev ^js stats) value))

(defn ino
  ^js [stats]
  (.-ino ^js stats))

(defn set-ino!
  ^js [stats value]
  (set! (.-ino ^js stats) value))

(defn mode
  ^js [stats]
  (.-mode ^js stats))

(defn set-mode!
  ^js [stats value]
  (set! (.-mode ^js stats) value))

(defn nlink
  ^js [stats]
  (.-nlink ^js stats))

(defn set-nlink!
  ^js [stats value]
  (set! (.-nlink ^js stats) value))

(defn uid
  ^js [stats]
  (.-uid ^js stats))

(defn set-uid!
  ^js [stats value]
  (set! (.-uid ^js stats) value))

(defn gid
  ^js [stats]
  (.-gid ^js stats))

(defn set-gid!
  ^js [stats value]
  (set! (.-gid ^js stats) value))

(defn rdev
  ^js [stats]
  (.-rdev ^js stats))

(defn set-rdev!
  ^js [stats value]
  (set! (.-rdev ^js stats) value))

(defn size
  ^js [stats]
  (.-size ^js stats))

(defn set-size!
  ^js [stats value]
  (set! (.-size ^js stats) value))

(defn blksize
  ^js [stats]
  (.-blksize ^js stats))

(defn set-blksize!
  ^js [stats value]
  (set! (.-blksize ^js stats) value))

(defn blocks
  ^js [stats]
  (.-blocks ^js stats))

(defn set-blocks!
  ^js [stats value]
  (set! (.-blocks ^js stats) value))

(defn atime-ms
  ^js [stats]
  (.-atimeMs ^js stats))

(defn set-atime-ms!
  ^js [stats value]
  (set! (.-atimeMs ^js stats) value))

(defn mtime-ms
  ^js [stats]
  (.-mtimeMs ^js stats))

(defn set-mtime-ms!
  ^js [stats value]
  (set! (.-mtimeMs ^js stats) value))

(defn ctime-ms
  ^js [stats]
  (.-ctimeMs ^js stats))

(defn set-ctime-ms!
  ^js [stats value]
  (set! (.-ctimeMs ^js stats) value))

(defn birthtime-ms
  ^js [stats]
  (.-birthtimeMs ^js stats))

(defn set-birthtime-ms!
  ^js [stats value]
  (set! (.-birthtimeMs ^js stats) value))

(defn atime
  ^js [stats]
  (.-atime ^js stats))

(defn set-atime!
  ^js [stats value]
  (set! (.-atime ^js stats) value))

(defn mtime
  ^js [stats]
  (.-mtime ^js stats))

(defn set-mtime!
  ^js [stats value]
  (set! (.-mtime ^js stats) value))

(defn ctime
  ^js [stats]
  (.-ctime ^js stats))

(defn set-ctime!
  ^js [stats value]
  (set! (.-ctime ^js stats) value))

(defn birthtime
  ^js [stats]
  (.-birthtime ^js stats))

(defn set-birthtime!
  ^js [stats value]
  (set! (.-birthtime ^js stats) value))

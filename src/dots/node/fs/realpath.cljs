(ns dots.node.fs.realpath
  "Asynchronously computes the canonical pathname by resolving `.`, `..` and
   symbolic links.
   
   A canonical pathname is not necessarily unique. Hard links and bind mounts can
   expose a file system entity through many pathnames.
   
   This function behaves like [`realpath(3)`](http://man7.org/linux/man-pages/man3/realpath.3.html), with some exceptions:
   
   1. No case conversion is performed on case-insensitive file systems.
   2. The maximum number of symbolic links is platform-independent and generally
   (much) higher than what the native [`realpath(3)`](http://man7.org/linux/man-pages/man3/realpath.3.html) implementation supports.
   
   The `callback` gets two arguments `(err, resolvedPath)`. May use `process.cwd`to resolve relative paths.
   
   Only paths that can be converted to UTF8 strings are supported.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use for
   the path passed to the callback. If the `encoding` is set to `'buffer'`,
   the path returned will be passed as a `Buffer` object.
   
   If `path` resolves to a socket or a pipe, the function will return a system
   dependent name for that object.
   Asynchronous realpath(3) - return the canonicalized absolute pathname."
  (:require ["fs" :as fs]))

(defn native
  "Asynchronous [`realpath(3)`](http://man7.org/linux/man-pages/man3/realpath.3.html).
   
   The `callback` gets two arguments `(err, resolvedPath)`.
   
   Only paths that can be converted to UTF8 strings are supported.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use for
   the path passed to the callback. If the `encoding` is set to `'buffer'`,
   the path returned will be passed as a `Buffer` object.
   
   On Linux, when Node.js is linked against musl libc, the procfs file system must
   be mounted on `/proc` in order for this function to work. Glibc does not have
   this restriction."
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (.native fs/realpath path))
  (^js [a b]
   (.native fs/realpath a b))
  (^js [path options callback]
   (.native fs/realpath path options callback)))

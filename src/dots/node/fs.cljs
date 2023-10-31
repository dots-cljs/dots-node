(ns dots.node.fs
  "The `fs` module enables interacting with the file system in a
   way modeled on standard POSIX functions.
   
   To use the promise-based APIs:
   
   ```js
   import * as fs from 'fs/promises';
   ```
   
   To use the callback and sync APIs:
   
   ```js
   import * as fs from 'fs';
   ```
   
   All file system operations have synchronous, callback, and promise-based
   forms, and are accessible using both CommonJS syntax and ES6 Modules (ESM)."
  (:require ["fs" :as fs]))

(defn rename
  "Asynchronously rename file at `oldPath` to the pathname provided
   as `newPath`. In the case that `newPath` already exists, it will
   be overwritten. If there is a directory at `newPath`, an error will
   be raised instead. No arguments other than a possible exception are
   given to the completion callback.
   
   See also: [`rename(2)`](http://man7.org/linux/man-pages/man2/rename.2.html).
   
   ```js
   import { rename } from 'fs';
   
   rename('oldFile.txt', 'newFile.txt', (err) => {
     if (err) throw err;
     console.log('Rename complete!');
   });
   ```"
  ^js [old-path new-path callback]
  (fs/rename old-path new-path callback))

(defn rename-sync
  "Renames the file from `oldPath` to `newPath`. Returns `undefined`.
   
   See the POSIX [`rename(2)`](http://man7.org/linux/man-pages/man2/rename.2.html) documentation for more details."
  ^js [old-path new-path]
  (fs/renameSync old-path new-path))

(defn truncate
  "Truncates the file. No arguments other than a possible exception are
   given to the completion callback. A file descriptor can also be passed as the
   first argument. In this case, `fs.ftruncate()` is called.
   
   ```js
   import { truncate } from 'fs';
   // Assuming that 'path/file.txt' is a regular file.
   truncate('path/file.txt', (err) => {
     if (err) throw err;
     console.log('path/file.txt was truncated');
   });
   ```
   
   Passing a file descriptor is deprecated and may result in an error being thrown
   in the future.
   
   See the POSIX [`truncate(2)`](http://man7.org/linux/man-pages/man2/truncate.2.html) documentation for more details.
   Asynchronous truncate(2) - Truncate a file to a specified length."
  {:arglists '([path]
               [path callback]
               [path len]
               [path len callback])}
  (^js [path]
   (fs/truncate path))
  (^js [a b]
   (fs/truncate a b))
  (^js [path len callback]
   (fs/truncate path len callback)))

(defn truncate-sync
  "Truncates the file. Returns `undefined`. A file descriptor can also be
   passed as the first argument. In this case, `fs.ftruncateSync()` is called.
   
   Passing a file descriptor is deprecated and may result in an error being thrown
   in the future."
  (^js [path]
   (fs/truncateSync path))
  (^js [path len]
   (fs/truncateSync path len)))

(defn ftruncate
  "Truncates the file descriptor. No arguments other than a possible exception are
   given to the completion callback.
   
   See the POSIX [`ftruncate(2)`](http://man7.org/linux/man-pages/man2/ftruncate.2.html) documentation for more detail.
   
   If the file referred to by the file descriptor was larger than `len` bytes, only
   the first `len` bytes will be retained in the file.
   
   For example, the following program retains only the first four bytes of the
   file:
   
   ```js
   import { open, close, ftruncate } from 'fs';
   
   function closeFd(fd) {
     close(fd, (err) => {
       if (err) throw err;
     });
   }
   
   open('temp.txt', 'r+', (err, fd) => {
     if (err) throw err;
   
     try {
       ftruncate(fd, 4, (err) => {
         closeFd(fd);
         if (err) throw err;
       });
     } catch (err) {
       closeFd(fd);
       if (err) throw err;
     }
   });
   ```
   
   If the file previously was shorter than `len` bytes, it is extended, and the
   extended part is filled with null bytes (`'\\0'`):
   
   If `len` is negative then `0` will be used.
   Asynchronous ftruncate(2) - Truncate a file to a specified length."
  {:arglists '([fd]
               [fd callback]
               [fd len]
               [fd len callback])}
  (^js [fd]
   (fs/ftruncate fd))
  (^js [a b]
   (fs/ftruncate a b))
  (^js [fd len callback]
   (fs/ftruncate fd len callback)))

(defn ftruncate-sync
  "Truncates the file descriptor. Returns `undefined`.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link ftruncate }."
  (^js [fd]
   (fs/ftruncateSync fd))
  (^js [fd len]
   (fs/ftruncateSync fd len)))

(defn chown
  "Asynchronously changes owner and group of a file. No arguments other than a
   possible exception are given to the completion callback.
   
   See the POSIX [`chown(2)`](http://man7.org/linux/man-pages/man2/chown.2.html) documentation for more detail."
  ^js [path uid gid callback]
  (fs/chown path uid gid callback))

(defn chown-sync
  "Synchronously changes owner and group of a file. Returns `undefined`.
   This is the synchronous version of {@link chown }.
   
   See the POSIX [`chown(2)`](http://man7.org/linux/man-pages/man2/chown.2.html) documentation for more detail."
  ^js [path uid gid]
  (fs/chownSync path uid gid))

(defn fchown
  "Sets the owner of the file. No arguments other than a possible exception are
   given to the completion callback.
   
   See the POSIX [`fchown(2)`](http://man7.org/linux/man-pages/man2/fchown.2.html) documentation for more detail."
  ^js [fd uid gid callback]
  (fs/fchown fd uid gid callback))

(defn fchown-sync
  "Sets the owner of the file. Returns `undefined`.
   
   See the POSIX [`fchown(2)`](http://man7.org/linux/man-pages/man2/fchown.2.html) documentation for more detail."
  ^js [fd uid gid]
  (fs/fchownSync fd uid gid))

(defn lchown
  "Set the owner of the symbolic link. No arguments other than a possible
   exception are given to the completion callback.
   
   See the POSIX [`lchown(2)`](http://man7.org/linux/man-pages/man2/lchown.2.html) documentation for more detail."
  ^js [path uid gid callback]
  (fs/lchown path uid gid callback))

(defn lchown-sync
  "Set the owner for the path. Returns `undefined`.
   
   See the POSIX [`lchown(2)`](http://man7.org/linux/man-pages/man2/lchown.2.html) documentation for more details."
  ^js [path uid gid]
  (fs/lchownSync path uid gid))

(defn lutimes
  "Changes the access and modification times of a file in the same way as {@link utimes }, with the difference that if the path refers to a symbolic
   link, then the link is not dereferenced: instead, the timestamps of the
   symbolic link itself are changed.
   
   No arguments other than a possible exception are given to the completion
   callback."
  ^js [path atime mtime callback]
  (fs/lutimes path atime mtime callback))

(defn lutimes-sync
  "Change the file system timestamps of the symbolic link referenced by `path`.
   Returns `undefined`, or throws an exception when parameters are incorrect or
   the operation fails. This is the synchronous version of {@link lutimes }."
  ^js [path atime mtime]
  (fs/lutimesSync path atime mtime))

(defn chmod
  "Asynchronously changes the permissions of a file. No arguments other than a
   possible exception are given to the completion callback.
   
   See the POSIX [`chmod(2)`](http://man7.org/linux/man-pages/man2/chmod.2.html) documentation for more detail.
   
   ```js
   import { chmod } from 'fs';
   
   chmod('my_file.txt', 0o775, (err) => {
     if (err) throw err;
     console.log('The permissions for file \"my_file.txt\" have been changed!');
   });
   ```"
  ^js [path mode callback]
  (fs/chmod path mode callback))

(defn chmod-sync
  "For detailed information, see the documentation of the asynchronous version of
   this API: {@link chmod }.
   
   See the POSIX [`chmod(2)`](http://man7.org/linux/man-pages/man2/chmod.2.html) documentation for more detail."
  ^js [path mode]
  (fs/chmodSync path mode))

(defn fchmod
  "Sets the permissions on the file. No arguments other than a possible exception
   are given to the completion callback.
   
   See the POSIX [`fchmod(2)`](http://man7.org/linux/man-pages/man2/fchmod.2.html) documentation for more detail."
  ^js [fd mode callback]
  (fs/fchmod fd mode callback))

(defn fchmod-sync
  "Sets the permissions on the file. Returns `undefined`.
   
   See the POSIX [`fchmod(2)`](http://man7.org/linux/man-pages/man2/fchmod.2.html) documentation for more detail."
  ^js [fd mode]
  (fs/fchmodSync fd mode))

(defn lchmod
  "Changes the permissions on a symbolic link. No arguments other than a possible
   exception are given to the completion callback.
   
   This method is only implemented on macOS.
   
   See the POSIX [`lchmod(2)`](https://www.freebsd.org/cgi/man.cgi?query=lchmod&sektion=2) documentation for more detail."
  ^js [path mode callback]
  (fs/lchmod path mode callback))

(defn lchmod-sync
  "Changes the permissions on a symbolic link. Returns `undefined`.
   
   This method is only implemented on macOS.
   
   See the POSIX [`lchmod(2)`](https://www.freebsd.org/cgi/man.cgi?query=lchmod&sektion=2) documentation for more detail."
  ^js [path mode]
  (fs/lchmodSync path mode))

(defn stat
  "Asynchronous [`stat(2)`](http://man7.org/linux/man-pages/man2/stat.2.html). The callback gets two arguments `(err, stats)` where`stats` is an `fs.Stats` object.
   
   In case of an error, the `err.code` will be one of `Common System Errors`.
   
   Using `fs.stat()` to check for the existence of a file before calling`fs.open()`, `fs.readFile()` or `fs.writeFile()` is not recommended.
   Instead, user code should open/read/write the file directly and handle the
   error raised if the file is not available.
   
   To check if a file exists without manipulating it afterwards, {@link access } is recommended.
   
   For example, given the following directory structure:
   
   ```text
   - txtDir
   -- file.txt
   - app.js
   ```
   
   The next program will check for the stats of the given paths:
   
   ```js
   import { stat } from 'fs';
   
   const pathsToCheck = ['./txtDir', './txtDir/file.txt'];
   
   for (let i = 0; i < pathsToCheck.length; i++) {
     stat(pathsToCheck[i], (err, stats) => {
       console.log(stats.isDirectory());
       console.log(stats);
     });
   }
   ```
   
   The resulting output will resemble:
   
   ```console
   true
   Stats {
     dev: 16777220,
     mode: 16877,
     nlink: 3,
     uid: 501,
     gid: 20,
     rdev: 0,
     blksize: 4096,
     ino: 14214262,
     size: 96,
     blocks: 0,
     atimeMs: 1561174653071.963,
     mtimeMs: 1561174614583.3518,
     ctimeMs: 1561174626623.5366,
     birthtimeMs: 1561174126937.2893,
     atime: 2019-06-22T03:37:33.072Z,
     mtime: 2019-06-22T03:36:54.583Z,
     ctime: 2019-06-22T03:37:06.624Z,
     birthtime: 2019-06-22T03:28:46.937Z
   }
   false
   Stats {
     dev: 16777220,
     mode: 33188,
     nlink: 1,
     uid: 501,
     gid: 20,
     rdev: 0,
     blksize: 4096,
     ino: 14214074,
     size: 8,
     blocks: 8,
     atimeMs: 1561174616618.8555,
     mtimeMs: 1561174614584,
     ctimeMs: 1561174614583.8145,
     birthtimeMs: 1561174007710.7478,
     atime: 2019-06-22T03:36:56.619Z,
     mtime: 2019-06-22T03:36:54.584Z,
     ctime: 2019-06-22T03:36:54.584Z,
     birthtime: 2019-06-22T03:26:47.711Z
   }
   ```"
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/stat path))
  (^js [a b]
   (fs/stat a b))
  (^js [path options callback]
   (fs/stat path options callback)))

(defn fstat
  "Invokes the callback with the `fs.Stats` for the file descriptor.
   
   See the POSIX [`fstat(2)`](http://man7.org/linux/man-pages/man2/fstat.2.html) documentation for more detail."
  {:arglists '([fd]
               [fd callback]
               [fd options]
               [fd options callback])}
  (^js [fd]
   (fs/fstat fd))
  (^js [a b]
   (fs/fstat a b))
  (^js [fd options callback]
   (fs/fstat fd options callback)))

(defn fstat-sync
  "Retrieves the `fs.Stats` for the file descriptor.
   
   See the POSIX [`fstat(2)`](http://man7.org/linux/man-pages/man2/fstat.2.html) documentation for more detail."
  (^js [fd]
   (fs/fstatSync fd))
  (^js [fd options]
   (fs/fstatSync fd options)))

(defn lstat
  "Retrieves the `fs.Stats` for the symbolic link referred to by the path.
   The callback gets two arguments `(err, stats)` where `stats` is a `fs.Stats` object. `lstat()` is identical to `stat()`, except that if `path` is a symbolic
   link, then the link itself is stat-ed, not the file that it refers to.
   
   See the POSIX [`lstat(2)`](http://man7.org/linux/man-pages/man2/lstat.2.html) documentation for more details."
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/lstat path))
  (^js [a b]
   (fs/lstat a b))
  (^js [path options callback]
   (fs/lstat path options callback)))

(defn link
  "Creates a new link from the `existingPath` to the `newPath`. See the POSIX [`link(2)`](http://man7.org/linux/man-pages/man2/link.2.html) documentation for more detail. No arguments other than
   a possible
   exception are given to the completion callback."
  ^js [existing-path new-path callback]
  (fs/link existing-path new-path callback))

(defn link-sync
  "Creates a new link from the `existingPath` to the `newPath`. See the POSIX [`link(2)`](http://man7.org/linux/man-pages/man2/link.2.html) documentation for more detail. Returns `undefined`."
  ^js [existing-path new-path]
  (fs/linkSync existing-path new-path))

(defn symlink
  "Creates the link called `path` pointing to `target`. No arguments other than a
   possible exception are given to the completion callback.
   
   See the POSIX [`symlink(2)`](http://man7.org/linux/man-pages/man2/symlink.2.html) documentation for more details.
   
   The `type` argument is only available on Windows and ignored on other platforms.
   It can be set to `'dir'`, `'file'`, or `'junction'`. If the `type` argument is
   not set, Node.js will autodetect `target` type and use `'file'` or `'dir'`. If
   the `target` does not exist, `'file'` will be used. Windows junction points
   require the destination path to be absolute. When using `'junction'`, the`target` argument will automatically be normalized to absolute path.
   
   Relative targets are relative to the link’s parent directory.
   
   ```js
   import { symlink } from 'fs';
   
   symlink('./mew', './mewtwo', callback);
   ```
   
   The above example creates a symbolic link `mewtwo` which points to `mew` in the
   same directory:
   
   ```bash
   $ tree .
   .
   ├── mew
   └── mewtwo -> ./mew
   ```
   Asynchronous symlink(2) - Create a new symbolic link to an existing file."
  {:arglists '([target path]
               [target path callback]
               [target path type]
               [target path type callback])}
  (^js [target path]
   (fs/symlink target path))
  (^js [a b c]
   (fs/symlink a b c))
  (^js [target path type callback]
   (fs/symlink target path type callback)))

(defn symlink-sync
  "Returns `undefined`.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link symlink }."
  (^js [target path]
   (fs/symlinkSync target path))
  (^js [target path type]
   (fs/symlinkSync target path type)))

(defn readlink
  "Reads the contents of the symbolic link referred to by `path`. The callback gets
   two arguments `(err, linkString)`.
   
   See the POSIX [`readlink(2)`](http://man7.org/linux/man-pages/man2/readlink.2.html) documentation for more details.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use for
   the link path passed to the callback. If the `encoding` is set to `'buffer'`,
   the link path returned will be passed as a `Buffer` object.
   Asynchronous readlink(2) - read value of a symbolic link."
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/readlink path))
  (^js [a b]
   (fs/readlink a b))
  (^js [path options callback]
   (fs/readlink path options callback)))

(defn readlink-sync
  "Returns the symbolic link's string value.
   
   See the POSIX [`readlink(2)`](http://man7.org/linux/man-pages/man2/readlink.2.html) documentation for more details.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use for
   the link path returned. If the `encoding` is set to `'buffer'`,
   the link path returned will be passed as a `Buffer` object.
   Synchronous readlink(2) - read value of a symbolic link."
  (^js [path]
   (fs/readlinkSync path))
  (^js [path options]
   (fs/readlinkSync path options)))

(defn realpath
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
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/realpath path))
  (^js [a b]
   (fs/realpath a b))
  (^js [path options callback]
   (fs/realpath path options callback)))

(defn realpath-sync
  "Returns the resolved pathname.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link realpath }.
   Synchronous realpath(3) - return the canonicalized absolute pathname."
  (^js [path]
   (fs/realpathSync path))
  (^js [path options]
   (fs/realpathSync path options)))

(defn unlink
  "Asynchronously removes a file or symbolic link. No arguments other than a
   possible exception are given to the completion callback.
   
   ```js
   import { unlink } from 'fs';
   // Assuming that 'path/file.txt' is a regular file.
   unlink('path/file.txt', (err) => {
     if (err) throw err;
     console.log('path/file.txt was deleted');
   });
   ```
   
   `fs.unlink()` will not work on a directory, empty or otherwise. To remove a
   directory, use {@link rmdir }.
   
   See the POSIX [`unlink(2)`](http://man7.org/linux/man-pages/man2/unlink.2.html) documentation for more details."
  ^js [path callback]
  (fs/unlink path callback))

(defn unlink-sync
  "Synchronous [`unlink(2)`](http://man7.org/linux/man-pages/man2/unlink.2.html). Returns `undefined`."
  ^js [path]
  (fs/unlinkSync path))

(defn rmdir
  "Asynchronous [`rmdir(2)`](http://man7.org/linux/man-pages/man2/rmdir.2.html). No arguments other than a possible exception are given
   to the completion callback.
   
   Using `fs.rmdir()` on a file (not a directory) results in an `ENOENT` error on
   Windows and an `ENOTDIR` error on POSIX.
   
   To get a behavior similar to the `rm -rf` Unix command, use {@link rm } with options `{ recursive: true, force: true }`."
  (^js [path callback]
   (fs/rmdir path callback))
  (^js [path options callback]
   (fs/rmdir path options callback)))

(defn rmdir-sync
  "Synchronous [`rmdir(2)`](http://man7.org/linux/man-pages/man2/rmdir.2.html). Returns `undefined`.
   
   Using `fs.rmdirSync()` on a file (not a directory) results in an `ENOENT` error
   on Windows and an `ENOTDIR` error on POSIX.
   
   To get a behavior similar to the `rm -rf` Unix command, use {@link rmSync } with options `{ recursive: true, force: true }`."
  (^js [path]
   (fs/rmdirSync path))
  (^js [path options]
   (fs/rmdirSync path options)))

(defn rm
  "Asynchronously removes files and directories (modeled on the standard POSIX `rm`utility). No arguments other than a possible exception are given to the
   completion callback."
  (^js [path callback]
   (fs/rm path callback))
  (^js [path options callback]
   (fs/rm path options callback)))

(defn rm-sync
  "Synchronously removes files and directories (modeled on the standard POSIX `rm`utility). Returns `undefined`."
  (^js [path]
   (fs/rmSync path))
  (^js [path options]
   (fs/rmSync path options)))

(defn mkdir
  "Asynchronously creates a directory.
   
   The callback is given a possible exception and, if `recursive` is `true`, the
   first directory path created, `(err[, path])`.`path` can still be `undefined` when `recursive` is `true`, if no directory was
   created.
   
   The optional `options` argument can be an integer specifying `mode` (permission
   and sticky bits), or an object with a `mode` property and a `recursive`property indicating whether parent directories should be created. Calling`fs.mkdir()` when `path` is a directory that
   exists results in an error only
   when `recursive` is false.
   
   ```js
   import { mkdir } from 'fs';
   
   // Creates /tmp/a/apple, regardless of whether `/tmp` and /tmp/a exist.
   mkdir('/tmp/a/apple', { recursive: true }, (err) => {
     if (err) throw err;
   });
   ```
   
   On Windows, using `fs.mkdir()` on the root directory even with recursion will
   result in an error:
   
   ```js
   import { mkdir } from 'fs';
   
   mkdir('/', { recursive: true }, (err) => {
     // => [Error: EPERM: operation not permitted, mkdir 'C:\\']
   });
   ```
   
   See the POSIX [`mkdir(2)`](http://man7.org/linux/man-pages/man2/mkdir.2.html) documentation for more details.
   Asynchronous mkdir(2) - create a directory.
   Asynchronous mkdir(2) - create a directory with a mode of `0o777`."
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/mkdir path))
  (^js [a b]
   (fs/mkdir a b))
  (^js [path options callback]
   (fs/mkdir path options callback)))

(defn mkdir-sync
  "Synchronously creates a directory. Returns `undefined`, or if `recursive` is`true`, the first directory path created.
   This is the synchronous version of {@link mkdir }.
   
   See the POSIX [`mkdir(2)`](http://man7.org/linux/man-pages/man2/mkdir.2.html) documentation for more details.
   Synchronous mkdir(2) - create a directory."
  (^js [path]
   (fs/mkdirSync path))
  (^js [path options]
   (fs/mkdirSync path options)))

(defn mkdtemp
  "Creates a unique temporary directory.
   
   Generates six random characters to be appended behind a required`prefix` to create a unique temporary directory. Due to platform
   inconsistencies, avoid trailing `X` characters in `prefix`. Some platforms,
   notably the BSDs, can return more than six random characters, and replace
   trailing `X` characters in `prefix` with random characters.
   
   The created directory path is passed as a string to the callback's second
   parameter.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use.
   
   ```js
   import { mkdtemp } from 'fs';
   
   mkdtemp(path.join(os.tmpdir(), 'foo-'), (err, directory) => {
     if (err) throw err;
     console.log(directory);
     // Prints: /tmp/foo-itXde2 or C:\\Users\\...\\AppData\\Local\\Temp\\foo-itXde2
   });
   ```
   
   The `fs.mkdtemp()` method will append the six randomly selected characters
   directly to the `prefix` string. For instance, given a directory `/tmp`, if the
   intention is to create a temporary directory _within_`/tmp`, the `prefix`must end with a trailing platform-specific path separator
   (`require('path').sep`).
   
   ```js
   import { tmpdir } from 'os';
   import { mkdtemp } from 'fs';
   
   // The parent directory for the new temporary directory
   const tmpDir = tmpdir();
   
   // This method is *INCORRECT*:
   mkdtemp(tmpDir, (err, directory) => {
     if (err) throw err;
     console.log(directory);
     // Will print something similar to `/tmpabc123`.
     // A new temporary directory is created at the file system root
     // rather than *within* the /tmp directory.
   });
   
   // This method is *CORRECT*:
   import { sep } from 'path';
   mkdtemp(`${tmpDir}${sep}`, (err, directory) => {
     if (err) throw err;
     console.log(directory);
     // Will print something similar to `/tmp/abc123`.
     // A new temporary directory is created within
     // the /tmp directory.
   });
   ```
   Asynchronously creates a unique temporary directory.
   Generates six random characters to be appended behind a required prefix to create a unique temporary directory."
  {:arglists '([prefix]
               [prefix callback]
               [prefix options]
               [prefix options callback])}
  (^js [prefix]
   (fs/mkdtemp prefix))
  (^js [a b]
   (fs/mkdtemp a b))
  (^js [prefix options callback]
   (fs/mkdtemp prefix options callback)))

(defn mkdtemp-sync
  "Returns the created directory path.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link mkdtemp }.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use.
   Synchronously creates a unique temporary directory.
   Generates six random characters to be appended behind a required prefix to create a unique temporary directory."
  (^js [prefix]
   (fs/mkdtempSync prefix))
  (^js [prefix options]
   (fs/mkdtempSync prefix options)))

(defn readdir
  "Reads the contents of a directory. The callback gets two arguments `(err, files)`where `files` is an array of the names of the files in the directory excluding`'.'` and `'..'`.
   
   See the POSIX [`readdir(3)`](http://man7.org/linux/man-pages/man3/readdir.3.html) documentation for more details.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use for
   the filenames passed to the callback. If the `encoding` is set to `'buffer'`,
   the filenames returned will be passed as `Buffer` objects.
   
   If `options.withFileTypes` is set to `true`, the `files` array will contain `fs.Dirent` objects.
   Asynchronous readdir(3) - read a directory."
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/readdir path))
  (^js [a b]
   (fs/readdir a b))
  (^js [path options callback]
   (fs/readdir path options callback)))

(defn readdir-sync
  "Reads the contents of the directory.
   
   See the POSIX [`readdir(3)`](http://man7.org/linux/man-pages/man3/readdir.3.html) documentation for more details.
   
   The optional `options` argument can be a string specifying an encoding, or an
   object with an `encoding` property specifying the character encoding to use for
   the filenames returned. If the `encoding` is set to `'buffer'`,
   the filenames returned will be passed as `Buffer` objects.
   
   If `options.withFileTypes` is set to `true`, the result will contain `fs.Dirent` objects.
   Synchronous readdir(3) - read a directory."
  (^js [path]
   (fs/readdirSync path))
  (^js [path options]
   (fs/readdirSync path options)))

(defn close
  "Closes the file descriptor. No arguments other than a possible exception are
   given to the completion callback.
   
   Calling `fs.close()` on any file descriptor (`fd`) that is currently in use
   through any other `fs` operation may lead to undefined behavior.
   
   See the POSIX [`close(2)`](http://man7.org/linux/man-pages/man2/close.2.html) documentation for more detail."
  (^js [fd]
   (fs/close fd))
  (^js [fd callback]
   (fs/close fd callback)))

(defn close-sync
  "Closes the file descriptor. Returns `undefined`.
   
   Calling `fs.closeSync()` on any file descriptor (`fd`) that is currently in use
   through any other `fs` operation may lead to undefined behavior.
   
   See the POSIX [`close(2)`](http://man7.org/linux/man-pages/man2/close.2.html) documentation for more detail."
  ^js [fd]
  (fs/closeSync fd))

(defn open
  "Asynchronous file open. See the POSIX [`open(2)`](http://man7.org/linux/man-pages/man2/open.2.html) documentation for more details.
   
   `mode` sets the file mode (permission and sticky bits), but only if the file was
   created. On Windows, only the write permission can be manipulated; see {@link chmod }.
   
   The callback gets two arguments `(err, fd)`.
   
   Some characters (`< > : \" / \\ | ? *`) are reserved under Windows as documented
   by [Naming Files, Paths, and Namespaces](https://docs.microsoft.com/en-us/windows/desktop/FileIO/naming-a-file). Under NTFS, if the filename contains
   a colon, Node.js will open a file system stream, as described by [this MSDN page](https://docs.microsoft.com/en-us/windows/desktop/FileIO/using-streams).
   
   Functions based on `fs.open()` exhibit this behavior as well:`fs.writeFile()`, `fs.readFile()`, etc.
   Asynchronous open(2) - open and possibly create a file. If the file is created, its mode will be `0o666`."
  {:arglists '([path]
               [path callback]
               [path flags]
               [path flags callback]
               [path flags mode]
               [path flags mode callback])}
  (^js [path]
   (fs/open path))
  (^js [a b]
   (fs/open a b))
  (^js [a b c]
   (fs/open a b c))
  (^js [path flags mode callback]
   (fs/open path flags mode callback)))

(defn open-sync
  "Returns an integer representing the file descriptor.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link open }."
  (^js [path flags]
   (fs/openSync path flags))
  (^js [path flags mode]
   (fs/openSync path flags mode)))

(defn utimes
  "Change the file system timestamps of the object referenced by `path`.
   
   The `atime` and `mtime` arguments follow these rules:
   
   * Values can be either numbers representing Unix epoch time in seconds,`Date`s, or a numeric string like `'123456789.0'`.
   * If the value can not be converted to a number, or is `NaN`, `Infinity` or`-Infinity`, an `Error` will be thrown."
  ^js [path atime mtime callback]
  (fs/utimes path atime mtime callback))

(defn utimes-sync
  "Returns `undefined`.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link utimes }."
  ^js [path atime mtime]
  (fs/utimesSync path atime mtime))

(defn futimes
  "Change the file system timestamps of the object referenced by the supplied file
   descriptor. See {@link utimes }."
  ^js [fd atime mtime callback]
  (fs/futimes fd atime mtime callback))

(defn futimes-sync
  "Synchronous version of {@link futimes }. Returns `undefined`."
  ^js [fd atime mtime]
  (fs/futimesSync fd atime mtime))

(defn fsync
  "Request that all data for the open file descriptor is flushed to the storage
   device. The specific implementation is operating system and device specific.
   Refer to the POSIX [`fsync(2)`](http://man7.org/linux/man-pages/man2/fsync.2.html) documentation for more detail. No arguments other
   than a possible exception are given to the completion callback."
  ^js [fd callback]
  (fs/fsync fd callback))

(defn fsync-sync
  "Request that all data for the open file descriptor is flushed to the storage
   device. The specific implementation is operating system and device specific.
   Refer to the POSIX [`fsync(2)`](http://man7.org/linux/man-pages/man2/fsync.2.html) documentation for more detail. Returns `undefined`."
  ^js [fd]
  (fs/fsyncSync fd))

(defn write
  "Write `buffer` to the file specified by `fd`.
   
   `offset` determines the part of the buffer to be written, and `length` is
   an integer specifying the number of bytes to write.
   
   `position` refers to the offset from the beginning of the file where this data
   should be written. If `typeof position !== 'number'`, the data will be written
   at the current position. See [`pwrite(2)`](http://man7.org/linux/man-pages/man2/pwrite.2.html).
   
   The callback will be given three arguments `(err, bytesWritten, buffer)` where`bytesWritten` specifies how many _bytes_ were written from `buffer`.
   
   If this method is invoked as its `util.promisify()` ed version, it returns
   a promise for an `Object` with `bytesWritten` and `buffer` properties.
   
   It is unsafe to use `fs.write()` multiple times on the same file without waiting
   for the callback. For this scenario, {@link createWriteStream } is
   recommended.
   
   On Linux, positional writes don't work when the file is opened in append mode.
   The kernel ignores the position argument and always appends the data to
   the end of the file.
   Asynchronously writes `buffer` to the file referenced by the supplied file descriptor.
   Asynchronously writes `string` to the file referenced by the supplied file descriptor."
  {:arglists '([fd buffer]
               [fd buffer callback]
               [fd buffer offset]
               [fd buffer offset callback]
               [fd buffer offset length]
               [fd buffer offset length callback]
               [fd buffer offset length position]
               [fd buffer offset length position callback]
               [fd string]
               [fd string callback]
               [fd string position]
               [fd string position callback]
               [fd string position encoding]
               [fd string position encoding callback])}
  (^js [a b]
   (fs/write a b))
  (^js [a b c]
   (fs/write a b c))
  (^js [a b c d]
   (fs/write a b c d))
  (^js [a b c d e]
   (fs/write a b c d e))
  (^js [fd buffer offset length position callback]
   (fs/write fd buffer offset length position callback)))

(defn write-sync
  "For detailed information, see the documentation of the asynchronous version of
   this API: {@link write }.
   Synchronously writes `string` to the file referenced by the supplied file descriptor, returning the number of bytes written."
  {:arglists '([fd buffer]
               [fd buffer offset]
               [fd buffer offset length]
               [fd buffer offset length position]
               [fd string]
               [fd string position]
               [fd string position encoding])}
  (^js [a b]
   (fs/writeSync a b))
  (^js [a b c]
   (fs/writeSync a b c))
  (^js [a b c d]
   (fs/writeSync a b c d))
  (^js [fd buffer offset length position]
   (fs/writeSync fd buffer offset length position)))

(defn read
  "Read data from the file specified by `fd`.
   
   The callback is given the three arguments, `(err, bytesRead, buffer)`.
   
   If the file is not modified concurrently, the end-of-file is reached when the
   number of bytes read is zero.
   
   If this method is invoked as its `util.promisify()` ed version, it returns
   a promise for an `Object` with `bytesRead` and `buffer` properties.
   Similar to the above `fs.read` function, this version takes an optional `options` object.
   If not otherwise specified in an `options` object,
   `buffer` defaults to `Buffer.alloc(16384)`,
   `offset` defaults to `0`,
   `length` defaults to `buffer.byteLength`, `- offset` as of Node 17.6.0
   `position` defaults to `null`"
  (^js [fd callback]
   (fs/read fd callback))
  (^js [fd options callback]
   (fs/read fd options callback))
  (^js [fd buffer offset length position callback]
   (fs/read fd buffer offset length position callback)))

(defn read-sync
  "Returns the number of `bytesRead`.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link read }.
   Similar to the above `fs.readSync` function, this version takes an optional `options` object.
   If no `options` object is specified, it will default with the above values."
  (^js [fd buffer]
   (fs/readSync fd buffer))
  (^js [fd buffer opts]
   (fs/readSync fd buffer opts))
  (^js [fd buffer offset length position]
   (fs/readSync fd buffer offset length position)))

(defn read-file
  "Asynchronously reads the entire contents of a file.
   
   ```js
   import { readFile } from 'fs';
   
   readFile('/etc/passwd', (err, data) => {
     if (err) throw err;
     console.log(data);
   });
   ```
   
   The callback is passed two arguments `(err, data)`, where `data` is the
   contents of the file.
   
   If no encoding is specified, then the raw buffer is returned.
   
   If `options` is a string, then it specifies the encoding:
   
   ```js
   import { readFile } from 'fs';
   
   readFile('/etc/passwd', 'utf8', callback);
   ```
   
   When the path is a directory, the behavior of `fs.readFile()` and {@link readFileSync } is platform-specific. On macOS, Linux, and Windows, an
   error will be returned. On FreeBSD, a representation of the directory's contents
   will be returned.
   
   ```js
   import { readFile } from 'fs';
   
   // macOS, Linux, and Windows
   readFile('<directory>', (err, data) => {
     // => [Error: EISDIR: illegal operation on a directory, read <directory>]
   });
   
   //  FreeBSD
   readFile('<directory>', (err, data) => {
     // => null, <data>
   });
   ```
   
   It is possible to abort an ongoing request using an `AbortSignal`. If a
   request is aborted the callback is called with an `AbortError`:
   
   ```js
   import { readFile } from 'fs';
   
   const controller = new AbortController();
   const signal = controller.signal;
   readFile(fileInfo[0].name, { signal }, (err, buf) => {
     // ...
   });
   // When you want to abort the request
   controller.abort();
   ```
   
   The `fs.readFile()` function buffers the entire file. To minimize memory costs,
   when possible prefer streaming via `fs.createReadStream()`.
   
   Aborting an ongoing request does not abort individual operating
   system requests but rather the internal buffering `fs.readFile` performs.
   Asynchronously reads the entire contents of a file."
  {:arglists '([path]
               [path callback]
               [path options]
               [path options callback])}
  (^js [path]
   (fs/readFile path))
  (^js [a b]
   (fs/readFile a b))
  (^js [path options callback]
   (fs/readFile path options callback)))

(defn read-file-sync
  "Returns the contents of the `path`.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link readFile }.
   
   If the `encoding` option is specified then this function returns a
   string. Otherwise it returns a buffer.
   
   Similar to {@link readFile }, when the path is a directory, the behavior of`fs.readFileSync()` is platform-specific.
   
   ```js
   import { readFileSync } from 'fs';
   
   // macOS, Linux, and Windows
   readFileSync('<directory>');
   // => [Error: EISDIR: illegal operation on a directory, read <directory>]
   
   //  FreeBSD
   readFileSync('<directory>'); // => <data>
   ```
   Synchronously reads the entire contents of a file."
  (^js [path]
   (fs/readFileSync path))
  (^js [path options]
   (fs/readFileSync path options)))

(defn write-file
  "When `file` is a filename, asynchronously writes data to the file, replacing the
   file if it already exists. `data` can be a string or a buffer.
   
   When `file` is a file descriptor, the behavior is similar to calling`fs.write()` directly (which is recommended). See the notes below on using
   a file descriptor.
   
   The `encoding` option is ignored if `data` is a buffer.
   
   The `mode` option only affects the newly created file. See {@link open } for more details.
   
   ```js
   import { writeFile } from 'fs';
   import { Buffer } from 'buffer';
   
   const data = new Uint8Array(Buffer.from('Hello Node.js'));
   writeFile('message.txt', data, (err) => {
     if (err) throw err;
     console.log('The file has been saved!');
   });
   ```
   
   If `options` is a string, then it specifies the encoding:
   
   ```js
   import { writeFile } from 'fs';
   
   writeFile('message.txt', 'Hello Node.js', 'utf8', callback);
   ```
   
   It is unsafe to use `fs.writeFile()` multiple times on the same file without
   waiting for the callback. For this scenario, {@link createWriteStream } is
   recommended.
   
   Similarly to `fs.readFile` \\- `fs.writeFile` is a convenience method that
   performs multiple `write` calls internally to write the buffer passed to it.
   For performance sensitive code consider using {@link createWriteStream }.
   
   It is possible to use an `AbortSignal` to cancel an `fs.writeFile()`.
   Cancelation is \"best effort\", and some amount of data is likely still
   to be written.
   
   ```js
   import { writeFile } from 'fs';
   import { Buffer } from 'buffer';
   
   const controller = new AbortController();
   const { signal } = controller;
   const data = new Uint8Array(Buffer.from('Hello Node.js'));
   writeFile('message.txt', data, { signal }, (err) => {
     // When a request is aborted - the callback is called with an AbortError
   });
   // When the request should be aborted
   controller.abort();
   ```
   
   Aborting an ongoing request does not abort individual operating
   system requests but rather the internal buffering `fs.writeFile` performs.
   Asynchronously writes data to a file, replacing the file if it already exists."
  (^js [path data callback]
   (fs/writeFile path data callback))
  (^js [file data options callback]
   (fs/writeFile file data options callback)))

(defn write-file-sync
  "Returns `undefined`.
   
   The `mode` option only affects the newly created file. See {@link open } for more details.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link writeFile }."
  (^js [file data]
   (fs/writeFileSync file data))
  (^js [file data options]
   (fs/writeFileSync file data options)))

(defn append-file
  "Asynchronously append data to a file, creating the file if it does not yet
   exist. `data` can be a string or a `Buffer`.
   
   The `mode` option only affects the newly created file. See {@link open } for more details.
   
   ```js
   import { appendFile } from 'fs';
   
   appendFile('message.txt', 'data to append', (err) => {
     if (err) throw err;
     console.log('The \"data to append\" was appended to file!');
   });
   ```
   
   If `options` is a string, then it specifies the encoding:
   
   ```js
   import { appendFile } from 'fs';
   
   appendFile('message.txt', 'data to append', 'utf8', callback);
   ```
   
   The `path` may be specified as a numeric file descriptor that has been opened
   for appending (using `fs.open()` or `fs.openSync()`). The file descriptor will
   not be closed automatically.
   
   ```js
   import { open, close, appendFile } from 'fs';
   
   function closeFd(fd) {
     close(fd, (err) => {
       if (err) throw err;
     });
   }
   
   open('message.txt', 'a', (err, fd) => {
     if (err) throw err;
   
     try {
       appendFile(fd, 'data to append', 'utf8', (err) => {
         closeFd(fd);
         if (err) throw err;
       });
     } catch (err) {
       closeFd(fd);
       throw err;
     }
   });
   ```
   Asynchronously append data to a file, creating the file if it does not exist."
  (^js [file data callback]
   (fs/appendFile file data callback))
  (^js [path data options callback]
   (fs/appendFile path data options callback)))

(defn append-file-sync
  "Synchronously append data to a file, creating the file if it does not yet
   exist. `data` can be a string or a `Buffer`.
   
   The `mode` option only affects the newly created file. See {@link open } for more details.
   
   ```js
   import { appendFileSync } from 'fs';
   
   try {
     appendFileSync('message.txt', 'data to append');
     console.log('The \"data to append\" was appended to file!');
   } catch (err) {
     // Handle the error
   }
   ```
   
   If `options` is a string, then it specifies the encoding:
   
   ```js
   import { appendFileSync } from 'fs';
   
   appendFileSync('message.txt', 'data to append', 'utf8');
   ```
   
   The `path` may be specified as a numeric file descriptor that has been opened
   for appending (using `fs.open()` or `fs.openSync()`). The file descriptor will
   not be closed automatically.
   
   ```js
   import { openSync, closeSync, appendFileSync } from 'fs';
   
   let fd;
   
   try {
     fd = openSync('message.txt', 'a');
     appendFileSync(fd, 'data to append', 'utf8');
   } catch (err) {
     // Handle the error
   } finally {
     if (fd !== undefined)
       closeSync(fd);
   }
   ```"
  (^js [path data]
   (fs/appendFileSync path data))
  (^js [path data options]
   (fs/appendFileSync path data options)))

(defn watch-file
  "Watch for changes on `filename`. The callback `listener` will be called each
   time the file is accessed.
   
   The `options` argument may be omitted. If provided, it should be an object. The`options` object may contain a boolean named `persistent` that indicates
   whether the process should continue to run as long as files are being watched.
   The `options` object may specify an `interval` property indicating how often the
   target should be polled in milliseconds.
   
   The `listener` gets two arguments the current stat object and the previous
   stat object:
   
   ```js
   import { watchFile } from 'fs';
   
   watchFile('message.text', (curr, prev) => {
     console.log(`the current mtime is: ${curr.mtime}`);
     console.log(`the previous mtime was: ${prev.mtime}`);
   });
   ```
   
   These stat objects are instances of `fs.Stat`. If the `bigint` option is `true`,
   the numeric values in these objects are specified as `BigInt`s.
   
   To be notified when the file was modified, not just accessed, it is necessary
   to compare `curr.mtimeMs` and `prev.mtimeMs`.
   
   When an `fs.watchFile` operation results in an `ENOENT` error, it
   will invoke the listener once, with all the fields zeroed (or, for dates, the
   Unix Epoch). If the file is created later on, the listener will be called
   again, with the latest stat objects. This is a change in functionality since
   v0.10.
   
   Using {@link watch } is more efficient than `fs.watchFile` and`fs.unwatchFile`. `fs.watch` should be used instead of `fs.watchFile` and`fs.unwatchFile` when possible.
   
   When a file being watched by `fs.watchFile()` disappears and reappears,
   then the contents of `previous` in the second callback event (the file's
   reappearance) will be the same as the contents of `previous` in the first
   callback event (its disappearance).
   
   This happens when:
   
   * the file is deleted, followed by a restore
   * the file is renamed and then renamed a second time back to its original name
   Watch for changes on `filename`. The callback `listener` will be called each time the file is accessed."
  {:arglists '([filename]
               [filename listener]
               [filename options]
               [filename options listener])}
  (^js [filename]
   (fs/watchFile filename))
  (^js [a b]
   (fs/watchFile a b))
  (^js [filename options listener]
   (fs/watchFile filename options listener)))

(defn unwatch-file
  "Stop watching for changes on `filename`. If `listener` is specified, only that
   particular listener is removed. Otherwise, _all_ listeners are removed,
   effectively stopping watching of `filename`.
   
   Calling `fs.unwatchFile()` with a filename that is not being watched is a
   no-op, not an error.
   
   Using {@link watch } is more efficient than `fs.watchFile()` and`fs.unwatchFile()`. `fs.watch()` should be used instead of `fs.watchFile()`and `fs.unwatchFile()` when possible."
  (^js [filename]
   (fs/unwatchFile filename))
  (^js [filename listener]
   (fs/unwatchFile filename listener)))

(defn watch
  "Watch for changes on `filename`, where `filename` is either a file or a
   directory.
   
   The second argument is optional. If `options` is provided as a string, it
   specifies the `encoding`. Otherwise `options` should be passed as an object.
   
   The listener callback gets two arguments `(eventType, filename)`. `eventType`is either `'rename'` or `'change'`, and `filename` is the name of the file
   which triggered the event.
   
   On most platforms, `'rename'` is emitted whenever a filename appears or
   disappears in the directory.
   
   The listener callback is attached to the `'change'` event fired by `fs.FSWatcher`, but it is not the same thing as the `'change'` value of`eventType`.
   
   If a `signal` is passed, aborting the corresponding AbortController will close
   the returned `fs.FSWatcher`.
   Watch for changes on `filename`, where `filename` is either a file or a directory, returning an `FSWatcher`."
  {:arglists '([filename]
               [filename listener]
               [filename options]
               [filename options listener])}
  (^js [filename]
   (fs/watch filename))
  (^js [a b]
   (fs/watch a b))
  (^js [filename options listener]
   (fs/watch filename options listener)))

(defn exists
  "Test whether or not the given path exists by checking with the file system.
   Then call the `callback` argument with either true or false:
   
   ```js
   import { exists } from 'fs';
   
   exists('/etc/passwd', (e) => {
     console.log(e ? 'it exists' : 'no passwd!');
   });
   ```
   
   **The parameters for this callback are not consistent with other Node.js**
   **callbacks.** Normally, the first parameter to a Node.js callback is an `err`parameter, optionally followed by other parameters. The `fs.exists()` callback
   has only one boolean parameter. This is one reason `fs.access()` is recommended
   instead of `fs.exists()`.
   
   Using `fs.exists()` to check for the existence of a file before calling`fs.open()`, `fs.readFile()` or `fs.writeFile()` is not recommended. Doing
   so introduces a race condition, since other processes may change the file's
   state between the two calls. Instead, user code should open/read/write the
   file directly and handle the error raised if the file does not exist.
   
   **write (NOT RECOMMENDED)**
   
   ```js
   import { exists, open, close } from 'fs';
   
   exists('myfile', (e) => {
     if (e) {
       console.error('myfile already exists');
     } else {
       open('myfile', 'wx', (err, fd) => {
         if (err) throw err;
   
         try {
           writeMyData(fd);
         } finally {
           close(fd, (err) => {
             if (err) throw err;
           });
         }
       });
     }
   });
   ```
   
   **write (RECOMMENDED)**
   
   ```js
   import { open, close } from 'fs';
   open('myfile', 'wx', (err, fd) => {
     if (err) {
       if (err.code === 'EEXIST') {
         console.error('myfile already exists');
         return;
       }
   
       throw err;
     }
   
     try {
       writeMyData(fd);
     } finally {
       close(fd, (err) => {
         if (err) throw err;
       });
     }
   });
   ```
   
   **read (NOT RECOMMENDED)**
   
   ```js
   import { open, close, exists } from 'fs';
   
   exists('myfile', (e) => {
     if (e) {
       open('myfile', 'r', (err, fd) => {
         if (err) throw err;
   
         try {
           readMyData(fd);
         } finally {
           close(fd, (err) => {
             if (err) throw err;
           });
         }
       });
     } else {
       console.error('myfile does not exist');
     }
   });
   ```
   
   **read (RECOMMENDED)**
   
   ```js
   import { open, close } from 'fs';
   
   open('myfile', 'r', (err, fd) => {
     if (err) {
       if (err.code === 'ENOENT') {
         console.error('myfile does not exist');
         return;
       }
   
       throw err;
     }
   
     try {
       readMyData(fd);
     } finally {
       close(fd, (err) => {
         if (err) throw err;
       });
     }
   });
   ```
   
   The \"not recommended\" examples above check for existence and then use the
   file; the \"recommended\" examples are better because they use the file directly
   and handle the error, if any.
   
   In general, check for the existence of a file only if the file won’t be
   used directly, for example when its existence is a signal from another
   process."
  ^js [path callback]
  (fs/exists path callback))

(defn exists-sync?
  "Returns `true` if the path exists, `false` otherwise.
   
   For detailed information, see the documentation of the asynchronous version of
   this API: {@link exists }.
   
   `fs.exists()` is deprecated, but `fs.existsSync()` is not. The `callback`parameter to `fs.exists()` accepts parameters that are inconsistent with other
   Node.js callbacks. `fs.existsSync()` does not use a callback.
   
   ```js
   import { existsSync } from 'fs';
   
   if (existsSync('/etc/passwd'))
     console.log('The path exists.');
   ```"
  ^js [path]
  (fs/existsSync path))

(defn access
  "Tests a user's permissions for the file or directory specified by `path`.
   The `mode` argument is an optional integer that specifies the accessibility
   checks to be performed. `mode` should be either the value `fs.constants.F_OK`or a mask consisting of the bitwise OR of any of `fs.constants.R_OK`,`fs.constants.W_OK`, and `fs.constants.X_OK`
   (e.g.`fs.constants.W_OK | fs.constants.R_OK`). Check `File access constants` for
   possible values of `mode`.
   
   The final argument, `callback`, is a callback function that is invoked with
   a possible error argument. If any of the accessibility checks fail, the error
   argument will be an `Error` object. The following examples check if`package.json` exists, and if it is readable or writable.
   
   ```js
   import { access, constants } from 'fs';
   
   const file = 'package.json';
   
   // Check if the file exists in the current directory.
   access(file, constants.F_OK, (err) => {
     console.log(`${file} ${err ? 'does not exist' : 'exists'}`);
   });
   
   // Check if the file is readable.
   access(file, constants.R_OK, (err) => {
     console.log(`${file} ${err ? 'is not readable' : 'is readable'}`);
   });
   
   // Check if the file is writable.
   access(file, constants.W_OK, (err) => {
     console.log(`${file} ${err ? 'is not writable' : 'is writable'}`);
   });
   
   // Check if the file is readable and writable.
   access(file, constants.R_OK | constants.W_OK, (err) => {
     console.log(`${file} ${err ? 'is not' : 'is'} readable and writable`);
   });
   ```
   
   Do not use `fs.access()` to check for the accessibility of a file before calling`fs.open()`, `fs.readFile()` or `fs.writeFile()`. Doing
   so introduces a race condition, since other processes may change the file's
   state between the two calls. Instead, user code should open/read/write the
   file directly and handle the error raised if the file is not accessible.
   
   **write (NOT RECOMMENDED)**
   
   ```js
   import { access, open, close } from 'fs';
   
   access('myfile', (err) => {
     if (!err) {
       console.error('myfile already exists');
       return;
     }
   
     open('myfile', 'wx', (err, fd) => {
       if (err) throw err;
   
       try {
         writeMyData(fd);
       } finally {
         close(fd, (err) => {
           if (err) throw err;
         });
       }
     });
   });
   ```
   
   **write (RECOMMENDED)**
   
   ```js
   import { open, close } from 'fs';
   
   open('myfile', 'wx', (err, fd) => {
     if (err) {
       if (err.code === 'EEXIST') {
         console.error('myfile already exists');
         return;
       }
   
       throw err;
     }
   
     try {
       writeMyData(fd);
     } finally {
       close(fd, (err) => {
         if (err) throw err;
       });
     }
   });
   ```
   
   **read (NOT RECOMMENDED)**
   
   ```js
   import { access, open, close } from 'fs';
   access('myfile', (err) => {
     if (err) {
       if (err.code === 'ENOENT') {
         console.error('myfile does not exist');
         return;
       }
   
       throw err;
     }
   
     open('myfile', 'r', (err, fd) => {
       if (err) throw err;
   
       try {
         readMyData(fd);
       } finally {
         close(fd, (err) => {
           if (err) throw err;
         });
       }
     });
   });
   ```
   
   **read (RECOMMENDED)**
   
   ```js
   import { open, close } from 'fs';
   
   open('myfile', 'r', (err, fd) => {
     if (err) {
       if (err.code === 'ENOENT') {
         console.error('myfile does not exist');
         return;
       }
   
       throw err;
     }
   
     try {
       readMyData(fd);
     } finally {
       close(fd, (err) => {
         if (err) throw err;
       });
     }
   });
   ```
   
   The \"not recommended\" examples above check for accessibility and then use the
   file; the \"recommended\" examples are better because they use the file directly
   and handle the error, if any.
   
   In general, check for the accessibility of a file only if the file will not be
   used directly, for example when its accessibility is a signal from another
   process.
   
   On Windows, access-control policies (ACLs) on a directory may limit access to
   a file or directory. The `fs.access()` function, however, does not check the
   ACL and therefore may report that a path is accessible even if the ACL restricts
   the user from reading or writing to it.
   Asynchronously tests a user's permissions for the file specified by path."
  {:arglists '([path]
               [path callback]
               [path mode]
               [path mode callback])}
  (^js [path]
   (fs/access path))
  (^js [a b]
   (fs/access a b))
  (^js [path mode callback]
   (fs/access path mode callback)))

(defn access-sync
  "Synchronously tests a user's permissions for the file or directory specified
   by `path`. The `mode` argument is an optional integer that specifies the
   accessibility checks to be performed. `mode` should be either the value`fs.constants.F_OK` or a mask consisting of the bitwise OR of any of`fs.constants.R_OK`, `fs.constants.W_OK`, and
   `fs.constants.X_OK` (e.g.`fs.constants.W_OK | fs.constants.R_OK`). Check `File access constants` for
   possible values of `mode`.
   
   If any of the accessibility checks fail, an `Error` will be thrown. Otherwise,
   the method will return `undefined`.
   
   ```js
   import { accessSync, constants } from 'fs';
   
   try {
     accessSync('etc/passwd', constants.R_OK | constants.W_OK);
     console.log('can read/write');
   } catch (err) {
     console.error('no access!');
   }
   ```"
  (^js [path]
   (fs/accessSync path))
  (^js [path mode]
   (fs/accessSync path mode)))

(defn create-read-stream
  "Unlike the 16 kb default `highWaterMark` for a `stream.Readable`, the stream
   returned by this method has a default `highWaterMark` of 64 kb.
   
   `options` can include `start` and `end` values to read a range of bytes from
   the file instead of the entire file. Both `start` and `end` are inclusive and
   start counting at 0, allowed values are in the
   \\[0, [`Number.MAX_SAFE_INTEGER`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/MAX_SAFE_INTEGER)\\] range. If `fd` is specified and `start` is
   omitted or `undefined`, `fs.createReadStream()` reads sequentially from the
   current file position. The `encoding` can be any one of those accepted by `Buffer`.
   
   If `fd` is specified, `ReadStream` will ignore the `path` argument and will use
   the specified file descriptor. This means that no `'open'` event will be
   emitted. `fd` should be blocking; non-blocking `fd`s should be passed to `net.Socket`.
   
   If `fd` points to a character device that only supports blocking reads
   (such as keyboard or sound card), read operations do not finish until data is
   available. This can prevent the process from exiting and the stream from
   closing naturally.
   
   By default, the stream will emit a `'close'` event after it has been
   destroyed.  Set the `emitClose` option to `false` to change this behavior.
   
   By providing the `fs` option, it is possible to override the corresponding `fs`implementations for `open`, `read`, and `close`. When providing the `fs` option,
   an override for `read` is required. If no `fd` is provided, an override for`open` is also required. If `autoClose` is `true`, an override for `close` is
   also required.
   
   ```js
   import { createReadStream } from 'fs';
   
   // Create a stream from some character device.
   const stream = createReadStream('/dev/input/event0');
   setTimeout(() => {
     stream.close(); // This may not close the stream.
     // Artificially marking end-of-stream, as if the underlying resource had
     // indicated end-of-file by itself, allows the stream to close.
     // This does not cancel pending read operations, and if there is such an
     // operation, the process may still not be able to exit successfully
     // until it finishes.
     stream.push(null);
     stream.read(0);
   }, 100);
   ```
   
   If `autoClose` is false, then the file descriptor won't be closed, even if
   there's an error. It is the application's responsibility to close it and make
   sure there's no file descriptor leak. If `autoClose` is set to true (default
   behavior), on `'error'` or `'end'` the file descriptor will be closed
   automatically.
   
   `mode` sets the file mode (permission and sticky bits), but only if the
   file was created.
   
   An example to read the last 10 bytes of a file which is 100 bytes long:
   
   ```js
   import { createReadStream } from 'fs';
   
   createReadStream('sample.txt', { start: 90, end: 99 });
   ```
   
   If `options` is a string, then it specifies the encoding."
  (^js [path]
   (fs/createReadStream path))
  (^js [path options]
   (fs/createReadStream path options)))

(defn create-write-stream
  "`options` may also include a `start` option to allow writing data at some
   position past the beginning of the file, allowed values are in the
   \\[0, [`Number.MAX_SAFE_INTEGER`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Number/MAX_SAFE_INTEGER)\\] range. Modifying a file rather than
   replacing it may require the `flags` option to be set to `r+` rather than the
   default `w`. The `encoding` can be any one of those accepted by `Buffer`.
   
   If `autoClose` is set to true (default behavior) on `'error'` or `'finish'`the file descriptor will be closed automatically. If `autoClose` is false,
   then the file descriptor won't be closed, even if there's an error.
   It is the application's responsibility to close it and make sure there's no
   file descriptor leak.
   
   By default, the stream will emit a `'close'` event after it has been
   destroyed.  Set the `emitClose` option to `false` to change this behavior.
   
   By providing the `fs` option it is possible to override the corresponding `fs`implementations for `open`, `write`, `writev` and `close`. Overriding `write()`without `writev()` can reduce
   performance as some optimizations (`_writev()`)
   will be disabled. When providing the `fs` option, overrides for at least one of`write` and `writev` are required. If no `fd` option is supplied, an override
   for `open` is also required. If `autoClose` is `true`, an override for `close`is also required.
   
   Like `fs.ReadStream`, if `fd` is specified, `fs.WriteStream` will ignore the`path` argument and will use the specified file descriptor. This means that no`'open'` event will be
   emitted. `fd` should be blocking; non-blocking `fd`s
   should be passed to `net.Socket`.
   
   If `options` is a string, then it specifies the encoding."
  (^js [path]
   (fs/createWriteStream path))
  (^js [path options]
   (fs/createWriteStream path options)))

(defn fdatasync
  "Forces all currently queued I/O operations associated with the file to the
   operating system's synchronized I/O completion state. Refer to the POSIX [`fdatasync(2)`](http://man7.org/linux/man-pages/man2/fdatasync.2.html) documentation for details. No arguments other
   than a possible
   exception are given to the completion callback."
  ^js [fd callback]
  (fs/fdatasync fd callback))

(defn fdatasync-sync
  "Forces all currently queued I/O operations associated with the file to the
   operating system's synchronized I/O completion state. Refer to the POSIX [`fdatasync(2)`](http://man7.org/linux/man-pages/man2/fdatasync.2.html) documentation for details. Returns `undefined`."
  ^js [fd]
  (fs/fdatasyncSync fd))

(defn copy-file
  "Asynchronously copies `src` to `dest`. By default, `dest` is overwritten if it
   already exists. No arguments other than a possible exception are given to the
   callback function. Node.js makes no guarantees about the atomicity of the copy
   operation. If an error occurs after the destination file has been opened for
   writing, Node.js will attempt to remove the destination.
   
   `mode` is an optional integer that specifies the behavior
   of the copy operation. It is possible to create a mask consisting of the bitwise
   OR of two or more values (e.g.`fs.constants.COPYFILE_EXCL | fs.constants.COPYFILE_FICLONE`).
   
   * `fs.constants.COPYFILE_EXCL`: The copy operation will fail if `dest` already
   exists.
   * `fs.constants.COPYFILE_FICLONE`: The copy operation will attempt to create a
   copy-on-write reflink. If the platform does not support copy-on-write, then a
   fallback copy mechanism is used.
   * `fs.constants.COPYFILE_FICLONE_FORCE`: The copy operation will attempt to
   create a copy-on-write reflink. If the platform does not support
   copy-on-write, then the operation will fail.
   
   ```js
   import { copyFile, constants } from 'fs';
   
   function callback(err) {
     if (err) throw err;
     console.log('source.txt was copied to destination.txt');
   }
   
   // destination.txt will be created or overwritten by default.
   copyFile('source.txt', 'destination.txt', callback);
   
   // By using COPYFILE_EXCL, the operation will fail if destination.txt exists.
   copyFile('source.txt', 'destination.txt', constants.COPYFILE_EXCL, callback);
   ```"
  (^js [src dest callback]
   (fs/copyFile src dest callback))
  (^js [src dest mode callback]
   (fs/copyFile src dest mode callback)))

(defn copy-file-sync
  "Synchronously copies `src` to `dest`. By default, `dest` is overwritten if it
   already exists. Returns `undefined`. Node.js makes no guarantees about the
   atomicity of the copy operation. If an error occurs after the destination file
   has been opened for writing, Node.js will attempt to remove the destination.
   
   `mode` is an optional integer that specifies the behavior
   of the copy operation. It is possible to create a mask consisting of the bitwise
   OR of two or more values (e.g.`fs.constants.COPYFILE_EXCL | fs.constants.COPYFILE_FICLONE`).
   
   * `fs.constants.COPYFILE_EXCL`: The copy operation will fail if `dest` already
   exists.
   * `fs.constants.COPYFILE_FICLONE`: The copy operation will attempt to create a
   copy-on-write reflink. If the platform does not support copy-on-write, then a
   fallback copy mechanism is used.
   * `fs.constants.COPYFILE_FICLONE_FORCE`: The copy operation will attempt to
   create a copy-on-write reflink. If the platform does not support
   copy-on-write, then the operation will fail.
   
   ```js
   import { copyFileSync, constants } from 'fs';
   
   // destination.txt will be created or overwritten by default.
   copyFileSync('source.txt', 'destination.txt');
   console.log('source.txt was copied to destination.txt');
   
   // By using COPYFILE_EXCL, the operation will fail if destination.txt exists.
   copyFileSync('source.txt', 'destination.txt', constants.COPYFILE_EXCL);
   ```"
  (^js [src dest]
   (fs/copyFileSync src dest))
  (^js [src dest mode]
   (fs/copyFileSync src dest mode)))

(defn writev
  "Write an array of `ArrayBufferView`s to the file specified by `fd` using`writev()`.
   
   `position` is the offset from the beginning of the file where this data
   should be written. If `typeof position !== 'number'`, the data will be written
   at the current position.
   
   The callback will be given three arguments: `err`, `bytesWritten`, and`buffers`. `bytesWritten` is how many bytes were written from `buffers`.
   
   If this method is `util.promisify()` ed, it returns a promise for an`Object` with `bytesWritten` and `buffers` properties.
   
   It is unsafe to use `fs.writev()` multiple times on the same file without
   waiting for the callback. For this scenario, use {@link createWriteStream }.
   
   On Linux, positional writes don't work when the file is opened in append mode.
   The kernel ignores the position argument and always appends the data to
   the end of the file."
  (^js [fd buffers cb]
   (fs/writev fd buffers cb))
  (^js [fd buffers position cb]
   (fs/writev fd buffers position cb)))

(defn writev-sync
  "For detailed information, see the documentation of the asynchronous version of
   this API: {@link writev }."
  (^js [fd buffers]
   (fs/writevSync fd buffers))
  (^js [fd buffers position]
   (fs/writevSync fd buffers position)))

(defn readv
  "Read from a file specified by `fd` and write to an array of `ArrayBufferView`s
   using `readv()`.
   
   `position` is the offset from the beginning of the file from where data
   should be read. If `typeof position !== 'number'`, the data will be read
   from the current position.
   
   The callback will be given three arguments: `err`, `bytesRead`, and`buffers`. `bytesRead` is how many bytes were read from the file.
   
   If this method is invoked as its `util.promisify()` ed version, it returns
   a promise for an `Object` with `bytesRead` and `buffers` properties."
  (^js [fd buffers cb]
   (fs/readv fd buffers cb))
  (^js [fd buffers position cb]
   (fs/readv fd buffers position cb)))

(defn readv-sync
  "For detailed information, see the documentation of the asynchronous version of
   this API: {@link readv }."
  (^js [fd buffers]
   (fs/readvSync fd buffers))
  (^js [fd buffers position]
   (fs/readvSync fd buffers position)))

(defn opendir-sync
  "Synchronously open a directory. See [`opendir(3)`](http://man7.org/linux/man-pages/man3/opendir.3.html).
   
   Creates an `fs.Dir`, which contains all further functions for reading from
   and cleaning up the directory.
   
   The `encoding` option sets the encoding for the `path` while opening the
   directory and subsequent read operations."
  (^js [path]
   (fs/opendirSync path))
  (^js [path options]
   (fs/opendirSync path options)))

(defn opendir
  "Asynchronously open a directory. See the POSIX [`opendir(3)`](http://man7.org/linux/man-pages/man3/opendir.3.html) documentation for
   more details.
   
   Creates an `fs.Dir`, which contains all further functions for reading from
   and cleaning up the directory.
   
   The `encoding` option sets the encoding for the `path` while opening the
   directory and subsequent read operations."
  (^js [path cb]
   (fs/opendir path cb))
  (^js [path options cb]
   (fs/opendir path options cb)))

(defn cp
  "Asynchronously copies the entire directory structure from `src` to `dest`,
   including subdirectories and files.
   
   When copying a directory to another directory, globs are not supported and
   behavior is similar to `cp dir1/ dir2/`."
  (^js [source destination callback]
   (fs/cp source destination callback))
  (^js [source destination opts callback]
   (fs/cp source destination opts callback)))

(defn cp-sync
  "Synchronously copies the entire directory structure from `src` to `dest`,
   including subdirectories and files.
   
   When copying a directory to another directory, globs are not supported and
   behavior is similar to `cp dir1/ dir2/`."
  (^js [source destination]
   (fs/cpSync source destination))
  (^js [source destination opts]
   (fs/cpSync source destination opts)))

(defn stat-sync
  "Synchronous stat(2) - Get file status."
  (^js []
   fs/statSync)
  (^js [path]
   (fs/statSync path))
  (^js [path options]
   (fs/statSync path options)))

(defn lstat-sync
  "Synchronous lstat(2) - Get file status. Does not dereference symbolic links."
  (^js []
   fs/lstatSync)
  (^js [path]
   (fs/lstatSync path))
  (^js [path options]
   (fs/lstatSync path options)))

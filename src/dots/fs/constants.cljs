(ns dots.fs.constants
  (:require ["fs" :as fs]))

(defn f-ok
  "Constant for fs.access(). File is visible to the calling process."
  ^js []
  (.-F_OK fs/constants))

(defn r-ok
  "Constant for fs.access(). File can be read by the calling process."
  ^js []
  (.-R_OK fs/constants))

(defn w-ok
  "Constant for fs.access(). File can be written by the calling process."
  ^js []
  (.-W_OK fs/constants))

(defn x-ok
  "Constant for fs.access(). File can be executed by the calling process."
  ^js []
  (.-X_OK fs/constants))

(defn copyfile-excl
  "Constant for fs.copyFile. Flag indicating the destination file should not be overwritten if it already exists."
  ^js []
  (.-COPYFILE_EXCL fs/constants))

(defn copyfile-ficlone
  "Constant for fs.copyFile. copy operation will attempt to create a copy-on-write reflink.
   If the underlying platform does not support copy-on-write, then a fallback copy mechanism is used."
  ^js []
  (.-COPYFILE_FICLONE fs/constants))

(defn copyfile-ficlone-force
  "Constant for fs.copyFile. Copy operation will attempt to create a copy-on-write reflink.
   If the underlying platform does not support copy-on-write, then the operation will fail with an error."
  ^js []
  (.-COPYFILE_FICLONE_FORCE fs/constants))

(defn o-rdonly
  "Constant for fs.open(). Flag indicating to open a file for read-only access."
  ^js []
  (.-O_RDONLY fs/constants))

(defn o-wronly
  "Constant for fs.open(). Flag indicating to open a file for write-only access."
  ^js []
  (.-O_WRONLY fs/constants))

(defn o-rdwr
  "Constant for fs.open(). Flag indicating to open a file for read-write access."
  ^js []
  (.-O_RDWR fs/constants))

(defn o-creat
  "Constant for fs.open(). Flag indicating to create the file if it does not already exist."
  ^js []
  (.-O_CREAT fs/constants))

(defn o-excl
  "Constant for fs.open(). Flag indicating that opening a file should fail if the O_CREAT flag is set and the file already exists."
  ^js []
  (.-O_EXCL fs/constants))

(defn o-noctty
  "Constant for fs.open(). Flag indicating that if path identifies a terminal device,
   opening the path shall not cause that terminal to become the controlling terminal for the process
   (if the process does not already have one)."
  ^js []
  (.-O_NOCTTY fs/constants))

(defn o-trunc
  "Constant for fs.open(). Flag indicating that if the file exists and is a regular file, and the file is opened successfully for write access, its length shall be truncated to zero."
  ^js []
  (.-O_TRUNC fs/constants))

(defn o-append
  "Constant for fs.open(). Flag indicating that data will be appended to the end of the file."
  ^js []
  (.-O_APPEND fs/constants))

(defn o-directory
  "Constant for fs.open(). Flag indicating that the open should fail if the path is not a directory."
  ^js []
  (.-O_DIRECTORY fs/constants))

(defn o-noatime
  "constant for fs.open().
   Flag indicating reading accesses to the file system will no longer result in
   an update to the atime information associated with the file.
   This flag is available on Linux operating systems only."
  ^js []
  (.-O_NOATIME fs/constants))

(defn o-nofollow
  "Constant for fs.open(). Flag indicating that the open should fail if the path is a symbolic link."
  ^js []
  (.-O_NOFOLLOW fs/constants))

(defn o-sync
  "Constant for fs.open(). Flag indicating that the file is opened for synchronous I/O."
  ^js []
  (.-O_SYNC fs/constants))

(defn o-dsync
  "Constant for fs.open(). Flag indicating that the file is opened for synchronous I/O with write operations waiting for data integrity."
  ^js []
  (.-O_DSYNC fs/constants))

(defn o-symlink
  "Constant for fs.open(). Flag indicating to open the symbolic link itself rather than the resource it is pointing to."
  ^js []
  (.-O_SYMLINK fs/constants))

(defn o-direct
  "Constant for fs.open(). When set, an attempt will be made to minimize caching effects of file I/O."
  ^js []
  (.-O_DIRECT fs/constants))

(defn o-nonblock
  "Constant for fs.open(). Flag indicating to open the file in nonblocking mode when possible."
  ^js []
  (.-O_NONBLOCK fs/constants))

(defn s-ifmt
  "Constant for fs.Stats mode property for determining a file's type. Bit mask used to extract the file type code."
  ^js []
  (.-S_IFMT fs/constants))

(defn s-ifreg
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a regular file."
  ^js []
  (.-S_IFREG fs/constants))

(defn s-ifdir
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a directory."
  ^js []
  (.-S_IFDIR fs/constants))

(defn s-ifchr
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a character-oriented device file."
  ^js []
  (.-S_IFCHR fs/constants))

(defn s-ifblk
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a block-oriented device file."
  ^js []
  (.-S_IFBLK fs/constants))

(defn s-ififo
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a FIFO/pipe."
  ^js []
  (.-S_IFIFO fs/constants))

(defn s-iflnk
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a symbolic link."
  ^js []
  (.-S_IFLNK fs/constants))

(defn s-ifsock
  "Constant for fs.Stats mode property for determining a file's type. File type constant for a socket."
  ^js []
  (.-S_IFSOCK fs/constants))

(defn s-irwxu
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating readable, writable and executable by owner."
  ^js []
  (.-S_IRWXU fs/constants))

(defn s-irusr
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating readable by owner."
  ^js []
  (.-S_IRUSR fs/constants))

(defn s-iwusr
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating writable by owner."
  ^js []
  (.-S_IWUSR fs/constants))

(defn s-ixusr
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating executable by owner."
  ^js []
  (.-S_IXUSR fs/constants))

(defn s-irwxg
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating readable, writable and executable by group."
  ^js []
  (.-S_IRWXG fs/constants))

(defn s-irgrp
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating readable by group."
  ^js []
  (.-S_IRGRP fs/constants))

(defn s-iwgrp
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating writable by group."
  ^js []
  (.-S_IWGRP fs/constants))

(defn s-ixgrp
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating executable by group."
  ^js []
  (.-S_IXGRP fs/constants))

(defn s-irwxo
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating readable, writable and executable by others."
  ^js []
  (.-S_IRWXO fs/constants))

(defn s-iroth
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating readable by others."
  ^js []
  (.-S_IROTH fs/constants))

(defn s-iwoth
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating writable by others."
  ^js []
  (.-S_IWOTH fs/constants))

(defn s-ixoth
  "Constant for fs.Stats mode property for determining access permissions for a file. File mode indicating executable by others."
  ^js []
  (.-S_IXOTH fs/constants))

(defn uv-fs-o-filemap
  "When set, a memory file mapping is used to access the file. This flag
   is available on Windows operating systems only. On other operating systems,
   this flag is ignored."
  ^js []
  (.-UV_FS_O_FILEMAP fs/constants))

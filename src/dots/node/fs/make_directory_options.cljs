(ns dots.node.fs.make-directory-options)

(defn recursive?
  "Indicates whether parent folders should be created.
   If a folder was created, the path to the first created folder will be returned."
  ^js [make-directory-options]
  (.-recursive ^js make-directory-options))

(defn set-recursive!
  "Indicates whether parent folders should be created.
   If a folder was created, the path to the first created folder will be returned."
  ^js [make-directory-options value]
  (set! (.-recursive ^js make-directory-options) value))

(defn mode
  "A file mode. If a string is passed, it is parsed as an octal integer. If not specified"
  ^js [make-directory-options]
  (.-mode ^js make-directory-options))

(defn set-mode!
  "A file mode. If a string is passed, it is parsed as an octal integer. If not specified"
  ^js [make-directory-options value]
  (set! (.-mode ^js make-directory-options) value))
